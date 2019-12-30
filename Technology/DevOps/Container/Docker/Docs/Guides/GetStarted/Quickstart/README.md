## [Get started: get started with Docker](https://docs.docker.com/get-started/)

### 1: Orientation

```
Linux containers: process virtualization; based on namespace and cgroup subsystems; processes think they have the whole Linux kernel for themselves and yet they share it with other such processes
Containerization: use of Linux containers to deploy applications
Image: an executable package
Container: a runtime instance of an image; thinks they have the whole kernel for themselves
```

```
$: docker version  # version
$: docker info  # installation details

$: docker container ls --all  # list containers
$: docker ps  # list running containers

$: docker image ls --all  # list images

$: docker run hello-world  # run test image
$: docker run Image-Tag  # run image
```

### 2: Containers

To create a "Docker app" you need to define:
1) container
2) services
3) stack

#### Dockerfile

A portable image.  
Defines the environment inside the container. Network interfaces, disk drives, ports, ...  

```
FROM  # parent image

WORKDIR _path  # set the working directory

COPY From-Path-Outside To-Path-Inside  # copy contents

RUN _command  # execute command (in shell form); creates a new layer/image

EXPOSE _port  # expose port outside the container

ENV NAME Env-Var-Name  # define environment variable

CMD ["python", "app.py"]

```

#### Build the image

```
$: docker build --tag=Image-Tag Dockerfile-Path  # build an image with a tag from a Dockerfile
```

#### Run the image

```
$: docker run -p Outside-Port:Image-Port Image-Tag  # run image and map ports

$: docker run -d -p Outside-Port:Image-Port Image-Tag  # run in the background, detached mode
$: docker container stop Container-Id - "SIGTERM"
$: docker container kill Container-Id - "SIGKILL"
```

#### Share the image

Registry is a collection of repositories.  
Repository is a collection of images.  

```
$: docker login  # connect to a registry

$: docker tag Image-Tag _repository/Image-Name:Image-Tag  # associate a local image with a repository on a registry
$: docker push _repository/Image-Name:Image-Tag  # upload image to registry

$: docker run -p Outside-Port:Image-Port _repository/Image-Name:Image-Tag  # run remote image from a registry
```

#### Remove resources

```
$: docker system prune  # remove dangling resources
$: docker system prune -a  # remove all resources

$: docker container rm Container-Id  # remove container
$: docker container rm $(docker container ls -a -q)  # remove all containers

$: docker image rm Image-Tag  # remove image
$: docker image rm $(docker image ls -a -q)  # remove all images
```

### 3: Services

```
Service: part of a distributed application, a container in production
Stack: bundle of services?
Task: a single container running in a service
```

#### docker-compose.yml

```
version: "3"
services:
  Service-Name:
    image: _repository/Image-Name:Image-Tag  # pull this image
    deploy:
      replicas: N # replication factor
      resources:
        limits:
          cpus: "X"  # X cores
          memory: Y  # Y RAM
      restart_policy:
        condition: Restart-Condition
    ports:
      - "Outside-Port:Image-Port"  # map ports
    networks:
      - Network-Name  # load balanced network
networks:
  Network-Name:  # define network
```

#### Run load-balanced app

```
$: docker swarm init  # init swarm manager

$: docker stack deploy -c docker-compose.yml Stack-Name  # run service stack

$: docker service ls  # list services
$: docker stack services Stack-Name  # list stack services
$: docker service ps Stack-Name  # list service tasks
```

#### Update docker-compose.yml

If you change the replicas number just rerun:  
```
$: docker stack deploy -c docker-compose.yml Stack-Name
```
No need to tear down containers manually.  

#### Shutdown the app

```
$: docker stack rm Stack-Name

$: docker swarm leave --force
```

### 4: Swarms

```
Swarm: multi-computer, multi-container Docker cluster
Swarm manager: executes Docker commands on the cluster
Nodes: physical or virtual machines in a swarm
Worker: provides capacity to the cluster
Swarm mode: makes your machine a swarm manager
```

#### Setup swarm

```
Linux with VirtualBox:
$: docker-machine create --driver virtualbox Vm-Name1  # create VM
$: docker-machine create --driver virtualbox Vm-Name2

$: docker-machine ls  # list VMs

$: docker-machine ssh Vm-Name1 "docker swarm init --advertise-addr Vm-Ip1"  # add a swarm manager
$: docker-machine ssh Vm-Name2 "docker swarm join --token Swarm-Join-Token Vm-Ip1"  # add a worker

$: docker-machine ssh Vm-Name1 "docker node ls"  # list swarm

$: docker-machine ssh Vm-Name "docker swarm leave"  # leave swarm
```

Connect host shell with VM:
```
$: docker-machine env Vm-Name1  # removes the need for the "docker-machine ssh" wrapper

Linux:
$: eval $(docker-machine env myvm1)  # connect host shell to Docker Machine VM

$: docker-machine ls  # list VMs; there should be a single asterisk in the row ACTIVE
```

#### Deploy the app

```
$: docker stack deploy -c docker-compose.yml Stack-Name  # run service stack

$: docker stack ps Stack-Name
```

#### Access the app

The app network is shared and load-balanced.  
You can visit either VM IP address.  

Nodes in a swarm participate in an ingress routing mesh.  
A port is assigned to a service not the node running the container.  

You can:
* scale the app using docker-compose.yml
* make changes to the app
* add more machines to the swarm

After making changes run:
```
$: docker stack deploy -c docker-compose.yml Stack-Name  # update swarm
```

#### Cleanup and reboot

```
$: docker stack rm Stack-Name  # tear down stack

$: docker-machine ssh Vm-Name2 "docker swarm leave"  # worker leaves the swarm
$: docker-machine ssh Vm-Name1 "docker swarm leave --force"  # manager leaves the swarm

$: docker-machine start Vm-Name2  # restart VM

$: docker-machine stop $(docker-machine ls -q)  # stop all VM
$: docker-machine rm $(docker-machine ls -q)  # delete all VM

Linux:
eval $(docker-machine env -u)  # unset environment variables; disconnect shell from VM
```

### 5: Stacks

```
Stack: group of services that share dependencies and can be scaled
```

#### Add a new service

Append docker-compose.yml with:  
```
version: "3"
services:
  ...

  Service-Name2:
    image: _repository/Image-Name:Image-Tag
    ports:
      - "Outside-Port:Image-Port"
    volumes:
      - "/var/run/docker.sock:/var/run/docker.sock"  # gives access to the host’s socket file; map files; define mount point in container
    deploy:
      placement:
        constraints: [node.role == manager]  # service will only run on a swarm manager (never a worker)
    networks:
      - Network-Name

  ...
```

Configure your VMs and shell:
```
$: docker-machine ls  # there should be an asterisk next to VM-Name

If not run:
$: docker-machine env myvm1
  Linux:
  eval $(docker-machine env myvm1)

$: docker stack deploy -c docker-compose.yml Stack-Name  # update stack

$: docker service ls
```

#### Add persistence

Append docker-compose.yml with:  
```
version: "3"
services:
  ...

  Service-Name3:
    image: _repository/Image-Name:Image-Tag
    ports:
      - "Outside-Port:Image-Port"
    volumes:
      - "/home/docker/data:/data"  # gives access to the host’s file; persist data on host; map files
    deploy:
      placement:
        constraints: [node.role == manager]  # service will only run on a swarm manager (never a worker)
    command: redis-server --appendonly yes
    networks:
      - Network-Name

  ...
```

Configure your VMs and shell:
```
$: docker-machine ssh myvm1 "mkdir ./data"  # create directory "data" on the manager

$: docker-machine ls  # there should be an asterisk next to VM-Name

If not run:
$: docker-machine env myvm1
  Linux:
  eval $(docker-machine env myvm1)

$: docker stack deploy -c docker-compose.yml Stack-Name  # update stack

$: docker service ls
```

### 6: Deploy your app

Wherever there is a Docker Engine, you can deploy your app.
