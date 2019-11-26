## [Define a Command and Arguments for a Container](https://kubernetes.io/docs/tasks/inject-data-application/define-command-argument-container/)

### Define a command and arguments when you create a Pod

Commands and arguments given to a `Pod` overrides those of a container.  
Commands and arguments are permanent after `Pod` creation.  

```
apiVersion: v1
kind: Pod
...
spec:
  containers:
    command: ["printenv"]  # overrides container command
    args: ["HOSTNAME", "KUBERNETES_PORT"]  # command arguments; invokes ENV VAR
...
```


### Use ENV VAR to define arguments

```
apiVersion: v1
kind: Pod
...
spec:
  containers:
    env:
    - name: MESSAGE
      value: "hello world"
    command: ["/bin/echo"]
    args: ["$(MESSAGE)"]  # -> invokes an ENV VAR and prints "hello world"
...
```

You can also use `ConfigMap` or `Secret` for defining ENV VAR.  

### Run a command in a shell

```
...
spec:
    containers:
      command: ["/bin/sh"]
      args: ["-c", "while true; do echo hello; sleep 10;done"]
...
```

### Docker and Kubernetes fields

```
Docker:           Kubernetes:
ENTRYPOINT   ==   command
CMD          ==   args
```

Kubernetes will override container commands and arguments.  

| ENTRYPOINT | CMD | command  | args | Run     |
|------------------|-----------|--------------|----------|-----------------|
| \[/img_cmd\]     | \[IMG\]   | -            | -        | \[img_cmd IMG\] |
| \[/img_cmd\]     | \[IMG\]   | \[/k8n_cmd\] | -        | \[k8n_cmd\]     |
| \[/img_cmd\]     | \[IMG\]   | -            | \[K8N\]  | \[img_cmd K8N\] |
| \[/img_cmd\]     | \[IMG\]   | \[/k8n_cmd\] | \[K8N\]  | \[k8n_cmd K8N\] |
