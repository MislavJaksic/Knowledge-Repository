## [Best practices for writing Dockerfiles](https://docs.docker.com/develop/develop-images/dockerfile_best-practices/)

Use `.dockerignore` to keep image size and built time to a minimum.  
Use different `docker build` syntax when it is convenient.  
Use multi-stage builds by ordering layers from most frequently used to least frequently used.  
Install only necessary packages.  
Keep containers modular.  
Only RUN, COPY and ADD create persistent layers which increase image size.  
Sort multi-line commands in descending order.  

### Optimize COMMANDS

#### FROM

Use [Alpine](https://hub.docker.com/_/alpine/) as a base image.  

#### LABEL

Apply metadata to images liberally.  

#### RUN

Split long and complex commands with a backslash.  

```
RUN apt-get clean && \
    rm -rf /one/path && \
    rm -rf /two/path
```

##### APT-GET

```
DON'T:
RUN apt-get upgrade
RUN apt-get dist-upgrade

DO:
apt-get install -y foo
```

```
DON'T:
FROM ubuntu:18.04
RUN apt-get update
RUN apt-get install -y curl

DO:
RUN apt-get update && apt-get install -y \
    package-bar \
    package-baz \
    package-foo
```

```
DO:
RUN apt-get update && apt-get install -y \
    aufs-tools \
    automake \
    build-essential \
    curl \
    dpkg-sig \
    libcap-dev \
    libsqlite3-dev \
    mercurial \
    reprepro \
    ruby1.9.1 \
    ruby1.9.1-dev \
    s3cmd=1.1.* && \
    rm -rf /var/lib/apt/lists/*
```

##### Piping

```
DON'T:
RUN wget -O - https://some.site | wc -l > /number

DO:
RUN set -o pipefail && wget -O - https://some.site | wc -l > /number
```

#### CMD

Use exec form.  

#### EXPOSE

Document ports you want to be exposed.  

#### ENV

Use it to set PATH variables, provide required information or set version numbers.  

```
DON'T:
FROM alpine
ENV ADMIN_USER="mark"
RUN echo $ADMIN_USER > ./mark
RUN unset ADMIN_USER
  Result: mark

DO:
FROM alpine
RUN export ADMIN_USER="mark" && \
    echo $ADMIN_USER > ./mark && \
    unset ADMIN_USER
CMD sh
  Result:
```

#### ADD or COPY

Prefer COPY to ADD.  
The best use for ADD is local tar extraction.  
Don't use ADD to get URL resources. Use wget and curl instead.  

```
DON'T:
ADD http://example.com/big.tar.xz /usr/src/things/
RUN tar -xJf /usr/src/things/big.tar.xz -C /usr/src/things
RUN make -C /usr/src/things all

DO:
RUN mkdir -p /usr/src/things && \
    wget -O - http://example.com/big.tar.xz | tar -xJC /usr/src/things && \
    make -C /usr/src/things all
```

#### ENTRYPOINT

To set a command before CMD.  
To execute helper scripts (set env var, create dir, ...).  

```
DO:
COPY ./docker-entrypoint.sh /
ENTRYPOINT ["/docker-entrypoint.sh"]
CMD ["postgres"]
```

#### VOLUME

To expose databases, configuration or files created by a container.  
For any mutable or user-serviceable parts an image.  

#### USER

Set to the least privilege user.  
Don't set it to `sudo`.  

#### WORKDIR

Avoid relative paths.  
Use it to shorten RUN, CMD and ENTRYPOINT paths.  

#### ONBUILD

Executes commands in child images before any of the child's commands.  
Always build images that don't have any ONBUILD commands.  
