## [Configure a Pod to Use a ConfigMap](https://kubernetes.io/docs/tasks/configure-pod-container/configure-pod-configmap/)

`ConfigMaps` decouple configuration from the image.  
`ConfigMaps` are `Secrets` that don’t contain sensitive information.  

### Create a ConfigMap

#### Create from a file

```
$: kubectl create configmap ConfigMap-Name --from-file=ConfigMap-Directory
OR
$: kubectl create configmap ConfigMap-Name --from-env-file=Env-Var-Properties-File
OR
$: kubectl create configmap ConfigMap-Name --from-file=Properties-Key=Data-Source
OR
$: kubectl create configmap ConfigMap-Name --from-literal=_key=_value

$: kubectl describe configmaps ConfigMap-Name
$: kubectl get configmaps ConfigMap-Name -o yaml
```

#### Generate using kustomization.yaml

```
$: cat <<EOF >./kustomization.yaml
configMapGenerator:
- name: ConfigMap-Name
  files:
  - [Properties-Key=]File-Name
  [literals:
  - _key=_value]
EOF

$: kubectl apply -k .

$: kubectl get configmap
$: kubectl describe configmaps/ConfigMap-Name-ID
```

### Define container environment variables using ConfigMap

```
kind: Pod
...
spec:
  containers:
      ...
      env:
        - name: ENV-VAR-NAME
          valueFrom:
            configMapKeyRef:
              name: ConfigMap-Name
              key: _key

# Note: you can include values from multiple ConfigMaps
```

### Configure key-values in a ConfigMap as container environment variables

```
kind: Pod
...
spec:
  containers:
      ...
      envFrom:
      - configMapRef:
          name: ConfigMap-Name
```

### Use ConfigMap-defined environment variables in Pod commands

```
kind: Pod
...
spec:
  containers:
      ...
      command: [ "/bin/sh", "-c", "echo $(ENV-VAR-NAME)" ]
      env:
        - name: ENV-VAR-NAME
          valueFrom:
            configMapKeyRef:
              name: ConfigMap-Name
              key: _key
```

### Add ConfigMap data to a Volume

Mounted configs are updated only so often.  

```
kind: Pod
...
spec:
  containers:
      ...
      volumeMounts:
      - name: Volume-Name
        mountPath: Path-To-ConfigMap
  volumes:
    - name: Volume-Name
      configMap:
        name: ConfigMap-Name

# Note: you can specify a path for ConfigMap items
```

### Understanding ConfigMaps and Pods

Think of `ConfigMaps` as Linux's `/etc` directory.  

Restrictions:
* create a `ConfigMap` before using it
* invalid `envFrom` environmental variables will be skipped
* `ConfigMaps` reside in a namespace
* `ConfigMaps` cannot be used by pods not found on the API server (pods created with Kubelet's --manifest-url, --config or REST API)
