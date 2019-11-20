## [Installing Kubernetes with Minikube](https://kubernetes.io/docs/setup/learning-environment/minikube/)

### Installation

[Instructions](../../../Tasks/InstallTools).

### Quickstart

```
$: minikube config view
$: minikube start [--vm-driver=virtualbox]
```

```
$: kubectl run hello-minikube --image=k8s.gcr.io/echoserver:1.10 --port=8080  

$: kubectl expose deployment hello-minikube --type=NodePort

$: kubectl get pod
$: minikube service hello-minikube --url  #-> paste link into the browser

$: kubectl delete services hello-minikube
$: kubectl delete deployment hello-minikube

$: minikube stop
```

### Managing your Cluster

```
$: minikube start [--kubernetes-version _version] [--vm-driver=_driver] [Alternative-Container-Runtime] [--extra-config=_key=_value]

$: minikube stop
$: minikube delete
```

#### Reuse local Docker images

TODO

### Interacting with Your Cluster

```
$: minikube dashboard
```

```
$: minikube service [-n _namespace] [--url] _service
```

```
$: minikube ip
```

#### Persistent Volumes

TODO

#### Mounted Host Folders

TODO

#### Private Container Registries

TODO

#### Add-ons

TODO

#### Using Minikube with an HTTP Proxy

TODO
