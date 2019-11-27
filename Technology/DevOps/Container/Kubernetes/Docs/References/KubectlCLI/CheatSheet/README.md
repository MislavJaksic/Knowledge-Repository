## [kubectl Cheat Sheet](https://kubernetes.io/docs/reference/kubectl/cheatsheet/)

### Kubectl Autocomplete

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

### Kubectl Context and Configuration

[Detailed instructions](../../../../Docs/Tasks/AccessAppsInCluster/ConfigureAccessToClusters)

```
# Note: use multiple `config` files
# Note: it's as if they were merged
  # KUBECONFIG=~/.kube/config-0:~/.kube/config-1

$: kubectl config view [--minify]  # show `config`
$: kubectl config use-context Context-Name  # switch context

$: kubectl config set-context --current --namespace=Namespace-Name  # set namespace to avoid writing [-n K8n-Namespace]
```

### Creating Objects

`apply` manages resources:
* define
* create
* update

```
$: kubectl apply -f File-Name-0 -f File-Name-1
$: kubectl apply -f /path/to/Dir-Name
$: kubectl apply -f URL

$: kubectl create Resource-Type Resource-Name

$: kubectl explain Resource-Type,Resource-Type
```

### Viewing, Finding Resources
```
$: kubectl get Resource-Type Resource-Name [-o Output-Option] [-n K8n-Namespace] [--selector=Label-Name=Label-Value] [--field-selector=.field.subfield=Field-Value] [--sort-by=.field.subfield]

$: kubectl describe Resource-Type Resource-Name
```

### Updating Resources

```
$: kubectl set image Resource-Type/Resource-Name Container-Name-0=Container-Image-0 Container-Name-1=Container-Image-1

$: kubectl rollout history Specific-Type/Resource-Name [--revision=X]
$: kubectl rollout undo Resource-Type/Resource-Name [--revision=X] [--dry-run=true]
$: kubectl rollout status Resource-Type/Resource-Name [-w]

$: cat File-Name | kubectl replace -f -
$: kubectl replace --force -f File-Name

$: kubectl expose Specific-Type/Resource-Name [--port=Server-Port] [--target-port=Container-Port] [--protocol=Protocol-Name] [--name=Service-Name]

$: kubectl label Resource-Type/Resource-Name Label-Name=Label-Value [--overwrite] [Annotation-Name-]
$: kubectl annotate Resource-Type/Resource-Name Annotation-Name=Annotation-Value [--overwrite] [Annotation-Name-]
$: kubectl autoscale Resource-Type/Resource-Name --max=X [--min=Y] [--cpu-percent=Z]
```

### Patching, Editing, Scaling and Deleting Resources

```
$: kubectl patch Resource-Type/Resource-Name -p Patch-Template

$: [KUBE_EDITOR="nano"] kubectl edit Resource-Type/Resource-Name

$: kubectl scale Resource-Type/Resource-Name --replicas=X [--current-replicas=Y]

$: kubectl delete Resource-Type/Resource-Name [-l name=Label-Name] [--now] [--force] [--grace-period=X]
```

### Interacting with running Pods

```
$: kubectl logs Pod-Name [-f] [-l Label-Name=Label-Value] [--since=X] [-c Container-Name] [--all-containers]

$: kubectl run Id-Name --image=Image-Name [--env="Env-Var-Name=Env-Var-Value"] [--port=Expose-Port] [--replicas=X] [--dry-run] [--command -- _command _arg0.._argN]

$: kubectl exec Pod-Name [-c Container-Name] [-i] [-t] -- _command [_arg0.._argN]
$: kubectl exec Resource-Type/Resource-Name [-c Container-Name] [-it] -- _command [_arg0.._argN]
```

### Interacting with Nodes and Cluster

TODO
