## [Kafka](https://kafka.apache.org/)

Kafka is a distributed streaming platform. It brokers data between programs using a publish-subscribe mechanism. 

### [Introduction](http://kafka.apache.org/intro)

Kafka is run as a cluster; stores streams of "records" in categories called "topics".

Producer: publish records to topics.  
Consumer: subscribe to topics and process streams of records.  
Streams: application as a stream processor; take the input stream from a topic and transform it into an output stream which outputs to a topic.  
Connector: connect topics to existing systems.  

Topic: category/feed to which records are published; has a partitioned log.  
Each partition in a log is ordered and immutable sequence of records. Partitions may be scattered over many nodes. Each record has an offset. The Kafka cluster controls when to delete the records using a retention policy.  

### [Quickstart](http://kafka.apache.org/quickstart)

#### Step 1

Java needs to be installed and configured.

First, download and install Kafka using a binary.
```
tar -xzf kafka_x.x-x.x.x.tgz
```

#### Step 2

To start Kafka, first start Zookeeper:  
```
$: bin/zookeeper-server-start.sh config/zookeeper.properties -> start Zookeeper
$: bin/kafka-server-start.sh config/server.properties -> start Kafka
```

#### Step 3

Topics are constructs that abstract data in Kafka.  
```
$: bin/kafka-topics.sh --list --zookeeper localhost:2181 -> list topics
[script_name] [command] [invoke_zookeeper] [host:port_of_broker]
$: bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test_topic -> create topic
[script_name] [command] [invoke_zookeeper] [host:port_of_broker] [replication] [partitioning] [topic_name]
```

#### Step 4

Producers are constructs that send data to a Kafka topic.
```
$: bin/kafka-console-producer.sh --broker-list localhost:9092 --topic test_topic -> command line producer
[script_name] [command] TODO
```

#### Step 5

Consumers are constructs that read data from a Kafka topic.
```
$: bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test_topic --from-beginning -> command line consumer
[script_name] [command] [bootstrap_server_to_connect] [topic_name] [begin_reading_from/offset]
```

#### Step 6

Kafka cluster can be made of only one node.  
To create a multi broker/node cluster start multiple Kafka instances.  

All Kafka instances must have different broker IDs and ports:  
```
$: cp config/server.properties config/server-1.properties
$: nano config/server-1.properties -> change "broker.id", "listeners", "log.dirs"

$: cp config/server.properties config/server-2.properties
$: nano config/server-2.properties -> change "broker.id", "listeners", "log.dirs"
```

Run Zookeeper and three Kafka brokers/nodes:  
```
$: bin/zookeeper-server-start.sh config/zookeeper.properties &
$: bin/kafka-server-start.sh config/server.properties &
$: bin/kafka-server-start.sh config/server-1.properties &
$: bin/kafka-server-start.sh config/server-2.properties &

$: ps -> PIDs
$: kill PID -> close program
```

Create a topic in a cluster:
```
$: bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 3 --partitions 1 --topic replicated_test -> create replicated topic
$: bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 3 --topic partitioned_test -> create partitioned topic
```

Inspect the topics:  
```
$: bin/kafka-topics.sh --describe --zookeeper localhost:2181 --topic replicated_test
  -> Topic:my-replicated-topic   PartitionCount:1    ReplicationFactor:3 Configs:
      -> Topic: replicated_test  Partition: 0    Leader: _leader_number   Replicas: 1,2,0 Isr: 1,2,0

$: bin/kafka-topics.sh --describe --zookeeper localhost:2181 --topic partitioned_test
  -> -
    -> -
```

You can try and kill the leader and then inspect the topics again to see what happened.  
```
$: ps -> PIDs
$: ps aux | grep server-_leader_number.properties -> find the _leader_number by inspecting the topic  
$: kill PID -> close program
```

#### Step 7

Use Kafka Connect instead of custome integration code.  
Kafka Connect is a construct that imports and exports data to and from Kafka.  

Start Connect in standalone mode, a local dedicated process:  
```
$: bin/connect-standalone.sh config/connect-standalone.properties config/connect-file-source.properties config/connect-file-sink.properties -> file reader/writer Connector pair  
[script_name] [connect_config] [connector_one_config] [connector_two_config]
```
Configuration files define the Connector's behaviour.  
The first Connector is a "source" and the second Connector is a "sink".  đ

The Connectors will continuously process data as you append data to the file.  

#### Step 8

Kafka Streams is a client library for building real time projects.  
It combines Java/Scala client side deployment and Kafka's server side cluster technology.  

### [Kafka in Production](http://kafka.apache.org/documentation/#operations) 

#### [Kafka Operations](http://kafka.apache.org/documentation/#basic_ops)

Adding, removing, modifying topics.  
Graceful shutdown.  
Balancing leadership.  
Balancing replicas.  
Data mirroring between clusters.  
Checking consumer positions.  
Managing consumer groups.  
Cluster expansion.  
Automatic data migration.  
Decommissioning brokers.  
Increasing replicas factor.  
Setting quotas.  

TODO  

#### [Datacenters](http://kafka.apache.org/documentation/#datacenters)

Questions regarding multiple datacenters.  

TODO  

#### [Kafka Configuration](http://kafka.apache.org/documentation/#config)

Kafka has a lot of different [configuration settings](http://kafka.apache.org/documentation/#configuration).  

See a sample production server configuration.  

### Nomenclature

Cluster - a group of Kafka instances/nodes/servers  
Broker - a deamon in charge of a node/server  
Node - a topic partition store in a cluster overseen by a broker  
Topic - a category/feed to which records are published  
Partition - a partitioned log owned by a topic  
Replica - a copy of the cluster leader node  
Consumer - an application, a program which reads data to a topic  
Producer - an application, a program which publishes data to a topic  
Stream - an application, a program which reads data, transforms data and publishes the same to another topic  
