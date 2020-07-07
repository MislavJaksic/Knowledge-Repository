## [Integrating Keycloak and ArgoCD](https://argoproj.github.io/argo-cd/operator-manual/user-management/keycloak/)

Using Keycloak group set and client ArgoCD with authenticate users.  

### Creating a new client in Keycloak

```
Clients -> Create -> input Client data -> Save -> input Client settings -> Save -> Credentials -> write down the Secret!
```

`Client` data:
* `Client ID`: Client-Name
* `Client Protocol`: `openid-connect`
* `Root URL`: ArgoCD-Url

`Client` settings:
* `Access Type`: `confidential`
* `Valid Redirect URIs`: https://ArgoCD-Url/auth/callback
* `Base URL`: /applications

### Configuring the groups claim

```
Client Scopes -> Create -> input Client Scopes data -> Mappers -> Create -> input Mapper data -> Save
```

`Client Scope` data:
* `Name`: Client-Scope-Name

`Mapper` data:
* `Protocol`: `openid-connect`
* `Name`: Mapper-Name
* `Mapper Type`: `Group Membership`
* `Token Claim Name`: Mapper-Name
* `Full group path`: `OFF`

Add `Client Scope` Client-Scope-Name to `Assigned Default Client Scopes` of `Client` Client-Name.  
Create `Group`. Add `User`s to the Group-Name.  

### Confguring ArgoCD OIDC

```
$: echo -n Client-Secret | base64  # -> Client-Secret-Base64
$: kubectl edit secret argocd-secret -n K8s-Argocd-Namespace
  # ...
  # oidc.keycloak.clientSecret:
  #     Client-Secret-Base64
  # ...
```

See `argocd-cm.yaml` in `Research/`.  

```
$: kubectl edit configmap argocd-cm -n K8s-Argocd-Namespace  # ->
  # replace ArgoCD-Url, Keycloak-Url, Keycloak-Realm, Client-Scope-Name
```

### Configuring ArgoCD Policy

See `argocd-rbac-cm.yaml` in `Research/`.  

```
$: kubectl edit configmap argocd-rbac-cm
```
