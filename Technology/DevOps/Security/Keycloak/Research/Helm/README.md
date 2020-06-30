## [Helm Chart: Keycloak](https://hub.helm.sh/charts/codecentric/keycloak)

```
$: helm repo add codecentric https://codecentric.github.io/helm-charts
$: helm repo update

$: kubectl create namespace K8s-Keycloak-Namespace
$: helm install keycloak codecentric/keycloak -n K8s-Keycloak-Namespace
```

```
Login:
  Username: keycloak
  Password: `$: kubectl get secret --namespace keycloak keycloak-http -o jsonpath="{.data.password}" | base64 --decode; echo`
```
