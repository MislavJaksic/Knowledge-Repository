## [Pulling Images from Registry during Kubernetes Deployment](https://docs.cloud.oracle.com/en-us/iaas/Content/Registry/Tasks/registrypullingimagesfromocir.htm)

```
$: kubectl create secret docker-registry Pull-Secret-Name --docker-server=Registry-Endpoint.ocir.io --docker-username='Tenancy-Object-Storage-Namespace/Tenancy-Username' --docker-password='Auth-Token' --docker-email='Contact-Email'
```

```
...
spec:
  containers:
    - name: ngnix
      image: Registry-Endpoint.ocir.io/Tenancy-Object-Storage-Namespace/Registry-Name/Image-Name:Image-Tag
      ...
  imagePullSecrets:
    - name: Pull-Secret-Name
```
