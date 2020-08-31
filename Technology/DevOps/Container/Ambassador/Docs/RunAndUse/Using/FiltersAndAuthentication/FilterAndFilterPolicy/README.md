## [Filters and Authentication](https://www.getambassador.io/docs/latest/topics/using/filters/)

`Filter`s modify or intercept a request.  
Commonly used for authentication.  

### Filter Types

Types:
* `JWT`: validates JSON Web Tokens
* `OAuth2`: perform OAuth2 authorization against an identity provider implementing `OIDC Discovery`
* `Plugin`: write a custom `Filter` in `Go`
* `External`: call other services for request processing

### Managing Filters

#### Filter Definition

`Filter`s are managed by a `FilterPolicy`.  

See `filter.yaml` in `/Research`.  

#### FilterPolicy Definition

`FilterPolicy` specifies a host or URL and a set of `Filter`s.  

See `filter-policy.yaml` in `/Research`.  

| Value   | Example        | Description                                    |
|---------|----------------|------------------------------------------------|
| `host`    | `*`, `foo.com`   | the Host that a given rule should match        |
| `path`    | `/foo/url/`      | the URL path that a given rule should match to |
| `filters` | `name: keycloak` | the name of a given filter to be applied       |

The wildcard `*` is supported for both `path` and `host`.  

Read what each setting means at the [source](https://www.getambassador.io/docs/latest/topics/using/filters/#filterpolicy-definition)!  

#### FilterPolicy Example

See `example.yaml` for an example.  

#### Multiple Domains

See `example-multi-domain.yaml` for an example.  

### Installing self-signed certificates

The `JWT` and `OAuth2` `Filter`s use HTTP or HTTPS.  
If using HTTPS and a self-signed certificate, an error `ERR x509: certificate signed by unknown authority` will appear.  

Installing the certificate into the Ambassador Edge Stack container.  

```
FROM docker.io/datawire/aes:1.5.5
USER root
COPY ./my-certificate.pem /usr/local/share/ca-certificates/my-certificate.crt
RUN update-ca-certificates
USER 1000
```

When deploying the Ambassador Edge Stack, refer to that custom Docker image, rather than to `docker.io/datawire/aes:1.5.5`.  
