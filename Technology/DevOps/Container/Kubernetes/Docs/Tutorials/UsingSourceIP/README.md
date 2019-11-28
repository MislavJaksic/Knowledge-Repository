## [Using Source IP](https://kubernetes.io/docs/tutorials/services/source-ip/)

Objectives:
* expose an app through various types of `Service`s
* understand how each `ServiceType` handles source IP NAT
* understand the tradeoffs involved in preserving source IP

Terminology:
* [NAT](https://en.wikipedia.org/wiki/Network_address_translation): Network Address Translation; remap the IP address by modifying the IP header of packets
* [Source NAT](https://en.wikipedia.org/wiki/Network_address_translation#SNAT: replacing the source IP on a packet, usually with a `Node`’s IP
* [Destination NAT](https://en.wikipedia.org/wiki/Network_address_translation#DNAT): replacing the destination IP on a packet, usually with a `Pod` IP
* VIP: a virtual IP, such as the one assigned to every Kubernetes `Service`
* `Kube-proxy`: a network daemon that orchestrates Service VIP management on every `Node`

Prerequisites:
* a webserver that echoes back the source IP of requests it receives through an HTTP header

```
$: kubectl run source-ip-app --image=k8s.gcr.io/echoserver:1.4
```

### Source IP for Services with Type=ClusterIP

Packet sent from within the cluster to `ClusterIP` will NOT be Source NAT'ed.  
That is, the source IP will not be replaced (with a `Node` IP) [if you are running Kubernetes in `iptables mode`].  

```
$: kubectl expose deployment source-ip-app --name=clusterip --port=80 --target-port=8080

$: kubectl get svc clusterip  # ->
  #NAME         TYPE        CLUSTER-IP           EXTERNAL-IP   PORT(S)
  # clusterip    ClusterIP   Service-Cluster-IP   <none>        80/TCP

$: kubectl run busybox -it --image=busybox --restart=Never --rm
  # ip addr
  # 1: lo: ...
  #     inet 127.0.0.1/8 scope host lo
  # 3: eth0: ...
  #     inet 10.244.3.8/24 scope global eth0  # they are the same!
  #
  # wget -qO - Service-Cluster-IP
  # CLIENT VALUES:
  # client_address=10.244.3.8  # they are the same!
  # command=GET
  # ...
```

The `client_address` is always the `Pod`’s IP address.  

### Source IP for Services with Type=NodePort

Packet sent to `NodePort` will be Source NAT'ed.  

```
$: kubectl expose deployment source-ip-app --name=nodeport --port=80 --target-port=8080 --type=NodePort

$: kubectl run busybox -it --image=busybox --restart=Never --rm
  # wget -qO - Kubectl-Server-IP:Node-Port
  # CLIENT VALUES:
  # client_address=172.17.0.1  # Endpoint host, not the client IP!
  # command=GET
  # ...
```

Received not the client's IP, but the cluster's internal IP.  

```
      client
         \ ^
          \ \
           v \       client sends packet to node2:nodePort
node 1 <--- node 2   node2 replaces the source IP address with its own IP address (SNAT)
| ^   SNAT           node2 replaces the destination IP on the packet with the pod IP
| |   --->           packet is routed to node 1, and then to the endpoint
v |                  the pod’s reply is routed back to node2
endpoint             the pod’s reply is sent back to the client
```

Kubernetes has a feature to preserve the client source IP.  
Setting `service.spec.externalTrafficPolicy` to `Local` will only proxy requests to local `Endpoints`. It will never forward traffic to other `Node`s. That preserves the original source IP address.  

### Source IP for Services with Type=LoadBalancer

Packet sent to `LoadBalancer` will be Source NAT'ed.  

```
$: kubectl expose deployment source-ip-app --name=loadbalancer --port=80 --target-port=8080 --type=LoadBalancer

$: minikube service loadbalancer  # -> client_address=172.17.0.1  # Endpoint host, not the client IP!
```

Kubernetes supports source IP preservation in these cloud providers:
* GCP
* Azure
Different cloud providers fulfil load-balancing needs in different ways.  
