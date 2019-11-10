## [Hello Minikube](https://kubernetes.io/docs/tutorials/hello-minikube/)

```
var http = require('http');                                       FROM node:6.14.2
                                                                  EXPOSE 8080
var handleRequest = function(request, response) {                 COPY server.js .
  console.log('Received request for URL: ' + request.url);        CMD node server.js
  response.writeHead(200);                                        
  response.end('Hello World!');                                   
};                                                                
var www = http.createServer(handleRequest);                       
www.listen(8080);                                                 
```

```
$: minikube dashboard  # enable dashboard add-on and open proxy in browser
```

### Create a Deployment

A Pod is a group of Containers.  
A Deployment restarts the Pod’s Container if it terminates.  
Deployments should be used to manage Pods.  

```
$: kubectl create deployment hello-node --image=gcr.io/hello-minikube-zero-install/hello-node

$: kubectl get deployments
$: kubectl get pods
$: kubectl get events  # list all events
$: kubectl config view  # list cluster, context and user configurations
```

### Create a Service

A Pod is only accessible within the cluster.  
To expose a Pod create a Service.  

```
$: kubectl expose deployment hello-node --type=LoadBalancer --port=8080

$: kubectl get services  #->
  # NAME         TYPE           CLUSTER-IP      EXTERNAL-IP   PORT(S)
  # hello-node   LoadBalancer   10.100.31.217   <pending>     8080:31887/TCP
  # kubernetes   ClusterIP      10.96.0.1       <none>        443/TCP

$: minikube service hello-node  #-> access the app
```

### Addons

Minikube has a lot of addons.  

```
$: minikube addons list  #->
  # - addon-manager: enabled
  # - dashboard: enabled
  # - default-storageclass: enabled
  # - efk: disabled
  # - freshpod: disabled
  # - gvisor: disabled
  # - heapster: disabled
  # - ingress: disabled
  # - logviewer: disabled
  # - metrics-server: disabled
  # - nvidia-driver-installer: disabled
  # - nvidia-gpu-device-plugin: disabled
  # - registry: disabled
  # - registry-creds: disabled
  # - storage-provisioner: enabled
  # - storage-provisioner-gluster: disabled
```

```
$: minikube addons enable Addon-Name

$: minikube addons disable Addon-Name
```
