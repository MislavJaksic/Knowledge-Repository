## [Persistent Volumes](https://kubernetes.io/docs/concepts/storage/persistent-volumes/)

A PersistentVolume (PV) is storage provisioned by an administrator or dynamically provisioned using Storage Classes.  
A PersistentVolume is a resource in the cluster just like a node is a cluster resource.  
PersistentVolume is a volume plugin, but it has an independent lifecycle.  

A PersistentVolumeClaim (PVC) is a request for storage.  
PersistentVolumeClaim is similar to a pod.  
Pods consume node resources and PersistentVolumeClaims consume PersistentVolume resources.  

A StorageClass resource allows admins to offer a variety of PersistentVolumes.  

### Lifecycle of a volume and claim

PVs are resources in the cluster.  
PVCs are requests for PVs.  

PVs can be provisioned statically or dynamically.
If statically, a cluster admin has to create a PV.  
If dynamically, a cluster admin has to create a StorageClass. They also have to enable the DefaultStorageClass admission controller on the API server.  

When a PVC is created the control loop will assign it to a PV.  
The PV may be in access of what the PVC is asking.  

Pods use claims as volumes.  
A PV belongs to the PVC for as long as it needs it.  
Pods access claimed PVs by including a persistentVolumeClaim in their Pod’s volumes block.  

A PVC is protected when the Finalizers list in a PVC includes kubernetes.io/pvc-protection.  
a PV is protected when the Finalizers list includes kubernetes.io/pv-protection.  

When done using the volume, delete the PVC.  
The reclaim policy for a PV tells the cluster what to do with the volume after it has been released of its claim.
* retain - when the PVC is deleted the PV will exist until manually reclaimed
* delete - deletion removes both the PV and the storage asset (AWS EBS, GCE PD, Azure Disk, Cinder, ...); dynamically provisioned volumes inherit a reclim policy from StorageClass
* recycle - DEPRECATED; use dynamic provisioning

TODO

### Types of Persistent Volumes

TODO

### Persistent Volumes

```
apiVersion: v1
kind: PersistentVolume
metadata:
  name: pv0003
spec:
  capacity:
    storage: 5Gi
  volumeMode: Filesystem
  accessModes:
    - ReadWriteOnce
  persistentVolumeReclaimPolicy: Recycle
  storageClassName: slow
  mountOptions:
    - hard
    - nfsvers=4.1
  nfs:
    path: /tmp
    server: 172.17.0.2
```

TODO

### PersistentVolumeClaims

```
apiVersion: v1
kind: PersistentVolumeClaim
metadata:
  name: myclaim
spec:
  accessModes:
    - ReadWriteOnce
  volumeMode: Filesystem
  resources:
    requests:
      storage: 8Gi
  storageClassName: slow
  selector:
    matchLabels:
      release: "stable"
    matchExpressions:
      - {key: environment, operator: In, values: [dev]}
```

TODO

### Claims As Volumes

```
apiVersion: v1
kind: Pod
metadata:
  name: mypod
spec:
  containers:
    - name: myfrontend
      image: nginx
      volumeMounts:
      - mountPath: "/var/www/html"
        name: mypd
  volumes:
    - name: mypd
      persistentVolumeClaim:
        claimName: myclaim
```

TODO

### Raw Block Volume Support

TODO

and many more topics