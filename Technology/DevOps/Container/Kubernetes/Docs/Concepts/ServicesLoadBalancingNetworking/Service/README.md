## [Service](https://kubernetes.io/docs/concepts/services-networking/service/)

TODO

## Headless Service

`Service`s that don't need load balancing or proxying.  
`Headless Service`s don't have a `ClusterIP`.  

If a selector:  
* is defined Endpoints records are defined and the DNS configuration will point to the Pod backing the `Headless Service`  
* is NOT defined the DNS configures either the CNAME records for ExternalName-type `Service`s or records for any Endpoints that share a name with the `Service`, for all other types

`Headless Service`s can still interface with other service discovery mechanisms.  

```
apiVersion: v1
kind: Service
...
spec:
  clusterIP: None  # makes it a headless service
  ...
```

### Publishing Services (ServiceTypes)

TODO
