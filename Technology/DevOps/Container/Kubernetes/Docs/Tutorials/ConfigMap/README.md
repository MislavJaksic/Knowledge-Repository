## [Configuring Redis using a ConfigMap](https://kubernetes.io/docs/tutorials/configuration/configure-redis-using-configmap/)

File-Name:
```
maxmemory 2mb
maxmemory-policy allkeys-lru
```

redis-pod.yaml:
```
apiVersion: v1
kind: Pod
metadata:
  name: redis
spec:
  containers:
  - name: redis
    image: redis:5.0.4
    ...
  ...
  volumes:
    - name: data
      emptyDir: {}
    - name: config
      configMap:
        name: ConfigMap-Name
        items:
        - key: _key
          path: redis.conf
```

```
$: cat <<EOF >./kustomization.yaml           configMapGenerator:
configMapGenerator:                  CREATE  - name: ConfigMap-Name
- name: ConfigMap-Name                 ->      files:
  files:                                       - File-Name
  - File-Name
EOF

$: cat <<EOF >>./kustomization.yaml          configMapGenerator:
resources:                           APPEND  - name: ConfigMap-Name
- redis-pod.yaml                       ->      files:
EOF                                            - File-Name
                                             resources:
                                             - redis-pod.yaml
```

```
$: kubectl apply -k .
```

```
$: kubectl get -k .
$: kubectl get configmaps

                                                         Name: ConfigMap-Name-ID
                                                         ...
                                                         Annotations: ...: {...,
                                                                            "data":{"_key":"maxmemory 2mb
                                                                                            maxmemory-policy allkeys-lru"},
$: kubectl describe configmaps                       ->  Data               ...
                                                         ====
                                                         _key:
                                                         ----
                                                         maxmemory 2mb
                                                         maxmemory-policy allkeys-lru


                                                         apiVersion: v1
                                                         data:
$: kubectl get configmaps ConfigMap-Name-ID -o yaml  ->    _key: |
                                                             maxmemory 2mb
                                                             maxmemory-policy allkeys-lru
                                                         kind: ConfigMap
                                                         ...
```

```
$: kubectl exec -it redis redis-cli
   -> $: config get maxmemory  #-> "maxmemory"="2097152"
   -> $: config get maxmemory-policy  #-> "maxmemory-policy"="allkeys-lru"
```

```
$ kubectl delete pod redis
```
