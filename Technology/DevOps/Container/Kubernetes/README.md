## [Kubernetes](https://kubernetes.io/)

Kubernetes is a container orchestra conductor.

### Install

A few other installers are: `kubeadm`, `kops`, `KRIB`, `kubespray`, ...

#### Minikube: local Kubernetes

[Install instructions](Docs/Tasks/InstallTools)  
[User instructions](Docs/GettingStarted/Learning/InstallingKubernetesWithMinikube)

```
$: minikube start
$: minikube stop

$: minikube delete
```

### kubectl

```
# Note: restrict namespace with [-n K8s-Namespace]

$: kubectl apply -f File-Name.yaml
$: kubectl apply -f /path/to/dir

$: kubectl get Resource-Type [-o Output-Option] [--watch] [--field-selector=field.subfield=Field-Value]  # like `describe`, but with flags
$: kubectl get Resource-Type Resource-Name
$: kubectl get Resource-Type,Resource-Type

$: kubectl describe Resource-Type  # like `get`, but more details
$: kubectl describe Resource-Type Resource-Name
$: kubectl describe Resource-Type/Resource-Name

$: kubectl delete Resource-Type [--all]
$: kubectl delete -f File-Name.yaml  # delete that type and name
$: kubectl delete Resource-Type,Resource-Type -l name=Label-Name

$: kubectl exec Pod-Name [-c Container-Name] _command  # defaults to first container
$: kubectl exec -ti Pod-Name /bin/bash

$: kubectl logs [-f] Pod-Name
  #-f: streams logs; like `tail -f`


$: kubectl rollout restart Resource-Type/Resource-Name

$: [KUBE_EDITOR="nano"] kubectl edit Resource-Type/Resource-Name
```

[Overview: examples, operations and resource types](Docs\References\KubectlCLI\Overview)  
[Commands](Docs\References\KubectlCLI\KubectlCommands)

### Remote kubectl and accessing multiple Kubernetes

kubectl `config` file location: `~/.kube/config`  
`config`s can be merged (by copy-pasting).  

```
$: kubectl version  # list client, server version
$: kubectl cluster-info [--dump]  # list client, cluster info
$: kubectl config view [--minify]  # list `config` file

$: kubectl config use-context Context-Name  # change `current-context` field
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
