## [Installing Helm](https://helm.sh/docs/using_helm/#installing-helm)

```
# Note: WARNING! https://github.com/helm/helm/issues/6374
# Helm (Tiller) does not (yet) play well with Kubernetes 1.16
# Solution: https://github.com/helm/helm/issues/6374#issuecomment-533841179
```

```
$: curl -LO https://git.io/get_helm.sh
$: chmod 700 get_helm.sh
$: ./get_helm.sh
```

### Role-based Access Control

rbac-config.yaml:
```
apiVersion: v1
kind: ServiceAccount
metadata:
  name: tiller
  namespace: kube-system
---
apiVersion: rbac.authorization.k8s.io/v1
kind: ClusterRoleBinding
metadata:
  name: tiller
roleRef:
  apiGroup: rbac.authorization.k8s.io
  kind: ClusterRole
  name: cluster-admin
subjects:
  - kind: ServiceAccount
    name: tiller
    namespace: kube-system
```

```
$: kubectl create -f rbac-config.yaml
```

```
$: helm init --service-account tiller --history-max 200
```
