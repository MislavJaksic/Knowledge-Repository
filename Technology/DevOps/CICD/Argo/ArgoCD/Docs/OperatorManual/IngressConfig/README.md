## [Ingress Configuration](https://argoproj.github.io/argo-cd/operator-manual/ingress/)

Argo CD runs a:
* gRPC server on 443 (for CLI)
* HTTP/HTTPS server on 80 (for UI)

Both are exposed by the `argocd-server` `Service`.  

### kubernetes/ingress-nginx

#### Option 1: SSL-Passthrough

TODO

#### Option 2: Multiple Ingress Objects And Hosts

TODO

### Traefik (v2.0)

TODO

### AWS Application Load Balancers (ALBs) And Classic ELB (HTTP Mode)

TODO

### Authenticating through multiple layers of authenticating reverse proxies

TODO

### ArgoCD Server and UI Root Path (v1.5.3)

ArgoCD server and UI path can be changed with the `argocd-server`'s `--rootpath` flag.  

```
$: argocd login ArgoCD-Hostname --grpc-web-root-path /Http-Path/
```

### UI Base Path

ArgoCD UI path can be changed with the `argocd-server`'s `--basehref` flag.  
