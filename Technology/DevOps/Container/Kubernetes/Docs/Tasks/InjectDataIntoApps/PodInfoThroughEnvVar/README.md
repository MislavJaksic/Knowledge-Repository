## [Expose Pod Information to Containers Through Environment Variables](https://kubernetes.io/docs/tasks/inject-data-application/environment-variable-expose-pod-information/)

### The Downward API

`Downward API` is how `Pod`s expose fields to their `Container`s:
* by using ENV VAR
* through `VolumeFile`s

### Use Pod fields as values for ENV VARs

```
apiVersion: v1
kind: Pod
...
spec:
  containers:
    - command: [ "sh", "-c"]
      args:
      - while true; do
          echo -en '\n';
          printenv MY_POD_IP MY_POD_SERVICE_ACCOUNT;  # -> prints "172.17.0.4 \n default"
          sleep 10;
        done;
      env:
        - name: MY_POD_IP  # assign to `Container` ENV VAR
          valueFrom:
            fieldRef:
              fieldPath: status.podIP  # `Pod`'s field value that is to be assigned
        - name: MY_POD_SERVICE_ACCOUNT
          valueFrom:
            fieldRef:
              fieldPath: spec.serviceAccountName
...
```

### Use Container fields as values for ENV VARs

```
apiVersion: v1
kind: Pod
...
spec:
  containers:
    - name: test-container
      command: [ "sh", "-c"]
      args:
      - while true; do
          echo -en '\n';
          printenv MY_CPU_REQUEST MY_CPU_LIMIT;  # -> prints "1 \n 1"
          sleep 10;
        done;
      env:
        - name: MY_CPU_REQUEST  # assign to `Container` ENV VAR
          valueFrom:
            resourceFieldRef:
              containerName: test-container
              resource: requests.cpu  # `Container`'s field value that is to be assigned
        - name: MY_CPU_LIMIT
          valueFrom:
            resourceFieldRef:
              containerName: test-container
              resource: limits.cpu
      resources:
        requests:
          cpu: "125m"
        limits:
          cpu: "250m"
...
```
