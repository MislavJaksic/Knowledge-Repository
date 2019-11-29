## Demo

In a single `Node` a generator `Pod` sends a message to the filter `Pod` when the user signals the generator `Pod`.  
Both `Pod`s are accessible from the outside because of `NodePort`.  
You can use an `Ingress` and an `Ingress Controller` as a single point on entry.  
You can use an API Gateway, Ambassador, which is more powerful then an `Ingress`.  
`ConfigMap` allows resources like `Deployment`s to be reconfigured.  

### Microservices

```
import os                                           from flask import Flask, request, jsonify
from random import randrange                        
import requests                                     app = Flask(__name__)
from flask import Flask, jsonify                    msgs = []

app = Flask(__name__)                               @app.route("/", methods=["GET"])
msgs = []                                           def get_filtered():
                                                        return jsonify([msg for msg in msgs])
@app.route("/")                                     
def generate():                               .---> @app.route("/filter", methods=["POST"])
    number = randrange(1, 101)                |     def filter():
    ADDRESS = os.environ.get("ADDRESS")       |         json = request.json
    payload = {"number": str(number)}         |         number = json["number"]
                                              |
    requests.post(ADDRESS, json=payload) -----*         if int(number) >= 50:
                                                            msgs.append(json)
    msgs.append(payload)                            
                                                        print(msgs)
    return jsonify([msg for msg in msgs])           
                                                        return jsonify({"number": str(number)})

if __name__ == "__main__":                          
    app.run(debug=True, host="0.0.0.0", port=5001)  if __name__ == "__main__":
                                                        app.run(debug=True, host="0.0.0.0", port=5002)
```

### Deployments

```
apiVersion: apps/v1                                     apiVersion: apps/v1
kind: Deployment                                        kind: Deployment
metadata:                                               metadata:
  name: generator-deployment                              name: filter-deployment
spec:                                                   spec:
  replicas: 1                                             replicas: 1
  selector:                                               selector:
    matchLabels:                                            matchLabels:
      tier: generator-tier                                    tier: filter-tier
  template:                                               template:
    metadata:                                               metadata:
      labels:                                                 labels:
        tier: generator-tier                                    tier: filter-tier
    spec:                                                   spec:
      containers:                                             containers:
      - name: generator                                       - name: filter
        image: */generator:demo                                 image: */filter:demo
        command: ["python"]                                     command: ["python"]
        args: ["server.py"]                                     args: ["server.py"]
        ports:                                                  ports:
          - containerPort: 5001                                   - containerPort: 5002
        envFrom:                                              restartPolicy: Always
          - configMapRef:
              name: generator-configmap
        env:
          - name: "UNUSED"
            value: "unused-id"
      restartPolicy: Always

---
apiVersion: v1
kind: ConfigMap
metadata:
  name: generator-configmap
data:
  ADDRESS: "http://filter-service:15002/filter"
```

### Services

```
apiVersion: v1             apiVersion: v1
kind: Service              kind: Service
metadata:                  metadata:
  name: generator-service    name: filter-service
spec:                      spec:
  type: NodePort             type: NodePort
  selector:                  selector:
    tier: generator-tier       tier: filter-tier
  ports:                     ports:
  - port: 15001               - port: 15002
    targetPort: 5001           targetPort: 5002
```

### Ingress

```
apiVersion: extensions/v1beta1
kind: Ingress
metadata:
  name: demo-ingress
  annotations:
    nginx.ingress.kubernetes.io/rewrite-target: /
spec:
  rules:
  - host: demo.Kubectl-Server-Ip.nip.io
    http:
      paths:
      - path: /generator
        backend:
          serviceName: generator-service
          servicePort: 15001
      - path: /filter
        backend:
          serviceName: filter-service
          servicePort: 15002
```

### Ambassador API Gateway

```
apiVersion: getambassador.io/v1           apiVersion: getambassador.io/v1
kind: Mapping                             kind: Mapping
metadata:                                 metadata:
  name: generator-mapping                   name: filter-mapping
spec:                                     spec:
  prefix: /generator-ambassador/            prefix: /filter-ambassador/
  service: generator-service:15001          service: filter-service:15002
```

### Usage

```
$: kubectl apply -f k8n-yaml

$: kubectl config view --minify  # ->
  # ...
  # clusters:
  # - cluster:
  #     certificate-authority: /path/to/k8n/ca.crt
  #     server: https://Kubectl-Server-Ip:Kubernetes-Port
  #   name: Cluster-Name
  # ...
$: kubectl get service  # ->
  # NAME                TYPE        CLUSTER-IP   EXTERNAL-IP   PORT(S)
  # filter-service      NodePort    ...          <none>        15002:Filter-Note-Port/TCP
  # generator-service   NodePort    ...          <none>        15001:Generator-Note-Port/TCP

# Note: visit http://Kubectl-Server-Ip:Service-Node-Port

# Note: or use `Ingress`
$: curl demo.Kubectl-Server-Ip.nip.io/generator
$: curl demo.Kubectl-Server-Ip.nip.io/filter

# Note: or use `Ambassador`
$: kubectl get svc -o wide ambassador  #->
  # NAME        EXTERNAL-IP       PORT(S)         
  # ambassador  LoadBalancer-IP   80:HTTP-Node-Port/TCP,443:HTTPS-Node-Port
# Note: visit http://LoadBalancer-IP/
# Note: visit http://Kubectl-Service-IP:HTTP-Node-Port

$: kubectl delete -f k8n-yaml
```
