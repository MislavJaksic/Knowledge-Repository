#!/bin/bash

docker swarm init

docker stack deploy -c docker-compose.yml Stack-Name

docker stack ls

docker service ls
