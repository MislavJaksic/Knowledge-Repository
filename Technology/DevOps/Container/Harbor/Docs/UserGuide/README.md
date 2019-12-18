## [User Guide](https://github.com/goharbor/harbor/blob/master/docs/user_guide.md)

TODO

### Pulling and Pushing Images using Docker Client

You can use HTTP instead of HTTPS, but its not recommended.  
Setup TLS using the [Research script](../../Research).  

```
$: docker login Domain-Name[:port]  # ->
  # Username: User-Name
  # Password: User-Password
  # ...
  # Login Succeeded

$: docker tag Image-Name:Image-Tag Domain-Name[:port]/Repository-Name/Image-Name:Image-Tag

$: docker push Domain-Name[:port]/Repository-Name/Image-Name:Image-Tag

$: docker pull Domain-Name[:port]/Repository-Name/Image-Name:Image-Tag
```

### Vulnerability Scanning

Harbor uses Clair.  
Images can be scanned manually or at a set time interval.  

### Connect Harbor to Additional Vulnerability Scanners

Current Helm Harbor chart (Chart version 1.2.3, App version 1.9.3) is not in sync with the documentation!  

### Pulling Images from Harbor in Kubernetes

### Managing Helm Charts

TODO
