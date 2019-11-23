## [Kubernetes](https://kubernetes.io/)

Kubernetes is a container orchestra conductor.

### Remote kubectl and accessing multiple Kubernetes

kubectl `config` file location: `~/.kube/config`  
`config`s can be merged.  

```
$: kubectl version  # list client, server version
$: kubectl cluster-info [--dump]  # list client, cluster info
$: kubectl config view [--minify]  # list `config` file

$: kubectl config use-context Context-Name  # change `current-context` field

$: kubectl get Resource-Name [-n K8s-Namespace]
$: kubectl apply -f File-Name.yaml [-n K8s-Namespace]
$: kubectl delete Resource-Name [-n K8s-Namespace]
```

[Instructions](Other/RemoteKubectl)

[Official instructions](Docs/Tasks/AccessAppsInCluster/ConfigureAccessToClusters)

### Connect to a remote Dashboard

Setup browser certificate.  

```
# Note: visit https://Kubectl-Server-IP:Kubectl-Server-Port/api/v1/namespaces/kubernetes-dashboard/services/https:kubernetes-dashboard:/proxy/#!/login
```

[Instructions](Other/RemoteKubernetesDashboard)

### Create a Bearer token

[Instructions](Other/DashboardDocs/UserGuide/AccessControl)

### Minikube: local Kubernetes

[Install instructions](Docs/Tasks/InstallTools)

```
$: minikube start
$: minikube stop

$: minikube delete
```

[User instructions](Docs/GettingStarted/Learning/InstallingKubernetesWithMinikube)
