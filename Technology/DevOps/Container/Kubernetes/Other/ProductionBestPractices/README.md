## [Kubernetes production best practices](https://learnk8s.io/production-best-practices)

### 1. Application development

#### Health checks

`Readiness Probe`: when can it receive traffic  
`Liveness Probe`: when to restart  

Containers have a `Readiness Probe`.  
Containers crash when there's a fatal error (e.g. uncaught exception, code typo, can't load a dependency).  
Use `Liveness Probe` only when a process is unresponsive.  
`Liveness Probe` != `Readiness Probe`.  

#### Apps are independent

Dependency failures propagate and cause downtime.  

`Readiness Probe` is independent, it doesn't check if a dependency is ready.  
An app retries connecting to a dependency until it succeeds. It doesn't crash if it fails.  

[More](https://blog.colinbreck.com/kubernetes-liveness-and-readiness-probes-how-to-avoid-shooting-yourself-in-the-foot/#shootingyourselfinthefootwithreadinessprobes)  

### Graceful shutdown

Stop accepting new  and drain existing connections.  
When a `Pod` is terminated, it is removed
Graceful shutdown sequence:
* upon receiving SIGTERM
* the server stops accepting new connections
* completes all active requests
* then immediately kills all keep-alive connections and
* the process exits


Gracefully terminate connections.  
Process requests within the grace period.  
Capture and forward SIGTERM.  
Close all idle keep-alive sockets.  

[More](https://freecontent.manning.com/handling-client-requests-properly-with-kubernetes/)  
[Graceful shutdown tester](https://github.com/mikkeloscar/kube-sigterm-test)  
[postStart and preStop handlers](https://kubernetes.io/docs/tasks/configure-pod-container/attach-handler-lifecycle-event/#define-poststart-and-prestop-handlers)  
[Signal forwarding](https://pracucci.com/graceful-shutdown-of-kubernetes-pods.html)  
[Gracefully shutdown Nodejs keep-alive connections](http://dillonbuchanan.com/programming/gracefully-shutting-down-a-nodejs-http-server/)  

### Fault tolerance

Hardware can catch fire, cloud or hypervisor can fail and kernels can panic.  
A `Pod` can be deleted manually or a `Node` can be drained.  
Don't lose all the `Pod`s and stop serving live traffic.  

Run more then one replica for each app.  
Assign replicas to different `Node`s using `Affinity` and `Taint`.  
Set `Pod Disruption Budget` to make sure  minimum number of `Pod`s stays alive.  

[Distribute Pods evenly across Nodes](https://cloudmark.github.io/Node-Management-In-GKE/#pod-anti-affinity-rules)  
[Inter-pod affinity and anti-affinity](https://kubernetes.io/docs/concepts/configuration/assign-pod-node/#inter-pod-affinity-and-anti-affinity)  
[Pod Disruption Budget](https://kubernetes.io/docs/concepts/workloads/pods/disruptions/)  

### Resources utilisation

Containers are the blocks; servers are the boards, and the scheduler is the player.  

Set memory limits and requests. Processes that go over the limit are terminated.  
Set CPU request to less then one.  
Don't set CPU requests!  
All `Namespace`s have a `LimitRange`.  
Set a `Quality of Service` for `Pod` evictions.  

[Vertical Pod Autoscaler](https://github.com/kubernetes/autoscaler/tree/master/vertical-pod-autoscaler)  
[K8s CPU time](https://medium.com/@betz.mark/understanding-resource-limits-in-kubernetes-cpu-time-9eff74d3161b)  
[LimitRange](https://kubernetes.io/docs/concepts/policy/limit-range/)  
[Quality of Service](https://kubernetes.io/docs/tasks/configure-pod-container/quality-service-pod/)  

### Tagging resources

TODO
