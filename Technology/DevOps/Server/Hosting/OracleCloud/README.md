## [Oracle Cloud](https://www.oracle.com/cloud/)

Manages hardware and software.  

### Container Engine (Kubernetes)

#### Create

[Create a cluster using Oracle's GUI](Docs/Infrastructure/Services/ContainerEngine/CreateKubernetes)

#### Access

Setup keys and Oracle CLI (`oci`) once.  
[Download `kubeconfig` file for kubectl](Docs/Infrastructure/Services/ContainerEngine/DownloadKubeconfig)  

```
$: kubectl get nodes  # ->
  # NAME       STATUS   ROLES   AGE   VERSION
  # Node-Name  Ready    ...     ...   ...
$: kubectl get node Node-Name -o=jsonpath='{range .status.addresses[*]}{.type}{"\t"}{.address}{"\n"}'  # ->
  # InternalIP	Node-Name
  # ExternalIP	Node-Ip OR Kubectl-Server-Ip
```

#### Dashboard

Steps:
* configure access to the cluster
* [Deploy the Dashboard](../../../../DevOps/Container/Kubernetes/Dashboard)  

```
$: kubectl apply -f oke-admin-service-account.yaml  # see Research

$: kubectl -n kube-system describe secret $(kubectl -n kube-system get secret | grep oke-admin | awk '{print $1}')  # copy Bearer Token in `token:`
```

```
$: kubectl proxy
# Note: visit http://localhost:8001/api/v1/namespaces/kubernetes-dashboard/services/https:kubernetes-dashboard:/proxy/
```

[Access the Dashboard](Docs/Infrastructure/Services/ContainerEngine/StartingK8sDashboard)

### (Image) Registry

Each region has a unique Registry endpoint.  

```
Germany Central (Frankfurt):
    https://eu-frankfurt-1.ocir.io
    https://fra.ocir.io
```

[Registry Endpoints](Docs\Infrastructure\Services\Registry\PrepareForRegistry)

#### Auth Token

```
Profile -> User Settings -> Auth Tokens -> Generate Token -> fill in information -> Generate Token
```

Servers as a `docker login` password.  

[Generate Auth Token](Docs\Infrastructure\Services\Registry\GetAuthToken)

### Create

```
Solutions and Platform -> Developer Services -> Registry -> Create Repository -> Add Repository -> fill in info
```

[Create a Registry](Docs\Infrastructure\Services\Registry\GetAuthToken)

### Push and Pull

```
$: docker login Registry-Endpoint.ocir.io  # ->
  # Username: Tenancy-Object-Storage-Namespace/Tenancy-Username
  # Password: Auth-Token

$: docker images

$: docker tag Image-Name:Image-Tag Registry-Endpoint.ocir.io/Tenancy-Object-Storage-Namespace/Registry-Name/Image-Name:Image-Tag

$: docker push Registry-Endpoint.ocir.io/Tenancy-Object-Storage-Namespace/Registry-Name/Image-Name:Image-Tag
```

[Pushing Images](Docs\Infrastructure\Services\Registry\PushingImages)  
[Pulling Images](Docs\Infrastructure\Services\Registry\PullingImages)  

TODO
