## [Vitess](https://vitess.io/)

### Install

Vitess `Operator` doesn't work with the `NodePort` `Service`.  

#### Helm Chart

```
$: apt install mysql-client

Note: visit https://github.com/vitessio/vitess/releases and extract `vtctlclient` to `$GOPATH/bin`
```

```
# Note: download Vitess GitHub repository
$: cd vitess/examples/helm

$: kubectl create namespace Vitess-Namespace
```

```
# Note: you may need to alter values.yaml
$: helm install vitess ../../helm/vitess -f 101_initial_cluster.yaml -n Vitess-Namespace
```

```
$: kubectl get pods,jobs -n Vitess-Namespace
```

```
$: helm delete vitess -n Vitess-Namespace
$: kubectl delete pvc -l "app=vitess" -n Vitess-Namespace
$: kubectl delete vitesstoponodes --all
```

[Install Vitess Helm Chart](Docs/GetStarted/VitessHelm)  

### Usage

`VTGate`: proxy to the database
`vtctld`: daemon for `vtctlclient`
