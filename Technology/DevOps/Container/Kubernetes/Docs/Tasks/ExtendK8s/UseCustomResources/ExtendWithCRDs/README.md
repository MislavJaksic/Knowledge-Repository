## [Extend the Kubernetes API with CustomResourceDefinitions](https://kubernetes.io/docs/tasks/access-kubernetes-api/custom-resources/custom-resource-definitions/)

If Kubernetes master version:
* > 1.16.0 use `apiextensions.k8s.io/v1`
* > 1.7.0 use `apiextensions.k8s.io/v1beta1`

### Create a CustomResourceDefinition

```
$: kubectl apply -f crd.yaml  # see Research
```

### Create custom objects

```
$: kubectl apply -f resource.yaml  # see Research
$: kubectl get crds
```

### Specifying a structural schema

TODO

### Advanced topics

TODO
