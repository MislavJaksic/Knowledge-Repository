## Apache Spark

Apache Spark allows a computation to be performed across many different computers at the same time. It
abstracts a dataset by creating a Resilient Distributed Dataset (RDD) and allows the user to apply functions
and transformations on it. It also abstract the computer cluster through the Spark Context.

### Spark Streaming

https://spark.apache.org/docs/latest/streaming-programming-guide.html

Ingest data from Kafka, Flume, Kinesis or TCP sockets. Outputs to filesystems, databases or dashboards.
DStream or discretized stream represents a stream of data. Is is a sequence of RDDs (Resilient Distributed Dataset).

StreamingContext TODO

### From Kafka to Spark

https://spark.apache.org/docs/latest/streaming-kafka-0-10-integration.html
Maven dependency:

<dependency>
  <groupId>org.apache.spark</groupId>
  <artifactId>spark-streaming-kafka-0-10_2.11</artifactId>
  <version>2.3.1</version>
</dependency>

Create kafka config; create kafka topics; create DStream.