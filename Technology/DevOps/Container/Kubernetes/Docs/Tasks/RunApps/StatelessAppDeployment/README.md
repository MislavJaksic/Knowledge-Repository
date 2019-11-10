## [Run a Stateless Application Using a Deployment](https://kubernetes.io/docs/tasks/run-application/run-stateless-application-deployment/)

```
apiVersion: apps/v1
kind: Deployment
metadata:
  name: Deployment-Name
spec:
  selector:
    matchLabels:
      app: App-Name
  replicas: 2
  template:
    metadata:
      labels:
        app: nginx
    spec:
      containers:
      - name: nginx
        image: nginx:1.7.9
        ports:
        - containerPort: 80
```

```
$: kubectl apply -f https://k8s.io/examples/application/deployment.yaml

$: kubectl describe deployment Deployment-Name
$: kubectl get pods -l app=App-Name
$: kubectl describe pod Pod-Name
```

```
...
    spec:
      containers:
      - name: nginx
        image: nginx:1.8
        ports:
        - containerPort: 80
```

```
$: kubectl apply -f https://k8s.io/examples/application/deployment-update.yaml

$: kubectl scale deployments/Deployment-Name --replicas=4
```

```
$: kubectl delete deployment Deployment-Name
```
