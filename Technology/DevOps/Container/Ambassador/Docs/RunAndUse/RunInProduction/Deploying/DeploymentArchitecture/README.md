### [The Ambassador Edge Stack Deployment Architecture](https://www.getambassador.io/docs/latest/topics/running/ambassador-deployment/)

Ambassadors works well in the Public Cloud: Amazon, Azure or Google. Traffic is routed to Ambassador via load balancer exposed with a `LoadBalander` `Service`.  

Ambassadors works well On-Premise Data Center. Ambassador is exposed as a `NodePort` `Service`. Works well with `MetalLB`.  

Ambassador works well with `Consul`.  
