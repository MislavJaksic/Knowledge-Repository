## [Install kubectl](https://kubernetes.io/docs/tasks/tools/install-kubectl/#install-kubectl-on-linux)

kubectl is a Kubernetes command-line tool.  

### Ubuntu, Fedora or HypriotOS

```
$: sudo apt-get update && sudo apt-get install -y apt-transport-https
$: curl -s https://packages.cloud.google.com/apt/doc/apt-key.gpg | sudo apt-key add -
$: echo "deb https://apt.kubernetes.io/ kubernetes-xenial main" | sudo tee -a /etc/apt/sources.list.d/kubernetes.list

$: sudo apt-get update
$: sudo apt-get install -y kubectl
```

### CentOS, RHEL or Fedora

```
$: cat <<EOF > /etc/yum.repos.d/kubernetes.repo
[kubernetes]
name=Kubernetes
baseurl=https://packages.cloud.google.com/yum/repos/kubernetes-el7-x86_64
enabled=1
gpgcheck=1
repo_gpgcheck=1
gpgkey=https://packages.cloud.google.com/yum/doc/yum-key.gpg https://packages.cloud.google.com/yum/doc/rpm-package-key.gpg
EOF

$: yum install -y kubectl
```

### Other Linux

```
$: curl -LO https://storage.googleapis.com/kubernetes-release/release/`curl -s https://storage.googleapis.com/kubernetes-release/release/stable.txt`/bin/linux/amd64/kubectl

$: chmod +x ./kubectl
$: sudo mv ./kubectl /usr/local/bin/kubectl

$: kubectl version
```

### Windows

TODO

### Google Cloud SDK

TODO

#### Verifying kubectl configuration

Kubernetes needs a kubeconfig file at "~/.kube/config".  
It is created when you either:
* kube-up.sh
* deploy a Minikube cluster

```
$: kubectl cluster-info [dump]
# Note: if connection is refused either deploy Minikube first or check your configuration
```
#### Optional kubectl configurations: enabling shell autocompletion

TODO

## [Install Minikube](https://kubernetes.io/docs/tasks/tools/install-minikube/)

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

## Run Minikube

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

## Additional resources

[Minikube](https://minikube.sigs.k8s.io/)
