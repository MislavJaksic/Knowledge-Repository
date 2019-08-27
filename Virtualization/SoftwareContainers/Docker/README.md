## [Docker](https://www.docker.com/resources/what-container)

Docker is a containerization program.

### [Install Docker](https://docs.docker.com/install/)

#### Ubuntu Linux

```
$: sudo apt-get update
$: sudo apt-get install apt-transport-https ca-certificates curl software-properties-common
$: curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
$: sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable"
```

```
$: sudo apt-get update
$: sudo apt-get install docker-ce
$: sudo docker run hello-world
```

#### [Post-installation for Linux](https://docs.docker.com/install/linux/linux-postinstall/)

Non-root users will have to prefix every command with "sudo". Avoid it with:
```
$: sudo groupadd docker
$: sudo usermod -aG docker $USER
-> RESTART VM/Linux
$: docker run hello-world
```

### [Docker Hub](https://hub.docker.com/)

Docker images can be browsed, download from and uploaded to the Hub.  
[Sample images](https://docs.docker.com/samples/):  
```
alpine - tiny OS
ubuntu - OS
centos - OS
baseimage - "fixed" Ubuntu

ibmjava - tiny Java
openjdk - preinstalled Java
openliberty - Java for microservices

rabbitmq - messaging broker
flink - stream and batch processor
storm - realtime computation system
zookeeper - distributed coordinator

httpd - Apache HTTP server
nginx - server
rapidoid - server for Java
tomcat - Java server

aerospike - flash and RAM database
arangodb - flexible model database
couchbase - NoSQL database
crate - SQL database
influxdb - time series database
mongo - document database
mysql - relational database
neo4j - graph database
orientdb - graph NoSQL database
postgres - relational database
rethinkdb - document database

memcached - object caching system
redis - key-value store

mediawiki - wiki
xwiki - wiki

consul - data center runtime
elasticsearch - search and analytics engine
kapacitor - time series processing, monitoring, and alerting
kibana - visualize ElasticSearch
odoo - open source ERP
rocker.chat - open source chat solution
```
There are many more official images on Docker Hub.  

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

### Best practice

#### System

Prune Docker from time to time.  

Keep the code as modular as possible.  

#### Dockerfile

When testing don't be afraid to put each command in its own layer.  
Don't optimize too early! You can always reduce the image size later.  
For production, merge all package update and install layers into one.  

Download and untar:
```
RUN wget -O - http://example.com/big.tar.xz | tar -xJC /usr/src/things
```

Avoid permission denied:
```
RUN chmod +x /path/to/file.ext
```


