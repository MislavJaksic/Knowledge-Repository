## [Kubernetes](https://kubernetes.io/)

Kubernetes is a container orchestra conductor.

### Install

Installers:
* [`minikube`](Minikube)
* `kubeadm`, `kops`, `KRIB`, `kubespray`, ...  

Command line tool [kubectl](kubectl).  

Kubernetes [Dashboard](Dashboard).  

### Expose apps through Services

`ServiceType`s specify the kind of service you want:
* `ClusterIP` (default): `Service` only reachable from within Kubernetes; expose `Service` on a cluster-internal IP
* `NodePort`: `Service` accessible from outside Kubernetes using `Node-IP:Node-Port`; expose `Service` on each `Node`’s IP at a static port (`Node-Port`); creates a `ClusterIP` `Service` to which it routes
* `LoadBalancer`: an external load balancer assigns a fixed, external IP to the `Service`; expose `Service` using a cloud provider’s load balancer; creates a `ClusterIP` and `NodePort` `Service`s to which it routes
* `ExternalName`: maps `Service` to `externalName` field by returning a CNAME record; no proxy is used

`Headless Service`s are used to interface with other service discovery mechanisms, without being tied to Kubernetes.  

[Details](Docs/Concepts/ServicesLoadBalancingNetworking/Service)

### Ingress

`Ingress` is not a `ServiceType`, but it does exposes `Service`s.  
`Ingress` is an entry point for your cluster.  
`Ingress` consolidates routing rules and exposes multiple `Service`s under the same IP address.  
`Ingress` doesn't expose ports or protocols, just HTTP(S)!  

[Ingress](Docs/Concepts/ServicesLoadBalancingNetworking/Ingress)  
[Ingress Controllers](Docs/Concepts/ServicesLoadBalancingNetworking/IngressController)  
[Minikube NGINX with /etc/host](Docs/Tasks/AccessAppsInCluster/SetupIngressOnMinikube)  

### Containers

[command and args](Docs/Tasks/InjectDataIntoApps/CommandArgumentContainer)  

### ENV VARs: how Containers in Pods use them

[Intro](Docs/Tasks/InjectDataIntoApps/EnvironmentVariablesContainer)  
[Configuration of Downward API](Docs/Tasks/InjectDataIntoApps/PodInfoThroughEnvVar)  

### ConfigMaps: how Containers in Pods use them

```
# Note: restrict namespace with [-n K8s-Namespace]

$: kubectl create configmap ConfigMap-Name --from-env-file=/path/to/ConfigMap-Dir/Config-0.properties
$: kubectl describe configmaps ConfigMap-Name
$: kubectl get configmaps ConfigMap-Name -o yaml
```

```
spec:
  containers:
      command: [ "/bin/sh", "-c", "echo $(ENV_VAR_0)" ]
      envFrom:
        - configMapRef:
            name: ConfigMap-Name-1
      env:
        - name: ENV_VAR_0
          valueFrom:
            configMapKeyRef:
              name: ConfigMap-Name-0
              key: Key-0
```

[Instructions](Docs/Tasks/ConfigurePodsContainers/ConfigurePodToUseConfigMap)

### Private repositories and images

```
$: docker login Private-Registry-Ip-Port

$: kubectl create secret generic Private-Repo-Secret --from-file=.dockerconfigjson=/path/to/.docker/config.json --type=kubernetes.io/dockerconfigjson

# Note: pods can only reference image pull secrets in their own namespace!
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

[Instructions](Docs/Concepts/ClusterAdministration/ManagingResources)

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
