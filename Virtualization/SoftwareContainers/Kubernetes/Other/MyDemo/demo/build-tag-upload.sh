#!/bin/bash

DOCKER_ID=""

GENERATOR="generator"

docker build --tag=$GENERATOR $GENERATOR/

echo "=== DOCKER BUILT ==="

docker tag $GENERATOR $DOCKER_ID/$GENERATOR:demo

echo "=== DOCKER TAGGED ==="

docker push $DOCKER_ID/$GENERATOR:demo

echo "=== DOCKER UPLOADED ==="



FILTER="filter"

docker build --tag=$FILTER $FILTER/

echo "=== DOCKER BUILT ==="

docker tag $FILTER $DOCKER_ID/$FILTER:demo

echo "=== DOCKER TAGGED ==="

docker push $DOCKER_ID/$FILTER:demo

echo "=== DOCKER UPLOADED ==="
