## [Core Concepts](https://argoproj.github.io/argo-cd/core_concepts/)

Assumptions:
* you are familiar with core `Git`, `Docker`, `Kubernetes`, `Continuous Delivery`, and `GitOps` concepts  

Argo CD concepts:

* `Application`: a group of `Kubernetes` resources such as `Custom Resource Definition`s (`CRD`s)
* `Application source type`: which `Tool` is used to build the app?
* `Target state`: desired state of an app, the state of a `Git` repository.
* `Live state`: what is deployed?
* `Sync status`: does the `Live state` matches the `Target state`
* `Sync`: move the app to its `Target state`
* `Sync operation status`: did the `Sync` succeed?
* `Refresh`: compare the latest code in `Git` with the live state; figure out the differences
* `Health`: is the app running correctly?; can it serve requests?
* `Tool`: `Kustomize` or `Ksonnet` or similar tools; see `Application Source Type`
* `Configuration management tool`: see `Tool`
* `Configuration management plugin`: a custom tool
