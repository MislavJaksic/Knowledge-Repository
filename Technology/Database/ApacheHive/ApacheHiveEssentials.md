## Apache Hive Essentials

Apache Hive Essentials is a book written by Dayong Du.

### Overview of Big Data and Hive

TODO

### Setting up the Hive Environment

Both Java and Hadoop need to be installed and configured.

You can install Apache Hive using Cloudera, MapR, IBM or Hortonworks.

Hive has two command line interfaces, HiveCLI and Beeline:
```
/your/path/to/hive/bin/hive
/your/path/to/hive/bin/beeline
```

To start Hive start Hadoop first: run "start-dfs.sh" and "start-yarn.sh".  
Then, start HiveServer2 by running "bin/hiveserver2".  

### Data Definition and Description

Hive data types: primitive and complex.  
Primitive: integer, float, double, binary, boolean, string, char, date, timestamp, ...  
Complex: array, map, struct, ...  

Hive Data Definition Language:

Database: collection of table.  
CREATE DATABASE [IF NOT EXISTS] _name;  
DROP DATABASE [IF EXISTS] _name [CASCADE];  

Internal table: Hive table; data is alive as long as the table isn't dropped.  
External table: data outside Hive; data lives even if the table is dropped; often preferred.  
Can use Create Table As Select (CTAS).  

Partition: scan only part of the table; faster queries.

Buckets: cluster databases; better performance.

View: logical structure; simplify queries.

### Data Selection and Scope

TODO
