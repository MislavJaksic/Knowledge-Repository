## [Apache Spark](https://spark.apache.org/docs/latest/index.html)

Apache Spark performs computations in a computer cluster. It has a rich API including Spark SQL, MLlib,
GraphX and Spark Streaming.

TODO

### [Quick start](https://spark.apache.org/docs/latest/quick-start.html)

#### Interactive Analysis with the Spark Shell

#### Self-Contained Applications

Simple Maven application:
```
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.Dataset;

public class SimpleApp {
  public static void main(String[] args) {
    String file = "_some_file.md"; // Should be some file on your system
    SparkSession spark = SparkSession.builder().appName("Simple Application").getOrCreate();
    Dataset<String> file_data = spark.read().textFile(file).cache(); //load data

    long numAs = file_data.filter(s -> s.contains("a")).count(); //filter with predicate function then count
    long numBs = file_data.filter(s -> s.contains("b")).count();

    spark.stop();
  }
}
// you also need to set Maven dependencies: spark-sql_VERSION
```

Package it using Maven (mvn package) and then execute the program using:
```
/path/to/spark/bin/spark-submit --class "SimpleApp" --master local[4] target/simple-project-1.0.jar
```

### [RDD Programming Guide](https://spark.apache.org/docs/latest/rdd-programming-guide.html)

RDD (Resilient Distributed Datasets) are data that can be operated on in parallel. They can be created in
diferent ways.
* .parallelize(_collection)
* or from an external data source

RDD operations are divided based on how they act:  
transformations are lazy and are stored instead on being computed right away,  
actions cause all transformations to be executed and then they return values.  

You can often pass a function to Spark using lambda expressions or inner classes that implement the Function
interface.

[Local vs cluster mode](https://spark.apache.org/docs/latest/rdd-programming-guide.html#local-vs-cluster-modes) is a cautionary tale of what happens when you try to execute a local function where
the normal rules of closure apply in a distributed environment which has its own rules.

Some RDD operations can only be performed on datasets that are made of key-value pairs.

The list of transformations is quite big, but some of the most commo nones are:
* map - pass each element through a function
* filter - return only those elements that satisfy a boolean function
* flatMap - pass each element through a function and return anywhere from 0-n elements
* mapPartitions - pass each RDD partition (block) through a function ([can reduce overhead](https://stackoverflow.com/questions/33655920/when-to-use-mapparitions-and-mappartitionswithindex))
* mapPartitionsWithIndex - pass each RDD partition (block) through a function where each partition will have an index

* sample - return a random data sample

* union - return a union of two datasets
* intersection - return an intersection of two datasets
* distinct - return a dataset without any duplicates

* groupByKey - when given (K, V) pairs return (K, Iterable<V>) pairs
* reduceByKey -
* aggreateByKey
* sortByKey
* join
* cogroup
* cartesian
* pipe
* coalesce
* repartition
* repartitionAndSortWithinPartition

### [Spark Streaming](https://spark.apache.org/docs/latest/streaming-programming-guide.html)

You can ingest data from Kafka, Flume, Kinesis or TCP sockets. Outputs to filesystems, databases or dashboards.
DStream (Discretised Stream) represents a stream of data. Is is a sequence of RDDs (Resilient Distributed
Dataset). You can change and transform it.

#### [SparkConf](https://spark.apache.org/docs/latest/api/java/index.html?org/apache/spark/SparkConf.html)

SparkConf is a configuration object for Spark.
* .setAppName specifies a name of the application.
* .setMaster specify if you want to run on a cluster ("spark://master:7077") or locally with "N" cores ("local[2]"). N should always be greater then the number of Receivers. For real applications, you want to pass it as a parameter via "spark-submit" command.

#### [StreamingContext](https://spark.apache.org/docs/latest/api/java/index.html?org/apache/spark/streaming/api/java/JavaStreamingContext.html)

(Java)StreamingContext is the many entry point into Spark Streaming; created with the SparkConf and batch Duration.  
Then, you will need to do the following:  
* define the input source
* set computations and transformations to be performed
* start receiving data with streaming_context.start()
* stop manually or when an error occurs with streaming_context.awaitTermination()
* or stop manually with streaming_context.stop()
* .stop() will stop both the streaming and spark contexts

#### [DStream creation](https://spark.apache.org/docs/latest/streaming-programming-guide.html#transformations-on-dstreams)

DStream abstracts data, RDDs. Each one has a Receiver. Can be basic or advanced.  
Basic sources are files and TCP sockets. TODO  
Advanced are Kafka, Flume and Kinesis.  

#### DStream transformations

DStream transformations can create a new DStream or change an existing one.

### [Kafka and Spark](https://spark.apache.org/docs/latest/streaming-kafka-integration.html)

Maven dependency:
```
<dependency>
    <groupId>org.apache.spark</groupId>
    <artifactId>spark-streaming-kafka-0-10_2.11</artifactId>
    <version>2.3.1</version>
</dependency>
```

Create Kafka config; create Kafka topics; create DStream.

Use default LocationStrategies (LocationStrategies.PreferConsistent()) and subscribe to a static number of topics (ConsumerStrategies.<...>Subscribe(topics, kafkaParams))).

Creating an RDD; Obtaining Offsets; ... TODO

### [Spark SQL, DataFrames and Datasets Guide](https://spark.apache.org/docs/latest/sql-programming-guide.html)

Spark SQL is a more advanced API then Spark RDD. Most often it is used to execute SQL queries.  
Spark SQL interacts well with Apache Hive, a database built on top of Hadoop which has a Hive Metastore.  

Spark SQL produces either Dataset or DataFrame using command line, JDBC or ODBC.

Dataset is a distributed collection. They can be manipulated using transformations (map, filter, ...). Database API is available for Java/Scala and python does not need it.  
DataFrame is a Dataset, but organised into named columns.   

First, create a SparkSession. (Note: Spark 2.0 supports Hive features even without you having to setup Hive)  
There are many ways in which DataFrames can be created:  
```
spark_session.read().json(...);
spark_session.sql(...);
```

The following are just some of the DataFrame operations:
```
data_frame.select("name"); //-> select only the "name" column
data_frame.select(col("name"), col("age").plus(1)); //-> select name and age, but increment age by 1
data_frame.filter(col("age").gt(21)); //-> select people older then 21
data_frame.groupBy("age").count(); //-> count people by age
```
[DataSet Javadoc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/sql/Dataset.html)  
[DataFrame Function Javadoc](https://spark.apache.org/docs/latest/api/java/org/apache/spark/sql/functions.html)  

Run SQL queries with:
```
spark_session.sql("SELECT * FROM _table LIMIT 10");
```

TODO... https://spark.apache.org/docs/latest/sql-programming-guide.html#global-temporary-view

#### Hive as a data source

Hive-Spark dependencies:
```
<dependency>
    <groupId>org.apache.spark</groupId>
    <artifactId>spark-core_VERSION</artifactId>
    <version>SPARK_VERSION</version>
</dependency>
<dependency>
    <groupId>org.apache.spark</groupId>
    <artifactId>spark-sql_VERSION</artifactId>
    <version>SPARK_VERSION</version>
</dependency>
<dependency>
    <groupId>org.apache.spark</groupId>
    <artifactId>spark-hive_VERSION</artifactId>
    <version>SPARK_VERSION</version>
</dependency>
<dependency> <!-- Optional -->
    <groupId>org.antlr</groupId>
    <artifactId>antlr4-runtime</artifactId>
    <version>VERSION</version>
</dependency>
<dependency> <!-- Optional -->
    <groupId>net.jpountz.lz4</groupId>
    <artifactId>lz4</artifactId>
    <version>VERSION</version>
</dependency>
```
Find out which version Hive and Spark are using with "find / -iname...".

Create a SparkSession; set .master().config("spark.sql.warehouse.dir", _value).config("hive.metastore.uris", _value).enableHiveSupport().

#### [Hive as a data sink](http://spark.apache.org/docs/latest/sql-programming-guide.html#saving-to-persistent-tables)
