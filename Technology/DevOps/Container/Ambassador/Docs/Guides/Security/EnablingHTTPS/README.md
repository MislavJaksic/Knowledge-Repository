## [Enabling HTTPS in Ambassador](https://www.getambassador.io/user-guide/tls-termination/)

IF you don't have a Fully Qualified Domain Name (FQDN) you have to enable TLS and HTTPS manually.  

### Create a Self-Signed Certificate

```
$: openssl genrsa -out key-for-ambassador.pem 2048

$: openssl req -x509 -key key-for-ambassador.pem -out cert-for-ambassador.pem -days 365 -subj '/CN=ambassador-cert'

# Note: you may get an error despite everything being alright
```

### Store the Certificate and Key in a Kubernetes Secret

```
$: kubectl create secret tls ambassador-tls-cert --cert=cert-for-ambassador.pem --key=key-for-ambassador.pem
```

### Tell Ambassador to Use this Secret for TLS Termination

`TLSContext` will tell Ambassador to terminate TLS.  

```
$: kubectl apply -f tls-context.yaml  # see Research

# Note: if hosts is ['*'], you will have to use TLS for all services; plain HTTP will not work!
```

### Send a Request Over HTTPS

```
$: kubectl get service ambassador -o yaml
  # apiVersion: v1
  # kind: Service
  # ...
  # spec:
  #   ports:
  #   - name: http  # may have different ports
  #     port: 80
  #     protocol: TCP
  #     targetPort: 8080
  #   - name: https  # may have different ports
  #     port: 443
  #     protocol: TCP
  #     targetPort: 8443
  # ...
```

```
# Note: make sure you write down the right port
# Note: visit https://Kubectl-Service-IP:HTTPS-Node-Port

$: curl -k https://Kubectl-Service-IP:HTTPS-Node-Port/backend/
  # -k: disable hostname validation
```

### Next Steps

Self signed certificates are not trusted.  
For that, you need a Certificate Authority (CA).  

[Get a Certificate from a Certificate Authority](../CertManagerAmbassador)
