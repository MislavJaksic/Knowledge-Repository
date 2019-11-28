## [Installing Ambassador with Helm](https://www.getambassador.io/user-guide/helm)

Don't attempt to install with Helm if:
* you don't have `LoadBalancer` configured

```
# Note: install Helm

$: helm install stable/ambassador [-n K8n-Namespace]
```

[Continue from the 3. step](../KubernetesYAML)
