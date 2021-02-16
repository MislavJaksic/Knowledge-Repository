## [Kubernetes Helm Chart](https://vitess.io/docs/get-started/helm/)

### Prerequisites

Prerequisites:
* have a `Kubernetes` cluster
* install `kubectl`
* install `Helm 3`
* install `MySQL` client locally
* install `vtctlclient` locally

```
$: apt install mysql-client

Note: visit https://github.com/vitessio/vitess/releases and extract `vtctlclient` to `$GOPATH/bin`
```

### Start a single keyspace cluster

```
# Note: download Vitess GitHub repository
$: cd vitess/examples/helm

$: kubectl create namespace Vitess-Namespace
```

```
$: helm install vitess ../../helm/vitess -f 101_initial_cluster.yaml -n Vitess-Namespace
```

### Verify cluster

```
$: kubectl get pods,jobs -n Vitess-Namespace
```

### Setup Port-forward

```
# Note: edit Namespace name in `pf.sh`
$: ./pf.sh &
$: sleep 5

$: alias vtctlclient="vtctlclient -server=localhost:15999"
$: alias mysql="mysql -h 127.0.0.1 -P 15306"
```

#### Connect to your cluster

```
$: mysql  # ->
  # mysql> show databases;
```

#### Summary

You:
* deployed a single unsharded keyspace named `commerce`
* executed the script below

```
create table product(
  sku varbinary(128),
  description varbinary(128),
  price bigint,
  primary key(sku)
);
create table customer(
  customer_id bigint not null auto_increment,
  email varbinary(128),
  primary key(customer_id)
);
create table corder(
  order_id bigint not null auto_increment,
  customer_id bigint,
  sku varbinary(128),
  price bigint,
  primary key(order_id)
);
```

### Next Steps

```
$: helm delete vitess -n Vitess-Namespace
$: kubectl delete pvc -l "app=vitess" -n Vitess-Namespace
$: kubectl delete vitesstoponodes --all
```
