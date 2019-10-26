## [Why Ambassador?](https://www.getambassador.io/about/why-ambassador)

Ambassador is a Kubernetes microservices API gateway built on the Envoy Proxy.  

Ambassador:
* supports per-service timeouts, rate limiting, authentication policies, ...
* supports TTP, HTTP/2, gRPC, gRPC-Web, WebSockets and can route raw TCP
* enables testing, canary routing and traffic shadowing
* exposes high resolution observability metrics
* supports GitOps
+ stores all configuration in Kubernetes



## [Features and Benefits](https://www.getambassador.io/about/features-and-benefits)

Designed to be used by both developers and operators:
* self-service deployments via Kubernetes annotations
* allows canary deployments
* integrates well with Kubernetes, gRPC, HTTP/2 and Istio
* supports authentication, rate limiting and diagnostics



## [Alternatives to Ambassador](https://www.getambassador.io/about/alternatives)

Amazon API gateway is a hosted API gateway.  
Kong is a traditional API gateway.  
Traefik, NGINX, HAProxy, or Envoy, or Ingress controllers are L7 proxies.  



## [Installing Ambassador](https://www.getambassador.io/user-guide/install)

### [Deploying Ambassador to Kubernetes](https://www.getambassador.io/user-guide/getting-started)

#### Deploying Ambassador

```
$: kubectl cluster-info dump --namespace kube-system | grep authorization-mode  #-> if RBAC then

$: kubectl apply -f https://getambassador.io/yaml/ambassador/ambassador-rbac.yaml
$: kubectl apply -f https://getambassador.io/yaml/ambassador/ambassador-no-rbac.yaml
```

For production you need to customize the YAML.  

#### Defining the Ambassador Service

```
---
apiVersion: v1
kind: Service
metadata:
  name: ambassador
spec:
  type: NodePort
  externalTrafficPolicy: Local
  ports:
   - port: 80
     targetPort: 8080
  selector:
    service: ambassador
```

```
$: $ kubectl apply -f ambassador-service.yaml
```

#### Creating your first service

```
---
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

#### Testing the Mapping

```
$: kubectl get svc -o wide ambassador  #->
  # NAME         TYPE       CLUSTER-IP      EXTERNAL-IP   PORT(S)        SELECTOR
  # ambassador   NodePort   10.109.214.20   <none>        80:32387/TCP   service=ambassador
```

```
$: minikube service ambassador
```

#### The Diagnostics Service in Kubernetes

```
http://AMBASSADOR-SERVICE-IP:PORT/ambassador/v0/diag/
```

#### Enable HTTPS

Can be done.  
