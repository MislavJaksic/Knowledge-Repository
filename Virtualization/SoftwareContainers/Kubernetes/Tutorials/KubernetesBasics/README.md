## [Kubernetes Basics](https://kubernetes.io/docs/tutorials/kubernetes-basics/)

### [Create a Kubernetes cluster](https://kubernetes.io/docs/tutorials/kubernetes-basics/create-cluster/cluster-intro/)

Kubernetes cluster has:
* a Master which coordinates the Kubernetes cluster
* many Nodes which are VM/physical machines that run applications

Each Node has a Kubelet, an agent that talks between the Master and the Node.  

Minikube is a lightweight Kubernetes implementation.  

kubectl is a CLI for executing Kubernetes API.  

```
$: minikube version
$: minikube start --vm-driver=_driver

$: kubectl version  #-> lists client and server versions

$: kubectl cluster-info  #-> IPs of Kubernetes master and KubeDNS
$: kubectl get nodes  #-> list nodes
```

### [Deploy an app](https://kubernetes.io/docs/tutorials/kubernetes-basics/deploy-app/deploy-intro/)

Kubectl can create Deployments.  
Deployment instructs Kubernetes how to create an instances of your application.  
Deployment Controller continuously monitors created instances.  

```
$: kubectl run kubernetes-bootcamp --image=gcr.io/google-samples/kubernetes-bootcamp:v1 --port=8080  # DEPRECATED

$: kubectl get deployments

$: kubectl proxy
$: curl http://localhost:8001/version
```

### [Explore your app](https://kubernetes.io/docs/tutorials/kubernetes-basics/explore/explore-intro/)

Deployment creates a Pod on a Node.  

Pod is a group of containers that share a resource.  
All Pod containers are deployed, scheduled and share context on the same Node.  
Pods are atomic.  
Resources are:
* storage, volumes
* network, IP
* version and port info

#### Nodes

Node is a worker and may be a VM or physical machine.  
Nodes are managed by a Master.  
Node can run many Pods.  

Each Node must have:
* Kubelet, a process for communication, Pod and container management
* container runtime such as rkt or Docker

```
$: kubectl get - list resource
$: kubectl describe - show detailed information about a resource
$: kubectl logs - print the logs from a container in a pod
$: kubectl exec - execute a command on a container in a pod
```

```
$: kubectl get pods
$: kubectl describe pods
$: kubectl proxy
$: kubectl logs Pod-Name
$: kubectl exec Pod-Name
```

### [Expose your app publicly](https://kubernetes.io/docs/tutorials/kubernetes-basics/expose/expose-intro/)

Service defines a logical set of Pods and enables external traffic exposure, load balancing and service discovery.  
Service is defined using YAML.  
Service targets a set of Pods using a LabelSelector.  

Service is exposed through a type in the Service spec:
* ClusterIP (default) - Service only reachable from within the cluster
* NodePort - Service accessible from outside the cluster using <NodeIP>:<NodePort>
* LoadBalancer - an external load balancer assigns a fixed, external IP to the Service
* ExternalName - expose the Service using a name by returning a CNAME record with the name; no proxy is used
Note: LoadBalancer is a superset of NodePort is a superset of ClusterIP.  
Note: you don't have to include selector in the Service spec

Services match a set of Pods using labels and selectors.  

Labels are key/value which:
* designate objects for development, test or production
* tag

```
$: kubectl get services
$: kubectl expose deployment/Deployment-Name --type="NodePort" --port 8080
$: kubectl describe services/Service-Name
$: curl Minikube-IP:Service-NodePort

$: kubectl describe deployment
$: kubectl get pods -l _label
$: kubectl get services -l _label
$: kubectl label pod Pod-Name _label

$: kubectl delete service -l _label  # Pod still exits but is unreachable from the outside
```

### [Scale up your app](https://kubernetes.io/docs/tutorials/kubernetes-basics/scale/scale-intro/)

Scaling is accomplished by changing the number of Pod replicas in a Deployment.  

```
$: kubectl scale deployments/Deployment-Name --replicas=4
```

### [Update your app](https://kubernetes.io/docs/tutorials/kubernetes-basics/update/update-intro/)

Rolling updates incrementally update Pod instances with new ones.

Rolling updates allow:
* container update
* rollback
* CICD

```
$: kubectl set image deployments/Deployment-Name Deployment-Name=New-Container
$: kubectl rollout status deployments/Deployment-Name
$: kubectl rollout undo deployments/Deployment-Name
```
