## [Service](https://kubernetes.io/docs/concepts/services-networking/service/)

TODO

## Headless Service

`Service`s that don't need load balancing or proxying.  
`Headless Service`s don't have a `ClusterIP`.  

If a selector:  
* IS defined `Endpoints` records are defined and the DNS configuration will point to the Pod backing the `Headless Service`  
* IS NOT defined the DNS configures either the CNAME records for `ExternalName`-type `Service`s or records for any `Endpoints` that share a name with the `Service`, for all other types

`Headless Service`s can still interface with other service discovery mechanisms.  

```
apiVersion: v1
kind: Service
...
spec:
  type: ClusterIP
  clusterIP: None  # makes it a headless service
  ...
```

### Publishing Services (ServiceTypes)

Services expose IP address.  

`ServiceType`s specify the kind of service you want:
* `ClusterIP` (default): `Service` only reachable from within Kubernetes; expose `Service` on a cluster-internal IP
* `NodePort`: `Service` accessible from outside Kubernetes using `Node-IP:Node-Port`; expose `Service` on each `Node`’s IP at a static port (`Node-Port`); creates a `ClusterIP` `Service` to which it routes
* `LoadBalancer`: an external load balancer assigns a fixed, external IP to the `Service`; expose `Service` using a cloud provider’s load balancer; creates a `ClusterIP` and `NodePort` `Service`s to which it routes
* `ExternalName`: maps `Service` to `externalName` field by returning a CNAME record; no proxy is used

`Ingress` is not a `ServiceType`.  
`Ingress` will expose your `Service`.  
`Ingress` is an entry point for your cluster.  
`Ingress` consolidates routing rules and will expose multiple `Service`s under the same IP address.  

#### Type NodePort

`NodePort` allocates a port. Port range is specified by `--service-node-port-range` flag.  
Each `Node` proxies the allocated port into your `Service`.  
The allocated port is the same port on every `Node`.  
See the allocated port `Service` in `.spec.ports[*].nodePort` field.  

Specify IPs to proxy the port with `--nodeport-addresses` flag in `kube-proxy` to particular IP blocks.  
Example:
* start `kube-proxy` with the `--nodeport-addresses=127.0.0.0/8`
* `kube-proxy` only selects the loopback interface (127.0.0.0/8) for `NodePort` `Service`s

Specific port number in `nodePort` field.  

`NodePort` `Service` is visible as:
* `<NodeIP>:spec.ports[*].nodePort`
* `.spec.clusterIP:spec.ports[*].port`

#### Type LoadBalancer

Cloud providers must support external load balancers for it to work.  
`Minikube` can expose a `LoadBalancer` `Service` using `$: minikube service LoadBalancer-Service-Name`.
`LoadBalancer` provisions a load balancer for your `Service`.  
See `Service`’s `LoadBalancer` status in `.status.loadBalancer`.  

```
apiVersion: v1
kind: Service
metadata:
  name: my-service
spec:
  selector:
    app: MyApp
  ports:
    - protocol: TCP
      port: 80
      targetPort: 9376
  clusterIP: 10.0.171.239
  type: LoadBalancer
status:
  loadBalancer:
    ingress:
    - ip: 192.0.2.127
```

TODO

#### Type ExternalName

TODO

#### External IPs

`Service` can be expose on `externalIP`s.  
Traffic that ingresses into the cluster with the external IP (as destination IP), on the `Service` port, will be routed to one of the `Service` endpoints.  
`externalIP`s are not managed by Kubernetes and are the responsibility of the cluster administrator.  

`externalIP`s can be specified along with any of the `ServiceTypes`.  

```
# Note: `my-service` can be accessed on `80.11.12.10:80`, `externalIP:port`
apiVersion: v1
kind: Service
metadata:
  name: my-service
spec:
  selector:
    app: MyApp
  ports:
    - name: http
      protocol: TCP
      port: 80
      targetPort: 9376
  externalIPs:
    - 80.11.12.10
```
