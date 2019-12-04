## [Overview of kubectl](https://kubernetes.io/docs/reference/kubectl/overview/)

`kubectl` is a CLI for Kubernetes.  
It connects using `$HOME/.kube/config` or `--kubeconfig`.  

### Syntax

```
#: kubectl [command] [TYPE] [NAME] [flags]
  # command: create, get, describe, delete, ...
  # TYPE: resource type; pod, configmap, ...
  # NAME: resource name
  # flags: optional configuration
```

### Operations

| Operation       | Description                                                                                                          |
|-----------------|----------------------------------------------------------------------------------------------------------------------|
| annotate        | Add or update the annotations of one or more resources\.                                                             |
| api\-versions   | List the API versions that are available\.                                                                           |
| apply           | Apply a configuration change to a resource from a file or stdin\.                                                    |
| attach          | Attach to a running container either to view the output stream or interact with the container \(stdin\)\.            |
| autoscale       | Automatically scale the set of pods that are managed by a replication controller\.                                   |
| cluster\-info   | Display endpoint information about the master and services in the cluster\.                                          |
| config          | Modifies kubeconfig files\. See the individual subcommands for details\.                                             |
| create          | Create one or more resources from a file or stdin\.                                                                  |
| delete          | Delete resources either from a file, stdin, or specifying label selectors, names, resource selectors, or resources\. |
| describe        | Display the detailed state of one or more resources\.                                                                |
| diff            | Diff file or stdin against live configuration \(BETA\)                                                               |
| edit            | Edit and update the definition of one or more resources on the server by using the default editor\.                  |
| exec            | Execute a command against a container in a pod\.                                                                     |
| explain         | Get documentation of various resources\. For instance pods, nodes, services, etc\.                                   |
| expose          | Expose a replication controller, service, or pod as a new Kubernetes service\.                                       |
| get             | List one or more resources\.                                                                                         |
| label           | Add or update the labels of one or more resources\.                                                                  |
| logs            | Print the logs for a container in a pod\.                                                                            |
| patch           | Update one or more fields of a resource by using the strategic merge patch process\.                                 |
| port\-forward   | Forward one or more local ports to a pod\.                                                                           |
| proxy           | Run a proxy to the Kubernetes API server\.                                                                           |
| replace         | Replace a resource from a file or stdin\.                                                                            |
| rolling\-update | Perform a rolling update by gradually replacing the specified replication controller and its pods\.                  |
| run             | Run a specified image on the cluster\.                                                                               |
| scale           | Update the size of the specified replication controller\.                                                            |
| version         | Display the Kubernetes version running on the client and server\.                                                    |

### Resource types

| Resource Name                   | Short Names | API Group                      | Namespaced | Resource Kind                  |
|---------------------------------|-------------|--------------------------------|------------|--------------------------------|
| bindings                        |             |                                | true       | Binding                        |
| componentstatuses               | cs          |                                | false      | ComponentStatus                |
| configmaps                      | cm          |                                | true       | ConfigMap                      |
| endpoints                       | ep          |                                | true       | Endpoints                      |
| limitranges                     | limits      |                                | true       | LimitRange                     |
| namespaces                      | ns          |                                | false      | Namespace                      |
| nodes                           | no          |                                | false      | Node                           |
| persistentvolumeclaims          | pvc         |                                | true       | PersistentVolumeClaim          |
| persistentvolumes               | pv          |                                | false      | PersistentVolume               |
| pods                            | po          |                                | true       | Pod                            |
| podtemplates                    |             |                                | true       | PodTemplate                    |
| replicationcontrollers          | rc          |                                | true       | ReplicationController          |
| resourcequotas                  | quota       |                                | true       | ResourceQuota                  |
| secrets                         |             |                                | true       | Secret                         |
| serviceaccounts                 | sa          |                                | true       | ServiceAccount                 |
| services                        | svc         |                                | true       | Service                        |
| mutatingwebhookconfigurations   |             | admissionregistration\.k8s\.io | false      | MutatingWebhookConfiguration   |
| validatingwebhookconfigurations |             | admissionregistration\.k8s\.io | false      | ValidatingWebhookConfiguration |
| customresourcedefinitions       | crd, crds   | apiextensions\.k8s\.io         | false      | CustomResourceDefinition       |
| apiservices                     |             | apiregistration\.k8s\.io       | false      | APIService                     |
| controllerrevisions             |             | apps                           | true       | ControllerRevision             |
| daemonsets                      | ds          | apps                           | true       | DaemonSet                      |
| deployments                     | deploy      | apps                           | true       | Deployment                     |
| replicasets                     | rs          | apps                           | true       | ReplicaSet                     |
| statefulsets                    | sts         | apps                           | true       | StatefulSet                    |
| tokenreviews                    |             | authentication\.k8s\.io        | false      | TokenReview                    |
| localsubjectaccessreviews       |             | authorization\.k8s\.io         | true       | LocalSubjectAccessReview       |
| selfsubjectaccessreviews        |             | authorization\.k8s\.io         | false      | SelfSubjectAccessReview        |
| selfsubjectrulesreviews         |             | authorization\.k8s\.io         | false      | SelfSubjectRulesReview         |
| subjectaccessreviews            |             | authorization\.k8s\.io         | false      | SubjectAccessReview            |
| horizontalpodautoscalers        | hpa         | autoscaling                    | true       | HorizontalPodAutoscaler        |
| cronjobs                        | cj          | batch                          | true       | CronJob                        |
| jobs                            |             | batch                          | true       | Job                            |
| certificatesigningrequests      | csr         | certificates\.k8s\.io          | false      | CertificateSigningRequest      |
| leases                          |             | coordination\.k8s\.io          | true       | Lease                          |
| events                          | ev          | events\.k8s\.io                | true       | Event                          |
| ingresses                       | ing         | extensions                     | true       | Ingress                        |
| networkpolicies                 | netpol      | networking\.k8s\.io            | true       | NetworkPolicy                  |
| poddisruptionbudgets            | pdb         | policy                         | true       | PodDisruptionBudget            |
| podsecuritypolicies             | psp         | policy                         | false      | PodSecurityPolicy              |
| clusterrolebindings             |             | rbac\.authorization\.k8s\.io   | false      | ClusterRoleBinding             |
| clusterroles                    |             | rbac\.authorization\.k8s\.io   | false      | ClusterRole                    |
| rolebindings                    |             | rbac\.authorization\.k8s\.io   | true       | RoleBinding                    |
| roles                           |             | rbac\.authorization\.k8s\.io   | true       | Role                           |
| priorityclasses                 | pc          | scheduling\.k8s\.io            | false      | PriorityClass                  |
| csidrivers                      |             | storage\.k8s\.io               | false      | CSIDriver                      |
| csinodes                        |             | storage\.k8s\.io               | false      | CSINode                        |
| storageclasses                  | sc          | storage\.k8s\.io               | false      | StorageClass                   |
| volumeattachments               |             | storage\.k8s\.io               | false      | VolumeAttachment               |

### Output options

```
$: kubectl [command] [TYPE] [NAME] -o <output_format>  # default is plain text
```

TODO

### Examples: Common operations

#### apply

Apply or Update a resource from a file or stdin.  

```
$: kubectl apply -f File-Name.yaml
$: kubectl apply -f /path/to/dir
```

#### get

List a resource.  
Like `kubectl describe`, but has powerful flags like `--watch`, which watches for updates.  

```
$: kubectl get Resource-Type [-o Output-Option] [--field-selector=.field.subfield=Field-Value]
$: kubectl get Resource-Type Resource-Name
$: kubectl get Resource-Type,Resource-Type
```

#### describe

Display detailed state of a resource.  
Like `kubectl get`, but focused on providing rich information.  

```
$: kubectl describe Resource-Type
$: kubectl describe Resource-Type Resource-Name
$: kubectl describe Resource-Type/Resource-Name
```

#### delete

Delete resources from:
* file, stdin
* specifying label selectors, names, resource selectors, resources

```
$: kubectl delete Resource-Type [--all]
$: kubectl delete -f File-Name.yaml  # delete that type and name
$: kubectl delete Resource-Type,Resource-Type -l Label-Name=Label-Value
```

#### exec

Execute a command against a `Container` in a `Pod`.  

```
$: kubectl exec Pod-Name _command [-c Container-Name]  # defaults to first container
$: kubectl exec -ti Pod-Name /bin/bash
```

### logs

Print the logs for a `Container` in a `Pod`.  

```
$: kubectl logs Pod-Name [-f] [-c Container-Name]
  # -f: streams logs; like `tail -f`
  # -c: specify container
```

### Examples: Creating and using plugins

TODO
