### [Kafka Connect](http://kafka.apache.org/documentation.html#connect)

Kafka Connectors move data between Kafka and another system.  

Kafka Connect features are:  
* standardized integration  
* distributed mode  
* REST interface  
* offset management  
* streaming integration  

Kafka Connectors can be run in two modes:  
* standalone  
* distributed  

#### Standalone mode

In standalone mode the Connectors is a single process.  

Run a Connector in standalone mode by executing:  
```
$: bin/connect-standalone.sh config/connect-standalone.properties [connector1.properties]..[connectorN.properties]
```
Worker configuration in "_name.properties" defines the behaviour of the Connector.  

General worker configuration:  
* bootstrap.servers - list of Kafka brokers (servers)
* key.converter - transforms message keys; converts between the Connect format and the serialized form that Kafka accepts  
* value.converter - transforms message values; converts between the Connect format and the serialized form that Kafka accepts  

Standalone mode configuration:  
* offset.storage.file.filename - file in which offset is stored  

These parameters need to be set up to three times:
1) for management access
2) for Kafka sink tasks
3) for Kafka source tasks

#### Distributed mode

In distributed mode Kafka balances work and ensures fault tolerance.  

Run a Connector in distributed mode by executing:  
```
$: bin/connect-distributed.sh config/connect-distributed.properties -> configure Connectors using REST API  
```
Offsets, configs and task status are stored in a Kafka topic.  
You should create it manually to ensure proper replication and partition number.  

Distributed mode configuration includes standalone configuration and:
* group.id - default connect-cluster; unique cluster name used when forming Connector clusters
* config.storage.topic - default connect-configs; topic for storing Connector and task configuration
* offset.storage.topic - default connect-offsets; topic for storing offsets
* status.storage.topic - default connect-status; topic for storing statuses

#### Configuring Connectors

Connector configurations are key-value pairs.  
In standalone mode they are defined in a properties file.  
In distributed mode they are defined in a JSON file.  

Common connector options are:  
* name - unique Connector name
* connector.class - Java class for the Connector; example: "org.apache.kafka.connect.file.FileStreamSinkConnector"
* tasks.max - max task number
* key.converter - overrides the default key converter; optional
* value.converter - overrides worker value converter; optional

Sink Connectors must also set one of the following:  
* topics - CSV list of topics used as input for this sink Connector
* topics.regex - Java regex of topics used as input for this sink Connector

#### Transformations

TODO  

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

#### REST API

Kafka Connectors expose a REST API for management and cross cluster communication with other Kafka Connectors.  

REST API server is configured using:  
* listeners - default "localhost:8083"; list of listeners; example: "listeners=http://localhost:8080,https://localhost:8443"

Kafka Connector cross cluster communication configuration:
* rest.advertised.host.name
* rest.advertised.port
* rest.advertised.listener 

REST API endpoints can be seen [here](https://kafka.apache.org/documentation/#connect_rest).


#### Connector Development Guide

Connector types:
* source - import data into Kafka
* sink - export data from Kafka

Connectors are just responsible for breaking up a job into multiple Tasks.  

Task types:
* source
* sink 

Tasks handle input/output streams of records with a schema.  

Streams are sequences of key-value records with IDs and offsets.  

#### Developing a Simple Connector

Kafka comes with a number of [Connector examples](https://github.com/apache/kafka/tree/trunk/connect/file/src).  

TODO

Creating a Connector:  
SourceConnector or SinkConnector.  
Implement two interfaces: Connector and Task.  
