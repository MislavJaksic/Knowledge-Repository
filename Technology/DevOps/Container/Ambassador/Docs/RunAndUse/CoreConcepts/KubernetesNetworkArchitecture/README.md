## [Kubernetes Network Architecture](https://www.getambassador.io/docs/latest/topics/concepts/kubernetes-network-architecture/)

### Kubernetes has its own isolated network

`Kubernetes` cluster is its own isolated network namespace.  
Each `Pod` can be accessed with its own IP address.  

Achieved by deploying an in-cluster `Edge Proxy`/`Ingress Controller` and an external load balancer.  

### Network Architecture

#### Load balancer

The external load balancer has at least one static IP address.  
A DNS entry maps a domain to the static IP address.  

Cloud infrastructure providers allow you to create a `Kubernetes` `Service` `LoadBalancer`.  
In a private data center an external load balancer will be created.  

In either case it should point to the `Edge Proxy`.  

#### Edge Proxy/Ingress Controller

The `Edge Proxy` is most likely a L7.  
The `Edge Proxy` accepts incoming traffic from a load balancer and route the traffic to `Kubernetes` `Service`s.  

Configure an `Edge Proxy` with the `Kubernetes` `Ingress` resource.  
An `Edge Proxy` is an `Ingress Controller` if it can process `Ingress` resources.  
Every `Ingress Controller` is an `Edge Proxy`.  

Beyond the scope of an `Ingress` resource:
* TLS termination
* redirecting to TLS
* timeouts
* rate limiting
* authentication

Ambassador Edge Stack can be an `Ingress Controller` but is also much more.  

#### Kubernetes services and pods

`kube-proxy` is a L4 proxy.  
`kube-proxy` load balance traffic between the `Pod`s if they use the `Service` resource.  
This is a problem for HTTP/2 and gRPC.  

Traffic can also be routed directly to `Pod`s.  
Ambassador Edge Stack supports routing both to Kubernetes `Service`s and directly to `Pod`s.  
