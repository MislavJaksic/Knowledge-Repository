## [Prometheus Operator Docs](https://github.com/coreos/prometheus-operator/tree/master/Documentation)

### Install

```
$: kubectl apply -f prometheus-operator-rbac.yaml  # see Research

$: kubectl apply -f example-app.yaml
$: kubectl apply -f service-monitor.yaml

$: kubectl apply -f prometheus-rbac.yaml

$: kubectl apply -f prometheus.yaml
```

```
http://Kubectl-Server-Ip:30900
```

[Instructions](GettingStarted)
