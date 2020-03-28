## [Oracle Cloud](https://www.oracle.com/cloud/)

Manages hardware and software.  

### Kubernetes

#### Create

[Create Kubernetes cluster](Docs\Infrastructure\Services\ContainerEngine\CreateKubernetes)

#### Access

```
$: kubectl proxy
# Note: visit http://localhost:8001/api/v1/namespaces/kube-system/services/https:kubernetes-dashboard:/proxy/#!/login
```

```
$: kubectl get nodes  # ->
  # NAME       STATUS   ROLES   AGE   VERSION
  # Node-Name  Ready    ...     ...   ...
$: kubectl get node Node-Name -o=jsonpath='{range .status.addresses[*]}{.type}{"\t"}{.address}{"\n"}'  # ->
  # InternalIP	Node-Name
  # ExternalIP	Node-Ip OR Kubectl-Server-Ip
```

[Download `kubeconfig` file for kubectl](Docs\Infrastructure\Services\ContainerEngine\DownloadKubeconfig)  
[Access the Dashboard](Docs\Infrastructure\Services\ContainerEngine\StartingK8sDashboard)  
