## [Smoke Test](https://github.com/kelseyhightower/kubernetes-the-hard-way/blob/master/docs/13-smoke-test.md)

Test the whole Kubernetes cluster.  

### Data Encryption

```
$: kubectl create secret generic kthw-data-encrypt-secret --from-literal="mykey=mydata"
```

```
$: gcloud compute ssh controller-0 --command "sudo ETCDCTL_API=3 etcdctl get --endpoints=https://127.0.0.1:2379 --cacert=/etc/etcd/ca.pem --cert=/etc/etcd/kubernetes.pem --key=/etc/etcd/kubernetes-key.pem /registry/secrets/default/kthw-data-encrypt-secret | hexdump -C"
```

The `etcd` key is prefixed with `k8s:enc:aescbc:v1:key1`.  
It means the `aescbc` provider was used to encrypt the data with the `key1` encryption key.  

### Deployments

```
$: kubectl create deployment nginx --image=nginx

$: kubectl get pods -l app=nginx
```

#### Port Forwarding

```
$: POD_NAME=$(kubectl get pods -l app=nginx -o jsonpath="{.items[0].metadata.name}")

$: kubectl port-forward $POD_NAME 8080:80
```

```
$: curl --head http://127.0.0.1:8080
```

#### Logs

```
$: kubectl logs $POD_NAME
```

#### Exec

```
$: kubectl exec -ti $POD_NAME -- nginx -v
```

### Services

```
$: kubectl expose deployment nginx --port 80 --type NodePort
```

You cannot create a `LoadBalancer` `Service` because you haven't integrated Kubernetes with the Cloud provider.  

```
$: NODE_PORT=$(kubectl get svc nginx --output=jsonpath='{range .spec.ports[0]}{.nodePort}')

$: gcloud compute firewall-rules create kthw-allow-nginx-service --allow=tcp:${NODE_PORT} --network kthw-vpc-network

$: EXTERNAL_IP=$(gcloud compute instances describe worker-0 --format 'value(networkInterfaces[0].accessConfigs[0].natIP)')
```

```
$: curl -I http://${EXTERNAL_IP}:${NODE_PORT}
```
