## [Reference](https://docs.docker.com/reference/)

### Dockerfile

```
EXEC form over SHELL form

RUN: execute command, create a new layer
CMD: sets default command, can be overridden through CLI
ENTRYPOINT: cannot be overridden

COPY: ADD without the tar and remote URL handling  

ARG: for build-time customization  
ENV: for run-time customization  

ONBUILD: concatenate commands to inheritor image
```

[Reference](FileFormats/DockerfileReference)
