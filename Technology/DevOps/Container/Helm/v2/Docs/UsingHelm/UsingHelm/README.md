## [Using Helm](https://helm.sh/docs/using_helm/#using-helm)

```
Chart: a Helm package
Repository: where charts are collected and shared
Release: instance of a chart running in a Kubernetes
```

### Install a chart

```
$: helm search Chart-Name
$: helm install Chart-Name

$: helm status Release-Name
```

### Customize a chart

```
$: helm inspect values Chart-Name
$: cat << EOF > config.yaml
Chart-Key1: _value
Char-Key2: _value
EOF

$ helm install -f config.yaml Chart-Name
```

### Upgrade and rollback a chart

TODO

### Helpful options

TODO

### Deleting releases

TODO

### Working with repositories

TODO

### Create a chart

```
$: helm create Chart-Name
$: helm lint
$: helm package Chart-Name

$: helm install Chart-Package
```
