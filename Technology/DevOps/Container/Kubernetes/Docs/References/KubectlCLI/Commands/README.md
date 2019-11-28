## [kubectl Commands](https://kubernetes.io/docs/reference/kubectl/kubectl-cmds/)

[Source](https://kubernetes.io/docs/reference/generated/kubectl/kubectl-commands)  

### GETTING STARTED

#### get

Displays resource. Like `describe`, but with flags.  

```
$: kubectl get Resource-Type/Resource-Name [-f] [-k] [-o Output-Option] [--watch] [--field-selector=field.subfield=Field-Value]
  # -f: use file
  # -k: use kustomize
  # -o: specify output option
  # --watch: watch for changes
  # --field-selector: field query
```

#### run

Create and run an image.  

```
$: kubectl run Id-Name --image=Image-Name [--env="Env-Var-Name=Env-Var-Value"] [--port=Expose-Port] [--replicas=X] [--dry-run] [--command -- _command _arg0.._argN]
  # --port: port that the container exposes
  # --dry-run: prints object, instead of running it
```

#### expose

Expose a resource as a `Service`.  

```
$: kubectl expose Specific-Type/Resource-Name [--port=Service-Port] [--target-port=Container-Port] [--protocol=Protocol-Name] [--name=Service-Name]
  # --port: service should serve on it
  # --target-port: direct traffic to this container port
  # --protocol: network protocol
```

#### delete

Delete resource. Supports graceful deletion.  
Careful with force deletion.  

```
$: kubectl delete Resource-Type/Resource-Name [-f] [-k] [-l name=Label-Name] [--now] [--force] [--grace-period=X]
  # -f: use file
  # -k: use kustomize
  # -l name: label query
```

### APP MANAGEMENT

TODO

#### apply

Apply a configuration to a resource.  

```
$: kubectl apply (-f file-Name | -f /path/to/dir) [-k] [URL]
  # -f: use file
  # -k: use kustomize
```

#### annotate

Update annotation which is a more detailed label.  

```
$: kubectl annotate Resource-Type/Resource-Name Annotation-Name=Annotation-Value [--overwrite] [Annotation-Name-]
  # --overwrite: overwrite existing annotation
  # Annotation-Name-: delete annotation
```

#### autoscale

```
$: kubectl autoscale Resource-Type/Resource-Name --max=X [--min=Y] [--cpu-percent=Z]
  # --cpu-percent: target CPU utilization
```

#### edit

Edits a resource using a `KUBE_EDITOR` or `EDITOR`.  

```
$: [KUBE_EDITOR="nano"] kubectl edit Resource-Type/Resource-Name
```

#### label

Update labels.  

```
$: kubectl label Resource-Type/Resource-Name Label-Name=Label-Value [--overwrite] [Annotation-Name-]
  # --overwrite: overwrite existing annotation
  # Label-Name-: delete annotation
```

#### patch

Update fields of a resource using strategic merge patch or a JSON merge patch.  

```
$: kubectl patch Resource-Type/Resource-Name -p Patch-Template
```

[About patching](../../../../Docs/Tasks/RunApps/UpdateObjects)

#### replace

Replace a resource.  

```
$: cat File-Name | kubectl replace -f -
$: kubectl replace --force -f File-Name
```

#### rollout

Manages rollout of:
* `Deployment`
* `DaemonSet`
* `StatefulSet`

```
$: kubectl rollout history Specific-Type/Resource-Name [--revision=X]
  # --revision: specify revision number

$: kubectl rollout restart Specific-Type/Resource-Name

$: kubectl rollout status Specific-Type/Resource-Name [--watch]
  # --watch: watch for changes

$: kubectl rollout undo Specific-Type/Resource-Name [--revision=X] [--dry-run]
  # --revision: specify revision number
  # --dry-run: prints object, instead of running it
```

#### scale

Set size under precondition.  

```
$: kubectl scale Resource-Type/Resource-Name --replicas=X [--current-replicas=Y]
  # --current-replicas: if current-replica is X
```

#### set

Changes existing app resources.  

```
$: kubectl set image Specific-Type/Resource-Name Container-Name-0=Container-Image-0 Container-Name-1=Container-Image-1
```

### WORKING WITH APPS

#### attach

TODO

#### describe

Print a detailed description of the selected resources.  

```
$: kubectl describe Resource-Type/Resource-Name [-f]
  # -f: use file
```

#### exec

Execute a command in a container.  

```
$: kubectl exec Pod-Name [-c Container-Name] [-it] -- _command [_arg0.._argN]
  # -c: specify container
  # -it: interactive pretty print
$: kubectl exec Resource-Type/Resource-Name [-c Container-Name] [-it] -- _command [_arg0.._argN]
  # -c: specify container
  # -it: interactive pretty print
```

#### logs

List `Container` log in a `Pod`.  

```
$: kubectl logs Pod-Name [-f] [-l Label-Name=Label-Value] [--since=X] [-c Container-Name] [--all-containers]
  # -f: streams logs; like `tail -f`
  # --since: in the last X time units
  # -c: specify container
```

#### port-forward

TODO

#### top

TODO

### CLUSTER MANAGEMENT

#### api-versions

TODO

### KUBECTL SETTINGS AND USAGE

#### api-resources

TODO

#### explain

List the fields for supported resources.  
Use case:
* learn more about a resource
*

```
$: kubectl explain Resource-Type[.field.subfield]
```

#### kustomize

TODO
