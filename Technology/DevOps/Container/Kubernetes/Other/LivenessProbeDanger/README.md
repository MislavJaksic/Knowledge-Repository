## [Liveness Probes are Dangerous](https://srcco.de/posts/kubernetes-liveness-probes-are-dangerous.html)

`Readiness Probe`: when can it receive traffic  
`Liveness Probe`: when to restart  

Takeaway: DON'T use `Liveness Probe` unless you know what you are doing.  

Incorrect use will lead to cascading failures.  

DOs:
* always define a `Readiness Probe` for HTTP microservices
* `Readiness Probe` must check the actual webserver port
* `Readiness Probe` must include database initialization (start HTTP server only after DB is initialized)
* use `httpGet` and a well know endpoint `/health`
* separate metrics and health from normal metrics
* use `Startup Probe` for prewarming and caching (use `Readiness Probe` before K8s 1.16)

DON'Ts:
* depend on external dependencies (data stores)
* use `Liveness Probe` only if you know restarting a `Pod` is the only option
* `Liveness Probe` != `Readiness Probe`
* don't use `exec` command probes
