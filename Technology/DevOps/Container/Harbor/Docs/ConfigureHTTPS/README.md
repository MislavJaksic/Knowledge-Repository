## [Configuring Harbor with HTTPS Access](https://github.com/goharbor/harbor/blob/master/docs/configure_https.md)

### Getting Certificate Authority

```
$: openssl genrsa -out ca.key 4096

$: openssl req -x509 -new -nodes -sha512 -days 3650 -subj "/C=CN/ST=Beijing/L=Beijing/O=example/OU=Personal/CN=Private-Registry-Ip-Port" -key ca.key -out ca.crt
```

### Getting Server Certificate

```
$: openssl genrsa -out tls.key 4096

$: openssl req -sha512 -new -subj "/C=CN/ST=Beijing/L=Beijing/O=example/OU=Personal/CN=Private-Registry-Ip-Port" -key tls.key -out tls.csr

$: cat > v3.ext <<-EOF
authorityKeyIdentifier=keyid,issuer
basicConstraints=CA:FALSE
keyUsage = digitalSignature, nonRepudiation, keyEncipherment, dataEncipherment
extendedKeyUsage = serverAuth
EOF

$: openssl x509 -req -sha512 -days 3650 -extfile v3.ext -CA ca.crt -CAkey ca.key -CAcreateserial -in tls.csr -out tls.crt
```

### Configuration and Installation

```
$: openssl x509 -inform PEM -in tls.crt -out tls.cert

$: cp tls.cert /etc/docker/certs.d/Private-Registry-Ip-Port/
$: cp tls.key /etc/docker/certs.d/Private-Registry-Ip-Port/
$: cp ca.crt /etc/docker/certs.d/Private-Registry-Ip-Port/
```

```
/etc/docker/certs.d/
    └── Private-Registry-Ip-Port
       ├── tls.cert  <-- Server certificate signed by CA
       ├── tls.key   <-- Server key signed by CA
       └── ca.crt               <-- Certificate authority that signed the registry certificate
```

TODO
