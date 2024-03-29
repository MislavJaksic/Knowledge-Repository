#!/bin/bash

KUBECTL_SERVER_IP_PORT=0

kubectl get secret harbor-harbor-nginx -o jsonpath='{.data.ca\.crt}' | base64 -d > ca.crt
kubectl get secret harbor-harbor-nginx -o jsonpath='{.data.tls\.crt}' | base64 -d > tls.cert
kubectl get secret harbor-harbor-nginx -o jsonpath='{.data.tls\.key}' | base64 -d > tls.key

sudo mkdir -p /etc/docker/certs.d/$KUBECTL_SERVER_IP_PORT

sudo cp ca.crt /etc/docker/certs.d/$KUBECTL_SERVER_IP_PORT
sudo cp tls.cert /etc/docker/certs.d/$KUBECTL_SERVER_IP_PORT
sudo cp tls.key /etc/docker/certs.d/$KUBECTL_SERVER_IP_PORT
