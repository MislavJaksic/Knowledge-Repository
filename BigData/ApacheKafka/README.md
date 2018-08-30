## [Kafka](https://kafka.apache.org/)

Kafka is a distributed streaming platform. It sends data between programs using a publish-subscribe
mechanism. 

### [Introduction](http://kafka.apache.org/intro)

Kafka is run as a cluster; stores streams of "records" in categories called "topics".

Producer: publish records to topics.
Consumer: subscribe to topics and process streams of records.
Streams: application as a stream processor; take input stream from topic and transform into an output
stream which outputs to a topic.
Connector: connect topics to existing systems.

Topic: category/feed to which records are published; a partitioned log; partition is a sequence of records;
has a retention policy;   

### [Quickstart](http://kafka.apache.org/quickstart)

Both Java needs to be installed and configured.

First, download and install Kafka.

To start Kafka start Zookeeper and Kafka:
> ZooKeeper: bin/zookeeper-server-start.sh config/zookeeper.properties
> Kafka: bin/kafka-server-start.sh config/server.properties

Topics are constructs that abstract data in Kafka.
> List topics: bin/kafka-topics.sh --list --zookeeper localhost:2181
> [script_name] [command] [invoke_zookeeper] [host:port_of_broker]
> Create simple topic: bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test
> [script_name] [command] [invoke_zookeeper] [host:port_of_broker] [replication] [partitioning] [topic_name]

Producers are constructs that send data to a Kafka topic.
> Command line producer: bin/kafka-console-producer.sh --broker-list localhost:9092 --topic test
> [script_name] [command] TODO

Consumers are constructs that read data from a Kakfa topic.
> bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test --from-beginning
> [script_name] [command] [bootstrap_server_to_connect] [topic_name] [begin_reading_from/offset]

Set up broker cluster: TODO;

Kafka Connect is a construct that import and exports data to and from Kafka.
> Import/export connector pair: bin/connect-standalone.sh config/connect-standalone.properties config/connect-file-source.properties config/connect-file-sink.properties
> [script_name] [connect_config] [connector_one_config] [connector_two_config]
> One Connector is reading and the other writing to a file.
> Configuration files deermine how Connectors behave.
Connect to import/export data: import/export data from and to Kafka; runs connectors; 

Process data: TODO

[Useful Kafka operations](http://kafka.apache.org/documentation/#operations) 

### Kafka Consumer

[Kafka consumer configuration](http://kafka.apache.org/documentation/#consumerconfigs)

### [Kafka Connect](http://kafka.apache.org/documentation.html#connect)

bin/connect-standalone.sh config/connect-standalone.properties [connector1.properties] ...

connect-standalone.properties stores worker configuration. Some configs are mandatory.
* bootstrap.servers: list of Kafka brokers (servers)
* key.converter: class converts between Connect format and serialized form that Kafka accepts
* value.converter: class converts between Connect format and serialized form that Kafka accepts

Standalone mode config:
* offset.storage.file.filename: file in which offset is stored

bin/connect-distributed.sh config/connect-distributed.properties
Distributed mode balances workload.
Connector config is done using REST API.
Standalone mode config:
* group.id: cluster name
* config.storage.topic: for storing connector and task config
* offset.storage.topic: for storing offsets
* status.storage.topic: for storing statuses

Connector configurations are key-value pairs.
Common connector options:
* name: connector name
* connector.class: Java class
* tasks.max: max task number
* key.converter: overrides worker converter
* value.converter: overrides worker converter

Each sink connector must set one of these:
* topics: list of topics used
* topics.regex: Java regex of topics

http://kafka.apache.org/documentation.html#connect_transforms

Connectors can transform messages on the fly.
Connector config for transformations:
* transforms: list order of transformation
* transforms.$alias.type: class names for transformations
* transforms.$alias.$transformationSpecificConfig: config for transformations

Example:
```
name=local-file-source
connector.class=FileStreamSource
tasks.max=1
file=test.txt
topic=connect-test
transforms=MakeMap, InsertSource // -> order of transforms
transforms.MakeMap.type=org.apache.kafka.connect.transforms.HoistField$Value // -> transform type
transforms.MakeMap.field=line // -> field name
transforms.InsertSource.type=org.apache.kafka.connect.transforms.InsertField$Value // -> transform type
transforms.InsertSource.static.field=data_source // -> field name
transforms.InsertSource.static.value=test-file-source // -> field value

"foo" becomes {"line":"foo","data_source":"test-file-source"}
"bar" becomes {"line":"bar","data_source":"test-file-source"}
"hello world" becomes {"line":"hello world","data_source":"test-file-source"}
```

... TODO

Creating a Connector:
SourceConnector or SinkConnector.
Implement two interfaces: Connector and Task.
