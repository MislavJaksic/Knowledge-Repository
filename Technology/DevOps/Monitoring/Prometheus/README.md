## [Prometheus](https://prometheus.io/)

Prometheus is a monitoring and alerting toolkit.  
Prometheus:
* scrapes targets for metrics
* stores metrics in a time series database
* has graphing tools to consume metrics

### Prometheus in Kubernetes

[Instructions](PrometheusKubernetesOperator)

#### Install

```
$: kubectl apply -f prometheus-operator-rbac.yaml

$: kubectl apply -f example-app.yaml
$: kubectl apply -f service-monitor.yaml

$: kubectl apply -f prometheus-rbac.yaml

$: kubectl apply -f prometheus.yaml
```

```
http://Kubectl-Server-Ip:30900
```
