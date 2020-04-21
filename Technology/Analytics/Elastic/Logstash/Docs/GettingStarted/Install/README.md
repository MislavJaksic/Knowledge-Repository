## [Installing Logstash](https://www.elastic.co/guide/en/logstash/current/installing-logstash.html)

TODO

## [Logstash Helm Chart](https://github.com/elastic/helm-charts/tree/master/logstash)

```
$: helm repo add elastic https://helm.elastic.co

# Note: set configuration files, `logstash.yml`, using `ConfigMap` and `logstashConfig` in `config.yaml`
$: helm install logstash elastic/logstash -f config.yaml -n K8s-Elastic-Namespace  # see Research
```
