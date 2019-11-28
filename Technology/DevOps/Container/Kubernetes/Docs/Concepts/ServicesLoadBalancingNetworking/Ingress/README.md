## [Ingress](https://kubernetes.io/docs/concepts/services-networking/ingress/)

Manages external access to the cluster.  
Ingress:
* gives `Service`s externally-reachable URLs
* load balance traffic
* terminate SSL / TLS
* offers name based virtual hosting

### What is Ingress?

Exposes HTTP(S) routes from outside the cluster to `Service`s within the cluster.  
Traffic routing is controlled by rules defined on the `Ingress` resource.

`Ingress Controller` is responsible for fulfilling the `Ingress`.  
`Ingress` doesn't expose ports or protocols.  
If you want to expose ports or protocols use `NodePort` or `LoadBalancer`.  

### Prerequisites

You must have an `Ingress Controller`.  
[Sample `Ingress Controller`s](../IngressController)

### The Ingress Resource

TODO
