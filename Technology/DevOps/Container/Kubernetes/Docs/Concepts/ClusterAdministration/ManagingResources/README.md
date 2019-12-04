## [Managing Resources](https://kubernetes.io/docs/concepts/cluster-administration/manage-deployment/)

### Organizing resource configurations

Group related resources into a single YAML.  

```
apiVersion: v1
kind: Service
...
---
apiVersion: apps/v1
kind: Deployment
...
```

```
$: kubectl apply -f File-Name.yaml  # created in order they appear in
$: kubectl apply -f /path/to/dir
$: kubectl apply -f URL
```

### Bulk operations in kubectl

Bulk operations:
* `apply`
* `delete`

Use label selectors.  
Chain (nest) commands.  
Recursively apply an operation on each directory.  

```
$: kubectl _operation [-l Label-Name=Label-Value] [-R]
```

### Using labels effectively

Labels slice and dice resources.  

```
$: kubectl get pods -Lapp -Ltier -Lrole  # ->
  # NAME                           ...   APP         TIER       ROLE
  # guestbook-fe-4nlpb             ...   guestbook   frontend   <none>
  # guestbook-fe-ght6d             ...   guestbook   frontend   <none>
  # guestbook-fe-jpy62             ...   guestbook   frontend   <none>
  # guestbook-redis-master-5pg3b   ...   guestbook   backend    master
  # guestbook-redis-slave-2q2yf    ...   guestbook   backend    slave
  # guestbook-redis-slave-qgazl    ...   guestbook   backend    slave
  # my-nginx-divi2                 ...   nginx       <none>     <none>
  # my-nginx-o0ef1                 ...   nginx       <none>     <none>
```

### Canary deployments

Distinguish (canary) releases using labels.  
Canary is a new release that is tested on live traffic before rollout.  

```
name: frontend               name: frontend-canary
replicas: 3                  replicas: 1
...                          ...
labels:                      labels:
  app: guestbook               app: guestbook
  tier: frontend               tier: frontend
  track: stable                track: canary  # different labels!
...                          ...
image: gb-frontend:v3        image: gb-frontend:v4

selector:  # some traffic is directed to the canary deployment
  app: guestbook
  tier: frontend
```

### Updating labels

```
$: kubectl label Resource-Type Label-Name=Label-Value [-l Label-Name=Label-Value]
```

### Updating annotations

```
$: kubectl annotate Resource-Type/Resource-Name Annotation-Name=Annotation-Value
```

### Scaling your application

```
$: kubectl scale Resource-Type/Resource-Name --replicas=X
$: kubectl autoscale Resource-Type/Resource-Name --max=X [--min=Y]
```

### In-place updates of resources

Update with:
* `apply`
* `edit`
* `patch`

### Disruptive updates

```
$: kubectl replace -f File-Name/Dir/URL --force
```
