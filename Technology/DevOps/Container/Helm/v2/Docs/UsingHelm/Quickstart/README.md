## [Quickstart Guide](https://helm.sh/docs/using_helm/#quickstart-guide)

You will need:
* Kubernetes
* locally configured kubectl

### Install Helm

See another tutorial.  

### Initialize Helm and Install Tiller

See above.  

### Install an example chart

```
$: helm repo update

$: helm search Chart-Name
$: helm inspect Chart-Name
$: helm install Chart-Name
```

### Releases

```
$: helm list  #-> list Releases
$: helm status Release-Name

$: helm delete Release-Name
```
