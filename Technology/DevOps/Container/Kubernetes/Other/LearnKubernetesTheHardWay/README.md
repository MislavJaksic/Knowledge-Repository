## [Kubernetes The Hard Way](https://github.com/kelseyhightower/kubernetes-the-hard-way)

The tutorial is free, but the compute resources cost about 6$ per day.  

You'll use a variety of products:
* cloud
* CLI
* TLS/SSL
* Kubernetes

You'll create:
* a `Virtual Private Cloud`: a virtual network
* a `subnet`: an IP range partition of a VPC
* a `firewall`: to control protocol use, both internal and external
* an `External Load Balancer`: for remote access and traffic balancing
* a `static IP address`: attached to the `External Load Balancer` to give it outside visibility
* a `Control Plane` and worker `Node` host machine

You'll generate and distribute TLS certificates for:
* all control and worker host machines
* an `admin` user
* `admin` user's `ServiceAccount`
* Kubernetes components: `etcd`, `kube-apiserver`, `kube-controller-manager`, `kube-scheduler`, `kubelet` and `kube-proxy`

You'll generate and distribute `kubeconfig` files for:
* `controller manager`
* `kubelet`
* `kube-proxy`
* `scheduler` clients
* `admin` user

You'll generate and transfer a data encryption key.  

You'll install and configure a high availability `etcd`, a distributed key-value store, for Kubernetes to store its state.  

You'll install and configure a high availability Kubernetes `Control Plane`. It's made up of: `kube-apiserver`, `kube-controller-manager` and `kube-scheduler`.  
You'll create an `External Load Balancer` for Kubernetes `API Server` to balance traffic.  
You'll perform health checks using a proxy, RBAC authorization, an `External Load Balancer`, `firewall`, `target-pool` and `forwarding-rule`.  

You'll install and configure multiple worker `Node`s. They are made up of: `runc`, `container networking plugins`, `containerd`, `kubelet`, and `kube-proxy`.  

You'll create a `kubeconfig` for `kubectl` to remotely access the Kubernetes `API Server`.  

You'll configure the workers' routing tables so their `Pod`s can see each other.  

You'll configure `CoreDNS` that will provide DNS capabilities to Kubernetes.  

You'll perform a smoke test to check if everything is working as expected: data encryption, `Deployments`, port forwarding, logs and `Service`s.  

Finally, you'll clean up all the compute resource.  
