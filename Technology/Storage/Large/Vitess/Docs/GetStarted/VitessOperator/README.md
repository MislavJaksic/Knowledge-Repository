## [Vitess Operator for Kubernetes](https://vitess.io/docs/get-started/operator/)

### Prerequisites

Prerequisites:
* have a `Kubernetes` cluster
* install `kubectl`
* install `MySQL` client locally
* install `vtctlclient` locally

```
$: apt install mysql-client

Note: visit https://github.com/vitessio/vitess/releases and extract `vtctlclient` to `$GOPATH/bin`
```

### Install the Operator

```
# Note: download Vitess GitHub repository
$: cd vitess/examples/operator

$: kubectl create namespace Vitess-Namespace
$: kubectl apply -f operator.yaml -n Vitess-Namespace
```

### Bring up an initial cluster

```
$: kubectl apply -f 101_initial_cluster.yaml -n Vitess-Namespace
```

### Verify cluster

```
$: kubectl get pods -n Vitess-Namespace
```

### Setup Port-forward

```
# Note: edit Namespace name in `pf.sh`
$: ./pf.sh &

$: alias vtctlclient="vtctlclient -server=localhost:15999"
$: alias mysql="mysql -h 127.0.0.1 -P 15306 -u user"
```

### Create Schema

```
$: vtctlclient ApplySchema -sql="$(cat create_commerce_schema.sql)" commerce
$: vtctlclient ApplyVSchema -vschema="$(cat vschema_commerce_initial.json)" commerce
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
$: kubectl delete -f 101_initial_cluster.yaml -n Vitess-Namespace
```
