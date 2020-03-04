## [Logstash](https://www.elastic.co/logstash)

### Install

#### Kubernetes

```
$: helm repo add elastic https://helm.elastic.co

# Note: set configuration files, `logstash.yml`, using `ConfigMap` and `logstashConfig` in `config.yaml`

$: helm install logstash elastic/logstash -f config.yaml -n K8s-Elastic-Namespace  # see Research
```
