## [Linkerd](https://linkerd.io/)

### Install

```
$: kubectl version --short

$: curl -sL https://run.linkerd.io/install | sh
# Note: add `export PATH=$PATH:$HOME/.linkerd2/bin` to `~/.bashrc` on Ubuntu

$: linkerd version  # ->
  # Client version: stable-X.Y.Z
  # Server version: unavailable

$: linkerd check --pre  # fix all issues before continuing

$: linkerd install config | kubectl apply -f -  # install in namespace `linkerd`
$: linkerd check config  # fix all issues before continuing

$: linkerd install control-plane | kubectl apply -f -  # install in namespace `linkerd`
$: linkerd check  # fix all issues before continuing
```

WARNING: tap api service FailedDiscoveryCheck!!! kubectl get apiservice shows an error!!! Tap Pod did not recognise certificate: linkerd2_proxy_identity::certify Failed to certify identity:!!!

### Uninstall

Remove any Linkerd proxy injection annotations and roll the deployments.

```
$: linkerd install --ignore-cluster | kubectl delete -f -
```
