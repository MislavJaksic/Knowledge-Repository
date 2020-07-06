## [Quick Start](https://www.getambassador.io/docs/latest/tutorials/getting-started/)

### Edgectl

Download `edgectl.exe`.  

```
$: edgectl install
```

### Kubernetes

```
$: kubectl apply -f https://www.getambassador.io/yaml/aes-crds.yaml && kubectl wait --for condition=established --timeout=90s crd -lproduct=aes && kubectl apply -f https://www.getambassador.io/yaml/aes.yaml && kubectl -n ambassador wait --for condition=available --timeout=90s deploy -lproduct=aes
```

```
$: kubectl get -n ambassador service ambassador -o "go-template={{range .status.loadBalancer.ingress}}{{or .ip .hostname}}{{end}}"
```

### Helm

```
$: helm repo add datawire https://www.getambassador.io

$: kubectl create namespace ambassador
$: helm install ambassador --namespace ambassador datawire/ambassador
```
