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

$: docker tag Image-Name:Image-Tag Domain-Name[:port]/Harbor-Project-Name/Image-Name:Image-Tag

$: docker push Domain-Name[:port]/Harbor-Project-Name/Image-Name:Image-Tag

$: docker pull Domain-Name[:port]/Harbor-Project-Name/Image-Name:Image-Tag
```
