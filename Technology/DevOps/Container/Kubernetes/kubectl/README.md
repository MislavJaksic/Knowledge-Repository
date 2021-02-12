## [kubectl](https://kubectl.docs.kubernetes.io/)

### Install

[Install kubectl](Other/Kubernetes/Docs/Tasks/InstallTools/InstallKubectl)  

### Config file

Common `/path/to/kubectl/config`:
* `~/.kube/config`
* `/home/ubuntu/.kube/config`
* `/etc/kubernetes/admin.conf`

`config`s can be merged. See Research.  

```
# Note: connect to a remote machine
$: sudo scp -i Private-Key.key _username@_ip:/path/to/kubectl/config .

# Note: use multiple `config` files
# Note: it's as if they were merged
  # KUBECONFIG=~/.kube/config-0:~/.kube/config-1

$: kubectl config view [--minify] [--raw]  # list `config` file
$: kubectl version  # list client, server version
$: kubectl cluster-info [--dump]  # list client, cluster info

$: kubectl config use-context Context-Name  # switch context
$: kubectl config set-context --current --namespace=Namespace-Name  # set namespace to avoid writing `-n K8n-Namespace`

$: kubectl config delete-cluster Cluster-Name
$: kubectl config delete-context Context-Name
# Note: you need to delete the user manually
```

[Official instructions](Other/Kubernetes/Docs/Tasks/AccessAppsInCluster/ConfigureAccessToClusters)
[Supplementary instructions](Other/RemoteKubectl)  

### Autocomplete

```
$: type _init_completion  # check if you have bash-completion

$: sudo apt-get install bash-completion
$: sudo yum install bash-completion

$: source <(kubectl completion bash)
$: echo "source <(kubectl completion bash)" >> ~/.bashrc
OR
$: source <(kubectl completion zsh)
$: echo "if [ $commands[kubectl] ]; then source <(kubectl completion zsh); fi" >> ~/.zshrc
```

[Cheat sheet](Other/Kubernetes/Docs/References/KubectlCLI/CheatSheet)  

### Usage

```
# Note: restrict namespace with [-n K8s-Namespace]
# Note: Resource-Type Resource-Name == Resource-Type/Resource-Name

$: kubectl api-versions
$: kubectl api-resources
$: kubectl explain Resource-Type[.field.subfield]

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

[Overview: examples, operations and resource types](Other/Kubernetes/Docs/References/KubectlCLI/Overview)  
[Commands](Other/Kubernetes/Docs/References/KubectlCLI/Commands)  
