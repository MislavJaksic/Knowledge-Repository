## [Debugging DNS Resolution](https://kubernetes.io/docs/tasks/administer-cluster/dns-debugging-resolution/)

Diagnose problems with DNS.  

You must have:
* a Kubernetes cluster version 1.6 of above
* `coredns` or `kube-dns` are configured

### Diagnose

#### Create a simple Pod to use as a test environment

Create `dnsutils.yaml`.  

```
$: kubectl apply -f dnsutils.yaml

$: kubectl exec -ti dnsutils -- nslookup kubernetes.default  # ->
  # Server:    10.0.0.10
  # Address 1: 10.0.0.10
  #
  # Name:      kubernetes.default
  # Address 1: 10.0.0.1
```

Everything is alright if you see the output above.  

#### Check the local DNS configuration first

```
$: kubectl exec -ti dnsutils -- cat /etc/resolv.conf
```

`/etc/resolv.conf` should look like:
```
`search` default.svc.cluster.local svc.cluster.local cluster.local google.internal c.gce_project_id.internal
`nameserver` 10.0.0.10
options ndots:5
```

If you ever see `nslookup: can't resolve 'kubernetes.default'` then there is a problem with `coredns`/`kube-dns` add-on.  

#### Check if the DNS pod is running

```
$: kubectl get pods --namespace=kube-system -l k8s-app=kube-dns
```

If there are no `Pod`s, you'll need to deploy them manually.  

#### Check for Errors in the DNS pod

```
$: for p in $(kubectl get pods --namespace=kube-system -l k8s-app=kube-dns -o name); do kubectl logs --namespace=kube-system $p; echo --- --- --- ---; done
OR
$: kubectl logs --namespace=kube-system $(kubectl get pods --namespace=kube-system -l k8s-app=kube-dns -o name | head -1) -c kubedns

$: kubectl logs --namespace=kube-system $(kubectl get pods --namespace=kube-system -l k8s-app=kube-dns -o name | head -1) -c dnsmasq

$: kubectl logs --namespace=kube-system $(kubectl get pods --namespace=kube-system -l k8s-app=kube-dns -o name | head -1) -c sidecar
```

In `kube-dns` look for a `W`, `E` or `F`, that is, `Warning`, `Error` or `Failure`.  

#### Is DNS service up?


```
$: kubectl get svc --namespace=kube-system
```

`kube-dns` should appear for both `CoreDNS` and `kube-dns`.  

#### Are DNS endpoints exposed?

```
$: kubectl get ep kube-dns --namespace=kube-system
```

You should see some endpoints.  

#### Are DNS queries being received/processed?

Only works for `CoreDNS`!  

```
$: [KUBE_EDITOR="nano"] kubectl -n kube-system edit configmap coredns
```

```
kind: ConfigMap
...
data:
  Corefile: |
    .:53 {
        log  # add to the Corefile!
        ...
    }
```

Wait a few minutes.  

```
$: for p in $(kubectl get pods --namespace=kube-system -l k8s-app=kube-dns -o name); do kubectl logs --namespace=kube-system $p; echo --- --- --- ---; done  # ->
  # ...
  # 172.17.0.18:41675 - [07/Sep/2018:15:29:11 +0000] 59925 "A IN kubernetes.default.svc.cluster.local. udp 54 false 512" NOERROR qr,aa,rd,ra 106 0.000066649s
  # ...
```

### Known issues

Linux distributions (e.g. `Ubuntu`) may use  `systemd-resolved` (a local DNS resolver)  by default.  
Fix it using `kubelet`'s `--resolv-conf` flag. Point to the correct `resolv.conf` (With `systemd-resolved`, this is `/run/systemd/resolve/resolv.conf`).  
`kubeadm` 1.11 or above does this automatically.  

Kubernetes installs don't configure the `Node`s' `resolv.conf` files to use the cluster DNS by default.  

Linux's `libc` (a.k.a. `glibc`) has a limit for the DNS `nameserver` records to 3 by default.   
Kubernetes needs to consume 1 `nameserver` record and 3 `search` records. If you are already using 3 `nameserver`s or more than 3 `search`es some settings will be lost.  
A `Node` can run `dnsmasq` to provide itself more `nameserver` entries.  
Use `kubelet`'s `--resolv-conf` flag.  
DNS `search` records limit can only be fixed by upgrading the linux distribution or `glibc`.  

[DNS on `Alpine` 3.3 or earlier doesen't work properly](https://github.com/kubernetes/kubernetes/issues/30215)  
