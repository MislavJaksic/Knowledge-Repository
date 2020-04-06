## [Oracle Cloud](https://www.oracle.com/cloud/)

Manages hardware and software.  

### Kubernetes

#### Create

Create a cluster using Oracle's GUI.  

[Create Kubernetes cluster](Docs/Infrastructure/Services/ContainerEngine/CreateKubernetes)

#### Access

Setup keys and Oracle CLI (`oci`) once.  
Download `kubectl` file for every cluster.  

```
$: kubectl get nodes  # ->
  # NAME       STATUS   ROLES   AGE   VERSION
  # Node-Name  Ready    ...     ...   ...
$: kubectl get node Node-Name -o=jsonpath='{range .status.addresses[*]}{.type}{"\t"}{.address}{"\n"}'  # ->
  # InternalIP	Node-Name
  # ExternalIP	Node-Ip OR Kubectl-Server-Ip
```

[Download `kubeconfig` file for kubectl](Docs/Infrastructure/Services/ContainerEngine/DownloadKubeconfig)   

#### Dashboard

First, configure access to the cluster.  

[Deploy the Dashboard](../../../../DevOps/Container/Kubernetes/Dashboard/README.md)  

```
$: kubectl apply -f oke-admin-service-account.yaml  # see Research

$: kubectl -n kube-system describe secret $(kubectl -n kube-system get secret | grep oke-admin | awk '{print $1}')  # copy Bearer Token in `token:`
```

```
$: kubectl proxy
# Note: visit http://localhost:8001/api/v1/namespaces/kubernetes-dashboard/services/https:kubernetes-dashboard:/proxy/
```

[Access the Dashboard](Docs/Infrastructure/Services/ContainerEngine/StartingK8sDashboard)
