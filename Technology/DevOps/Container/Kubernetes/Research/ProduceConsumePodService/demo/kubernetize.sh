#!/bin/bash

kubectl apply -f generator/deployment.yaml
kubectl apply -f filter/deployment.yaml

kubectl apply -f generator/service.yaml
kubectl apply -f filter/service.yaml

# minikube service generator-service
# minikube service filter-service

# kubectl exec -it generator-deployment-ID bash
