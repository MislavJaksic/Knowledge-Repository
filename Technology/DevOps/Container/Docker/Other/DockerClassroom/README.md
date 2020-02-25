## [Play with Docker Classroom](https://training.play-with-docker.com/)

### [Docker for developers](https://training.play-with-docker.com/dev-stage1/)

#### Beginner Linux

Docker container != Docker image.  
A Docker image is a template for container construction.

Docker containers can be used in different ways:
* to execute a single task
* to interact with
* to create a long running job

Linux containers run on Linux hosts and Windows containers run on Windows hosts.

Example Dockerfile:
```
FROM nginx:latest  # specify base image

COPY index.html /usr/share/nginx/html # transfer file from where the Dockerfile is located into the image
COPY linux.png /usr/share/nginx/html

EXPOSE 80 443  # document ports to be published with -p

CMD ["nginx", "-g", "daemon off;"]  # specify command and arguments for a command that will be run after the container is started
```

If you want to make changes to the files in the container, you don't have to stop it. You can use bind mount.
Bind mount will push changes from a host file to a file located in the container.

#### Swarm stack intro

A stack is a group of services deployed together.
