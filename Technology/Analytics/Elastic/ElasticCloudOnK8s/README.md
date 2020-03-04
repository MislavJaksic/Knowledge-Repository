## [Elastic Cloud on Kubernetes](https://www.elastic.co/elastic-cloud-kubernetes)

### Install Elasticsearch

```
$: kubectl apply -f all-in-one.yaml  # see Research
$: kubectl apply -f elasticsearch.yaml

$: PASSWORD=$(kubectl get secret Elastic-Cluster-es-elastic-user -o=jsonpath='{.data.elastic}' | base64 --decode)
$: curl -u "elastic:$PASSWORD" -k "https://Kubectl-Server-Ip:32000"
```

[Instructions](Docs/Quickstart)

### Install Kibana (with existing Elasticsearch)

```
$: kubectl apply -f kibana.yaml  # see Research

# Note: visit https://Kubectl-Server-Ip:32001
  # Username_ elastic
  # Password: `kubectl get secret Elastic-Cluster-es-elastic-user -o=jsonpath='{.data.elastic}' | base64 --decode`
```

[Instructions](Docs/Quickstart)

### Monitoring

Monitor ElasticSearch and Kibana with `Prometheus`.  
See Research.  

[Instructions](../Other/Monitoring)
