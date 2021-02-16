## [Apache Hive](https://hive.apache.org/)

Apache Hive is a data warehouse built on top of Apache Hadoop.

### [Installation](https://cwiki.apache.org/confluence/display/Hive/AdminManual+Installation)

You will need:
* Java
* Hadoop

```
# Note: download Hive
$: tar -xzvf hive-x.y.z.tar.gz
```

```
# Note: add to `.bashrc`
export HIVE_HOME=/path/to/hive
export PATH=$HIVE_HOME/bin:$PATH

HADOOP_HOME=/path/to/hadoop
```

```
# Note: start Hadoop and YARN
$: start-dfs.sh
$: start-yarn.sh
```

```
$: $HADOOP_HOME/bin/hadoop fs -mkdir       /tmp
$: $HADOOP_HOME/bin/hadoop fs -mkdir       /user/hive/warehouse # Note: if you cannot create a folder it means you didn't construct the parent folder

$: $HADOOP_HOME/bin/hadoop fs -chmod g+w   /tmp
$: $HADOOP_HOME/bin/hadoop fs -chmod g+w   /user/hive/warehouse

$: $HADOOP_HOME/bin/hadoop fs -ls /  # browse the HDFS
$: $HIVE_HOME/bin/hive  # test if it works
```

Use Beeline and HiveServer2 CLI.  
[Settings up Beeline and HiveServer2](https://cwiki.apache.org/confluence/display/Hive/Setting+Up+HiveServer2)  

```
hive.server2.thrift.min.worker.threads: minimum number of worker threads, default 5.
hive.server2.thrift.max.worker.threads: maximum number of worker threads, default 500.
hive.server2.thrift.port: TCP port number to listen on, default 10000.
hive.server2.thrift.bind.host: TCP interface to bind to, NOT SET.

hive.server2.transport.mode: set to http to enable HTTP transport mode, default binary.
hive.server2.thrift.http.port: HTTP port number to listen on, default 10001.
hive.server2.thrift.http.max.worker.threads: maximum worker threads in the server pool, default 500.
hive.server2.thrift.http.min.worker.threads: minimum worker threads in the server pool, default 5.
hive.server2.thrift.http.path: the service endpoint, default cliservice.
```

The server can run in:
* HTTP mode
* TCP mode

```
# Note: start HiveServer2 and Beeline
$: bin/hiveserver2
$: bin/beeline
OR
$: bin/beeline -u jdbc:hive2://$HS2_HOST:$HS2_PORT  # if connecting remotely
  # !connect jdbc:hive2://localhost:10000
  # !tables
```

[Install and configure Apache Derby](https://cwiki.apache.org/confluence/display/Hive/HiveDerbyServerMode)

[Settings fine tuning](https://cwiki.apache.org/confluence/display/Hive/AdminManual+Configuration)

### Hive partitions

Partitions are like folders.

```
CREATE TABLE alarms (stamp TIMESTAMP, state STRING, status_code STRING, is_up TINYINT, alarm_type STRING, info STRING)
PARTITIONED BY (data_name STRING, year STRING, month STRING, ip STRING)
CLUSTERED BY(status_code) INTO 4 BUCKETS
STORED AS ORC;
```

With Hive 3.0.0 you can [dynamically partition data while streaming](https://cwiki.apache.org/confluence/display/Hive/Streaming+Data+Ingest+V2#HiveStreamingConnection).  
If the data is already in Hive you can [partition it dynamically by overwritting a table](https://cwiki.apache.org/confluence/display/Hive/DynamicPartitions)).  

```
INSERT OVERWRITE TABLE alarms PARTITION (data_name = "alarms_raw", year, month, ip)
SELECT stamp, state, status_code, is_up, alarm_type, info, year, month, ip FROM unpartitioned_alarms;

# Note: data_name is partitioned statically
# Note: year, month and ip are partitioned dynamically
```

### Running Hive

```
# Note: start Hadoop and YARN
$: start-dfs.sh
$: start-yarn.sh
```

```
# Note: start HiveServer2 and Beeline
$: bin/hiveserver2
$: bin/beeline
OR
$: bin/beeline -u jdbc:hive2://$HS2_HOST:$HS2_PORT  # if connecting remotely
  # !connect jdbc:hive2://localhost:10000
  # !tables
  # !dbinfo
```

### Hive troubleshooting

* Problem 1: Hortonworks Hive Out of Memory/VERTEX_FAILURE

[Example](https://community.rapidminer.com/t5/RapidMiner-Radoop-Forum/Performance-Node-Out-of-Memory-Error/m-p/35303#M72)  
[Possible solution](https://community.hortonworks.com/articles/14309/demystify-tez-tuning-step-by-step.html)  
[Possible solution](https://docs.hortonworks.com/HDPDocuments/HDP2/HDP-2.3.4/bk_installing_manually_book/content/determine-hdp-memory-config.html)  

* Problem 2: "... relative path in absolute URI ..."

```
<property>
  <name>system:java.io.tmpdir</name>
  <value>/tmp/hive/java</value>
</property>
<property>
  <name>system:user.name</name>
  <value>${user.name}</value>
</property>
```
