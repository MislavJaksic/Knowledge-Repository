## [Docker](https://www.docker.com/resources/what-container)

Docker is a containerization program.  

### [Docker Hub](https://hub.docker.com/)

Docker images can be browsed, download from and uploaded to the Hub.  
[Sample images](Docs/Samples/SampleApplications/SamplesHome)

There are many more official images on Docker Hub.  

### Install

[Instructions](Docs/Guides/GetDocker/DockerEngineCommunity)

### Docker commands

```
$: docker container ls -a - list all containers



$: docker build --tag=Image-Tag Dockerfile-Path - build an image with a tag from a Dockerfile

$: docker run -d -P --name Container-Name Docker-Id/_repository - run without terminal and with port map
  -d: detach container from the terminal
  -P: publish exposed ports to random ports
  --name: give container a name

  -i: interactive
  --rm: remove container after shutdown

$: docker container stop Container-Name - gracefully stop a container

$: docker container rm Container-Name - remove container



$: docker container logs Container-Name - list logs

$: docker container top Container-Name - list running processes



$: docker container exec -it Container-Name _command - browse the container
  -i: interact
  -t: TTY; pretty print



$: docker login - connect to a registry

$: docker tag Image-Tag Docker-Id/_repository:_tag - associate a local image with a repository on a registry

$: docker push Docker-Id/_repository:_tag - upload image to registry



$: docker swarm init - create swarm and add a manager

$: docker swarm join --token Swarm-Join-Token _ip - add a worker

$: docker node ls - list swarm nodes

$: docker stack ls - list stacks

$: docker stack services Stack-Name - list stack services

$: docker stack deploy -c docker-compose.yml Stack-Name - run service stack

$: docker service ps Service-Name - list services
```

### Best practices

```
$: docker system prune [--all]  # deletes cache
```

Keep the Dockerfile code as modular as possible.  

#### Dockerfile

When testing don't be afraid to put each command in its own layer.  
Don't optimize too early! You can always reduce the image size later.  
For production, merge all package update and install layers into one.  

:
```
RUN wget -O - http://example.com/big.tar.xz | tar -xJC /usr/src/things  # download and untar
```

```
RUN chmod +x /path/to/file.ext  # grant permission
```
