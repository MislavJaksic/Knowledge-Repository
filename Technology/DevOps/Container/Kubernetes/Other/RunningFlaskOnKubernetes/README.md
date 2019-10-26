## [Running Flask on Kubernetes](https://testdriven.io/blog/running-flask-on-kubernetes/)

Skip chapters until Minikube.  

### Minikube

Install Minikube.  

```
$: minikube dashboard
```

If there is a problem, reset Minikube:
```
$: minikube stop; minikube delete
$: rm /usr/local/bin/minikube
$: rm -rf ~/.minikube

# Note: download minikube again
$: minikube start
```

### Volume

```
apiVersion: v1
kind: PersistentVolume
metadata:
  name: pv-name
spec:
  capacity:
    storage: 2Gi
  storageClassName: storageclass-name
  accessModes:
    - ReadWriteOnce
  hostPath:  # only in single node Kubernetes
    path: "/host/path/pv-name"
```

```
apiVersion: v1
kind: PersistentVolumeClaim
metadata:
  name: pvc-name
spec:
  accessModes:
    - ReadWriteOnce
  resources:
    requests:
      storage: 2Gi
  volumeName: pv-name
  storageClassName: storageclass-name
```

```
$: kubectl apply -f persistent-volume.yml
$: kubectl apply -f ./kubernetes/persistent-volume-claim.yml

$: kubectl get pv  #->
  # NAME      CAPACITY   ACCESS MODES   RECLAIM POLICY   STATUS      CLAIM   STORAGECLASS        REASON
  # pv-name   2Gi        RWO            Retain           Available           storageclass-name         
$: kubectl get pvc  #->
  # NAME       STATUS   VOLUME    CAPACITY   ACCESS MODES   STORAGECLASS     
  # pvc-name   Bound    pv-name   2Gi        RWO            storageclass-name
```

### Secret

Secrets handling passwords, API tokens, SSH keys and similar sensitive information.  

```
apiVersion: v1
kind: Secret
metadata:
  name: secret-name
type: Opaque
data:
  user: c2FtcGxl
  password: cGxlYXNlY2hhbmdlbWU=
```

```
$: kubectl apply -f secret.yml
```

### Postgres

```
apiVersion: apps/v1                                    apiVersion: v1
kind: Deployment                                       kind: Service
metadata:                                              metadata:
  name: postgres                                         name: postgres # DNS name
spec:                                                  spec:
  replicas: 1                                            selector:
  selector:                                                db: deployment-label-db-value
    matchLabels:                                         type: ClusterIP
      db: deployment-label-db-value                      ports:
  template:                                              - port: 5432
    metadata:                                          
      labels:                                          
        db: deployment-label-db-value                  
    spec:                                              
      containers:                                      
      - name: postgres                                 
        image: postgres:10.4-alpine                    
        env:                                           
          - name: POSTGRES_USER
            valueFrom:                                 
              secretKeyRef:                            
                name: secret-name                      
                key: user                              
          - name: POSTGRES_PASSWORD                    
            valueFrom:                                 
              secretKeyRef:                            
                name: secret-name                      
                key: password                          
        volumeMounts:                                  
          - name: volume-mount                         
            mountPath: /var/lib/postgresql/data        
      volumes:                                         
      - name: volume-mount                             
        persistentVolumeClaim:                         
          claimName: pvc-name                          
      restartPolicy: Always                            
```

```
$: kubectl create -f postgres-deployment.yml
$: kubectl create -f postgres-service.yml

$: kubectl exec postgres-ID --stdin --tty -- createdb -U sample books
$: kubectl exec postgres-ID --stdin --tty -- psql -U sample
```

### Flask

```
apiVersion: apps/v1                                        apiVersion: v1
kind: Deployment                                           kind: Service
metadata:                                                  metadata:
  name: flask                                                name: flask # DNS name
spec:                                                      spec:
  replicas: 1                                                selector:
  selector:                                                    app: deployment-label-app-value
    matchLabels:                                             ports:
      app: deployment-label-app-value                        - port: 5000
  template:                                                    targetPort: 5000
    metadata:                                              
      labels:                                              
        app: deployment-label-app-value                    
    spec:                                                  
      containers:                                          
      - name: flask                                        
        image: mjhea0/flask-kubernetes:latest              
        env:                                               
        - name: FLASK_ENV                                  
          value: "development"                             
        - name: APP_SETTINGS                               
          value: "project.config.DevelopmentConfig"        
        - name: POSTGRES_USER                              
          valueFrom:                                       
            secretKeyRef:                                  
              name: secret-name                            
              key: user                                    
        - name: POSTGRES_PASSWORD                          
          valueFrom:                                       
            secretKeyRef:                                  
              name: secret-name                            
              key: password                                
      restartPolicy: Always                                
```

```
$: kubectl create -f flask-deployment.yml
$: kubectl create -f flask-service.yml

$: kubectl exec flask-ID --stdin --tty -- python manage.py recreate_db
$: kubectl exec flask-ID --stdin --tty -- python manage.py seed_db
```

### Ingress

TODO
