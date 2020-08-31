## [SSO with Keycloak](https://www.getambassador.io/docs/latest/howtos/sso/keycloak/#keycloak)

`Keycloak` as your IdP.  
Create a `Client`.  

```
Clients -> Create -> input Client data -> Save -> input Client settings -> Save -> Mappers -> Create -> input Mapper data -> Save
```

`Client` data:
* `Client ID`: Client-Name
* `Client Protocol`: `openid-connect`
* `Root URL`: leave blank!

`Client` settings:
* `Access Type`: `confidential`
* `Valid Redirect URIs`: *

`Mapper` data:
* `Protocol`: `openid-connect`
* `Name`: Ambassador-Mapper-Name
* `Mapper Type`: `Audience`
* `Included Client Audience`: Client-Name

You may also change `Client Scopes`.  

`Assigned Default Client Scopes` must be included in the `FilterPolicy` scopes argument.  

### Configure Filter and FilterPolicy

See `filter-keycloak.yaml` and `filter-policy-keycloak.yaml` in `/Research`.  

[OAuth Filter](../../../RunAndUse/Using/FiltersAndAuthentication/OAuth2Filter)  
