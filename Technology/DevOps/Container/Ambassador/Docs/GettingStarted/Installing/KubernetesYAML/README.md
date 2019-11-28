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
  namespace: K8n-Namespace  # remember to change the namespace!
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
  type: NodePort/LoadBalancer/loadBalancerIP  # choose one
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

```
apiVersion: v1
kind: Service
metadata:
  name: tour
spec:
  ports:
  - name: ui
    port: 5000
    targetPort: 5000
  - name: backend
    port: 8080
    targetPort: 8080
  selector:
    app: tour
---
apiVersion: apps/v1
kind: Deployment
metadata:
  name: tour
spec:
  replicas: 1
  selector:
    matchLabels:
      app: tour
  strategy:
    type: RollingUpdate
  template:
    metadata:
      labels:
        app: tour
    spec:
      containers:
      - name: tour-ui
        image: quay.io/datawire/tour:ui-0.2.6
        ports:
        - name: http
          containerPort: 5000
      - name: quote
        image: quay.io/datawire/tour:backend-0.2.6
        ports:
        - name: http
          containerPort: 8080
        resources:
          limits:
            cpu: "0.1"
            memory: 100Mi
---
apiVersion: getambassador.io/v1
kind: Mapping
metadata:
  name: tour-ui
spec:  # maps / to the service "tour", port 5000
  prefix: /
  service: tour:5000
---
apiVersion: getambassador.io/v1
kind: Mapping
metadata:
  name: tour-backend
spec:  # maps /backend/ to the service "tour", port 8000
  prefix: /backend/
  service: tour:8080
  labels:
    ambassador:
      - request_label:
        - backend
```

```
$: kubectl apply -f tour.yaml
```

### 4. Testing the Mapping

```
$: kubectl get svc -o wide ambassador  #->
  # NAME         TYPE       CLUSTER-IP      EXTERNAL-IP   PORT(S)        SELECTOR
  # ambassador   NodePort   10.109.214.20   <none>        80:32387/TCP   service=ambassador
```

```
$: minikube service ambassador
```

### 5. The Diagnostics Service in Kubernetes

```
http://AMBASSADOR-SERVICE-IP:PORT/ambassador/v0/diag/
```

### 6. Enable HTTPS

Can be done.  
