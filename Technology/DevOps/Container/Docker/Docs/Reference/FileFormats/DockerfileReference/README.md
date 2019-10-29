## [Dockerfile reference](https://docs.docker.com/engine/reference/builder/)

### Usage

Dockerfile contains all the commands to assemble an image.  
Build an image from a Dockerfile and a context:
```
$: docker build . - recursively send the context to Docker daemon
```
Each instruction builds an intermediate image layer.
Every instruction is independent.  

### Format

```
# - Dockerfile comment
Must begin with FROM and can be preceded by ARG.
Has directives.
```

### Parser directives

```
syntax - enabled if Buildkit is used
escape - set escape character
```

### Environment replacement

```
$Var-Name OR ${Var-Name} - var replacement syntax

${Var-Name:-Var-Value} - if Var-Name is not set then Var-Value will because the result
${Var-Name:+Var-Value} - if Var-Name is set then Var-Value will because the result, otherwise it will be an empty string
```

```
FROM busybox
ENV foo /bar
WORKDIR ${foo}   # WORKDIR /bar
ADD . $foo       # ADD . /bar
COPY \$foo /quux # COPY $foo /quux
```

### .dockerignore file

```
.dockerignore - exclude files from build context
```

### FROM

```
FROM Image-Name[:Image-Tag] [AS Substitute-Name] - set base image
```

### RUN

```
RUN ["_executable", "_param1", "_param2"] - create a new layer and execute the command
```
Like CMD and ENTRYPOINT.  

### CMD

```
CMD ["_executable","_param1","_param2"] - set default executable command
```
Like RUN and ENTRYPOINT.  

### LABEL

```
LABEL _key1=_value1 _key2=_value2 - add image metadata

$: docker inspect Image-Name - list labels
```

### EXPOSE

```
EXPOSE _port [_port/_protocol] - documents that a port should be published; DOES NOT PUBLISH A PORT

$: docker run -P Docker-Id/_repository - publish all ports and run the container
```

### ENV

```
ENV _key1=_value1 _key2=_value2 - set key to value for all following build stage instructions and all resulting containers
```
Like ARG, but for run-time.  

```
ENV myName="John Doe" myDog=Rex\ The\ Dog \
    myCat=fluffy
```

### ADD

```
ADD ["Source-Path1","Source-Path2","Destination-Path"] - copy a file, directory or URL to destination
```
Like COPY but with tar and URL handling.  

### COPY

```
COPY ["Source-Path1","Source-Path2","Destination-Path"] - copy a file or directory to destination
```
Like ADD but without tar and URL handling.  

### ENTRYPOINT

```
ENTRYPOINT ["_executable","_param1","_param2"] - set a command that must be executed
```
Like RUN and CMD.  

### VOLUME

```
VOLUME ["/Mount-Point-Name"] - create mount point and mark it as holding externally mounted volumes from native host or other containers
```

### USER

```
USER _user>[:_group] OR USER _uid[:_gid] - set username and usergroup for RUN, CMD and ENTRYPOINT
```

### WORKDIR

```
WORKDIR /path/to/workdir - set absolute working directory
WORKDIR add/relative - set relative working directory
```

### ARG

```
ARG Var-Name[=Default-Value] - define variable to be passed at build-time

$: docker build --build-args Var-Name=_value ... - NOT FOR PASSING IN SECRETS
```
Like ENV, but for build-time.  

Predefined ARGs:
```
HTTP_PROXY
HTTPS_PROXY
FTP_PROXY
NO_PROXY
```

### ONBUILD

```
ONBUILD [_instruction] - add any build instruction as trigger instruction
```
Triggered when used as a base image for another image.  
If you need access to apps source code.  
Cannot be inherited by grand-children.  

```
FROM alpine

ONBUILD ADD . /app/src
ONBUILD RUN /usr/local/bin/python-build --dir /app/src

++

FROM base-image

CMD ["run.py"]

==

FROM alpine

ADD . /app/src
RUN /usr/local/bin/python-build --dir /app/src

CMD ["run.py"]
```

### STOPSIGNAL

```
STOPSIGNAL signal - set which signal will be sent to the container to exit
```

### HEALTHCHECK

```
HEALTHCHECK [OPTIONS] CMD _command - set how to test that the container is still working

OPTIONS:
  --interval=DURATION (default: 30s)
  --timeout=DURATION (default: 30s)
  --start-period=DURATION (default: 0s)
  --retries=N (default: 3)
```
Add healthy and unhealthy states.  
Prevents infinite loops and similar process level problems.  

```
HEALTHCHECK --interval=5m --timeout=3s CMD curl -f http://localhost/ || exit 1
```

### SHELL

```
SHELL ["_executable", "param1", "_param2"]
```
Useful on Windows.  



### Extra credit

#### RUN vs CMD vs ENTRYPOINT

##### Shell form

```
_instruction _command

RUN apt-get install python3
CMD echo "Hello world"
ENTRYPOINT echo "Hello world"
```
Executes "/bin/sh -c _command" under the hood.  
Shell form is a subset of exec form.  

##### Exec form

```
_instruction ["_executable", "_param1", "_param2", ...]

RUN ["apt-get", "install", "python3"]
CMD ["/bin/echo", "Hello world"]
ENTRYPOINT ["/bin/echo", "Hello world"]
```
There is no shell processing as the executable is called directly.  
Exec form is a superset of shell form.  

##### Layers

Almost every line in Dockerfile adds a new layer to the image and creates an intermediate image.  
Image layers are built once and then cached.  

##### RUN

Execute a command and create a new layer on top of the current image. Used to install applications and packages.  
If you want to chain commands into a single layer use &&.

##### CMD

Set the default executable command. It will be run only if you don't specify a CLI argument when running the container.  

##### ENTRYPOINT

Like CMD, but its arguments cannot be overwritten. Prefer ENTRYPOINT over CMD when building an executable image.  



#### ADD vs COPY

```
COPY is same as ADD but without the tar and remote url handling.
```

Source: [code comment](https://github.com/moby/moby/blob/670c8696a29825b23208496bd4d8e88b5faa7773/builder/dispatchers.go#L77)



#### ARG vs ENV

##### ARG

For build-time customization.  

##### ENV

For run-time customization.  

Source: [blog guide](https://vsupalov.com/docker-arg-env-variable-guide/)
