## [Pulling Images Using the Docker CLI](https://docs.cloud.oracle.com/en-us/iaas/Content/Registry/Tasks/registrypullingimagesusingthedockercli.htm)

[Get Auth Token](../GetAuthToken)  
[Get Registry Region Endpoint](../PrepareForRegistry)  

```
$: docker login Registry-Endpoint.ocir.io  # ->
  # Username: Tenancy-Object-Storage-Namespace/Tenancy-Username
  # Password: Auth-Token

$: docker pull Registry-Endpoint.ocir.io/Tenancy-Object-Storage-Namespace/Registry-Name/Image-Name:Image-Tag

$: docker images
```
