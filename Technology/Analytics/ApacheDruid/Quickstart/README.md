## [Single-Server Quickstart](https://druid.apache.org/docs/latest/tutorials/index.html)

### Install

You will need:  
* Java 8 (8u92+) [must be Java 8]  
* Linux, Mac OS X, or other Unix-like OS [Druid cannot be installed on Windows]  

For a single-server micro-quickstart you will need:  
* 4 CPUs  
* 16GB of RAM  

```
$: tar -xzf apache-druid-Druid-Version.tar.gz

$: pwd -> apache-druid-...

$: wget -O - https://archive.apache.org/dist/zookeeper/zookeeper-Zookeeper-Version/zookeeper-Zookeeper-Version.tar.gz | tar -xJC /path/to/druid/zk
```

### Start Druid

```
$: bin/start-micro-quickstart
# Note: visit http://localhost:8888  
```

Cluster metadata and segments are at: /path/to/druid/var  
Logs are at: /path/to/druid/var/sv

### [Loading a file](https://druid.apache.org/docs/latest/tutorials/tutorial-batch.html)

Demonstrates how to batch load a file.  

```
# Note: visit localhost:8888  
Load data -> Local disk -> Firehose type: local                               -> Preview ->
                        -> Base directory: quickstart/tutorial/
                        -> File filter: wikiticker-2015-09-12-sampled.json.gz

-> Next: Parse data -> Parser to use: json ->
                    -> Flatten?: no

-> Next: Parse time -> Column/Constant? -> Next: Transform -> Next: Filter ->

-> Next: Configure schema -> Specify dimension?: yes ->
                          -> Rollup?: no

-> Next: Partition -> Next: Tune -> Next: Publish -> Name: wikipedia -> Submit
```
Refresh Tasks until you see a green light.  
Refresh data sources until you see a green light.  

```
Query -> SELECT * FROM "wikipedia"
```

### [Load streaming data from Kafka](https://druid.apache.org/docs/latest/tutorials/tutorial-kafka.html)

### [Querying data](https://druid.apache.org/docs/latest/tutorials/tutorial-query.html)

```
SELECT page, COUNT(*) AS Edits
FROM wikipedia
WHERE "__time" BETWEEN TIMESTAMP '2015-09-12 00:00:00' AND TIMESTAMP '2015-09-13 00:00:00'
GROUP BY page ORDER BY Edits DESC
LIMIT 10
```
Query via the console, via dsql or over HTTP.  

### [Roll-up](https://druid.apache.org/docs/latest/tutorials/tutorial-rollup.html)

A way to summarize data.  

### [Updating existing data](https://druid.apache.org/docs/latest/tutorials/tutorial-update-data.html)

Using dsql.  

### [Writing an ingestion spec](https://druid.apache.org/docs/latest/tutorials/tutorial-ingestion-spec.html)

How to ingest custom data.  

### [Transforming input data](https://druid.apache.org/docs/latest/tutorials/tutorial-transform-spec.html)

How to filter and transform during ingestion.  
