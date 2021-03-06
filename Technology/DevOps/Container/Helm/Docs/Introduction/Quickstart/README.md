## [Quickstart Guide](https://helm.sh/docs/intro/quickstart/)

### Prerequisites

They are:
* Kubernetes
* configured local copy of `kubectl`
* installing and configuring Helm
* security configurations to apply to your installation, if any

### Install Helm

[Instructions](../Installing)

### Initialize a Helm Chart Repository

```
$: helm repo add Repo-Name Repo-Url

$: helm repo add stable https://kubernetes-charts.storage.googleapis.com/  # add chart repository

$: helm repo list
```

```
$: helm search repo stable  # ->
  # NAME                                    CHART VERSION   APP VERSION                     DESCRIPTION
  # ...
  # stable/ambassador                       4.1.0           0.81.0                          A Helm chart for Datawire Ambassador
  # ... and many more!
```

### Install an Example Chart

```
$: helm repo update
$: helm install stable/mysql --generate-name  # create release and generate Release-Name

$: helm show chart Repo-Name/Chart-Name  # list chart
$: helm show all Repo-Name/Chart-Name  # list chart docs
```

### Learn About Releases

```
$: helm list  # ->
  # NAME          VERSION   UPDATED                   STATUS    CHART
  # Release-Name  1         Wed Sep 28 12:59:46 2016  DEPLOYED  mysql-0.1.0
```

### Uninstall a Release

```
$: helm uninstall Release-Name [--keep-history]
```

### Reading the Help Text

```
$: helm get -h
```
