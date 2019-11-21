## [DNS for Services and Pods](https://kubernetes.io/docs/concepts/services-networking/dns-pod-service/)

Kubernetes DNS schedules a DNS `Pod` and `Service`.  
They tell containers to use the DNS `Service`’s IP to resolve DNS names.  

Every `Service` is assigned a DNS name.  
```
# Imagine a Pod named FOO in a namespace BAR
# A Pod in BAR makes this DNS query: FOO
# A Pod not in BAR makes this DNS query: BAR.FOO
```

### Services

`Headless Service`s are those with `.spec.clusterIP = None`.  

#### A records

```
my-svc.my-namespace.svc.cluster-domain.example
```

Not headless: resolve it to the cluster IP of the `Service`.  
Headless: resolve it to a set of IPs of the pods selected by the `Service`.

#### SVR records

```
_my-port-name._my-port-protocol.my-svc.my-namespace.svc.cluster-domain.example
```

Not headless: resolve it to the port number and the domain name (A record name).
Headless: resolve it to a set which contains, for each pod, a port number and a domain name.

```
# Note: headless domain name
auto-generated-name.my-svc.my-namespace.svc.cluster-domain.example
```

### Pods

A `Pod`'s hostname is metadata.name by default.  
The `Pod` spec has a hostname field to override the default.  
The `Pod` spec has a subdomain field.  

```
hostname: FOO
subdomain: BAR            ->   FQDN: foo.bar.my-namespace.svc.cluster-domain.example
namespace: my-namespace
```

#### Pod’s DNS Policy

```
Default - inherits name resolution configuration from the node
ClusterFirst - default; DNS query not matching the cluster domain is forwarded to the upstream nameserver inherited from the node
ClusterFirstWithHostNet - for Pods running with hostNetwork
None - ignore DNS settings; DNS settings are given using the dnsConfig field
```

#### Pod’s DNS Config

`Pod`’s DNS Config gives more DNS control.

TODO
