## [Using Helm](https://helm.sh/docs/intro/using_helm/)

### Three Big Concepts

`Chart` is a Helm package.  
`Repository` is the where `Chart`s are collected.  
`Release` is an instance of a `Chart` running in a `Kubernetes` cluster.  

### `helm search repo`: Finding Charts

Fuzzy search for `Chart`s in `Repository`s.  

### `helm install`: Installing a Package

```
# Note: you can also use `--generate-name` flag instead of `Release-Name`

$: helm install Release-Name Repo-Name/Chart-Name
$: helm install Release-Name File-Name.tgz  # install from chart archive
$: helm install Release-Name path/to/dir  # install from unpacked chart directory
$: helm install Release-Name https://example.com/charts/File-Name.tgz)  # install from URL
```

Many `Chart`s require `Docker` images that are over 600M in size.  
Install them will take a long time.  

```
$: helm status Release-Name  # list release status
```

#### Customizing the Chart Before Installing

```
$: helm show values Repo-Name/Chart-Name  # list config fields and values

$: helm get values Release-Name  # list set config values
```

```
$: helm show values stable/mariadb  # ->
  # ## Create a database user
  # ## ref: https://github.com/bitnami/bitnami-docker-mariadb/blob/master/README.md#creating-a-database-user-on-first-run
  # ##
  # # mariadbUser:
  # # mariadbPassword:

  # ## Create a database
  # ## ref: https://github.com/bitnami/bitnami-docker-mariadb/blob/master/README.md#creating-a-database-on-first-run
  # ##
  # # mariadbDatabase:
  # # ...
```

```
$: echo '{mariadbUser: user0, mariadbDatabase: user0db}' > config.yaml
$: helm install -f config.yaml stable/mariadb  # override values
```

You can also skip creating `*.yaml` and set configs from the CLI:
```
=== SET COMMAND ===                                    === YAML EQUIVALENT ===
--set name=value                                       name: value

--set a=b,c=d                                          a: b
                                                       c: d

--set outer.inner=value                                outer:
                                                         inner: value

--set name={a, b}                                      name:
                                                         - a
                                                         - b

--set servers[0].port=80 \                             servers:
      servers[0].host=example                            - port: 80
                                                           host: example

--set nodeSelector."kubernetes\.io/role"=master        nodeSelector:
                                                         kubernetes.io/role: master
```

### `helm upgrade` and `helm rollback`: Upgrading a Release, and Recovering on Failure

```
$: helm upgrade -f config.yaml Release-Name Repo-Name/Chart-Name  # upgrade chart
$: helm history Release-Name  # show Revision-Ids
$: helm rollback Release-Name Revision-Id  # revert upgrade
```

### Helpful Options for Install/Upgrade/Rollback

```
$: helm _command [--wait [--timeout _time]] [--no-hooks]
  # --timeout _time: max wait time to completion
  # --wait: wait until Pods are in Ready state
  # --no-hooks: skip running hooks
```

### `helm uninstall`: Uninstalling a Release

```
$: helm list [--all]  # list Release-Names
$: helm uninstall Release-Name [--keep-history]  # uninstall chart
  # --keep-history: keep Release record
```

### `helm repo`: Working with Repositories

```
$: helm repo list
$: helm repo add Repo-Name Repo-Name Repo-Url
$: helm repo update
$: helm repo remove Repo-Name
```

### Creating Your Own Charts

```
$: helm create Chart-Name
$: helm lint Chart-Name
$: helm package Chart-Name
```
