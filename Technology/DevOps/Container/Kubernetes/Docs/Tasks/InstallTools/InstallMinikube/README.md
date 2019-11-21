## [Install Minikube](https://kubernetes.io/docs/tasks/tools/install-minikube/)

Additional resource: [Official Minikube Docs](https://minikube.sigs.k8s.io/)

### Linux

```
$: egrep -q 'vmx|svm' /proc/cpuinfo && echo yes || echo no
# Note: if it says "no" you have to run it without VM drivers
```

```
# Install VirtualBox
# Note: other VM drivers are available
```


#### Debian/Ubuntu (deb)

```
$: curl -LO https://storage.googleapis.com/minikube/releases/latest/minikube_1.4.0.deb \
 && sudo dpkg -i minikube_1.4.0.deb
```

#### Fedora/Red Hat (rpm)

```
$: curl -LO https://storage.googleapis.com/minikube/releases/latest/minikube-1.4.0.rpm \
 && sudo rpm -ivh minikube-1.4.0.rpm
```

### Windows

```
$: systeminfo  # shows "VM Monitor Mode Extensions: Yes ..."
```

TODO

### Run Minikube

```
$: minikube start --vm-driver=virtualbox
$: minikube stop
$: minikube delete
```

```
$: minikube config set vm-driver virtualbox
$: minikube config set cpus 4
$: minikube config set memory 4096

$: minikube config view
```

### Optional: create PersistentVolume

```
# Note: if you get `pod has unbound immidiate PersistentVolumeCliam` error
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
  hostPath:
    path: "/data/hostname-ten"
```
