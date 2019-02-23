### [Kafka Connect](http://kafka.apache.org/documentation.html#connect)

Kafka Connectors can be run in standalone mode by executing:  
```
bin/connect-standalone.sh config/connect-standalone.properties [connector1.properties]..[connectorN.properties]
```
Configuration files define the Connector's behaviour.  

Kafka Connect features include:
* standardized integration
* distributed mode
* REST interface
* offset management
* streaming integration

TODO  

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
TODO  

Creating a Connector:  
SourceConnector or SinkConnector.  
Implement two interfaces: Connector and Task.  
