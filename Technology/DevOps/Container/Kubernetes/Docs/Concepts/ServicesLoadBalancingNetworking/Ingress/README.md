## [Ingress](https://kubernetes.io/docs/concepts/services-networking/ingress/)

Manages external access to the cluster.  
`Ingress`:
* gives `Service`s externally-reachable URLs
* load balance traffic
* terminate SSL / TLS
* offers name based virtual hosting

### What is Ingress?

Exposes HTTP(S) routes from outside the cluster to `Service`s within the cluster.  
Traffic routing is controlled by rules defined on the `Ingress` resource.

`Ingress Controller` is responsible for fulfilling the `Ingress`.  
`Ingress` doesn't expose ports or protocols!  
If you want to expose ports or protocols use `NodePort` or `LoadBalancer`.  

### Prerequisites

You must have an `Ingress Controller`.  
[Sample `Ingress Controller`s](../IngressController)

### The Ingress Resource

`Ingress Controller` use annotations to configure options.  
`Ingress` only supports rules for directing HTTP traffic.  

```
apiVersion: networking.k8s.io/v1beta1
kind: Ingress
metadata:
  name: Ingress-Name
  annotations:
    nginx.ingress.kubernetes.io/rewrite-target: /  # NGINX Controller specific annotation
spec:  # no host; apply rules to all hosts
  rules:
  - http:
      paths:
      - path: /HTTP-Path
        backend:
          serviceName: Service-Name
          servicePort: Service-Port
```

```
           userinfo          host        port
       ┌───────┴───────┐ ┌────┴────────┐ ┌┴┐
http://john.doe:password@www.example.com:123/forum/questions/?tag=networking&order=newest#top
└─┬─┘ └───────────┬────────────────────────┘└─┬─────────────┘└────────┬──────────────────┘└┬─┘
scheme         authority                     path(HTTP URI)         query             fragment
```

`Ingress` rules:
* host: optional, if host (for example, foo.bar.com) matches, apply the rules
* paths: if the path matches, direct traffic to a backend, a `Service`
* backend: HTTP(S) requests that match the host and path are sent to the backend, a `Service`

Default backend is used the request that can't find a match.  

### Types of Ingress

#### Single Service

`Ingress` can expose a single service:
* specify a default backend
* don't set a rule

#### Fanout

`Ingress` can expose multiple services based on the path (HTTP URI).  

```
# Note: `Ingress` that implements the following:
  # foo.bar.com -> 178.91.123.132 -> /s1   service1:4200
  #                                  /s2   service2:8080

apiVersion: networking.k8s.io/v1beta1
kind: Ingress
metadata:
  name: Ingress-Name
  annotations:
    nginx.ingress.kubernetes.io/rewrite-target: /  # NGINX Controller specific annotation
spec:
  rules:
  - host: foo.bar.com
    http:
      paths:
      - path: /s1
        backend:
          serviceName: service1
          servicePort: 4200
      - path: /s2
        backend:
          serviceName: service2
          servicePort: 8080

# Note: you may also need a default-http-backend `Service`
```

#### Name based virtual hosting

`Ingress` can expose multiple services based on the host name.  

```
# Note: `Ingress` that implements the following:
  # foo.bar.com --|                |-> foo.bar.com service1:80
  #               | 178.91.123.132 |
  # bar.foo.com --|                |-> bar.foo.com service2:80

apiVersion: networking.k8s.io/v1beta1
kind: Ingress
metadata:
  name: Ingress-Name
spec:
  rules:
  - host: foo.bar.com
    http:
      paths:
      - backend:
          serviceName: service1
          servicePort: 80
  - host: bar.foo.com
    http:
      paths:
      - backend:
          serviceName: service2
          servicePort: 80
  - http:  # route any traffic without a hostname defined in the request
      paths:
      - backend:
          serviceName: service3
          servicePort: 80
```

`Ingress` tells the load balancer to route requests based on the [Host header](https://tools.ietf.org/html/rfc7230#section-5.4).  

### TLS

Secure an `Ingress` with a TLS `Secret` that has a private key and certificate, `tls.crt` and `tls.key`.  
`Ingress` only supports a single TLS port, 443.  
`Ingress` assumes TLS termination.  
If a TLS `Ingress Controller` supports SNI and specifies different hosts, they are multiplexed on the same port according to the hostname specified through the SNI TLS extension.  

```
apiVersion: v1
kind: Secret
type: kubernetes.io/tls
metadata:
  name: TLS-Secret
  namespace: default
data:
  tls.crt: base64 encoded cert
  tls.key: base64 encoded key
---
apiVersion: networking.k8s.io/v1beta1
kind: Ingress
metadata:
  name: Ingress-Name
spec:
  tls:
  - hosts:
    - sslexample.foo.com
    secretName: TLS-Secret
  rules:
    - host: sslexample.foo.com
      http:
        paths:
        - path: /
          backend:
            serviceName: service1
            servicePort: 80
```

`Ingress` tells the `Ingress Controller` to secure the channel from the client to the load balancer using TLS.   
Certificate must have a `Common Name` (CN), a `Fully Qualified Domain Name` (FQDN).  

### Loadbalancing

`Ingress Controller` is bootstrapped with some load balancing policy settings.  
Concepts such as persistent sessions and dynamic weights are not yet exposed through the `Ingress`. Get these through the load balancer used for a `Service`.  

Health checks are not exposed through the `Ingress`.  
Kubernetes has [readiness probes](../../../Tasks/ConfigurePodsContainers/LivelinessReadinessStarupProbes) that are similar.  
