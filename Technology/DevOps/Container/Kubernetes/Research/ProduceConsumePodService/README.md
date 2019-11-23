## Demo

In a single `Node` a generator `Pod` sends a message to the filter `Pod` when the user signals the generator `Pod`.  
Both `Pod`s are accessible from the outside.  

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
        ports:                                                  ports:
          - containerPort: 5001                                   - containerPort: 5002
        env:                                                  restartPolicy: Always
          - name: "ADDRESS"                             
            value: "http://filter-service:5002/filter"  
      restartPolicy: Always
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
  - port: 5001               - port: 5002
    targetPort: 5001           targetPort: 5002
```

### Usage

Run `kubernetize.sh`. Wait until the `Pod`s are online.  
```
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
  # filter-service      NodePort    ...          <none>        5002:Assigned-Filter-Port/TCP
  # generator-service   NodePort    ...          <none>        5001:Assigned-Generator-Port/TCP
  # kubernetes          ClusterIP   ...          <none>        443/TCP
```
Visit `http://Kubectl-Server-Ip:Assigned-Service-Port`.  

Run `unkubernetize.sh` to delete all `Service`s and `Deployment`s.  
