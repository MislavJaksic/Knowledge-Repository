## [Change the default StorageClass](https://kubernetes.io/docs/tasks/administer-cluster/change-default-storage-class/)

### Why change the default storage class?

Default `StorageClass` is then used to provision storage for `PersistentVolumeClaims`.  

Deleting the default `StorageClass` may not work.  
It may be re-created automatically.  
Consult the documentation.  

### Changing the default StorageClass

```
$: kubectl get storageclass  # ->
  # NAME                 ...
  # Default-Class (default)   ...
  # Non-Default-Class                 ...
```

#### Unmark default StorageClass

```
$: kubectl patch storageclass Default-Class -p '{"metadata": {"annotations":{"storageclass.kubernetes.io/is-default-class":"false"}}}'
```

#### Mark default StorageClass

```
$: kubectl patch storageclass Non-Default-Class -p '{"metadata": {"annotations":{"storageclass.kubernetes.io/is-default-class":"true"}}}'
```
