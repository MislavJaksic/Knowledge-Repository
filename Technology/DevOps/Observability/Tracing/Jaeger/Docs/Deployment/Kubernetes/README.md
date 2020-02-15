## [Operator for Kubernetes](https://www.jaegertracing.io/docs/1.16/operator/)

### Understanding Operators

`Operator`s are a method of packaging, deploying, and managing a Kubernetes application.  

### Installing the Operator

#### Installing the Operator on Kubernetes

```
$: kubectl create namespace K8s-Tracing-Namespace

$: kubectl create -f jaegertracing.io_jaegers_crd.yaml  # see Research
$: kubectl create -f service_account.yaml
$: kubectl create -f role.yaml
$: kubectl create -f role_binding.yaml
$: kubectl create -f operator.yaml

# Note: don't use `kubectl apply`! Use `kubectl create`! CRD is too long!
```

#### Installing the Operator on OKD/OpenShift

TODO

### Quick Start - Deploying the AllInOne image

```
$: kubectl apply -f simplest.yaml  # see Research
```

### Deployment Strategies

Possible values:
* `allInOne`
* `production`
* `streaming`

#### AllInOne (Default) strategy

Default strategy is intended for development, testing, and demo purposes, not for production.  
Uses in-memory as storage.  

#### Production strategy

TODO

#### Streaming strategy

TODO

### Understanding Custom Resource Definitions

TODO

### Configuring the Custom Resource

TODO

### Accessing the Jaeger Console (UI)

Use `Ingress`.  

To enable `TLS` in the `Ingress` pass a `Secret` with the `TLS` certificate:

```
apiVersion: jaegertracing.io/v1
kind: Jaeger
metadata:
  name: ingress-with-tls
spec:
  ingress:
    secretName: my-tls-secret
```

You can also open a `NodePort` by FORCE.  
Edit the `Service` `simplest-query` and change `spec.type`.  
See Research.  

### Upgrading the Operator and its managed instances

TODO

### Updating a Jaeger instance (experimental)

TODO

### Removing a Jaeger instance

```
$: kubectl delete -f simplest.yaml
```

### Tracing the operator

TODO

### Monitoring the operator

The `Jaeger Operator` starts a `Prometheus`-compatible endpoint on `0.0.0.0:8383/metrics`.  
See Research.  

### Uninstalling the operator

```
$: kubectl delete -f jaegertracing.io_jaegers_crd.yaml  # see Research
$: kubectl delete -f service_account.yaml
$: kubectl delete -f role.yaml
$: kubectl delete -f role_binding.yaml
$: kubectl delete -f operator.yaml
```
