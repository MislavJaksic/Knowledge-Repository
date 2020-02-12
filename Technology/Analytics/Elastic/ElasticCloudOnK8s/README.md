## [Elastic Cloud on Kubernetes](https://www.elastic.co/elastic-cloud-kubernetes)

### Install Elasticsearch

```
$: kubectl apply -f all-in-one.yaml  # see Research
$: kubectl apply -f elasticsearch.yaml

$: PASSWORD=$(kubectl get secret Elastic-Cluster-es-elastic-user -o=jsonpath='{.data.elastic}' | base64 --decode)
$: kubectl port-forward service/Elastic-Cluster-es-http 9200  # outside Kubernetes
$: curl -u "elastic:$PASSWORD" -k "https://localhost:9200"
```

[Instructions](Docs/Quickstart)

### Install Kibana (with existing Elasticsearch)

```
$: kubectl apply -f kibana.yaml  # see Research

$: kubectl port-forward service/Kibana-Cluster-kb-http 5601

# Note: visit https://localhost:5601
  # Username_ elastic
  # Password: `kubectl get secret Elastic-Cluster-es-elastic-user -o=jsonpath='{.data.elastic}' | base64 --decode`

# Note: if using NodePort visit https://Kubectl-Server-Ip:Node-Port
```

[Instructions](Docs/Quickstart)

### Monitoring

Monitor ElasticSearch and Kibana with `Prometheus`.  
See Research.  

[Instructions](../Other/Monitoring)
