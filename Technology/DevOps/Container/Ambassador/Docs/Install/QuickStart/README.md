## [Quick Start Installation Guide](https://www.getambassador.io/user-guide/getting-started)

### Install the Ambassador Edge Stack

First:  
```
# Note: you must support LoadBalancers or use Minikube

$: kubectl apply -f https://www.getambassador.io/yaml/aes-crds.yaml && \
$: kubectl wait --for condition=established --timeout=90s crd -lproduct=aes && \
$: kubectl apply -f https://www.getambassador.io/yaml/aes.yaml && \
$: kubectl -n K8s-Ambassador-Namespace wait --for condition=available --timeout=90s deploy -lproduct=aes
```

Second:
```
$: kubectl get -n K8s-Ambassador-Namespace service ambassador -o 'go-template={{range .status.loadBalancer.ingress}}{{print .ip "\n"}}{{end}}'
```

Third (start here if you installed using `Helm`):
```
# Note: navigate to https://Kubectl-Service-IP:Node-Port
```

Fourth:
[Edge Policy Console](../../../Other/EdgePolicyConsole)

Fifth:
```
$: edgectl login --namespace=K8s-Ambassador-Namespace Ambassador-Host
```

### Configure TLS Termination and Automatic HTTPS

TODO

### Create a Mapping

`Mapping`s associate parts of your domain with:
* URLs
* IP addresses
* prefixes

```
$: kubectl apply -f quote.yaml  # see Research

$: kubectl apply -f quote-mapping.yaml.
```

```
$: curl -Lk https://Kubectl-Service-IP:Node-Port/backend/
```

`Mapping`s routes `http://Kubectl-Service-IP:Node-Port/backend/` to the `quote` `Service`

### A single source of configuration

TODO

### Developer Onboarding

TODO
