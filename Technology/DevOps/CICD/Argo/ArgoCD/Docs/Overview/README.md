## [Overview](https://argoproj.github.io/argo-cd/)

Argo CD is a declarative, `GitOps` continuous delivery tool.  

### Getting Started

```
$: kubectl create namespace argocd
$: kubectl apply -n argocd -f https://raw.githubusercontent.com/argoproj/argo-cd/v1.5.4/manifests/install.yaml
```

[Getting Started Guide](../GettingStarted)  

### How it works

Uses the `GitOps` pattern: `Git` as the source of truth.  
Specify Kubernetes manifests as:
* `Kustomize`
* `Helm` `Chart`
* `Ksonnet`
* `Jsonnet`
* plain directory of `YAML`/`JSON` manifests
* a custom config management tool

Automatically deploy apps to a cluster.  
Tracks updates to branches, tags or commits.  

[Tracking and Deployment Strategies](../UserGuide/TrackAndDeployStrategy)  

### Architecture

Argo CD is a `Kubernetes` controller.  
It compares the `Kubernetes` state to the `Git` repository state.  

### Features

They are:
* automatically deploy apps to `Kubernetes`
* deploy to multiple clusters
* supports `Kustomize`, `Helm`, `Ksonnet`, `Jsonnet`, plain-`YAML`
* `SSO` Integration (`OIDC`, `OAuth2`, `LDAP`, `SAML 2.0`, `GitHub`, `GitLab`, `Microsoft`, `LinkedIn`)
* multi-tenancy and `RBAC` policies for authorization
* rollback
* health status analysis
* drift detection and visualization
* sync of apps manually or automatically
* Web UI
* `CLI` for automation and `CI` integration
* webhook integration (`GitHub`, `BitBucket`, `GitLab`)
* access tokens for automation
* `PreSync`, `Sync`, `PostSync` hooks for blue/green or canary upgrades
* audit trails for application events and API calls
* `Prometheus` metrics
* parameter overrides for overriding `Ksonnet`/`Helm` parameters in `Git`
