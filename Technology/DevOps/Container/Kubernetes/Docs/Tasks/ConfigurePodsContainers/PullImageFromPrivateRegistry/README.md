## [Pull an Image from a Private Registry](https://kubernetes.io/docs/tasks/configure-pod-container/pull-image-private-registry/)

### Log in to Docker

```
$: docker login Private-Registry-Ip-Port  # ->
  # Username: ***
  # Password: ***
  # ...
  # Login Succeeded

$: cat ~/.docker/config.json
{
	"auths": {
		"Private-Registry-Ip-Port": {
			"auth": "YW...U="
		}
	}
}

# Note: if you are using a Docker credentials store you will see a `credsStore` entry with the name of the store as value
```

### Create a Secret based on existing Docker credentials

```
$: kubectl create secret generic Private-Repo-Secret --from-file=.dockerconfigjson=/path/to/.docker/config.json --type=kubernetes.io/dockerconfigjson
```

### Create a Secret by providing credentials on the command line

Not recommended because secrets will be stored in the command line history.  

### Inspecting the Secret Private-Repo-Secret

```
$: kubectl get secret Private-Repo-Secret -o yaml

$: kubectl get secret Private-Repo-Secret --output="jsonpath={.data.\.dockerconfigjson}" | base64 --decode  # -> {"auths": {...}}

$: echo "YW...U=" | base64 --decode  # -> User-Name:User-Password
```

### Create a Pod that uses your Secret

```
apiVersion: v1
kind: Pod
metadata:
  name: private-pod
spec:
  containers:
  - name: pod-container
    image: Private-Registry-Ip-Port/Repository-Name/Image-Name:Image-Tag
  imagePullSecrets:
  - name: Private-Repo-Secret
```
