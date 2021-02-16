## Hive Streaming

Allows data to be appended continuously to a Hive table.

### Hive configuration

```
Javadocs: https://hive.apache.org/javadoc.html

Before Hive 3 examples:
https://cwiki.apache.org/confluence/display/Hive/Streaming+Data+Ingest
https://community.hortonworks.com/articles/49949/test-7.html
https://github.com/mfjohnson/HiveStreamingExamples/tree/master/src/main/java

After Hive 3 examples:
https://cwiki.apache.org/confluence/display/Hive/Streaming+Data+Ingest+V2
```

In "hive-site.xml" set the following properties:
```
hive.txn.manager                 = org.apache.hadoop.hive.ql.lockmgr.DbTxnManager
hive.compactor.initiator.on      = true
hive.compactor.worker.threads    = 1 (greater then 0)

hive.support.concurrency         = true
hive.enforce.bucketing           = true
hive.exec.dynamic.partition.mode = nonstrict
hive.txn.timeout                 = 300
```

### Table configuration

A streaming table has to be:
* stored as ORC (syntax: "stored as orc"),
* transactional (syntax: "tblproperties("transactional"="true")"),
* bucketed but not sorted (syntax: "clustered by (_column_name) into 10 buckets"),
* set in such a way that the client has permissions (how do you set table permission???)

Example:
```
CREATE TABLE alarms_raw (stamp TIMESTAMP, state STRING, state_code STRING, status TINYINT, alarm_type STRING, info STRING)
PARTITIONED BY (year STRING, month STRING, ip STRING)
CLUSTERED BY(state) INTO 4 BUCKETS
STORED AS ORC
tblproperties("transactional"="true");
```

### Maven dependencies

Double check the required dependency version. You can check which version you need by inspecting which
.jar files Hive uses.
```
<dependency>
    <groupId>org.apache.hive.hcatalog</groupId>
    <artifactId>hive-hcatalog-streaming</artifactId>
    <version>HIVE_VERSION</version>
</dependency>
<dependency>
    <groupId>org.apache.hive.hcatalog</groupId>
    <artifactId>hive-hcatalog-core</artifactId>
    <version>HIVE_VERSION</version>
</dependency>
<dependency>
    <groupId>org.apache.hadoop</groupId>
    <artifactId>hadoop-hdfs</artifactId>
    <version>HADOOP_VERSION</version>
</dependency>
<dependency>
    <groupId>org.apache.hadoop</groupId>
    <artifactId>hadoop-common</artifactId>
    <version>HADOOP_VERSION</version>
</dependency>
<dependency>
    <groupId>org.apache.hadoop</groupId>
    <artifactId>hadoop-mapreduce-client-core</artifactId>
    <version>HADOOP_VERSION</version>
</dependency>
<dependency> <!-- Optional -->
    <groupId>org.apache.hive</groupId>
    <artifactId>hive-jdbc-handler</artifactId>
    <version>JDBC_HANDLER</version>
</dependency>
```

If a class is still missing, you can use the jar-explorer utility to find where the missing class is located.

### Hive transactions

Transactions can behave strangely. Be careful.
