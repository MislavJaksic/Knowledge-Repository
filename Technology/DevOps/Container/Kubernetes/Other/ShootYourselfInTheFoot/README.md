## [10 Ways to Shoot Yourself in the Foot with Kubernetes](https://www.youtube.com/watch?v=QKI-JRs2RIE)

Presented by Datadog.  

### 1. It's always DNS

`resolv.conf` file:
```
search   <namespace>.svc.cluster.local
         svc.cluster.local
         cluster.local
         ec2.internal

options  ndots:5
```

TODO: very slow
