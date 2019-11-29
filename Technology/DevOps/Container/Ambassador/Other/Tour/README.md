## Ambassador Service Tour

Connect to the Ambassador `Service` created during installation.  

```
# Note: visit http://LoadBalancer-IP/
# Note: visit http://Kubectl-Service-IP:Node-Port

$: minikube service list
```

### Welcome

With Ambassador you can:
* support real-time, decentralized, multi-platform, L7 workloads

### Declarative Configuration

Ambassador is configured through `CustomResourceDefinition`s (`Mappings`, ...).  
You can manage configuration using source control.  

### Multi Platform

Can be integrated with Consul.  

### Diagnostics and Monitoring

```
# Note: visit http://Ambassador-Service-IP:Ambassador-Port/ambassador/v0/diag/
```

Ambassador:
* has a (public) diagnostics service
* exposes Envoy Proxy's statistics using statsd
* integrates with Prometheus and Grafana

### Single Sign-on

Only comes with Ambassador Pro.  

### Rate Limiting

Advanced features only comes with Ambassador Pro.  

### Ambassador Pro

You have to pay for it.  

### GitHub Single Sing-On

Only comes with Ambassador Pro.  

### Service Preview

Only comes with Ambassador Pro.  
