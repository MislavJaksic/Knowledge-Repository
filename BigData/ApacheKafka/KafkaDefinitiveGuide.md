## Kafka Definitive Guide

Kafka Definitive Guide in a book written by Narkhede, Shapira and Palino.

### Meet Kafka

A system of transferring data between applications.

Publish/subscribe messaging system, a distributed streaming tool.  
Message is a unit of data (a row or record in a database).  
Messages can have keys. Keys control message partitioning.  
Batch is a collection of messages.  

Schema is a structure to which all messages have to adhere. Apache Avro, JSON, XML or other.

Topics are categories (database tables or folders). Topics are broken down into partitions.  
Partitions are commit logs, ordered, append-only data structures.  
Stream is a single topic, regardless how many partitions it has, moving data from a producer to a consumer
in real time.  

Producer creates new messages to a topic.  
Consumer reads messages by subscribing to topics. Consumers are part of a consumer group.  

Broker is a Kafka server. Broker receives messages and grants them to consumers.  
Cluster is a group of brokers. One broker is the cluster controller.  
Partitions are owned by a single broker, called a leader of a partition. It provides redundancy.  
Retention is how long data is going to be kept in a topic or how big the topic can get or what key it has
according to log compaction.  

Multiple clusters are required for large scale projects.

Why use Kafka?  
Multiple producers.  
Multiple consumers.  
Hard disk retention policy.  
Scalable.  
Performance.  

Use cases:  
Activity tracking:  
Messaging:  
Metrics and logging:  
Commit log:  
Stream processing:  


### Installing Kafka

TODO

### Kafka Producers: Writing Messages to Kafka

Producers write to Kafka, Consumers read from Kafka and applications do both.  
Producer mandatory properties:  
* bootstrap.server: host:port pairs of brokers with which the producer will try to establish a connection.
* key.serializer: class that will serialize keys; may need to implement your own.
* value.serializer: class that will serialize values.

TODO

### Building Data Pipelines

TODO

Use producer-consumer when you can modify an application. Use Connect when you cannot (such as when using a
database you didn't construct).

Connect moves data between Kafka and other data stores.

TODO
