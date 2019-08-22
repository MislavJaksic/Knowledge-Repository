## (Dockerfile reference)[https://docs.docker.com/engine/reference/builder/]





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