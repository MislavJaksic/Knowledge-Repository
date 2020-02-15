## [Prometheus](https://prometheus.io/)

Prometheus is a monitoring and alerting toolkit.  
Prometheus:
* scrapes targets for metrics
* stores metrics in a time series database
* has graphing tools to consume metrics

### Prometheus in Kubernetes

#### Install

```
$: kubectl create namespace K8s-Monitoring-Namespace

$: kubectl apply -f prometheus-operator-rbac.yaml  # see Research
$: kubectl apply -f prometheus-rbac.yaml

$: kubectl apply -f prometheus.yaml
```

```
http://Kubectl-Server-Ip:30900
```

[Instructions](PrometheusKubernetesOperator/Docs/GettingStarted)

#### Alerting

TODO

[Instructions](PrometheusKubernetesOperator/Docs/Alerting)

#### Monitoring Ingress with Ambassador

TODO

[Instructions](PrometheusKubernetesOperator/Docs/MonitoringK8sIngress)

### Querying

```
jaeger_collector_batch_size  # valid query
{namespace='tracing',service='jaeger-operator-metrics'}  # valid query
```

[Instructions](Docs/Prometheus/Querying)
