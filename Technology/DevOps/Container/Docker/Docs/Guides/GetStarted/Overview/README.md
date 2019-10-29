## [Get Started: Docker overview](https://docs.docker.com/engine/docker-overview/)

Docker is an open platform for running applications.  
Docker separates applications from infrastructure.  

Containers are loosely isolated environment. They are light because they use the host kernel not a hypervisor.  

Docker Engine has:  
* a server, a daemon process
* REST API
* a Command Line Interface client

### Use cases

* application delivery, CI/CD
* deployment and scaling
* hardware efficiency

### Docker architecture

```
Daemon - builds, runs and distributes Docker containers; manages images, containers, networks, and volumes

Client - talks to the Docker daemon

Registry - stores Docker images; it can be public like Docker Hub or private
```

```
Objects - images, containers, networks, volumes, plugins, and other objects

Image - template for creating a Docker container; build using a Dockerfile
Dockerfile - each instruction is an image layer

Container - instance of an image; you can connect to it or attach storage

Service - scales containers across multiple daemons (a swarm with managers and workers); to a consumer it appears as a single app
```

### Underlying technology

Docker is written in Go.  
Docker uses namespaces, control groups and union file system to create a container format.  
