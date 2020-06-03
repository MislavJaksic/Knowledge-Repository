## [Deploying the DNS Cluster Add-on](https://github.com/kelseyhightower/kubernetes-the-hard-way/blob/master/docs/12-dns-addon.md)

Deploy the DNS add-on backed by `CoreDNS`.  

### The DNS Cluster Add-on

```
$: kubectl apply -f coredns.yaml

$: kubectl get pods -l k8s-app=kube-dns -n kube-system
```

### Verification

```
$: kubectl run --generator=run-pod/v1 busybox --image=busybox:1.28 --command -- sleep 3600

$: kubectl get pods -l run=busybox
```

```
$: POD_NAME=$(kubectl get pods -l run=busybox -o jsonpath="{.items[0].metadata.name}")

$: kubectl exec -ti $POD_NAME -- nslookup kubernetes
```
