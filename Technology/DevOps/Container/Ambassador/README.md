## [Ambassador](https://www.getambassador.io/)

Ambassador is an API Gateway, self-service edge proxy, a control plane for Envoy Proxy in Kubernetes.  
Provides:
* traffic management: declarative policy engine
* app security: authentication, access control, rate limiting
* API development: self-service portal

### Install

In `ambassador-no-rbac.yaml` or `ambassador-no-rbac.yaml`:
```
...
kind: ClusterRoleBinding
subjects:
- namespace: K8n-Namespace  # change the namespace
...
```

```
$: kubectl cluster-info dump --namespace kube-system | grep authorization-mode  #-> if you see "...RBAC" then RBAC is enabled

$: kubectl apply -f ambassador-rbac.yaml

$: kubectl create clusterrolebinding my-cluster-admin-binding --clusterrole=cluster-admin --user=$(gcloud info --format="value(config.account)")
$: kubectl apply -f
```

Deploy both the RBAC and the `Service`.  

[Instructions](Docs/GettingStarted/Installing/KubernetesYAML)

### Mapping external requests to Services

TODO

### Enable HTTPS (enable TLS)

[Instructions](Docs\Guides\Security\EnablingHTTPS)

TODO
### cert-manager
### Ambassador ID != default?
