## [Kubernetes](https://kubernetes.io/)

Kubernetes is a container orchestra conductor.

### Install

A few other installers are: `kubeadm`, `kops`, `KRIB`, `kubespray`, ...

#### Minikube: local Kubernetes

```
$: minikube start
$: minikube stop

$: minikube delete
```

[Install instructions](Docs/Tasks/InstallTools)  
[User instructions](Docs/GettingStarted/Learning/InstallingKubernetesWithMinikube)  

### kubectl

```
# Note: restrict namespace with [-n K8s-Namespace]
# Note: Resource-Type Resource-Name == Resource-Type/Resource-Name

$: kubectl get Resource-Type/Resource-Name [-f] [-k] [-o Output-Option] [--watch] [--field-selector=field.subfield=Field-Value]
$: kubectl run Id-Name --image=Image-Name [--env="Env-Var-Name=Env-Var-Value"] [--port=Expose-Port] [--replicas=X] [--dry-run] [--command -- _command _arg0.._argN]
$: kubectl delete Resource-Type/Resource-Name [-f] [-k] [-l name=Label-Name] [--now] [--force] [--grace-period=X]

$: kubectl apply (-f file-Name | -f /path/to/dir) [-k] [URL]
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

kubectl `config` file location: `~/.kube/config`  
`config`s can be merged (by copy-pasting).  

```
# Note: use multiple `config` files
# Note: it's as if they were merged
  # KUBECONFIG=~/.kube/config-0:~/.kube/config-1

$: kubectl version  # list client, server version
$: kubectl cluster-info [--dump]  # list client, cluster info

$: kubectl config view [--minify]  # list `config` file
$: kubectl config use-context Context-Name  # switch context

$: kubectl config set-context --current --namespace=Namespace-Name  # set namespace to avoid writing [-n K8n-Namespace]
```

[Instructions](Other/RemoteKubectl)  
[Official instructions](Docs/Tasks/AccessAppsInCluster/ConfigureAccessToClusters)

### Connect to a remote Dashboard

Setup browser certificate.  

```
# Note: visit https://Kubectl-Server-IP:Kubectl-Server-Port/api/v1/namespaces/kubernetes-dashboard/services/https:kubernetes-dashboard:/proxy/#!/login
```

[Instructions](Other/RemoteKubernetesDashboard)

### Create a Bearer token

[Instructions](Other/DashboardDocs/UserGuide/AccessControl)

### Running Containers in Pods

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
