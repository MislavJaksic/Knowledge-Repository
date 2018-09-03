## [Kubernetes](https://kubernetes.io/)

Kubernetes is a container orchestra conductor, where the orchestra are containers located on different machines.

### [Install a single-node Kubernetes](https://kubernetes.io/docs/setup/minikube/)

This setup will create a single node inside a VM.

Install a hypervisor such as VirtualBox.
Create an appropriate VM.
Install [kubectl](https://kubernetes.io/docs/tasks/tools/install-kubectl/) using one out of a myriad of ways.
* sudo snap install kubectl --classic
Install [minikube](https://github.com/kubernetes/minikube/releases).
* curl -Lo minikube https://storage.googleapis.com/minikube/releases/v0.28.2/minikube-linux-amd64 && chmod +x minikube && sudo mv minikube /usr/local/bin/

After install all ofhe required programs you can continue with the tutorial.

### [Running Kubernetes locally](https://kubernetes.io/docs/setup/minikube/#managing-your-cluster)

Start/stop/delete the cluster with:
* minikube start/stop/delete


