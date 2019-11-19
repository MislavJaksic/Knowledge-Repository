## [StatefulSet Basics](https://kubernetes.io/docs/tutorials/stateful-application/basic-stateful-set/)

`StatefulSet`s are used with stateful apps: ordered or unique `Pod`s with sticky identities.  

### Creating a StatefulSet

```
apiVersion: v1
kind: Service
metadata:
  name: nginx
spec:
  ports:
  - port: 80
    name: web
  clusterIP: None  # makes it a headless service
  selector:
    app: nginx
---
apiVersion: apps/v1
kind: StatefulSet
metadata:
  name: web
spec:
  serviceName: "nginx"
  replicas: 2
  selector:
    matchLabels:
      app: nginx
  template:
    metadata:
      labels:
        app: nginx
    spec:
      containers:
      - name: nginx
        image: k8s.gcr.io/nginx-slim:0.8
        ports:
        - containerPort: 80
          name: web
        volumeMounts:
        - name: www
          mountPath: /usr/share/nginx/html
  volumeClaimTemplates:  # automated Volume Creation and Claiming
  - metadata:
      name: www
    spec:
      accessModes: [ "ReadWriteOnce" ]
      resources:
        requests:
          storage: 1Gi
```

```
$: kubectl apply -f web.yaml

$: kubectl get pv  #->
  # NAME     CAPACITY   ACCESS MODES   RECLAIM POLICY   STATUS      CLAIM               STORAGECLASS   REASON
  # pvc-ID   1Gi        RWO            Delete           Bound       default/www-web-1   standard             
  # pvc-ID   1Gi        RWO            Delete           Bound       default/www-web-0   standard             
$: kubectl get pvc  #->
  # NAME        STATUS   VOLUME   CAPACITY   ACCESS MODES   STORAGECLASS
  # www-web-0   Bound    pvc-ID   1Gi        RWO            standard    
  # www-web-1   Bound    pvc-ID   1Gi        RWO            standard    
```

### Pods in a StatefulSet

```
$: kubectl get pods -l app=nginx  #-> Pod web-0 is created before web-1
  # NAME    READY   STATUS    RESTARTS   AGE
  # web-0   1/1     Running   0          4m11s
  # web-1   1/1     Running   0          3m16s
$: for i in 0 1; do kubectl exec web-$i -- sh -c 'hostname'; done  #-> get sticky, unique identities
  # web-0
  # web-1
```

The CNAME of the `Headless Service` points to a SRV record, one for each `Pod`.  
The SRV records point to A record entries that contain the `Pod`s’ IP addresses.  

```
$: kubectl run -i --tty --image busybox:1.28 dns-test --restart=Never --rm  #-> test in-cluster DNS visibility
  # $: nslookup web-0.nginx
  #   Server:    10.96.0.10
  #   Address 1: 10.96.0.10 kube-dns.kube-system.svc.cluster.local
  #   Name:      web-0.nginx
  #   Address 1: 172.17.0.7 web-0.nginx.default.svc.cluster.local
  # $: nslookup web-1.nginx
  #   Server:    10.96.0.10
  #   Address 1: 10.96.0.10 kube-dns.kube-system.svc.cluster.local
  #   Name:      web-1.nginx
  #   Address 1: 172.17.0.8 web-1.nginx.default.svc.cluster.local
```

To find `StatefulSet` `Pod`s query the CNAME of the `Headless Service` like:  
* nginx.default.svc.cluster.local  
You can also use the SRV records of the `Pod`s like:  
* web-0.nginx.default.svc.cluster.local  
* web-1.nginx.default.svc.cluster.local  

### Scaling a StatefulSet

```
kubectl scale sts web --replicas=5
```

When scaling down, PVs and PVCs are not deleted.  

### Updating StatefulSets

A rolling update updates all Pods in reverse order.  

```
$: kubectl patch statefulset web -p '{"spec":{"updateStrategy":{"type":"RollingUpdate"}}}'
$: kubectl patch statefulset web --type='json' -p='[{"op": "replace", "path": "/spec/template/spec/containers/0/image", "value":"gcr.io/google_containers/nginx-slim:0.8"}]'
$: kubectl rollout status sts/web
```

A staged update keeps all `Pod`s in the `StatefulSet` at the current version while allowing mutations to the .spec.template.  

```
$: kubectl patch statefulset web -p '{"spec":{"updateStrategy":{"type":"RollingUpdate","rollingUpdate":{"partition":3}}}}'
$: kubectl patch statefulset web --type='json' -p='[{"op": "replace", "path": "/spec/template/spec/containers/0/image", "value":"k8s.gcr.io/nginx-slim:0.7"}]'
```

A `StatefulSet` `Pod` in staged update mode is updated only if its ordinal number is greater then the rollingUpdate.partition number.  
This is called a canary update.  

```
$: kubectl patch statefulset web -p '{"spec":{"updateStrategy":{"type":"RollingUpdate","rollingUpdate":{"partition":2}}}}'
```

You can perform a phased roll out by setting the rollingUpdate.partition number to the ordinal number at which you want the updates to pause.  

```
$: kubectl patch statefulset web -p '{"spec":{"updateStrategy":{"type":"RollingUpdate","rollingUpdate":{"partition":0}}}}'
```

### Deleting StatefulSets

* Non-Cascading Delete - when the `StatefulSet` is deleted the `Pod`s are NOT deleted
* Cascading Delete - when the `StatefulSet` is deleted the `Pod`s are deleted

```
$: kubectl delete statefulset web --cascade=false
# Note: you have to delete the Pods manually
```

```
$: kubectl delete service nginx
$: kubectl delete statefulset web

$: kubectl delete pvc --all
$: kubectl delete pv --all
```

### Pod Management Policy

For when you don't need ordering guarantees.  

TODO
