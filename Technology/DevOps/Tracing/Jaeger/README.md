## [Jaeger](https://www.jaegertracing.io/)

End-to-end distributed tracing.  
Problems with the distributed architecture are networking and observability.  

### Install using Kubernetes Operator

```
$: kubectl create namespace K8s-Tracing-Namespace

$: kubectl create -f jaegertracing.io_jaegers_crd.yaml  # see Research
$: kubectl create -f service_account.yaml
$: kubectl create -f role.yaml
$: kubectl create -f role_binding.yaml
$: kubectl create -f operator.yaml

# Note: don't use `kubectl apply`! Use `kubectl create`! CRD is too long!

$: kubectl apply -f simplest.yaml  # see Research

$: kubectl apply -f hotrod-nodeport.yaml  # see Research
```

You can also open a `NodePort` by FORCE.  
Edit the `Service` `simplest-query` and change `spec.type`.  

[Instructions](Docs/Deployment/Kubernetes)
