## [Provisioning a CA and Generating TLS Certificates](https://github.com/kelseyhightower/kubernetes-the-hard-way/blob/master/docs/04-certificate-authority.md)

Provision the `Public Key Infrastructure` using `cfssl`, bootstrap a `Certificate Authority` (CA) and generate TLS certificates.  

### Certificate Authority

Provision a `Certificate Authority` used to generate additional TLS certificates.  

```
$: cfssl gencert -initca ca-csr.json | cfssljson -bare ca  # -> creates ca-key.pem and ca.pem
```

### Client and Server Certificates

#### The Admin Client Certificate

```
$: cfssl gencert -ca=ca.pem -ca-key=ca-key.pem -config=ca-config.json -profile=kubernetes admin-csr.json | cfssljson -bare admin  # -> creates admin-key.pem and admin.pem
```

#### The Kubelet Client Certificates

`Node Authorizer` authorization mode authorizes API requests made by `Kubelet`s.  
`Kubelet`s must prove they belong to the `system:nodes` group, with a username `system:node:Node-Name`.  

```
$: for instance in worker-0 worker-1 worker-2; do
cat > ${instance}-csr.json <<EOF
{
  "CN": "system:node:${instance}",
  "key": {
    "algo": "rsa",
    "size": 2048
  },
  "names": [
    {
      "C": "US",
      "L": "Portland",
      "O": "system:nodes",
      "OU": "Kubernetes The Hard Way",
      "ST": "Oregon"
    }
  ]
}
EOF

EXTERNAL_IP=$(gcloud compute instances describe ${instance} \
  --format 'value(networkInterfaces[0].accessConfigs[0].natIP)')

INTERNAL_IP=$(gcloud compute instances describe ${instance} \
  --format 'value(networkInterfaces[0].networkIP)')

cfssl gencert -ca=ca.pem -ca-key=ca-key.pem -config=ca-config.json -hostname=${instance},${EXTERNAL_IP},${INTERNAL_IP} -profile=kubernetes ${instance}-csr.json | cfssljson -bare ${instance}
done  # -> creates worker-$(digit)-key.pem and worker-$(digit).pem
```

#### The Controller Manager Client Certificate

```
$: cfssl gencert -ca=ca.pem -ca-key=ca-key.pem -config=ca-config.json -profile=kubernetes kube-controller-manager-csr.json | cfssljson -bare kube-controller-manager  # -> creates kube-controller-manager-key.pem and kube-controller-manager.pem
```

#### The Kube Proxy Client Certificate

```
$: cfssl gencert -ca=ca.pem -ca-key=ca-key.pem -config=ca-config.json -profile=kubernetes kube-proxy-csr.json | cfssljson -bare kube-proxy  # -> creates kube-proxy-key.pem and kube-proxy.pem
```

#### The Scheduler Client Certificate

```
$: cfssl gencert -ca=ca.pem -ca-key=ca-key.pem -config=ca-config.json -profile=kubernetes kube-scheduler-csr.json | cfssljson -bare kube-scheduler  # -> creates kube-scheduler-key.pem and kube-scheduler.pem
```

#### The Kubernetes API Server Certificate

Included `kthw-address` `static IP address` in the list of subject alternative names for the Kubernetes `API Server` certificate.  
Remote clients can then validate certificates.  

```
$: {

KUBERNETES_PUBLIC_ADDRESS=$(gcloud compute addresses describe kthw-address --region $(gcloud config get-value compute/region) --format 'value(address)')

KUBERNETES_HOSTNAMES=kubernetes,kubernetes.default,kubernetes.default.svc,kubernetes.default.svc.cluster,kubernetes.svc.cluster.local

cfssl gencert -ca=ca.pem -ca-key=ca-key.pem -config=ca-config.json -hostname=10.32.0.1,10.240.0.10,10.240.0.11,10.240.0.12,${KUBERNETES_PUBLIC_ADDRESS},127.0.0.1,${KUBERNETES_HOSTNAMES} -profile=kubernetes kubernetes-csr.json | cfssljson -bare kubernetes

}  # -> creates kubernetes-key.pem and kubernetes.pem
```

The Kubernetes `API Server` is automatically assigned the `kubernetes` internal DNS name.  
It's linked to the first IP address (`10.32.0.1`) from the address range (`10.32.0.0/24`).  
It's reserved for internal cluster services.  

### The Service Account Key Pair

```
$: cfssl gencert -ca=ca.pem -ca-key=ca-key.pem -config=ca-config.json -profile=kubernetes service-account-csr.json | cfssljson -bare service-account  # creates service-account-key.pem and service-account.pem
```

#### Distribute the Client and Server Certificates

```
$: for instance in worker-0 worker-1 worker-2; do
  gcloud compute scp ca.pem ${instance}-key.pem ${instance}.pem ${instance}:~/
done

$: for instance in controller-0 controller-1 controller-2; do
  gcloud compute scp ca.pem ca-key.pem kubernetes-key.pem kubernetes.pem \
    service-account-key.pem service-account.pem ${instance}:~/
done
```

The `kube-proxy`, `kube-controller-manager`, `kube-scheduler`, and `kubelet` client certificates are used to generate client authentication files.  
