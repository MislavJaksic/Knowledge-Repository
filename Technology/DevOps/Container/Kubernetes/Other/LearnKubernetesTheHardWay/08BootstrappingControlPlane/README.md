## [Bootstrapping the Kubernetes Control Plane](https://github.com/kelseyhightower/kubernetes-the-hard-way/blob/master/docs/08-bootstrapping-kubernetes-controllers.md)

Create a high availability `Control Plane`.  
Create an external load balancer that exposes the Kubernetes `API Server`s to remote clients.  

### Prerequisites

Login to each controller.  

```
$: gcloud compute ssh controller-0
$: gcloud compute ssh controller-1
$: gcloud compute ssh controller-2
```

#### Running commands in parallel with tmux

`tmux` can run commands on multiple machines at the same time.  

Steps:
* run `tmux`
* spit panes with `C-b "`
* move between panes with `C-b Arrow-Key`
* login with `gcloud compute ssh controller-X`
* synchronize panes with `C+b : set synchronize-panes on`

### Provision the Kubernetes Control Plane

```
$: sudo mkdir -p /etc/kubernetes/config
```

#### Download and Install the Kubernetes Controller Binaries

```
$: wget -q --show-progress --https-only --timestamping "https://storage.googleapis.com/kubernetes-release/release/v1.15.12/bin/linux/amd64/kube-apiserver" "https://storage.googleapis.com/kubernetes-release/release/v1.15.12/bin/linux/amd64/kube-controller-manager" "https://storage.googleapis.com/kubernetes-release/release/v1.15.12/bin/linux/amd64/kube-scheduler" "https://storage.googleapis.com/kubernetes-release/release/v1.15.12/bin/linux/amd64/kubectl"
```

```
$: chmod +x kube-apiserver kube-controller-manager kube-scheduler kubectl
$: sudo mv kube-apiserver kube-controller-manager kube-scheduler kubectl /usr/local/bin/
```

#### Configure the Kubernetes `API Server`

```
$: sudo mkdir -p /var/lib/kubernetes/

$: sudo mv ca.pem ca-key.pem kubernetes-key.pem kubernetes.pem service-account-key.pem service-account.pem encryption-config.yaml /var/lib/kubernetes/
```

The instance internal IP address is used to advertise the `API Server` to members of the cluster.  

```
$: INTERNAL_IP=$(curl -s -H "Metadata-Flavor: Google" http://metadata.google.internal/computeMetadata/v1/instance/network-interfaces/0/ip)
```

```
$: cat <<EOF | sudo tee /etc/systemd/system/kube-apiserver.service
[Unit]
Description=Kubernetes API Server
Documentation=https://github.com/kubernetes/kubernetes

[Service]
ExecStart=/usr/local/bin/kube-apiserver \\
  --advertise-address=${INTERNAL_IP} \\
  --allow-privileged=true \\
  --apiserver-count=3 \\
  --audit-log-maxage=30 \\
  --audit-log-maxbackup=3 \\
  --audit-log-maxsize=100 \\
  --audit-log-path=/var/log/audit.log \\
  --authorization-mode=Node,RBAC \\
  --bind-address=0.0.0.0 \\
  --client-ca-file=/var/lib/kubernetes/ca.pem \\
  --enable-admission-plugins=NamespaceLifecycle,NodeRestriction,LimitRanger,ServiceAccount,DefaultStorageClass,ResourceQuota \\
  --etcd-cafile=/var/lib/kubernetes/ca.pem \\
  --etcd-certfile=/var/lib/kubernetes/kubernetes.pem \\
  --etcd-keyfile=/var/lib/kubernetes/kubernetes-key.pem \\
  --etcd-servers=https://10.240.0.10:2379,https://10.240.0.11:2379,https://10.240.0.12:2379 \\
  --event-ttl=1h \\
  --encryption-provider-config=/var/lib/kubernetes/encryption-config.yaml \\
  --kubelet-certificate-authority=/var/lib/kubernetes/ca.pem \\
  --kubelet-client-certificate=/var/lib/kubernetes/kubernetes.pem \\
  --kubelet-client-key=/var/lib/kubernetes/kubernetes-key.pem \\
  --kubelet-https=true \\
  --runtime-config=api/all \\
  --service-account-key-file=/var/lib/kubernetes/service-account.pem \\
  --service-cluster-ip-range=10.32.0.0/24 \\
  --service-node-port-range=30000-32767 \\
  --tls-cert-file=/var/lib/kubernetes/kubernetes.pem \\
  --tls-private-key-file=/var/lib/kubernetes/kubernetes-key.pem \\
  --v=2
Restart=on-failure
RestartSec=5

[Install]
WantedBy=multi-user.target
EOF
```
#### Configure the Kubernetes Controller Manager

```
$: sudo mv kube-controller-manager.kubeconfig /var/lib/kubernetes/
```

```
$: cat <<EOF | sudo tee /etc/systemd/system/kube-controller-manager.service
[Unit]
Description=Kubernetes Controller Manager
Documentation=https://github.com/kubernetes/kubernetes

[Service]
ExecStart=/usr/local/bin/kube-controller-manager \\
  --address=0.0.0.0 \\
  --cluster-cidr=10.200.0.0/16 \\
  --cluster-name=kubernetes \\
  --cluster-signing-cert-file=/var/lib/kubernetes/ca.pem \\
  --cluster-signing-key-file=/var/lib/kubernetes/ca-key.pem \\
  --kubeconfig=/var/lib/kubernetes/kube-controller-manager.kubeconfig \\
  --leader-elect=true \\
  --root-ca-file=/var/lib/kubernetes/ca.pem \\
  --service-account-private-key-file=/var/lib/kubernetes/service-account-key.pem \\
  --service-cluster-ip-range=10.32.0.0/24 \\
  --use-service-account-credentials=true \\
  --v=2
Restart=on-failure
RestartSec=5

[Install]
WantedBy=multi-user.target
EOF
```

#### Configure the Kubernetes Scheduler

```
$: sudo mv kube-scheduler.kubeconfig /var/lib/kubernetes/
```

```
$: cat <<EOF | sudo tee /etc/kubernetes/config/kube-scheduler.yaml
apiVersion: kubescheduler.config.k8s.io/v1alpha1
kind: KubeSchedulerConfiguration
clientConnection:
  kubeconfig: "/var/lib/kubernetes/kube-scheduler.kubeconfig"
leaderElection:
  leaderElect: true
EOF
```

```
$: cat <<EOF | sudo tee /etc/systemd/system/kube-scheduler.service
[Unit]
Description=Kubernetes Scheduler
Documentation=https://github.com/kubernetes/kubernetes

[Service]
ExecStart=/usr/local/bin/kube-scheduler \\
  --config=/etc/kubernetes/config/kube-scheduler.yaml \\
  --v=2
Restart=on-failure
RestartSec=5

[Install]
WantedBy=multi-user.target
EOF
```

#### Start the Controller Services

```
$: {
  sudo systemctl daemon-reload
  sudo systemctl enable kube-apiserver kube-controller-manager kube-scheduler
  sudo systemctl start kube-apiserver kube-controller-manager kube-scheduler
}
```

Wait 30 seconds until the Kubernetes `API Server` is initialized.  

#### Enable HTTP Health Checks

A `Google Network Load Balancer` will  distribute traffic across all three `API Server`s.  
Each `API Server` terminates TLS connections and validates client certificates.  

A `Google Network Load Balancer` accepts HTTPS only.  
To perform HTTP health checks create an `nginx` server to proxy health checks.  

`nginx` will accept HTTP health checks on port `80` and proxy them to the `API Server` on `https://127.0.0.1:6443/healthz`.  

```
$: sudo apt-get update
$: sudo apt-get install -y nginx
```

```
$: cat > kubernetes.default.svc.cluster.local <<EOF
server {
  listen      80;
  server_name kubernetes.default.svc.cluster.local;

  location /healthz {
     proxy_pass                    https://127.0.0.1:6443/healthz;
     proxy_ssl_trusted_certificate /var/lib/kubernetes/ca.pem;
  }
}
EOF
```

```
$: {
  sudo mv kubernetes.default.svc.cluster.local \
    /etc/nginx/sites-available/kubernetes.default.svc.cluster.local

  sudo ln -s /etc/nginx/sites-available/kubernetes.default.svc.cluster.local /etc/nginx/sites-enabled/
}
```

```
$: sudo systemctl restart nginx

$: sudo systemctl enable nginx
```

#### Verification

```
$: kubectl get componentstatuses --kubeconfig admin.kubeconfig  # ->
  # NAME                 STATUS    MESSAGE              ERROR
  # controller-manager   Healthy   ok
  # ...
```

```
$: curl -H "Host: kubernetes.default.svc.cluster.local" -i http://127.0.0.1/healthz
```

### RBAC for Kubelet Authorization

Kubernetes `API Server` needs an RBAC permission to access the `Kubelet` API on each worker.  

Sets the `Kubelet` `--authorization-mode` flag to `Webhook`.  
`Webhook` mode uses the `SubjectAccessReview` API to determine authorization.  

Exit `tmux`!  
You only need to execute these commands on one controller.  

```
$: gcloud compute ssh controller-0
```

`ClusterRole`  permits access to the `Kubelet` API.  

```
$: cat <<EOF | kubectl apply --kubeconfig admin.kubeconfig -f -
apiVersion: rbac.authorization.k8s.io/v1beta1
kind: ClusterRole
metadata:
  annotations:
    rbac.authorization.kubernetes.io/autoupdate: "true"
  labels:
    kubernetes.io/bootstrapping: rbac-defaults
  name: system:kube-apiserver-to-kubelet
rules:
  - apiGroups:
      - ""
    resources:
      - nodes/proxy
      - nodes/stats
      - nodes/log
      - nodes/spec
      - nodes/metrics
    verbs:
      - "*"
EOF
```

The Kubernetes `API Server` authenticates to the `Kubelet` as the `kubernetes` user using the `--kubelet-client-certificate` flag.  

```
$: cat <<EOF | kubectl apply --kubeconfig admin.kubeconfig -f -
apiVersion: rbac.authorization.k8s.io/v1beta1
kind: ClusterRoleBinding
metadata:
  name: system:kube-apiserver
  namespace: ""
roleRef:
  apiGroup: rbac.authorization.k8s.io
  kind: ClusterRole
  name: system:kube-apiserver-to-kubelet
subjects:
  - apiGroup: rbac.authorization.k8s.io
    kind: User
    name: kubernetes
EOF
```

### The Kubernetes Frontend Load Balancer

Provision an `External Load Balancer` for the Kubernetes `API Server`s.  
The `kthw-address` `static IP address` will be attached to the resulting load balancer.  

Execute the following commands from the same machine that provisioned the compute resources!  

#### Provision a Network Load Balancer

```
$: {
  KUBERNETES_PUBLIC_ADDRESS=$(gcloud compute addresses describe kthw-address \
    --region $(gcloud config get-value compute/region) \
    --format 'value(address)')

  gcloud compute http-health-checks create kubernetes-health-check \
    --description "Kubernetes Health Check" \
    --host "kubernetes.default.svc.cluster.local" \
    --request-path "/healthz"

  gcloud compute firewall-rules create kthw-allow-health-check \
    --network kthw-vpc-network \
    --source-ranges 209.85.152.0/22,209.85.204.0/22,35.191.0.0/16 \
    --allow tcp

  gcloud compute target-pools create kubernetes-target-pool \
    --http-health-check kubernetes-health-check

  gcloud compute target-pools add-instances kubernetes-target-pool \
   --instances controller-0,controller-1,controller-2

  gcloud compute forwarding-rules create kubernetes-forwarding-rule \
    --address ${KUBERNETES_PUBLIC_ADDRESS} \
    --ports 6443 \
    --region $(gcloud config get-value compute/region) \
    --target-pool kubernetes-target-pool
}
```

#### Verification

Execute the following commands from the same machine that provisioned the compute resources!  

```
$: KUBERNETES_PUBLIC_ADDRESS=$(gcloud compute addresses describe kthw-address \
  --region $(gcloud config get-value compute/region) \
  --format 'value(address)')
```

```
$: curl --cacert ca.pem https://${KUBERNETES_PUBLIC_ADDRESS}:6443/version
```
