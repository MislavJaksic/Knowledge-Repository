## [kube-prometheus](https://github.com/coreos/kube-prometheus)

### Prerequisites

`kubelet`:
* `--authentication-token-webhook=true`: `ServiceAccount` is used for authentication
* `--authorization-mode=Webhook`: perform an RBAC request to determine if Prometheus can access the `/metrics` endpoint

`Prometheus Adapter` is an `Extension API Server`. `Kubernetes` needs to be have this feature enabled.  

### Customizing Kube-Prometheus

#### Installing and compiling

```
# Note: download coreos/kube-prometheus repository from GitHub

$: pwd  # -> .../kube-prometheus-master
$: docker run --rm -v $(pwd):$(pwd) --workdir $(pwd) quay.io/coreos/jsonnet-ci jb update
$: docker run --rm -v $(pwd):$(pwd) --workdir $(pwd) quay.io/coreos/jsonnet-ci ./build.sh example.jsonnet  # see Research (override repository defaults!)
```

#### Apply compiled files

```
$: pwd  # -> .../kube-prometheus-master

$: kubectl apply -f manifests/setup
$: kubectl apply -f manifests/

$: kubectl delete --ignore-not-found=true -f manifests/ -f manifests/setup
```

### Configuration

There are a lot of configuration options.  
See Research.  

### Customization Examples

Even more examples of configuration options!  

### Errors

```
Error: could not get apiVersions from Kubernetes: unable to retrieve the complete list of server APIs
```

```
$: kubectl get apiservice

# Note: if `v1beta1.metrics.k8s.io` failed, remove all `prometheus-adapter` manifests
```
