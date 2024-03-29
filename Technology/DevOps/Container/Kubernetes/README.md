## [Kubernetes](https://kubernetes.io/)

Kubernetes is a container orchestrator:
* allocates machine, CPU, memory, disk, IP and port
* provides DNS, load balancing and fault tolerance

### Install

Installers:
* [`minikube`](Minikube)
* `kubeadm`, `kops`, `KRIB`, `kubespray`, ...  
* manually on the [Google Cloud Platform](Other/LearnKubernetesTheHardWay)

[kubectl Command Line Tool](kubectl)  

[Kubernetes Dashboard](Dashboard)  

### Workloads

[Container: command and args](Docs/Tasks/InjectDataIntoApps/CommandArgumentContainer)  

[Container: ENV VARs](Docs/Tasks/InjectDataIntoApps/EnvironmentVariablesContainer)  
[Downward API: Pods expose info to their Containers](Docs/Tasks/InjectDataIntoApps/PodInfoThroughEnvVar)  

[ConfigMaps used by Pods](Docs/Tasks/ConfigurePodsContainers/ConfigurePodToUseConfigMap)  

[Liveness, Readiness and Startup Probes](Docs/Tasks/ConfigurePodsContainers/LiveReadyStartProbes)  
[Probes: dangers, tips and tricks](Other/LivenessProbeDanger)  

[Production Best Practices](Other/ProductionBestPractices)  

[Flask and Kubernetes](Other/RunningFlaskOnKubernetes)  

```
# Note: a throwaway Ubuntu Pod
$: kubectl run throwaway-shell --rm -i --tty --image ubuntu -- bash  # ->
  # $: apt update
  # $: apt install curl
  # ...
```

### Services

`ServiceType`s:
* `ClusterIP` (default): `Service` only reachable inside Kubernetes; expose `Service` on a cluster-internal IP
* `NodePort`: `Service` accessible outside Kubernetes using `Node-IP:Node-Port`; expose `Service` on each `Node`'s IP at a static port (`Node-Port`); creates a `ClusterIP` `Service` to which it routes
* `LoadBalancer`: an external load balancer assigns a fixed, external IP to the `Service`; expose `Service` using a cloud provider's load balancer; creates a `ClusterIP` and `NodePort` `Service`s to which it routes
* `ExternalName`: maps `Service` to `externalName` field by returning a CNAME record; no proxy is used

`Headless Service`s are used to interface with other service discovery mechanisms, without being tied to Kubernetes.  

Non-`Headless Service` DNS syntax is `Service-Name.Namespace:Service-Port`. For example, `flask-app.frontend:18080`.  

[Service details](Docs/Concepts/ServicesLoadBalancingNetworking/Service)  
[DNS for Services and Pods](Docs/Concepts/ServicesLoadBalancingNetworking/DNSForServicesPods)

### Ingress

`Ingress` is not a `ServiceType`, but it does expose a `Service`.  
`Ingress` is an entry point for your cluster.  
`Ingress` consolidates routing rules and exposes multiple `Service`s under the same IP address.  
`Ingress` doesn't expose ports or protocols, just HTTP(S)!  

[Ingress](Docs/Concepts/ServicesLoadBalancingNetworking/Ingress)  
[Ingress Controllers](Docs/Concepts/ServicesLoadBalancingNetworking/IngressController)  
[Minikube NGINX with /etc/host](Docs/Tasks/AccessAppsInCluster/SetupIngressOnMinikube)  

### Private repositories and images

```
$: docker login Private-Registry-Ip-Port
# Note: input username and password

$: kubectl create secret generic Private-Repo-Secret --from-file=.dockerconfigjson=/path/to/.docker/config.json --type=kubernetes.io/dockerconfigjson

# Note: Pods can only reference image pull Secrets in their own Namespace!
# Note: setup Docker TLS certificates
```

[Create Secret](Docs/Tasks/ConfigurePodsContainers/PullImageFromPrivateRegistry)  
[Docker TLS certificates](../Docker)  
[Get private images](Research/DeploymentPodPrivate)

### Managing resources

Group related resources into a single YAML with `---`.  
Specify `Service`s before `Deplyoment`s.  
Use labels and label selectors.  
Chain (nest) `kubectl` commands.  
Recursively apply a `kubectl` command on each directory with `-R`.  
Distinguish (canary) releases with labels.  
Label with `label`.  
Annotate with `annotate`.  
Scale with `scale` or `autoscale`.  

[Resource Tips and Tricks](Docs/Concepts/ClusterAdministration/ManagingResources)

### DNS

[DNS Diagnostics and Debugging](Docs/Tasks/AdministerCluster/DebuggingDNSResolution)  

### Security

[Overview](Docs/Concepts/Security/Overview)  
[Securing a Cluster](Docs/Tasks/AdministerCluster/SecuringCluster)  
[Best Practices](Other/KubernetesSecurityBestPractices)  

### StorageClass

[Change default StorageClass](Docs/Tasks/AdministerCluster/ChangeDefaultStorageClass)  

### Kubernetes-based platforms

[Platform on Kubernetes](Other/KubernetesBasedPlatform)  

### Errors

Force delete a `Terminating` namespace.  
```
(
NAMESPACE=Terminating-Namespace  # change
kubectl proxy &
kubectl get namespace $NAMESPACE -o json |jq '.spec = {"finalizers":[]}' >temp.json
curl -k -H "Content-Type: application/json" -X PUT --data-binary @temp.json 127.0.0.1:8001/api/v1/namespaces/$NAMESPACE/finalize
)
```

[Kubernetes Problems and Errors](Other/ShootYourselfInTheFoot)  
