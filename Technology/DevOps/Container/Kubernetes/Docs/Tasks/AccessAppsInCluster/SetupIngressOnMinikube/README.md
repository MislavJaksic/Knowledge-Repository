## [Set up Ingress on Minikube with the NGINX Ingress Controller](https://kubernetes.io/docs/tasks/access-application-cluster/ingress-minikube/)

`Ingress` defines rules for external access to `Service`s.  `Ingress Controller` fulfils the rules set in the `Ingress`.  

### Enable the Ingress controller

```
$: minikube addons enable ingress  # enable NGINX Ingress Controller

$: kubectl get pods -n kube-system
  # NAME                          READY     STATUS
  # nginx-ingress-controller-ID   1/1       Running
  # ...
```

### Deploy a hello, world app

```
$: kubectl run web --image=gcr.io/google-samples/hello-app:1.0 --port=8080
$: kubectl run web2 --image=gcr.io/google-samples/hello-app:2.0 --port=8080

$: kubectl expose deployment web --target-port=8080 --type=NodePort

$: kubectl get service web
  # NAME      TYPE       CLUSTER-IP       EXTERNAL-IP   PORT(S)       
  # web       NodePort   10.104.133.249   <none>        8080:Node-Port/TCP

# Note: visit http://Kubectl-Server-IP:Node-Port
```

### Create an Ingress resource

```
apiVersion: networking.k8s.io/v1beta1
kind: Ingress
metadata:
  name: example-ingress
  annotations:
    nginx.ingress.kubernetes.io/rewrite-target: /$1
spec:
  rules:
  - host: Ingress-Host  # put it into /etc/hosts  # or use `Kubectl-Service-IP.nip.io`
    http:
      paths:
      - path: /
        backend:
          serviceName: web
          servicePort: 8080
      - path: /v2/*
        backend:
          serviceName: web2
          servicePort: 8080
```

```
$: kubectl apply -f example-ingress.yaml
```

```
$: kubectl get ingress  # ->
  # NAME              HOSTS          ADDRESS             PORTS
  # example-ingress   Ingress-Host   Kubectl-Server-IP   80   
```

```
# Note: get Kubectl-Server-IP from `minikube ip`
# Note: append `Kubectl-Server-IP Ingress-Host` to `/etc/hosts` if you didn't use `nip.io`

$: curl Ingress-Host
$: curl Ingress-Host/v2
```
