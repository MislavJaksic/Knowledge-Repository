#!/bin/bash

kubectl delete -f generator/deployment.yaml
kubectl delete -f filter/deployment.yaml

kubectl delete -f generator/service.yaml
kubectl delete -f filter/service.yaml
