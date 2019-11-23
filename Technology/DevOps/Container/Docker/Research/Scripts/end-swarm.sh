#!/bin/bash

docker stack rm Stack-Name

docker swarm leave --force
