## [Docker](https://www.jenkins.io/doc/book/installing/docker/)

Install [Docker](../../../../../Container/Docker).

TODO

### Jenkins in Docker

```
$: docker pull jenkinsci/blueocean
```

#### MacOS and Linux

```
$: docker run -u root --rm -d -p 8080:8080 -p 50000:50000 -v jenkins-data:/var/jenkins_home -v /var/run/docker.sock:/var/run/docker.sock --name jenkins-blueocean jenkinsci/blueocean
  # -u user
  # --rm delete container after shut down
  # -d detach container
  # -p maps ports
  # -v maps volumes
  # --name names the container
```

#### Windows

TODO

#### Accessing Jenkins

```
$: docker exec -it jenkins-blueocean bash
$: docker logs jenkins-blueocean
```

### Post-installation setup wizard

Unlock Jenkins by copy-pasting the output:
```
$: docker exec -it jenkins-blueocean cat /var/jenkins_home/secrets/initialAdminPassword  #-> odvxxfn2pheystwsp4qb0d2d26cc7017
```

Install Jenkins plugins.  

Create an Admin user.  

Set the Jenkins URL.  
