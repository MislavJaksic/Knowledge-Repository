#!/bin/bash

kubectl delete service generator-service
kubectl delete service filter-service

kubectl delete deployment generator-deployment
kubectl delete deployment filter-deployment
