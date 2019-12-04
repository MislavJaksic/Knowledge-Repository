## [Installation Guide ](https://kubernetes.github.io/ingress-nginx/deploy/#using-helm)

TODO

### Using Helm

```
$: helm install nginx-ingress stable/nginx-ingress [--set rbac.create=true]

$: POD_NAME=$(kubectl get pods -l app.kubernetes.io/name=ingress-nginx -o jsonpath='{.items[0].metadata.name}')
$: kubectl exec -it $POD_NAME -- /nginx-ingress-controller --version
```
