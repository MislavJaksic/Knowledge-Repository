## [Test an insecure registry](https://docs.docker.com/registry/insecure/)

### Deploy a plain HTTP registry

Don't.  

### Use self-signed certificates

Get or create your own certificates.  

```
$: mkdir -p certs

$: openssl req -newkey rsa:4096 -nodes -sha256 -keyout certs/tls.key -x509 -days 365 -out certs/ca.crt  # ->
  # ...
  # Common Name: Private-Registry-Ip-Port
  # ...
```

#### Linux setup

```
$: mkdir -p /etc/docker/certs.d/Private-Registry-Ip-Port
```

```
# Note: copy the certificates:
  # /etc/docker/certs.d/
  #     └── Private-Registry-Ip-Port
  #        ├── tls.cert  # Server certificate signed by CA
  #        ├── tls.key  # Server key signed by CA
  #        └── ca.crt  # Certificate authority that signed the registry certificate
```

[Additional instructions](../../../../../Guides/RunInProduction/ConfigureContainers/Security/CertsForRepoClientVerification)
