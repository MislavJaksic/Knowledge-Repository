## [Deploying Ambassador to Kubernetes](https://www.getambassador.io/user-guide/getting-started)

At the end you will have ingress routing.  

Ambassador functionality:
* path-based routing
* authentication
* URL rewriting
* CORS
* rate limiting
* automatic metrics collection

Service authors control how services are exposed to the Internet.  
Uses annotations.  

### 1. Deploying Ambassador

```
apiVersion: rbac.authorization.k8s.io/v1beta1
kind: ClusterRoleBinding
metadata:
  name: ambassador
roleRef:
  apiGroup: rbac.authorization.k8s.io
  kind: ClusterRole
  name: ambassador
subjects:
- kind: ServiceAccount
  name: ambassador
  namespace: K8n-Namespace  # change the namespace
```

```
$: kubectl cluster-info dump --namespace kube-system | grep authorization-mode  #-> if you see "...RBAC" then RBAC is enabled

$: kubectl apply -f ambassador-rbac.yaml

$: kubectl create clusterrolebinding my-cluster-admin-binding --clusterrole=cluster-admin --user=$(gcloud info --format="value(config.account)")
$: kubectl apply -f ambassador-no-rbac.yaml
```

For production you need to customize the YAML.  

### 2. Defining the Ambassador Service

```
...
spec:
  type: Supported-Service-Type  # choose one
  externalTrafficPolicy: Local  # propagate the (request) source IP
...
```

Choices:
* `LoadBalancer` (default)
* `NodePort`: if you don't have an external `LoadBalancer`
* `loadBalancerIP`: if your cloud has a static IP

```
$: $ kubectl apply -f ambassador-service.yaml
```

### 3. Creating your first service

If you installed Ambassador using Helm, you are in the right place.  

```
$: kubectl apply -f tour.yaml
```

`Mapping` `CustomResourceDefinition`s (CRDs) are used to configure routing.  

```
apiVersion: v1                apiVersion: getambassador.io/v1
kind: Service                 kind: Mapping
metadata:                     metadata:
  name: tour-service            name: tour-ui-mapping
spec:                         spec:
  ports:                        prefix: /
  - name: tour-ui-port          service: tour-service:15000
    port: 15000               ---
    targetPort: 5000          apiVersion: getambassador.io/v1
  - name: backend-port        kind: Mapping
    port: 18080               metadata:
    targetPort: 8080            name: tour-backend-mapping
  selector:                   spec:
    app: tour-app               prefix: /backend/
                                service: tour-service:18080
```

`Mapping`s do the following:
* route `http://Kubectl-Service-IP:Node-Port/*` to `tour-service` and its port 15000
* route `http://Kubectl-Service-IP:Node-Port/backend/` to `tour-service` and its port 18080

### 4. Testing the Mapping

```
$: kubectl get svc -o wide ambassador  #->
  # NAME        EXTERNAL-IP       PORT(S)         
  # ambassador  LoadBalancer-IP   80:HTTP-Node-Port/TCP,443:HTTPS-Node-Port
```

```
# Note: visit http://LoadBalancer-IP/
# Note: visit http://Kubectl-Service-IP:HTTP-Node-Port

$: minikube service list
```

[Tour](../../../../Other/Tour)

### 5. The Diagnostics Service in Kubernetes

```
# Note: visit http://Ambassador-Service-IP:Ambassador-Port/ambassador/v0/diag/
```

[Diagnostics](../../../../Other/Diagnostics)

You can disable the public diagnostics tool with an Ambassador `Module`, a global configuration resource.  
To view diagnostics, you'll have to port-forward.  

```
$: kubectl apply -f ambassador-module.yaml

$ kubectl get pods  # ->
  # NAME                          READY     STATUS
  # ambassador-Pod-ID   1/1       Running

$: kubectl port-forward ambassador-Pod-ID Local-Port

# Note: visit http://localhost:Local-Port/ambassador/v0/diag/
```

### 6. Enable HTTPS

[Security Guide: Enabling HTTPS](../../../Guides/Security/EnablingHTTPS)  
