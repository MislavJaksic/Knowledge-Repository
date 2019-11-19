## [Pods](https://kubernetes.io/docs/concepts/workloads/pods/pod/)

`Pod`s are the smallest deployable units of computing that can be created and managed in Kubernetes.  

### What is a Pod?

```
In terms of Docker constructs, a Pod is modelled as a group of Docker containers with shared namespaces and shared filesystem volumes.  
```

A `Pod` has containers which share storage/network and instructions for how to run them.  
A `Pod`’s containers are co-located, co-schedule, and run in a shared context.  

Containers in a `Pod` share an IP/port space and can find each other via localhost.  
Containers in different `Pod`s (usually) communicate using `Pod` IP addresses.  
Containers in a `Pod` have access to shared volumes.  

`Pod`s are ephemeral.  
If a `Node` dies, the `Pod`s are scheduled for deletion.  
A `Pod` can be replaced by an identical `Pod`, but a different UID.  
When a `Pod`'s lifetime is referenced it talks about the UID.  

### Motivation for Pods

TODO
