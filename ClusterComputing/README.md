## Apache Spark

Apache Spark allows a computation to be performed across many different computers at the same time. It
abstracts a dataset by creating a Resilient Distributed Dataset (RDD) and allows the user to apply functions
and transformations to it. It also abstracts the computer cluster through the Spark Context.

### Spark Streaming

https://spark.apache.org/docs/latest/streaming-programming-guide.html

You can ingest data from Kafka, Flume, Kinesis or TCP sockets. Outputs to filesystems, databases or dashboards.
DStream (Discretised Stream) represents a stream of data. Is is a sequence of RDDs (Resilient Distributed
Dataset). You can change and transform it.

#### SparkConf

https://spark.apache.org/docs/latest/api/java/index.html?org/apache/spark/SparkConf.html

SparkConf is a configuration object for Spark.
* .setAppName specifies a name of the application.
* .setMaster specify if you want to run on a cluster ("spark://master:7077") or locally with "N" cores ("local[2]"). N should always be greater then the number of Receivers. For real applications, you want to pass it as a parameter via "spark-submit" command.

#### StreamingContext

https://spark.apache.org/docs/latest/api/java/index.html?org/apache/spark/streaming/api/java/JavaStreamingContext.html

(Java)StreamingContext is the many entry point into Spark Streaming; created with the SparkConf and batch Duration.
Then, you will need to do the following:
* define the input source
* set computations and transformations to be performed
* start receiving data with streaming_context.start()
* stop manually or when an error occurs with streaming_context.awaitTermination()
* or stop manually with streaming_context.stop()
* .stop() will stop both the streaming and spark contexts

#### DStream creation

https://spark.apache.org/docs/latest/streaming-programming-guide.html#transformations-on-dstreams

DStream abstracts data, RDDs. Each one has a Receiver. Can be basic or advanced.
Basic sources are files and TCP sockets. TODO
Advanced are Kafka, Flume and Kinesis.

#### DStream transformations

DStream transformations can create a new DStream or change an existing one.

### From Kafka to Spark

https://spark.apache.org/docs/latest/streaming-kafka-0-10-integration.html
Maven dependency:

<dependency>
  <groupId>org.apache.spark</groupId>
  <artifactId>spark-streaming-kafka-0-10_2.11</artifactId>
  <version>2.3.1</version>
</dependency>

Create kafka config; create kafka topics; create DStream.

Use default LocationStrategies (LocationStrategies.PreferConsistent()) and subscribe to a static number of topics (ConsumerStrategies.<...>Subscribe(topics, kafkaParams))).

Creating an RDD; Obtaining Offsets; ... TODO