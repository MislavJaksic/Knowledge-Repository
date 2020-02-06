## [Ambassador Core Concepts](https://www.getambassador.io/concepts/overview/)

Ambassador can do a lot.  

### [Features and Benefits](https://www.getambassador.io/about/features-and-benefits)

Designed to be used by both developers and operators:
* self-service deployments via `Kubernetes` annotations
* allows canary deployments
* integrates well with `Kubernetes`, `gRPC`, `HTTP/2` and `Istio`
* supports authentication, rate limiting and diagnostics

### [Using Ambassador Edge Stack in Your Organization](https://www.getambassador.io/concepts/using-ambassador-in-org/)

When:
* transitioning from a monolith to microservices: "strangler", facade pattern
* testing: canary releases and traffic shadowing
* and much much more

### [Alternatives to Ambassador](https://www.getambassador.io/about/alternatives)

`Amazon API gateway` is a hosted API gateway.  
`Kong` is a traditional API gateway.  
`Traefik`, `NGINX`, `HAProxy`, or `Envoy` or Ingress controllers are L7 proxies.  
`Istio` is a service mesh.  

Ambassador is:
* self-servicing
* `Kubernetes` native
* design for API management

### [Ambassador Architecture](https://www.getambassador.io/concepts/architecture)

Ambassador is a control plane for `Envoy Proxy`.  
Scales well and is highly available.  
Ambassador is stateless.  

### [Ambassador Deployment Architecture](https://www.getambassador.io/concepts/ambassador-deployment)

Ambassadors works well in the Public Cloud: Amazon, Azure or Google. Traffic is routed to Ambassador via load balancer exposed with a `LoadBalander` `Service`.  

Ambassadors works well On-Premise Data Center. Ambassador is exposed as a `NodePort` `Service`. Works well with MetalLB.  

Ambassador works well with `Consul`.  
