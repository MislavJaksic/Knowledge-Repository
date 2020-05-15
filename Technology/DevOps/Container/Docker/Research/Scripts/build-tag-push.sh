#!/bin/bash

DOCKER_ID=""
TAG=""

IMAGE=""

docker build --tag=$IMAGE:$TAG
docker tag $IMAGE:$TAG $DOCKER_ID/$IMAGE:$TAG
docker push $DOCKER_ID/$IMAGE:$TAG
