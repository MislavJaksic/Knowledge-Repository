## [Provisioning Compute Resources](https://github.com/kelseyhightower/kubernetes-the-hard-way/blob/master/docs/03-compute-resources.md)

Kubernetes requires a set of machines.  
Machines host the `Control Plane` and the worker `Node`s.  
Worker `Node`s run the application containers.  

You will provision the compute resources across a single compute zone.  

### Networking

Kubernetes networking model is flat.  
`NetworkPolicy` can change that.  

#### Virtual Private Cloud Network

Create:
* `Virtual Private Cloud` (VPC): virtual network
* `subnet`: an IP range partition of a VPC

```
$: gcloud compute networks create kthw-vpc-network --subnet-mode custom

$: gcloud compute networks subnets create kthw-subnet --network kthw-vpc-network --range 10.240.0.0/24
```

#### Firewall Rules

Create:
* `firewall`: to control protocol use, both internal and external
* `External Load Balancer`: for remote access and traffic balancing

```
$: gcloud compute firewall-rules create kthw-firewall-internal --allow tcp,udp,icmp --network kthw-vpc-network --source-ranges 10.240.0.0/24,10.200.0.0/16

$: gcloud compute firewall-rules create kthw-firewall-external --allow tcp:22,tcp:6443,icmp --network kthw-vpc-network --source-ranges 0.0.0.0/0

$: gcloud compute firewall-rules list --filter="network:kthw-vpc-network"
```

#### Kubernetes Public IP Address

Create:
* `static IP address`: attached to the `External Load Balancer` to give it outside visibility

```
$: gcloud compute addresses create kthw-address --region $(gcloud config get-value compute/region)

$: gcloud compute addresses list --filter="name=('kthw-address')"
```

### Compute Instances

Provision `Ubuntu Servers` 18.04 with `containerd` container runtime and fixed private IP addresses.  

#### Kubernetes Controllers

Create the Kubernetes `Control Plane` hosts.  

```
$: for i in 0 1 2; do
  gcloud compute instances create controller-${i} \
    --async \
    --boot-disk-size 200GB \
    --can-ip-forward \
    --image-family ubuntu-1804-lts \
    --image-project ubuntu-os-cloud \
    --machine-type n1-standard-1 \
    --private-network-ip 10.240.0.1${i} \
    --scopes compute-rw,storage-ro,service-management,service-control,logging-write,monitoring \
    --subnet kthw-subnet \
    --tags kthw,controller
done
```

#### Kubernetes Workers

Each worker requires a `Pod` `subnet` allocation from CIDR range.  
Used to configure container networking.  
`pod-cidr` is used to expose `Pod` `subnet` at runtime.  

Create the Kubernetes worker hosts.  

```
$: for i in 0 1 2; do
  gcloud compute instances create worker-${i} \
    --async \
    --boot-disk-size 200GB \
    --can-ip-forward \
    --image-family ubuntu-1804-lts \
    --image-project ubuntu-os-cloud \
    --machine-type n1-standard-1 \
    --metadata pod-cidr=10.200.${i}.0/24 \
    --private-network-ip 10.240.0.2${i} \
    --scopes compute-rw,storage-ro,service-management,service-control,logging-write,monitoring \
    --subnet kthw-subnet \
    --tags kthw,worker
done
```

#### Verification

```
$: gcloud compute instances list
```

### Configuring SSH Access

`SSH` is used to configure the hosts.  
When connecting for the first time `SSH` keys will be generated and stored.  

```
$: gcloud compute ssh controller-0  # ->
  # ...
  # Enter passphrase (empty for no passphrase):
  # Enter same passphrase again:
```

You'll be logged into `controller-0` machine.  
Exit using the command `exit`.  
