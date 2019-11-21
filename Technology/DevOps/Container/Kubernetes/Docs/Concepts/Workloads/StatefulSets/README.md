## [StatefulSets](https://kubernetes.io/docs/concepts/workloads/controllers/statefulset/)

`StatefulSet` manages stateful apps (unlike Deployments which manage replicated apps).  
`StatefulSet` provides guarantees about the ordering and uniqueness of `Pod`s.  
A `StatefulSet` maintains a sticky identity for each of their `Pod`s.  
`StatefulSet` `Pod`s are not interchangeable and persist across rescheduling.  

### Using StatefulSets

Useful if an apps requires:
* stable, unique network identifiers
* stable, persistent storage
* ordered deployment and scaling
* ordered rolling updates

Stable means: will persist across `Pod` (re)scheduling.  

### Limitations

* storage must be provisioned manually or by a `Provisioner`/`StorageClass`
* deleting a `StatefulSet` will not delete the volumes
* `StatefulSet`s require a `Headless Service` for the network identity of the `Pod`s (you have to create a `Headless Service`)
* there are no termination guarantees then you delete a `StatefulSet`
* may enter into a broken state if using `Rolling Updates`

### Components

```
apiVersion: v1
kind: Service
metadata:
  name: nginx
  labels:
    app: nginx
spec:
  type: ClusterIP
  ports:
  - port: 80
    name: web
  clusterIP: None
  selector:
    app: nginx
---
apiVersion: apps/v1
kind: StatefulSet
metadata:
  name: web
spec:
  selector:
    matchLabels:
      app: Label-Name
  serviceName: "nginx"
  replicas: 3
  template:
    metadata:
      labels:
        app: Label-Name
    spec:
      terminationGracePeriodSeconds: 10
      containers:
      - name: nginx
        image: k8s.gcr.io/nginx-slim:0.8
        ports:
        - containerPort: 80
          name: web
        volumeMounts:
        - name: www
          mountPath: /usr/share/nginx/html
  volumeClaimTemplates:
  - metadata:
      name: www
    spec:
      accessModes: [ "ReadWriteOnce" ]
      storageClassName: "my-storage-class"
      resources:
        requests:
          storage: 1Gi
# Note: .spec.selector field of a StatefulSet must match the .spec.template.metadata.labels field
```

### Pod Identity

Stable means: will persist across `Pod` (re)scheduling.  

`StatefulSet` `Pod`s have a unique identity made of:
* an ordinal (think: positive number)
* a stable network identity
* a stable storage

Each `Pod` in a `StatefulSet` has a hostname $(statefulset name)-$(ordinal).  
The domain managed by a `Headless Service` is $(service name).$(namespace).svc.cluster.local (cluster.local is the cluster domain).  
Each `Pod` gets a matching DNS subdomain $(podname).$(governing service domain) (governing service is the serviceName field).  

| Cluster Domain | Service (ns/name) | StatefulSet (ns/name) | StatefulSet Domain              | Pod DNS                                      | Pod Hostname |
|----------------|:-----------------:|----------------------:|---------------------------------|----------------------------------------------|--------------|
| Cluster-Domain  |     Service-Namespace/Service-Name     |               Service-Namespace/StatefulState-Name | Service-Name.Service-Namespace.svc.Cluster-Domain     | StatefulState-Name-{0..N-1}.Service-Name.Service-Namespace.svc.Cluster-Domain     | StatefulState-Name-{0..N-1} |
| cluster.local  |   default/nginx   |           default/web | nginx.default.svc.cluster.local | web-{0..N-1}.nginx.default.svc.cluster.local | web-{0..N-1} |
| kube.local     |     foo/nginx     |               foo/web | nginx.foo.svc.kube.local        | web-{0..N-1}.nginx.foo.svc.kube.local        | web-{0..N-1} |

Kubernetes creates one `PersistentVolume` for each `VolumeClaimTemplate`.  

A `Pod` is given a label, statefulset.kubernetes.io/Pod-Name by the `StatefulState` controller.  

### Deployment and Scaling Guarantees

* `Pod`s are created in order
* `Pod`s are terminated in reverse order
* before scaling all `Pod`'s predecessors must be Running and Ready
* before a `Pod` is terminated all its successors must be shutdown

DO NOT specify a pod.Spec.TerminationGracePeriodSeconds of 0.  

You can relax ordering guarantees via the .spec.podManagementPolicy field.  

### Update Strategies

.spec.updateStrategy field allows you to configure rolling updates.  

TODO
