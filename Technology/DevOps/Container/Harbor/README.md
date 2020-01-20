## [Harbour](https://goharbor.io/)

### Install

```
$: helm repo add harbor https://helm.goharbor.io
$: helm repo update

$: helm install harbour harbor/harbor -f config.yaml  # install and configure

$: helm uninstall harbour
```

[Instructions](Docs/HarborOnK8s)

### Usage

#### Using Helm and NodePort

[Instructions](Docs/UserGuide)

##### Login

```
https://Kubectl-Server-IP:30003

First time, default:
* username: `admin`
* password: `Harbor12345`
```

```
$: bash get-harbor-docker-tls.sh  # see Research

$: docker login Kubectl-Server-IP:30003  # ->
  # Username: admin
  # Password: Harbor12345
  # ...
  # Login Succeeded
```

##### Push images

```
$: docker tag Image-Name:Image-Tag Kubectl-Server-IP:30003/Repository-Name/Image-Name:Image-Tag

$: docker push Kubectl-Server-IP:30003/Repository-Name/Image-Name:Image-Tag
```

##### Pull images

```
$: docker pull Kubectl-Server-IP:30003/Repository-Name/Image-Name:Image-Tag
```

### As a private repository

```
$: docker login Private-Registry-Ip-Port

$: kubectl create secret generic Private-Repo-Secret --from-file=.dockerconfigjson=path/to/.docker/config.json --type=kubernetes.io/dockerconfigjson

# Note: pods can only reference image pull secrets in their own namespace!
# Note: setup Docker TLS certificates
```

### Upgrade or Migrate

TODO
