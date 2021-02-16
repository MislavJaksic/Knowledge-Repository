## [Quickstart](https://github.com/zalando/postgres-operator/blob/master/docs/quickstart.md)

Prerequisites:
* a `Kubernetes` cluster
* `kubectl` pointing to the cluster

### Configuration Options

Configure the Postgres Operator before deploying a Postgres cluster.  
Configure using:
* `ConfigMap` or
* `OperatorConfiguration` object

### Helm Chart deployment

Install Helm v3.  

```
$: helm install postgres-operator postgres-operator/ -f ./postgres-operator/values-crd.yaml -n K8s-Postgres-Namespace
```

### Check if Postgres Operator is running

TODO

### Deploy the operator UI

```
$: helm install postgres-operator-ui postgres-operator-ui/ -n K8s-Postgres-Namespace
```

```
$: kubectl port-forward "$(kubectl get pod -l name=postgres-operator-ui --output='name')" 8081
```

### Create a Postgres cluster

```
$: kubectl create -f postgresql.yaml  # see Research
```

### Connect to the Postgres cluster via psql

See [User Guide](../UserGuide).  

### Delete a Postgres cluster

```
$: kubectl delete -f postgresql.yaml
```
