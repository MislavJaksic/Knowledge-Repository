## [Keycloak](https://www.keycloak.org/)

Add authentication and secure services.  

Features:
* `User Federation`
* `Identity Brokering`
* `Social Login`

### Install

#### Helm Chart

```
$: helm repo add codecentric https://codecentric.github.io/helm-charts
$: helm repo update

$: kubectl create namespace K8s-Keycloak-Namespace
$: helm install keycloak codecentric/keycloak -n K8s-Keycloak-Namespace
```

```
Login:
  Username: keycloak
  Password: `$: kubectl get secret -n K8s-Keycloak-Namespace keycloak-http -o jsonpath="{.data.password}" | base64 --decode; echo
```

[Helm Chart by Codecentric](Research/Helm)  

### Create

[Getting Started](GettingStarted/Kubernetes)  

#### Realm

Login. Hover over `Master   V`, then click `Create Realm`.  

#### User

```
Users -> Add User -> fill in -> Credentials -> Set Password
```

Login:
```
$KEYCLOAK_URL/auth/realms/Realm-Name/account/
```

#### Client Test Client

```
Clients -> Create
```

`Client` data:
* `Client ID`: Client-Name
* `Client Protocol`: `openid-connect`
* `Root URL`: https://www.keycloak.org/app/

```
https://www.keycloak.org/app/
  Keycloak URL: $KEYCLOAK_URL/auth/
  Realm: Realm-Name
  Client: Client-Name
    Username: User-Name
    Password: User-Password
```


!!!
https://www.keycloak.org/docs/latest/server_admin/index.html#_identity_broker
!!!
