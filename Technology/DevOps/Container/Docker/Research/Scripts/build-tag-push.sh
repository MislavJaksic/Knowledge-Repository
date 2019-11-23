#!/bin/bash

DOCKER_ID=""
TAG=""

IMAGE=""

docker build --tag=$IMAGE $IMAGE/

docker tag $IMAGE $DOCKER_ID/$IMAGE:$TAG

docker push $DOCKER_ID/$IMAGE:$TAG
