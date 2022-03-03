## [Configure a Pod to Use a ConfigMap](https://kubernetes.io/docs/tasks/configure-pod-container/configure-pod-configmap/)

`ConfigMap`s decouple configuration from the image.  
`ConfigMap`s are `Secret`s that don't contain sensitive information.  

### Create a ConfigMap

Use `kubectl` or `Kustomize` (since 1.14).  

#### Using kubectl

Create from:
* directories
* files
* literal values

Key:
* a file name
* a key provided during creation

Value:
* file contents
* literal value

```
$: kubectl create configmap ConfigMap-Name Data-Source

$: kubectl describe configmaps ConfigMap-Name
$: kubectl get configmaps ConfigMap-Name -o yaml
```

Imagine this directory when pondering the following examples:
```
ConfigMap-Dir
|-- Config-0.properties
`-- Config-1.properties
```

The result will most often be:
```
apiVersion: v1
kind: ConfigMap
metadata:
  name: ConfigMap-Name
  ...
data:
  Config-0.properties: |
    Key-0=Value-0
  Config-1.properties: |
    Key-1=Value-1
```

##### Create ConfigMaps from directories

```
$: kubectl create configmap ConfigMap-Name --from-file=ConfigMap-Dir
```

##### Create ConfigMaps from files

```
$: kubectl create configmap ConfigMap-Name --from-env-file=/path/to/ConfigMap-Dir/Config-0.properties

# Note: cannot take multiple files `--from-env-file`
# Note: defines a new file key `--from-file=New-Config-0-Name=/path/to/ConfigMap-Dir/Config-0.properties`
# Note: you can send multiple files using `--from-file=/path/to/ConfigMap-Dir/Config-0.properties`
```

##### Create ConfigMaps from literal values

```
$: kubectl create configmap ConfigMap-Name --from-literal=Key-In-ConfigMap=Value-In-ConfigMap
```

#### Using Kustomize generator

TODO

##### Generate using kustomization.yaml

TODO

```
$: cat <<EOF >./kustomization.yaml
configMapGenerator:
- name: ConfigMap-Name
  files:
  - [Properties-Key=]File-Name
  [literals:
  - Key-In-ConfigMap=Value-In-ConfigMap]
EOF

$: kubectl apply -k .

$: kubectl get configmap
$: kubectl describe configmaps/ConfigMap-Name-ID
```

### Define container ENV VARs using ConfigMap data

```
apiVersion: v1
kind: Pod
...
spec:
  containers:
      env:
        - name: ENV_VAR_0
          valueFrom:
            configMapKeyRef:
              name: ConfigMap-Name-0
              key: Key-0
        - name: ENV_VAR_1
          valueFrom:
            configMapKeyRef:
              name: ConfigMap-Name-1
              key: Key-1
...
```

### Configure all key-value pairs in a ConfigMap as container ENV VARs

Inject every key-value into ENV VARs using `envFrom`.  

```
apiVersion: v1
kind: Pod
...
spec:
  containers:
      envFrom:  # not `env`!
      - configMapRef:
          name: ConfigMap-Name
...
```

### Use ConfigMap-defined ENV VARs in Pod commands

```
apiVersion: v1
kind: Pod
...
spec:
  containers:
      command: [ "/bin/sh", "-c", "echo $(ENV_VAR_0)" ]
      env:
        - name: ENV_VAR_0
          valueFrom:
            configMapKeyRef:
              name: ConfigMap-Name-0
              key: Key-0
...
```

### Add ConfigMap data to a Volume

TODO

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
* if a referenced `ConfigMap` doesn't exist, the `Pod` won't start
* invalid ENV VARs in `envFrom` will be skipped and recorder in `InvalidVariableNames` event (`kubectl get events`)
* `ConfigMaps` reside in a namespace
* `ConfigMaps` cannot be used by `Pod`s not found on the API server (pods created with Kubelet's --manifest-url, --config or REST API)
