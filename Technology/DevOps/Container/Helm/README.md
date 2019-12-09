## [Helm](https://helm.sh/)

A "package manager" for Kubernetes.  

### [Helm Hub](https://hub.helm.sh/)

Public Helm `chart` repository.  

[Sample Charts](Charts)

### Install

### Linux/Windows

```
$: curl https://raw.githubusercontent.com/helm/helm/master/scripts/get-helm-3 > get_helm.sh
$: chmod 700 get_helm.sh
$: ./get_helm.sh  # upgrade or install
```

```
$: scoop install helm  # check if its 3.x or 2.x
$: scoop uninstall helm
```

[Instructions](v3/Docs/Introduction/Installing)

### Common Operations

```
# Note: [-n K8s-Namespace] specifies a namespace

$: helm repo list  # list chart repos
$: helm repo add Repo-Name Repo-Url  # add chart repo
$: helm repo update  # update before searching/installing

$: helm search repo Repo-Name  # search for chart
$: helm show values Repo-Name/Chart-Name  # list config fields and values
$: helm install Release-Name Repo-Name/Chart-Name [-f Config-File.yaml]  # install chart

$: helm status Release-Name  # list release status
$: helm get values Release-Name  # list set config values

$: helm list  # list Release-Names
$: helm uninstall Release-Name [--keep-history]  # uninstall chart
```
