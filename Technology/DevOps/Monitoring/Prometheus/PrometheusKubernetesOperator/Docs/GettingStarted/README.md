## [Getting started](https://github.com/coreos/prometheus-operator/blob/master/Documentation/user-guides/getting-started.md)

Operators operate other software.  

### Example Prometheus Operator manifest

See `prometheus-operator-rbac.yaml`.  

```
$: kubectl apply -f prometheus-operator-rbac.yaml  # see Research
```

### Related resources

Resources:
* `Prometheus`: describes Prometheus deployment; field `serviceMonitorSelector` selects `ServiceMonitor`s in namespace `serviceMonitorNamespaceSelector`
* `Alertmanager`: see [Alerting guide](../Alerting)
* `ServiceMonitor`: describes targets to be monitored

See `example-app.yaml` and `service-monitor.yaml`.  

```
$: kubectl apply -f example-app.yaml    # see Research
$: kubectl apply -f service-monitor.yaml
```

### Enable RBAC rules for Prometheus pods

See `prometheus-rbac.yaml`.  

```
$: kubectl apply -f prometheus-rbac.yaml    # see Research
```

### Include ServiceMonitors, PodMonitors and expose the Prometheus instance

See `prometheus.yaml`.   

```
$: kubectl apply -f prometheus.yaml    # see Research

# Note: visit http://Kubectl-Server-Ip:30900
```

### Expose the Prometheus Admin API

See [Prometheus official docs](https://prometheus.io/docs/prometheus/latest/querying/api/#tsdb-admin-apis).  
