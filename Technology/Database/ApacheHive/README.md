## [Apache Hive](https://hive.apache.org/)

Apache Hive is a data warehouse built on top of Apache Hadoop.

### [Installation](https://cwiki.apache.org/confluence/display/Hive/AdminManual+Installation)

Both Java and Hadoop need to be installed and configured.

Download Hive. Unpack it with "tar -xzvf hive-x.y.z.tar.gz".

Add to PATHs to .bashrc:
```
export HIVE_HOME=/path/to/your/hive
export PATH=$HIVE_HOME/bin:$PATH

HADOOP_HOME=/path/to/your/hadoop
```

Start Hadoop and YARN by running "start-dfs.sh" and "start-yarn.sh".  
Execute the following commands:  
```
$HADOOP_HOME/bin/hadoop fs -mkdir       /tmp
$HADOOP_HOME/bin/hadoop fs -mkdir       /user/hive/warehouse (Note: if you cannot create a folder it just means you didn't construct the parent folder)
$HADOOP_HOME/bin/hadoop fs -chmod g+w   /tmp
$HADOOP_HOME/bin/hadoop fs -chmod g+w   /user/hive/warehouse
```
You can browse the HDFS with "$HADOOP_HOME/bin/hadoop fs -ls /".

Try running "$HIVE_HOME/bin/hive" and if it doesen't work, see the Hive troubleshooting section.  
HiveCLI is deprecated, use Beeline and HiveServer2 instead.  

[Settings up Beeline and HiveServer2](https://cwiki.apache.org/confluence/display/Hive/Setting+Up+HiveServer2)

The following HiveServer2 settings are already configured:
```
hive.server2.thrift.min.worker.threads – Minimum number of worker threads, default 5.
hive.server2.thrift.max.worker.threads – Maximum number of worker threads, default 500.
hive.server2.thrift.port – TCP port number to listen on, default 10000.
hive.server2.thrift.bind.host – TCP interface to bind to, NOT SET.

hive.server2.transport.mode - Set to http to enable HTTP transport mode, default binary.
hive.server2.thrift.http.port - HTTP port number to listen on, default 10001.
hive.server2.thrift.http.max.worker.threads - Maximum worker threads in the server pool, default 500.
hive.server2.thrift.http.min.worker.threads - Minimum worker threads in the server pool, default 5.
hive.server2.thrift.http.path - The service endpoint, default cliservice.
```

The server can run in either HTTP or TCP mode, but not both.  
Start HiveServer2 by running "bin/hiveserver2". There should be no prompts if everything started correctly.  

Start Beeline by running "bin/beeline".  
Execute "!connect jdbc:hive2://localhost:10000".  
If connecting remotely, execute "bin/beeline -u jdbc:hive2://$HS2_HOST:$HS2_PORT" as well.  
Run "!tables" command. If it works, Beeline and HiveServer2 are up and running!  

https://cwiki.apache.org/confluence/display/Hive/HiveDerbyServerMode  
Install and configure Apache Derby.  
TODO... Installing Derby.  

https://cwiki.apache.org/confluence/display/Hive/AdminManual+Configuration  
TODO... Fine tune the config.  

### Hive partitions

You should think of partitions as folders.

Example:
```
CREATE TABLE alarms (stamp TIMESTAMP, state STRING, status_code STRING, is_up TINYINT, alarm_type STRING, info STRING)
PARTITIONED BY (data_name STRING, year STRING, month STRING, ip STRING)
CLUSTERED BY(status_code) INTO 4 BUCKETS
STORED AS ORC;
```

With Hive 3.0.0 you can [dynamically partition data while streaming](https://cwiki.apache.org/confluence/display/Hive/Streaming+Data+Ingest+V2#HiveStreamingConnection).  
If the data is already in Hive you can [partition it dynamically by overwritting a table](https://cwiki.apache.org/confluence/display/Hive/DynamicPartitions)).  
Example:  
```
INSERT OVERWRITE TABLE alarms PARTITION (data_name = "alarms_raw", year, month, ip)
SELECT stamp, state, status_code, is_up, alarm_type, info, year, month, ip FROM unpartitioned_alarms;
```
Note: data_name is partitioned statically; year, month and ip are partitioned dynamically.

### Running Hive

Start Hadoop first: run "start-dfs.sh" and "start-yarn.sh".  
Start HiveServer2 by running "bin/hiveserver2".  
Start Beeline with "bin/beeline".  
Execute "!connect jdbc:hive2://localhost:10000" or "bin/beeline -u jdbc:hive2://$HS2_HOST:$HS2_PORT" if connecting remotely.  
Execute "!tables" and "!dbinfo".  
If all outputs are normal, Hive is ready for use.  

### Hive troubleshooting

* Problem 1: Hortonworks Hive Out of Memory/VERTEX_FAILURE

Example: https://community.rapidminer.com/t5/RapidMiner-Radoop-Forum/Performance-Node-Out-of-Memory-Error/m-p/35303#M72  
Possible solution: https://community.hortonworks.com/articles/14309/demystify-tez-tuning-step-by-step.html  
Possible solution: https://docs.hortonworks.com/HDPDocuments/HDP2/HDP-2.3.4/bk_installing_manually_book/content/determine-hdp-memory-config.html  

* Problem 2: "... relative path in absolute URI ..."

Add:
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
