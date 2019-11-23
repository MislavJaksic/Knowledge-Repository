## [Helm](https://helm.sh/)

A "package manager" for Kubernetes.  

### [Helm Hub](https://hub.helm.sh/)

Public Helm chart repository.  

[Sample Charts](Charts)

### Common Operations

```
# Note: [-n K8s-Namespace] specifies a namespace

$: helm repo list  # list chart repos
$: helm repo add Repo-Name Repo-Url  # add chart repo
$: helm repo update  # update before searching/installing

$: helm search repo Repo-Name  # search for chart
$: helm show values Repo-Name/Chart-Name  # list config fields and values
$: helm install Release-Name Repo-Name/Chart-Name  # install chart
$: helm status Release-Name  # list release status
$: helm get values Release-Name  # list set config values

$: helm list  # list Release-Names
$: helm uninstall Release-Name [--keep-history]  # uninstall chart
```
