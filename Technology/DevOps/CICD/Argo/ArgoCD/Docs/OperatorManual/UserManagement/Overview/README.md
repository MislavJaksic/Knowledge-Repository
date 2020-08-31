## [Overview](https://argoproj.github.io/argo-cd/operator-manual/user-management/)

Argo CD has only one user, the `admin`.  

### Local users/accounts

`Local User` account use-cases:
* authentication tokens for Argo CD management automation
* additional users for when SSO integration is unnecessary

Each `Local User` needs RBAC rules.  
The default `Local User` policy is specified by `policy.default` field of the `argocd-rbac-cm` `ConfigMap`.  

The maximum length of a `Local User` is 32.  

#### Create new user

See `argocd-cm.yaml` in `Research/`.  

#### Disable admin user

It's highly recommended!  

#### Manage users

```
$: argocd account list
$: argocd account get User-Name

$: argocd account update-password \
  --account User-Name \
  --current-password Current-Password \
  --new-password New-Password
$: argocd account generate-token --account User-Name
```

#### Failed logins rate limiting

Control throttling settings:
* `ARGOCD_SESSION_MAX_FAIL_COUNT`: max fails; default: 5
* `ARGOCD_SESSION_FAILURE_WINDOW_SECONDS`: failure window; default: 300 (seconds)
* `ARGOCD_SESSION_MAX_CACHE_SIZE`: max cache; default: 1000
* `ARGOCD_MAX_CONCURRENT_LOGIN_REQUESTS_COUNT`: max concurrent login requests; default: 50

### SSO

SSO configuration:
* `Dex`: if the identity provider doesn't support OIDC or if you wish to leverage `Dex` features
* otherwise integrate with your existing, OICD supporting, identity provider

### Dex

TODO

### Existing OIDC Provider

See `argocd-cm.yaml` in `Research/`.  

The callback address should be the `/auth/callback` like `https://argocd.example.com/auth/callback`.  

#### Requesting additional ID token claims

Not all OIDC providers support a special groups scope.  
`Okta`, `OneLogin` and `Microsoft` support a special groups scope.  

TODO
