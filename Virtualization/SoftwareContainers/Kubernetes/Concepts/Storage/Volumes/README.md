## [Volumes](https://kubernetes.io/docs/concepts/storage/volumes/)

Volumes allow containers to be restarted and to share data with other containers in a Pod.  

### Background

```
In Docker, a volume is simply a directory on disk or in another Container.
```

A Kubernetes volume has a lifetime: the Pod that encloses it.  
A volume outlives any Containers and data is preserved across Container restarts.  

A volume is a directory with some data which is accessible to the Containers in a Pod.  

A Pod specifies:
* volumes in the .spec.volumes field
* where to mount those into Containers in the .spec.containers.volumeMounts field

### Types of Volumes

There are so many...

#### persistentVolumeClaim

A persistentVolumeClaim volume is used to mount a PersistentVolume into a Pod.  
PersistentVolumes claim durable storage.  

TODO

### Using subPath

You can share one volume for multiple uses in a single Pod.  
The volumeMounts.subPath field can be used to specify a sub-path inside the referenced volume instead of its root.  

### Resources

TODO

### Out-of-Tree Volume Plugins

TODO

### Developer resources

TODO

### Mount propagation

You can share mounted volumes with Containers in the same Pod or on the same Node.  

Mount propagation is controlled by the mountPropagation field in Container.volumeMounts.  
* None - default; no subsequent mounts and mounts are not visible on the host
* HostToContainer - receive all subsequent mounts; if the host mounts anything inside the volume mount, the Container will see it mounted there
* Bidirectional - allowed only in privileged containers; same as HostToContainer; all volume mounts created by the Container will be propagated back to the host and to all Containers of all Pods that use the same volume

#### Enable Docker mount propagation

Edit your Docker’s systemd service file.
* set MountFlags=shared
* remove MountFlags=slave
* then restart Docker daemon

```
sudo systemctl daemon-reload
sudo systemctl restart docker
```
