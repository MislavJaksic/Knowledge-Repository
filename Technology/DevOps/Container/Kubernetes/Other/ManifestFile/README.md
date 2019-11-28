## [The beginners guide to creating Kubernetes manifests](https://prefetch.net/blog/2019/10/16/the-beginners-guide-to-creating-kubernetes-manifests/)

Manifest file: describes a Kubernetes resource (`Deployment`, `Service`, `Pod`, ...).  

```
$: kubectl api-versions  # ->
  # admissionregistration.k8s.io/v1beta1
  # apiextensions.k8s.io/v1beta1
  # ...
$: kubectl api-resources  # ->
  # NAME          SHORTNAMES   APIGROUP   NAMESPACED   KIND
  # daemonsets    ds           apps       true         DaemonSet
  # deployments   deploy       apps       true         Deployment
  # ...
$: kubectl explain --api-version=apps/v1 replicaset  # ->
  # KIND:     ReplicaSet
  # VERSION:  apps/v1

  # DESCRIPTION:
  #      ReplicaSet ensures that a specified number of pod replicas are running at
  #      any given time.
$: kubectl explain deployment.metadata  # ->
  # KIND:     Deployment
  # VERSION:  extensions/v1beta1

  # RESOURCE: metadata <Object>

  # DESCRIPTION:
  #      Standard object metadata.
  # ...
$: kubectl create deployment nginx --image=nginx -o yaml --dry-run  # ->
  # apiVersion: apps/v1
  # kind: Deployment
  # metadata:
  #   creationTimestamp: null
  #   labels:
  #     app: nginx
  #   name: nginx
  # spec:
  #   replicas: 1
  # ...
```
