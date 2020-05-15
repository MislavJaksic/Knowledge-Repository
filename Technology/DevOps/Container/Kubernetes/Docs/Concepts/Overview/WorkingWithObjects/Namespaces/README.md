## [Namespaces](https://kubernetes.io/docs/concepts/overview/working-with-objects/namespaces/)

Virtual clusters.  

### When to Use Multiple Namespaces

For multi-tenancy.  

A resource can only be in one `Namespace`.  
`Namespace` divide cluster resources between users using resource quota.  

### Working with Namespaces

```
$: kubectl get namespace

$: kubectl K8s-Command [--namespace=K8s-Namespace]
$: kubectl config set-context --current --namespace=K8s-Namespace
```

### Namespaces and DNS

`Service` creates a DNS entry `<service-name>.<namespace-name>.svc.cluster.local`.  

### Not All Objects are in a Namespace

```
$: kubectl api-resources --namespaced=true

$: kubectl api-resources --namespaced=false
```
