## [The OAuth2 Filter](https://www.getambassador.io/docs/latest/topics/using/filters/oauth2/)

The `OAuth2` `Filter` performs `OAuth2` authorization against an `Identity Provider` implementing `OIDC Discovery`.  

`Filter` is:
* an `OAuth Client`: it fetches resources from the `Resource Server` on the user's behalf
* half of a `Resource Server`: it validates the `Access Token` before allowing the request through to the upstream service, which implements the other half of the `Resource Server`

The `OAuth Client` and the `Resource Server` are in the same security domain. The `Authorization Server` is independent.

In most other implementations the `Authorization Server` and the `Resource Server` are in the same security domain.  

### The Ambassador Authentication Flow

<p align="center">
  <img width="400" src="images/ambassador-oauth-external-identity-provider-flow.png" alt="Ambassador OAuth flow using an external Identity Provider"></a>
</p>

#### Some basic authentication terms

Definitions:
* `OpenID`: is a decentralized authentication protocol. `OpenID` allows users to be authenticated by `Relying Parties` (RP) using a third-party authentication service. End-users can create accounts by selecting an `OpenID` `Identity Provider` (`Auth0`, `Okta`, `Keycloak`, ...) and then use those accounts to sign onto any website that accepts `OpenID` authentication.
* `Open Authorization` (`OAuth`): token-based authentication and authorization standard. `OAuth` delegates authentication to a third-party. Apps can trust the third-party because of `OAuth`.
* `Identity Provider` (IdP): has identity information for user accounts (`Principal`). It provides authentication services to apps (`Relying Parties`).
* `OpenID Connect` (OIDC): authentication layer for `OAuth 2.0`. Allows apps to verify the user identity using an IdP. Helps in implementing `Role-based Access Control` (RBAC).
* `JSON Web Token` (JWT): standard for creating `Access Token`s. JWTs help implement `Single Sign-On` (SSO). Profile information, claims or roles can be added to a JWT.

#### Using an Identity Hub

`Identity Hub`/`Identity Broker` allows you to support many IdPs.  
`Identity Hub`/`Identity Broker` is between your app and the IdP.  

### OAuth2 Global Arguments

Read what each setting means at the [source](https://www.getambassador.io/docs/latest/topics/using/filters/oauth2/#general-settings)!  

### OAuth2 Path-Specific Arguments

Read what each setting means at the [source](https://www.getambassador.io/docs/latest/topics/using/filters/oauth2/#oauth2-path-specific-arguments)!  

### XSRF protection

TODO

### RP-initiated logout

TODO

### Redis

`Redis` to stores authentication credentials and rate limiting information.  
If it is destroyed, users will need to log back in.  
