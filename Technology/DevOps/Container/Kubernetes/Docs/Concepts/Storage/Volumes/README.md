## [Volumes](https://kubernetes.io/docs/concepts/storage/volumes/)

`Volume`s allow containers to be restarted and to share data with other containers in a `Pod`.  

### Background

```
In Docker, a volume is simply a directory on disk or in another Container.
```

A Kubernetes `Volume` has a lifetime: the `Pod` that encloses it.  
A `Volume` outlives any Containers and data is preserved across Container restarts.  

A `Volume` is a directory with some data which is accessible to the Containers in a `Pod`.  

A `Pod` specifies:
* `Volume`s in the .spec.volumes field
* where to mount those into Containers in the .spec.containers.volumeMounts field

### Types of Volumes

There are so many...

#### persistentVolumeClaim

A `PersistentVolumeClaim` volume is used to mount a `PersistentVolume` into a `Pod`.  
`PersistentVolume`s claim durable storage.  

TODO

### Using subPath

You can share one `Volume` for multiple uses in a single `Pod`.  
The `volumeMounts.subPath` field can be used to specify a sub-path inside the referenced `Volume` instead of its root.  

### Resources

TODO

### Out-of-Tree Volume Plugins

TODO

### Developer resources

TODO

### Mount propagation

You can share mounted `Volume`s with `Container`s in the same `Pod` or on the same `Node`.  

Mount propagation is controlled by the `mountPropagation` field in `Container.volumeMounts`.  
* `None` - default; no subsequent mounts and mounts are not visible on the host
* `HostToContainer` - receive all subsequent mounts; if the host mounts anything inside the `Volume` mount, the `Container` will see it mounted there
* `Bidirectional` - allowed only in privileged containers; same as `HostToContainer`; all `Volume` mounts created by the `Container` will be propagated back to the host and to all `Container`s of all `Pod`s that use the same `Volume`

#### Enable Docker mount propagation

Edit your `Docker`'s `systemd` service file.
* set `MountFlags=shared`
* remove `MountFlags=slave`
* then restart Docker daemon

```
$: sudo systemctl daemon-reload
$: sudo systemctl restart docker
```
