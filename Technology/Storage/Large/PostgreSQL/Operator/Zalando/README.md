## [Postgres Operator](https://github.com/zalando/postgres-operator)

### Install

```
$: helm install postgres-operator postgres-operator/ -f ./postgres-operator/values-crd.yaml -n K8s-Postgres-Namespace

$: kubectl create -f postgresql.yaml  # see Research
```

### UI

```
$: helm install postgres-operator-ui postgres-operator-ui/ -n K8s-Postgres-Namespace

$: kubectl port-forward "$(kubectl get pod -l name=postgres-operator-ui --output='name')" 8081
```

### Access

Using `kubectl proxy` or `LoadBalancer` `Service`.  
