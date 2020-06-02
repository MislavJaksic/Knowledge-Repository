## [Configuring kubectl for Remote Access](https://github.com/kelseyhightower/kubernetes-the-hard-way/blob/master/docs/10-configuring-kubectl.md)

Generate a `kubeconfig` file for `kubectl`.  

Execute the following commands where you generated the certificates!  

### The Admin Kubernetes Configuration File

Each `kubeconfig` requires a Kubernetes `API Server`.  
Use the IP address assigned to the `External Load Balancer` fronting the Kubernetes `API Server`s.  

```
$: {
  KUBERNETES_PUBLIC_ADDRESS=$(gcloud compute addresses describe kthw-address \
    --region $(gcloud config get-value compute/region) \
    --format 'value(address)')

  kubectl config set-cluster kthw-cluster \
    --certificate-authority=ca.pem \
    --embed-certs=true \
    --server=https://${KUBERNETES_PUBLIC_ADDRESS}:6443

  kubectl config set-credentials admin \
    --client-certificate=admin.pem \
    --client-key=admin-key.pem

  kubectl config set-context kthw-cluster \
    --cluster=kthw-cluster \
    --user=admin

  kubectl config use-context kthw-cluster
}
```

### Verification

```
$: kubectl get componentstatuses -o yaml
```

```
$: kubectl get nodes
```
