## [Docker](https://www.docker.com/resources/what-container)

Docker is a containerization program.  

### [Docker Hub](https://hub.docker.com/)

[Sample images](Docs/Samples/SampleApplications/SamplesHome)

### Install

[Instructions for Windows and Linux](Docs/Guides/GetDocker/DockerEngineCommunity)

### Dockerfile

Keep it modular.  
Put each command in its own layer when testing.  
Don't optimize too early!  
For production, merge all package update and install layers into one.  

```
RUN wget -O - http://example.com/big.tar.xz | tar -xJC /usr/src/things  # download, extract and delete `*.tar`
```

```
RUN chmod +x /path/to/file.ext  # grant permission
```

[Instructions](Docs/Guides/DevelopWithDocker/DevelopAppsOnDocker/DevelopImages/BestPractice)

### Docker commands

```
$: docker system prune [--all]  # delete cache

$: docker container ls -a  # list all containers

$: docker build --tag=_repository/Image-Name:Image-Tag Dockerfile-Path  # build and tag image
$: docker run [-d] [-P] [--name Container-Name] [-it] [--rm] _repository/Image-Name:Image-Tag  # run without terminal and with port map
  # -d: detach container from the terminal
  # -P: publish exposed ports to random ports
  # --name: give container a name
  # -it: interactive and pretty print
  # --rm: remove container after shutdown

$: docker container stop Container-Name  # stop container
$: docker container rm Container-Name  # delete container

$: docker container logs Container-Name  # list logs
$: docker container top Container-Name  # list running processes

$: docker container exec -it Container-Name _command  # execute a command in container
  # -i: interact
  # -t: TTY; pretty print

$: docker save Image-Name:Image-Tag | gzip > Archive-Name.tar.gz
$: docker load < Archive-Name.tar.gz

$: docker login  # connect to registry
$: docker tag Image-Tag _repository/Image-Name:Image-Tag  # tag image with a registry repository
$: docker push _repository/Image-Name:Image-Tag  # upload image to registry

$: docker swarm init  # create swarm and add a manager
$: docker swarm join --token Swarm-Join-Token _ip  # add a worker
$: docker node ls  # list swarm nodes
$: docker stack ls  # list stacks
$: docker stack services Stack-Name  # list stack services
$: docker stack deploy -c docker-compose.yml Stack-Name  # run service stack
$: docker service ps Service-Name  # list services

$: docker network ls  # list networks
$: docker network inspect Network-Name  # inspect network
$: docker network create Network-Name  # create network
$: docker network inspect Network-Name --format '{{index .Peers 0 "IP"}}'  # list network IP
```

### Private Docker registry

#### TLS

[Instructions](Docs/ProductManuals/OpenSourceProjects/DockerRegistry/Recepies/TestInsecureRegistry)  
