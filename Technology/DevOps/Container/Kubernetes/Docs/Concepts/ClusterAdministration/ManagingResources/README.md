## [Managing Resources](https://kubernetes.io/docs/concepts/cluster-administration/manage-deployment/)

### Organizing resource configurations

Resources can be grouped up into a single YAML.  

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

TODO
