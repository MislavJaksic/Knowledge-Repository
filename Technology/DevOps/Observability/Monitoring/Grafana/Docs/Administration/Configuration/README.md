## [Configuration](https://grafana.com/docs/grafana/latest/installation/configuration/)

TODO

### Using environment variables

Configuration file values can be overridden using environmental variables.  

```
# default section
instance_name = my-instance       GF_DEFAULT_INSTANCE_NAME=my-instance

[security]
admin_user = admin            ->  GF_SECURITY_ADMIN_USER=admin

[auth.google]
client_secret = newS3cretKey      GF_AUTH_GOOGLE_CLIENT_SECRET=newS3cretKey
```
