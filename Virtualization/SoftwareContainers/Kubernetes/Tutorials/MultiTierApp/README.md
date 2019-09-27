## [Example: Deploying PHP Guestbook application with Redis](https://kubernetes.io/docs/tutorials/stateless-application/guestbook/)


### Setup Redis Master

```
$: kubectl apply -f redis-master-deployment.yaml  # create Deployment and Pod

                                          # Server started, Redis version 2.8.19
$: kubectl logs -f redis-master-ID   ->   # WARNING: The TCP backlog setting of 511 ...
                                          * The server is now ready to accept connections on port 6379

$: kubectl apply -f redis-master-service.yaml  # create a Service and expose the Pod
$: kubectl get service
```

```
apiVersion: apps/v1                        apiVersion: v1
kind: Deployment                           kind: Service
metadata:                                  metadata:
  name: redis-master                         name: redis-master
  labels:                                    labels:
    app: redis                                 app: redis
spec:                                          role: master
  selector:                                    tier: backend
    matchLabels:                           spec:
      app: redis                             ports:
      role: master                           - port: 6379
      tier: backend                            targetPort: 6379
  replicas: 1                                selector:
  template:                                    app: redis
    metadata:                                  role: master
      labels:                                  tier: backend
        app: redis                         
        role: master                       
        tier: backend                      
    spec:                                  
      containers:                          
      - name: master                       
        image: k8s.gcr.io/redis:e2e        
        resources:                         
          requests:                        
            cpu: 100m                      
            memory: 100Mi                  
        ports:                             
        - containerPort: 6379
```

### Setup Redis Slave

```
$: kubectl apply -f redis-slave-deployment.yaml

$: kubectl apply -f redis-slave-service.yaml
```

```
apiVersion: apps/v1                                          apiVersion: v1
kind: Deployment                                             kind: Service
metadata:                                                    metadata:
  name: redis-slave                                            name: redis-slave
  labels:                                                      labels:
    app: redis                                                   app: redis
spec:                                                            role: slave
  selector:                                                      tier: backend
    matchLabels:                                             spec:
      app: redis                                               ports:
      role: slave                                              - port: 6379
      tier: backend                                            selector:
  replicas: 2                                                    app: redis
  template:                                                      role: slave
    metadata:                                                    tier: backend
      labels:                                                
        app: redis                                           
        role: slave                                          
        tier: backend                                        
    spec:                                                    
      containers:                                            
      - name: slave                                          
        image: gcr.io/google_samples/gb-redisslave:v3        
        resources:                                           
          requests:                                          
            cpu: 100m                                        
            memory: 100Mi                                    
        env:                                                 
        - name: GET_HOSTS_FROM                               
          value: dns                                         
        ports:                                               
        - containerPort: 6379
```

### Setup Guestbook Frontend

```
$: kubectl apply -f frontend-deployment.yaml

$: kubectl apply -f frontend-service.yaml

# If Service NodePort:
$: minikube service frontend --url  #-> http://_ip:_port
# If Service LoadBalancer:
$: kubectl get service frontend  #-> copy-paste the EXTERNAL-IP into a browser

$: kubectl get services  #->
  # NAME           TYPE        CLUSTER-IP       EXTERNAL-IP   PORT(S)
  # frontend       NodePort    10.110.17.204    <none>        80:30832/TCP
  # kubernetes     ClusterIP   10.96.0.1        <none>        443/TCP
  # redis-master   ClusterIP   10.101.127.218   <none>        6379/TCP
  # redis-slave    ClusterIP   10.103.27.75     <none>        6379/TCP
```

```
apiVersion: apps/v1                                        apiVersion: v1
kind: Deployment                                           kind: Service
metadata:                                                  metadata:
  name: frontend                                             name: frontend
  labels:                                                    labels:
    app: guestbook                                             app: guestbook
spec:                                                          tier: frontend
  selector:                                                spec:
    matchLabels:                                             type: NodePort
      app: guestbook                                         # type: LoadBalancer
      tier: frontend                                         ports:
  replicas: 3                                                - port: 80
  template:                                                  selector:
    metadata:                                                  app: guestbook
      labels:                                                  tier: frontend
        app: guestbook                                     
        tier: frontend                                     
    spec:                                                  
      containers:                                          
      - name: php-redis                                    
        image: gcr.io/google-samples/gb-frontend:v4        
        resources:                                         
          requests:                                        
            cpu: 100m                                      
            memory: 100Mi                                  
        env:                                               
        - name: GET_HOSTS_FROM                             
          value: dns                                       
        ports:                                             
        - containerPort: 80
```

### Scale the app

```
$: kubectl scale deployment frontend --replicas=2

$: kubectl get pods  #-> the number of Pods increased
```

### Clean up

Don't do it if you canto do the next [tutorial](https://kubernetes.io/docs/tutorials/stateless-application/guestbook-logs-metrics-with-elk/).

```
$: kubectl delete deployment -l app=redis
$: kubectl delete service -l app=redis
$: kubectl delete deployment -l app=guestbook
$: kubectl delete service -l app=guestbook
```
