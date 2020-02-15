## [Design](https://github.com/coreos/prometheus-operator/blob/master/Documentation/design.md)

`Prometheus Operator` `CRD`s:
* `Prometheus`
* `ServiceMonitor`
* `PodMonitor`
* `Alertmanager`
* `PrometheusRule`

### Prometheus

`Prometheus` `CRD` defines a `Prometheus` and `Alertmanager` setup.  

`Prometheus` `Pod`s mount a `Secret` called `Prometheus-Name` containing the configuration for `Prometheus`.  

`Prometheus` `CRD` covers `ServiceMonitor`s based on their labels.  
`Prometheus Operator` updates the `Secret` containing the configuration.  

If no `ServiceMonitor` is selected it is up to the user to manage the `Secret`.  

### ServiceMonitor

`ServiceMonitor` defines how to monitor `Service`s.  
Select `Service`s by a label.  

`Endpoint`s are lists of IPs populated by a `Pod`'s `Service`.  
`ServiceMonitor` discovers `Endpoint`s and configures Prometheus to monitor those `Pod`s.  

Restrict namespaces with `ServiceMonitorNamespaceSelector` of the `PrometheusSpec` and `namespaceSelector` of the `ServiceMonitorSpec`.  

### PodMonitor

`PodMonitor` defines how to monitor `Pod`s.  
Select `Pod`s by a label.  

`Pod`s expose metrics on ports.  

`PodMonitor` discovers `Pod`s and configures Prometheus to monitor those `Pod`s.  

Restrict namespaces with `namespaceSelector` of the `PodMonitorSpec`.  

### Alertmanager

`Alertmanager` defines an `Alertmanager` setup.  

`Alertmanager` `Pod`s mount a `Secret` called `Alertmanager-Name` containing the configuration for `Alertmanager`.  

### PrometheusRule

`PrometheusRule` defines a Prometheus rule.  
