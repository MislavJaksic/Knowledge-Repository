## [Kubernetes](https://kubernetes.io/)

Kubernetes is a container orchestra conductor.

### Install

Installers are: `kubeadm`, `kops`, `KRIB`, `kubespray`, ...

#### Minikube: local Kubernetes

```
$: minikube config view
$: minikube start

$: minikube ip
$: minikube dashboard
$: minikube service Service-Name [-n K8n-Namespace] [--url]

$: minikube stop
$: minikube delete
```

[Install instructions](Docs/Tasks/InstallTools)  
[User instructions](Docs/GettingStarted/Learning/InstallingKubernetesWithMinikube)  
[Hello World: Minikube](Docs/Tutorials/HelloMinikube)  

### kubectl

```
# Note: restrict namespace with [-n K8s-Namespace]
# Note: Resource-Type Resource-Name == Resource-Type/Resource-Name

$: kubectl get Resource-Type/Resource-Name [-f] [-k] [-o Output-Option] [--watch] [--field-selector=field.subfield=Field-Value] [-LLabel-Name]
$: kubectl run Id-Name --image=Image-Name [--env="Env-Var-Name=Env-Var-Value"] [--port=Expose-Port] [--replicas=X] [--dry-run] [--command -- _command _arg0.._argN]
$: kubectl delete Resource-Type/Resource-Name [-f] [-k] [-l Label-Name=Label-Value] [--now] [--force] [--grace-period=X]
$: kubectl delete Resource-Type/Resource-Name --grace-period=0 --force  # delete "stuck" resources

$: kubectl apply (-f File-Name | -f /path/to/dir | -f URL) [-k] [-R]
$: [KUBE_EDITOR="nano"] kubectl edit Resource-Type/Resource-Name
$: kubectl rollout restart Specific-Type/Resource-Name

$: kubectl describe Resource-Type/Resource-Name [-f]
$: kubectl exec Pod-Name [-c Container-Name] [-it] -- _command [_arg0.._argN]
$: kubectl exec Resource-Type/Resource-Name [-c Container-Name] [-it] -- _command [_arg0.._argN]
$: kubectl logs Pod-Name [-f] [-l Label-Name=Label-Value] [--since=X] [-c Container-Name] [--all-containers]
```

[Installation instruction](Docs/Tasks/InstallTools/InstallKubectl)  
[Overview: examples, operations and resource types](Docs/References/KubectlCLI/Overview)  
[Cheat sheet](Docs/References/KubectlCLI/CheatSheet)  
[Commands](Docs/References/KubectlCLI/Commands)  

### Remote kubectl and accessing multiple Kubernetes

`kubectl` `config` file location: `~/.kube/config`  
`config`s can be merged (by copy-pasting).  

```
# Note: connect to a remote machine with a `config` file
$: sudo scp -i Private-Key.key _username@_ip:/path/to/.kube/config .

# Note: use multiple `config` files
# Note: it's as if they were merged
  # KUBECONFIG=~/.kube/config-0:~/.kube/config-1

$: kubectl version  # list client, server version
$: kubectl cluster-info [--dump]  # list client, cluster info

$: kubectl config view [--minify]  # list `config` file
$: kubectl config use-context Context-Name  # switch context

$: kubectl config set-context --current --namespace=Namespace-Name  # set namespace to avoid writing `-n K8n-Namespace`
```

[Instructions](Other/RemoteKubectl)  
[Official instructions](Docs/Tasks/AccessAppsInCluster/ConfigureAccessToClusters)

### Connect to a remote Dashboard

```
$: kubectl apply -f https://raw.githubusercontent.com/kubernetes/dashboard/v2.0.0-beta8/aio/deploy/recommended.yaml  # deploy dashboard

# Note: connect to a remote machine with a `config` file
# Note: locate your kubeconfig or config file
# Note: most likely locations are `~/.kube/config`, `/home/ubuntu/.kube/config`, `/etc/kubernetes/admin.conf`, ...

$: grep 'client-certificate-data' /path/to/config | head -n 1 | awk '{print $2}' | base64 -d >> kubecfg.crt
$: grep 'client-key-data' /path/to/config | head -n 1 | awk '{print $2}' | base64 -d >> kubecfg.key
$: openssl pkcs12 -export -clcerts -inkey kubecfg.key -in kubecfg.crt -out kubecfg.p12

$: sudo scp -i Private-Key.key _username@_ip:/path/to/.kube/kubecfg.p12 .
```

Import the certificate into your browser.  

```
https://Kubectl-Server-IP:Kubectl-Server-Port/api/v1/namespaces/kubernetes-dashboard/services/https:kubernetes-dashboard:/proxy/#!/login
```

[Instructions](Other/RemoteKubernetesDashboard)

### Create a Bearer token

```
# Note: create ServiceAccount and ClusterRoleBinding first

$: kubectl -n kubernetes-dashboard describe secret $(kubectl -n kubernetes-dashboard get secret | grep admin-user | awk '{print $1}')  # ->
  # Name:         admin-user-token-ID
  # Namespace:    kubernetes-dashboard
  # Labels:       <none>
  # Annotations:  kubernetes.io/service-account.name: admin-user
  #               kubernetes.io/service-account.uid:  ...
  # Type:  kubernetes.io/service-account-token
  # Data
  # ====
  # ca.crt:     X bytes
  # namespace:  Y bytes
  # token:      Bearer-Token
```

[Instructions](Other/DashboardDocs/UserGuide/AccessControl)

### Services: how to expose apps to the outside world

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
`Ingress` consolidates routing rules and will expose multiple `Service`s under the same IP address.  
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
Use labels and label selectors.  
Chain (nest) `kubectl` commands.  
Recursively apply a `kubectl` command on each directory with `-R`.  
Distinguish (canary) releases with labels.  
Label with `label`.  
Annotate with `annotate`.  
Scale with `scale` or `autoscale`.  

[Instructions](Docs/Concepts/ClusterAdministration/ManagingResources)
