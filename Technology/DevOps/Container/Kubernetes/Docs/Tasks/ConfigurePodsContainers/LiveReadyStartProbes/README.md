## [Configure Liveness, Readiness and Startup Probes](https://kubernetes.io/docs/tasks/configure-pod-container/configure-liveness-readiness-startup-probes/)

`Liveness Probe`: when to restart  
`Readiness Probe`: when can it receive traffic  
`Startup probes`: when a container has started

### Define a liveness command

```
# liveness checking command   # liveness through HTTP        # liveness and readiness through TCP
spec:                         spec:                          spec:
  containers:                   containers:                    containers:
  - livenessProbe:              - livenessProbe:               - readinessProbe:
      exec:                         httpGet:                       tcpSocket:
        command:                      path: /healthz                 port: 8080
        - cat                         port: 8080                   initialDelaySeconds: 5
        - /tmp/healthy                httpHeaders:                 periodSeconds: 10
      initialDelaySeconds: 5          - name: Custom-Header      livenessProbe:
      periodSeconds: 5                  value: Awesome             tcpSocket:
                                    initialDelaySeconds: 3           port: 8080
                                    periodSeconds: 3               initialDelaySeconds: 15
                                                                   periodSeconds: 20
```

### Use a named port

```
ports:
- name: liveness-port
  containerPort: 8080
  hostPort: 8080

livenessProbe:
  httpGet:
    path: /healthz
    port: liveness-port
```

### Protect slow starting containers with startup probes

maxStartupTime = failureThreshold * periodSeconds

```
livenessProbe:           startupProbe:
  httpGet:                 httpGet:
    path: /healthz           path: /healthz
    port: liveness-port      port: liveness-port
  failureThreshold: 1      failureThreshold: 30
  periodSeconds: 10        periodSeconds: 10

# Note: 300sec = 30 * 10 (startupProbe)
```

### Define readiness probes

`Pod`s can report they are not ready.  
They will not receive traffic.  
Their config is identical to liveness probes.  

### Configure Probes

```
XProbe:
  initialDelaySeconds: delay before probing
  periodSeconds: probe frequency
  timeoutSeconds: probe timeout
  successThreshold: # of consecutive successes required after a failure
  failureThreshold: # of consecutive failiures before failing
  httpGet:
    host: host name (`Pod` IP)
    scheme: HTTP or HTTPS
    path: server path
    httpHeaders: custom headers
    port: name or number of a container port
```
