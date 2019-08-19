## [Get started](https://docs.docker.com/get-started/)

### 1: Orientation

```
Linux containers - process virtualization; based on namespace and cgroup subsystems; processes think they have the whole Linux kernel for themselves and yet they share it with other such processes
Containerization - use of Linux containers to deploy applications
Image - an executable package
Container - a runtime instance of an image; thinks they have the whole kernel for themselves
```

```
$: docker version - version
$: docker info - installation details

$: docker container ls --all - list containers
$: docker ps - list running containers

$: docker image ls --all - list images

$: docker run hello-world - run test image
$: docker run Image-Name - run image
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
FROM - parent image

WORKDIR _path - set the working directory

COPY From-Path-Outside To-Path-Inside - copy contents

RUN _command - execute command (in shell form); creates a new layer/image

EXPOSE _port - expose port outside the container

ENV NAME Env-Var-Name - define environment variable

# Run app.py when the container launches
CMD ["python", "app.py"]

```

#### Build the image

```
$: docker build --tag=_tag Dockerfile-Directory - build an image with a tag from a Dockerfile
```

#### Run the image

```
$: docker run -p Outside-Port:Image-Port _tag - run image and map ports

$: docker run -d -p Outside-Port:Image-Port _tag - run in the background, detached mode
$: docker container stop Container-Id - "SIGTERM"
$: docker container kill Container-Id - "SIGKILL"
```

#### Share the image

Registry is a collection of repositories.  
Repository is a collection of images.  

```
$: docker login - connect to a registry

$: docker tag _image Docker-Id/_repository:_tag - associate a local image with a repository on a registry
$: docker push Docker-Id/_repository:_tag - upload image to registry

$: docker run -p Outside-Port:Image-Port Docker-Id/_repository:_tag - run remote image from a registry
```

#### Additional commands

```
$: docker container rm Container-Id - remove container
$: docker container rm $(docker container ls -a -q) - remove all containers

$: docker image rm _image - remove image
$: docker image rm $(docker image ls -a -q) - remove all images
```

### 3: Services

Service is part of a distributed application. It is a container "in production".  

#### docker-compose.yml












#### Extra credit (Dockerfile)

RUN vs CMD vs ENTRYPOINT

Shell form:  
```
_instruction _command

RUN apt-get install python3
CMD echo "Hello world"
ENTRYPOINT echo "Hello world"
```
Executes /bin/sh -c _command under the hood.  
Shell form is a subset of exec form.  

Exec form:
```
_instruction> ["_executable", "_param1", "_param2", ...]

RUN ["apt-get", "install", "python3"]
CMD ["/bin/echo", "Hello world"]
ENTRYPOINT ["/bin/echo", "Hello world"]
```
There is no shell processing as the executable is called directly.  
Exec form is a superset of shell form.  

Docker image layer
Almost every line in Dockerfile adds a new layer to the image and creates an intermediate image.  
When image layers overlap, they are built only once.  

RUN
Execute a command and create a new layer on top of the current image. Used to install applications and packages.  
If you want to chain commands into a single layer use &&.

CMD
Set the default command. It will be run only if you don't specify a CLI argument when running the container.  

ENTRYPOINT
Like CMD, but its arguments cannot be overwritten. Prefer ENTRYPOINT over CMD when building an executable image.  




