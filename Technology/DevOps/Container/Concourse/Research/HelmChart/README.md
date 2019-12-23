## [Concourse Helm Chart](https://github.com/concourse/concourse-chart)

```
$: helm repo add concourse https://concourse-charts.storage.googleapis.com/
$: helm install concourse concourse/concourse -f config.yaml

$: helm uninstall concourse
$: kubectl delete namespace concourse-main

$: kubectl delete pvc -l app=concourse-worker
$: kubectl delete pvc data-concourse-postgresql-0
```

### Configuration

The table is incomplete:
* `concource.web.externalUrl` is never mentioned in the README

Instead:
* use `$: helm show values concourse/concourse`
* read the [values.yaml](https://github.com/concourse/concourse-chart/blob/master/values.yaml)
