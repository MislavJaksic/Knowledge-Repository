## [Configure a Pod to Use a PersistentVolume for Storage](https://kubernetes.io/docs/tasks/configure-pod-container/configure-persistent-volume-storage/)

### Create a file on a Node

```
$: minikube ssh
  # $: sudo mkdir /mnt/data
  # $: sudo sh -c "echo 'Hello from Kubernetes storage' > /mnt/data/index.html"
```

### Create a PersistentVolume

In this exercise you'll use `hostPath` `PersistentVolume` to emulate network-attached storage.  

In production use: EBS for AWS, Persistent Disk for Google Cloud, Cinder for OpenStack, vSphere Volumes on vSphere, NFS share or the like.  

Setup dynamic provisioning using `StorageClasses`.  

```
apiVersion: v1
kind: PersistentVolume
metadata:
  name: PV-Name
  labels:
    type: local
spec:
  storageClassName: manual
  capacity:
    storage: 10Gi
  accessModes:
    - ReadWriteOnce
  hostPath:
    path: "/mnt/data"
```

```
$: kubectl apply -f https://k8s.io/examples/pods/storage/pv-volume.yaml

$: kubectl get pv PV-Name  #->
  # NAME      CAPACITY   ACCESS MODES   RECLAIM POLICY   STATUS      CLAIM   STORAGECLASS
  # PV-Name   10Gi       RWO            Retain           Available           manual      
```

### Create a PersistentVolumeClaim

```
apiVersion: v1
kind: PersistentVolumeClaim
metadata:
  name: PVC-Name
spec:
  storageClassName: manual
  accessModes:
    - ReadWriteOnce
  resources:
    requests:
      storage: 3Gi
```

```
$: kubectl apply -f https://k8s.io/examples/pods/storage/pv-claim.yaml

$: kubectl get pv PV-Name  #->
  # NAME      CAPACITY   ACCESS MODES   RECLAIM POLICY   STATUS   CLAIM              STORAGECLASS
  # PV-Name   10Gi       RWO            Retain           Bound    default/PVC-Name   manual      

$: kubectl get pvc PVC-Name  #->
  # NAME       STATUS   VOLUME    CAPACITY   ACCESS MODES   STORAGECLASS
  # PVC-Name   Bound    PV-Name   10Gi       RWO            manual      
```

### Create a Pod

```
apiVersion: v1
kind: Pod
metadata:
  name: Pod-Name
spec:
  volumes:
    - name: Pod-PV-Name
      persistentVolumeClaim:
        claimName: PVC-Name
  containers:
    - name: task-pv-container
      image: nginx
      ports:
        - containerPort: 80
          name: "http-server"
      volumeMounts:
        - mountPath: "/usr/share/nginx/html"
          name: Pod-PV-Name
```

```
$: kubectl apply -f https://k8s.io/examples/pods/storage/pv-pod.yaml
```

```
$: kubectl delete pod Pod-Name
$: kubectl delete pvc PVC-Name
$: kubectl delete pv PV-Name

$: minikube ssh
  # $: sudo rm -rf /mnt/data
```

### Access control

TODO
