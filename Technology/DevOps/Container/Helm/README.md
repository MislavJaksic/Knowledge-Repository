## [Helm](https://helm.sh/)

A "package manager" for Kubernetes.  

### [Artifact HUB](../ArtifactHub)

Take a look at already built `Chart`s.  

[Old Sample Charts](Charts)

### Install

#### Linux

```
$: curl https://raw.githubusercontent.com/helm/helm/master/scripts/get-helm-3 > get_helm.sh
$: chmod 700 get_helm.sh
$: ./get_helm.sh  # upgrade or install
```

#### Windows

```
$: scoop install helm  # check if its 3.x or 2.x
$: scoop uninstall helm
```

[Instructions](v3/Docs/Introduction/Installing)

### Common Operations

```
# Note: [-n K8s-Namespace] specifies a namespace

$: helm repo list
$: helm repo add Repo-Name Repo-Name Repo-Url
$: helm repo update
$: helm repo remove Repo-Name

$: helm _command [--wait [--timeout _time]] [--no-hooks]
  # --timeout _time: max wait time to completion
  # --wait: wait until Pods are in Ready state
  # --no-hooks: skip running hooks

$: helm search repo Repo-Name  # search for chart
$: helm show values Repo-Name/Chart-Name  # list config fields and values
$: helm install Release-Name Repo-Name/Chart-Name [-f Config-File.yaml] [--version Chart-Version] [--debug --dry-run]  # install chart

$: helm status Release-Name  # list release status
$: helm get values Release-Name  # list set config values

$: helm upgrade -f config.yaml Release-Name Repo-Name/Chart-Name  # upgrade chart
$: helm history Release-Name  # show Revision-Ids
$: helm rollback Release-Name Revision-Id  # revert upgrade

$: helm list [--all]  # list Release-Names
$: helm uninstall Release-Name [--keep-history]  # uninstall chart
```

[Common commands](v3/Docs/Introduction/Using)

### Creating Charts

```
$: helm create Chart-Name [--starter]
$: helm dependency update Chart-Name  # download dependency Charts to charts/
$: helm lint Chart-Name
$: helm template Chart-Name  # output filled in templates to stdout
$: helm package Chart-Name  # create Chart-Name-Chart-Version.tgz
$: helm install Release-Name Chart-Package-Tgz-Name [--debug --dry-run]
```

If a template uses Go templating, replace `{{` with `{{ "{{" }}`.  

[Details](v3/Docs/Topics/Charts)

### Errors

```
Error: could not get apiVersions from Kubernetes: unable to retrieve the complete list of server APIs
```

```
$: kubectl get apiservice

# Note: remove all failed API services
```
