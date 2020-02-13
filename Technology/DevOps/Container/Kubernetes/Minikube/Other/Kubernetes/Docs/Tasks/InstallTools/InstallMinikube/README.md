## [Install Minikube](https://kubernetes.io/docs/tasks/tools/install-minikube/)

### Linux

```
$: egrep -q 'vmx|svm' /proc/cpuinfo && echo yes || echo no
# Note: if it says "no" you have to run it without VM drivers

# Install VirtualBox
# Note: other VM drivers are available

# Note: if Debian/Ubuntu (deb):
$: curl -LO https://storage.googleapis.com/minikube/releases/latest/minikube_1.7.2.deb \
 && sudo dpkg -i minikube_1.7.2.deb

# Note: if Fedora/Red Hat (rpm)
$: curl -LO https://storage.googleapis.com/minikube/releases/latest/minikube-1.7.2.rpm \
 && sudo rpm -ivh minikube-1.7.2.rpm
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
