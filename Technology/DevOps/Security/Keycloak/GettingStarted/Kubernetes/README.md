## [Keycloak on Kubernetes](https://www.keycloak.org/getting-started/getting-started-kube)

### Before you start

```
$: minikube addons list
$: minikube addons enable ingress
```

### Run Keycloak

Use the `Helm` `Chart` instead.  

TODO

### Login to the admin console

Login using your username and password.  

### Create a realm

Keycloak `Realm` is a tenant.  
`master` `Realm` is used by Keycloak and no one else.  

Hover over `Master   V`, then click `Create Realm`.  

### Create a user

```
Users -> Add User -> fill in -> Credentials -> Set Password
```

### Login to account console

```
$KEYCLOAK_URL/auth/realms/Realm-Name/account/
```

### Secure your first app

```
Clients -> Create
```

Data:
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

### Production Keycloak

Switch to a production ready database.  
Configure SSL with your own certificates.  
Switch the admin password to a more secure password.  
