## [Install kubectl](https://kubernetes.io/docs/tasks/tools/install-kubectl/)

`kubectl` is a Kubernetes command-line tool.  

Before you begin

### Linux

#### Ubuntu, Fedora or HypriotOS

```
$: sudo apt-get update && sudo apt-get install -y apt-transport-https
$: curl -s https://packages.cloud.google.com/apt/doc/apt-key.gpg | sudo apt-key add -
$: echo "deb https://apt.kubernetes.io/ kubernetes-xenial main" | sudo tee -a /etc/apt/sources.list.d/kubernetes.list

$: sudo apt-get update
$: sudo apt-get install -y kubectl
```

#### CentOS, RHEL or Fedora

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

#### Other Linux

```
$: curl -LO https://storage.googleapis.com/kubernetes-release/release/`curl -s https://storage.googleapis.com/kubernetes-release/release/stable.txt`/bin/linux/amd64/kubectl

$: chmod +x ./kubectl
$: sudo mv ./kubectl /usr/local/bin/kubectl

$: kubectl version
```

### macOS

TODO

### Windows

```
$: scoop install kubectl
$: kubectl version

# Note: configure kubectl to use a remote Kubernetes

$: cd %USERPROFILE%
$: mkdir .kube
$: cd .kube
$: New-Item config -type file
```

### Google Cloud SDK

TODO

### Verifying kubectl configuration

Kubernetes needs a kubeconfig file at "~/.kube/config".  
It is created when you either:
* kube-up.sh
* deploy Minikube

```
$: kubectl cluster-info [dump]
# Note: if connection is refused either deploy Minikube first or check your configuration
```
### Optional kubectl configurations: enabling shell autocompletion

```
$: type _init_completion  # check if you have bash-completion

$: sudo apt-get install bash-completion
$: sudo yum install bash-completion
```

```
$: source <(kubectl completion bash)
$: echo "source <(kubectl completion bash)" >> ~/.bashrc
```

```
$: source <(kubectl completion zsh)
$: echo "if [ $commands[kubectl] ]; then source <(kubectl completion zsh); fi" >> ~/.zshrc
```
