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
$: docker run --rm -v $(pwd):$(pwd) --workdir $(pwd) quay.io/coreos/jsonnet-ci ./build.sh simple.jsonnet  # see Research (override repository defaults!)
```

#### Apply compiled files

```
$: pwd  # -> .../kube-prometheus-master

$: kubectl apply -f manifests/setup
$: kubectl apply -f manifests/
```

### Configuration

There are a lot of configuration options.  
See Research.  

### Customization Examples

Even more examples of configuration options!  
