## [Define Environment Variables for a Container](https://kubernetes.io/docs/tasks/inject-data-application/define-environment-variable-container/)

### Define an environment variable for a container

```
apiVersion: v1
kind: Pod
...
spec:
  containers:
    env:
    - name: DEMO_GREETING
      value: "Hello from the environment"
    - name: DEMO_FAREWELL
      value: "Such a sweet sorrow"
...
```

`Pod` ENV VARs will override container ENV VARs.  

### Using environment variables inside of your config

ENV VARs can be used anywhere in the `Pod`.  

```
apiVersion: v1
kind: Pod
...
spec:
  containers:
    env:
    - name: GREETING
      value: "Warm greetings to"
    - name: HONORIFIC
      value: "The Most Honorable"
    - name: NAME
      value: "Kubernetes"
    command: ["echo"]
    args: ["$(GREETING) $(HONORIFIC) $(NAME)"]  # -> invokes an ENV VAR and prints "Warm greetings to The Most Honorable Kubernetes"
...
```
