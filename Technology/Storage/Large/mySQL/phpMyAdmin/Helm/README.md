## [phpmyadmin Helm Chart](https://hub.helm.sh/charts/bitnami/phpmyadmin)

### Install

```
$: helm repo add bitnami https://charts.bitnami.com/bitnami
$: helm install Release-Name bitnami/phpmyadmin -f config.yaml -n Db-Namespace  # see Research
```

You may need to download and alter the Chart to set `PHPMYADMIN_ALLOW_NO_PASSWORD` to `true`.  

```
$: helm pull bitnami/phpmyadmin
```

### Uninstall

```
$: helm delete Release-Name -n Db-Namespace
```
