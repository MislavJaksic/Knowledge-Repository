## [Brigade](https://brigade.sh/)

Brigade is a tool for running scriptable, automated tasks in Kubernetes.  

### Install

[Instructions](Docs/GettingStarted/Quickstart)

#### Brigade

```
$: helm repo add brigade https://brigadecore.github.io/charts
$: helm install brigade brigade/brigade -n K8s-Cicd-Namespace [--set Key=Value]

# Note: genericGateway.enabled=true if activating Generic Gateway

$: helm uninstall brigade -n K8s-Cicd-Namespace
```

[Helm Chart Brigade Values](https://github.com/brigadecore/charts/blob/master/charts/brigade/values.yaml)  
[Helm Chart Kashti Values](https://github.com/brigadecore/charts/blob/master/charts/kashti/values.yaml)  

#### Brig

See [releases](https://github.com/brigadecore/brigade/releases/) for each:
* OS
* Brigade version

```
# Note: an example way of installing Brig

$: wget -O brig https://github.com/brigadecore/brigade/releases/download/v1.2.1/brig-linux-amd64
$: chmod +x brig
$: mv brig /bin
```

### Using Brig

```
# Note: suffix every command with `-n K8s-Cicd-Namespace`
# Note: all project and Builds are have a Secret you can check for feedback

$: brig project list

$: brig project create

$: brig run Project-Name -f Brigade-Js [-r Branch-Name]
```

### Using Kashti

```
$: kubectl port-forward service/brigade-kashti 8000:80 -n K8s-Cicd-Namespace
OR
$: brig dashboard -n K8s-Cicd-Namespace
```

```
http://localhost:8000/
```

### Private Git repositories

Answer `Yes` to `Configure GitHub Access?` when asked by `brig project create`.  

[GitLab's OAuth2 token](../../VersionControl/GitLab)
