## [Docker Curriculum](https://docker-curriculum.com/)

Note: I didn't followed this tutorial from beginning to end. It repeats concepts from [Get started: get started with Docker](https://docs.docker.com/get-started/).

### Introduction

Skipped.  

### Getting started

Skipped.  

### Hello World

```
$: docker run -i -t Image-Name _command _param1 _param2 ... - interact in pretty print
  -i enables input and output
  -t format output

$: docker container prune - delete stopped containers
```

### Webapps with Docker

```
$: docker run --rm Docker-Id/_repository:_tag
  --rm delete container after it stopped

$: docker run -d -P --name Container-Name Docker-Id/_repository - run without terminal and with port map
  -d: detach container from the terminal
  -P: publish exposed ports to random ports
  --name: give container a name

$: docker port Container-Name - list port map; Inside-Port -> Outside-Port
```

```
Base image - have no parent image; OSs
Child image - build on top of base images

Official image - officially maintained
User image - created by users

ONBUILD image - help bootstrap apps
```

### Multi Container Environments

Container logs:
```
$: docker container ls - show containers

$: docker container logs Container-Name - list container logs
```

Dockerfile:
```
FROM ubuntu:latest # base image

RUN apt-get -yqq update # -yqq suppress output and assumes "Yes" to all prompts
RUN apt-get -yqq install python-pip python-dev curl gnupg # install dependencies
RUN curl -sL https://deb.nodesource.com/setup_10.x | bash
RUN apt-get install -yq nodejs

ADD flask-app /opt/flask-app # copy directory into container
WORKDIR /opt/flask-app # set working directory context path

RUN npm install # install app dependencies
RUN npm run build
RUN pip install -r requirements.txt

EXPOSE 5000 # expose port to the outside

CMD [ "python", "./app.py" ] # execute command
```

Containers can't see each other.  
The host can access each container on 0.0.0.0, but containers can't.  

```
Docker network - isolates container communication and provides automatic service discovery
  Docker network: bridge - default Docker container network

Bridge network type - containers connected to the same bridge can communicate
```

Docker networks:
```
$: docker network ls - list networks

$: docker network inspect Network-Name - inspect network

$: docker network create Network-Name - create network
```

```
$: docker run -d --name Container-Name --net Network-Name -p Outside-Port:Image-Port -e Env-Var Container-Name - connect container to network

$: docker run -d --net Container-Name -p Outside-Port:Image-Port --name Container-Name Container-Name - connect another container to network
```

#### Docker Compose

Compose defines and runs multi-container apps.  

docker-compose.yml:
```
version: "3"
services:
  Service-Name:
    image: Docker-Id/_repository:_tag # pull this image
    environment:
      - discovery.type=single-node # set environmental variable
    ports:
      - "Outside-Port:Image-Port" # map ports
    volumes:
      - esdata1:/usr/share/elasticsearch/data # define mount point in container
  Service-Name:
    image: Docker-Id/_repository:_tag
    command: _command _param1 _param2 ...
    depends_on:
      - Service-Name
    ports:
      - "Outside-Port:Image-Port"
    volumes:
      - ./flask-app:/opt/flask-app
volumes:
    esdata1:
      driver: local
```

### Conclusion

Skipped.  
