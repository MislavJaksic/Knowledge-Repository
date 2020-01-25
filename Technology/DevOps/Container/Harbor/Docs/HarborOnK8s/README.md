## [Helm Chart for Harbor](https://github.com/goharbor/harbor-helm)

```
$: helm repo add harbor https://helm.goharbor.io
$: helm repo update

$: helm install harbor harbor/harbor -f config.yaml  # install and configure

# Note: if `Deployment` is `extensions/v1beta1`, download the chart, apply changes and install it manually
$: helm pull harbor/harbor
$: helm install harbor harbor -f config.yaml

$: helm uninstall harbor
```

### Configuration

Set `expose.type`:
* `Ingress`: ingress controller must be present. If TLS is disabled, the port must be included in the command when pulling/pushing images
* `ClusterIP`: services can only be reached within the cluster
* `NodePort`: services are assigned a port on each `Node`
* `LoadBalancer`: use a cloud provider’s load balancer

Set `externalURL` in `protocol://domain[:port]` format:
* if behind the proxy, set it as the URL of proxy
* if `Ingress`, the `domain` should be the value of `expose.ingress.hosts.core`
* if `ClusterIP`, the `domain` should be the value of `expose.clusterIP.name`
* if `NodePort`, the `domain` should be the IP address of a `Node`
* if `LoadBalancer`, set the `domain` as your own domain name and add a CNAME record to map the domain name to the one you got from the cloud provider  

Set `persistence.*`:
* disable: data does not survive the termination of a `Pod`
* `Persistent Volume Claim` (`PVC`): default; a default `StorageClass` is needed in the cluster to dynamic provision the volumes; specify another `StorageClass` in the `storageClass` or set `existingClaim` if you have existing `Persistance Volume`s (`PV`s) to use
* External Storage (only for images and charts): supported external storages are: `azure`, `gcs`, `s3 swift` and `oss`

Optionally, set `Secret` values:
* `core.secret`
* `jobservice.secret`
* `registry.secret`
* `notary.secretName`
* `core.secretName`

[Configuration names and default values](https://github.com/goharbor/harbor-helm/blob/master/README.md#configuration)  
