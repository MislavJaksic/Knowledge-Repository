## [Installing Kubernetes with Minikube](https://kubernetes.io/docs/setup/learning-environment/minikube/)

### Installation

[Instructions](../../../Tasks/InstallTools/InstallMinikube).

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
$: minikube ip
$: minikube dashboard
$: minikube service Service-Name [-n K8n-Namespace] [--url]
```

#### Persistent Volumes

```
# Note: if you get `pod has unbound immediate PersistentVolumeClaim` error
# Note: check if you defined a `PersistentVolume`
```

```
apiVersion: v1
kind: PersistentVolume
metadata:
  name: hostname-ten
  labels:
    type: local
spec:
  capacity:
    storage: 10Gi
  storageClassName: standard
  accessModes:
    - ReadWriteOnce
  hostPath:  # only works for single Node clusters!
    path: "/data/hostname-ten"
```

#### Mounted Host Folders

TODO

#### Private Container Registries

TODO

#### Add-ons

TODO

#### Using Minikube with an HTTP Proxy

TODO
