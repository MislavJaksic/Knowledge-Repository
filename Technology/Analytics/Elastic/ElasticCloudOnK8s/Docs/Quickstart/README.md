## [Quickstart](https://www.elastic.co/guide/en/cloud-on-k8s/current/k8s-quickstart.html)

### Deploy ECK in your Kubernetes cluster

```
$: kubectl create namespace K8s-Elastic-Namespace
$: kubectl apply -f all-in-one.yaml  # see Research
$: kubectl -n K8s-Elastic-Namespace logs -f statefulset.apps/elastic-operator
```

### Deploy an Elasticsearch cluster

```
$: kubectl apply -f elasticsearch.yaml  # see Research
```

See why [node.store.allow_mmap: false](../RunningElastic) is false.  

### Request Elasticsearch access

```
# Note: `Elastic-Cluster` value is defined in `elasticsearch.yaml`

$: PASSWORD=$(kubectl get secret Elastic-Cluster-es-elastic-user -o=jsonpath='{.data.elastic}' | base64 --decode)

$: kubectl port-forward service/Elastic-Cluster-es-http 9200  # outside Kubernetes
$: curl -u "elastic:$PASSWORD" -k "https://localhost:9200"
$: curl -u "elastic:$PASSWORD" -k "https://Elastic-Cluster-es-http:9200"  # inside Kubernetes
```

See how else you can [access the Stack](../AccessingElastic).  

### Deploy a Kibana instance

```
# Note: `Kibana-Cluster` value is defined in `kibana.yaml`

$: kubectl apply -f kibana.yaml  # see Research

$: kubectl port-forward service/Kibana-Cluster-kb-http 5601
```

```
# Note: visit https://localhost:5601
  # Username_ elastic
  # Password: `kubectl get secret Elastic-Cluster-es-elastic-user -o=jsonpath='{.data.elastic}' | base64 --decode`
```

### Use persistent storage

[About VolumeClaims](../AccessingElastic).  

### Check out the samples

[Samples](https://github.com/elastic/cloud-on-k8s/tree/master/config)  

`samples/` and `crds/` are the most interesting.  
