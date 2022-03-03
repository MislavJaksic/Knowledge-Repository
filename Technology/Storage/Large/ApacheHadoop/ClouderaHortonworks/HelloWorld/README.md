### [Learning the Ropes of the HDP Sandbox](https://hortonworks.com/tutorial/learning-the-ropes-of-the-hortonworks-sandbox/)

Sandbox VM is installed.  
Attached to a virtual network.  
By default, NAT (Network Address Translation) network mode.  

NAT:  
guest IP == host IP, external devices cannot connect to the guest (the Virtual Machine), but the guest can connect to external devices.  
can portfoward to make them reachable.  

Bridged Networking:  
guest can be reached and can reach external devices.  
needed for Connected Data Architecture.  

Determine IP of Sandbox: ??

Terminal access: through Putty with <something-something> or Web GUI with <something-something>:4200

Transfer data:  
```
scp -P 2222 <from> <to>

scp -P 2222 <local_directory_file> root@<something-something>:<sandbox_directory_file>
OR
scp -P 2222 root@<something-something>:<sandbox_directory_file> <local_directory_file>
```

Sandbox Welcome Page: <something-something>:8888 (DOESEN'T WORK)

Explore Ambari: <something-something>:8080
            
### [Hadoop Tutorial – Getting Started with HDP](https://hortonworks.com/tutorial/hadoop-tutorial-getting-started-with-hdp/)

#### Concepts

HDP (Hortonworks Data Platform).  
Hadoop Distributed File System for data storage.  
YARN is the Data Operating System that allows Hive/Pig and other languages to access the data.  

Apache Hadoop distributes and stores data.  
Made of Hadoop Common, HDFS, YARN, MapReduce.  
HDP manages Hadoop clusters.  

HDFS partitions data across multiple computers. A single computer cannot hold all the data.  
HDFS Cluster:  
NameNode - manage cluster metadata (replicas, data block mapping, requests, ...
CataNode - store data.  

File View: next to login credentials, in a dropdown box, "File View".

MapReduce: algorithm to distribute and compute data, minimize data movement.  
YARN: Yet Another Resource Negotiator, split resource management and job scheduling.  

Hive: SQL database for big datasets; Hive QL is a SQL dialect; can analyze data.  
Tez: batch and interactive data processing, speedup MapReduce; uses YARN.  
Stinger: Hive extension to broaden its capabilities.  
Hive View 2.0: next to login credentials, in a dropdown box, "Hive View 2.0"; simple GUI.  

Pig: simplify MapReduce scripts using Pig Latin language; for script data processing.  
Pig View: next to login credentials, in a dropdown box, "Pig View"; simple GUI.  

#### Loading (Sensor) Data into HDFS

Open Files View.  
Go to /user/<someone>, for example /user/maria_dev.  
Create a new folder and upload the files there.  
Select folder and change Write permissions to solid BLUE.  

#### Hive - Data ETL (Extract, Transform, Load)

Open Hive View 2.0.

Query: for SQL.  
Jobs: query history.  
Tables: view tables.  
Saved queries: self explanatory.  
UDFs: user defined functions.  
Settings: modify Hive.  

Create table, upload table, tell it where you can find some data, click preview.  
Example: there is a header, from HDFS, write the path.  

You can write queries in the Query Tab.  
TEZ View: view DAGs (Directed Acyclic Graph); for troubleshooting results.  

Possible to create a table from SELECT. CTAS (Create Table As Select).

#### Pig - Risk Factor

Open Pig View.  
Create a Pig script with the .pig extension.  
[Pig Latin syntax](http://pig.apache.org/docs/r0.14.0/basic.html)  

```
a = LOAD 'geolocation' using org.apache.hive.hcatalog.pig.HCatLoader();
b = filter a by event != 'normal';
c = foreach b generate driverid, event, (int) '1' as occurance;
d = group c by driverid;
e = foreach d generate group as driverid, SUM(c.occurance) as t_occ;
g = LOAD 'drivermileage' using org.apache.hive.hcatalog.pig.HCatLoader();
h = join e by driverid, g by driverid;
final_data = foreach h generate $0 as driverid, $1 as events, $3 as totmiles, (float) $3/$1 as riskfactor;
store final_data into 'riskfactor' using org.apache.hive.hcatalog.pig.HCatStorer();
```

```
The line a = loads the geolocation table from HCatalog.
The line b = filters out all the rows where the event is not ‘Normal'.
Then we add a column called occurrence and assign it a value of 1.
We then group the records by driverid and sum up the occurrences for each driver.
At this point we need the miles driven by each driver, so we load the table we created using Hive.
To get our final result, we join by the driverid the count of events in e with the mileage data in g.
Now it is real simple to calculate the risk factor by dividing the miles driven by the number of events
Note: add -useHCatalog to the argument box; that way Pig will load the proper libraries
```

#### Spark - Risk Factor (With Zeppelin Notebook)

Uses RDD (Resilient Distributed Dataset).

View the Zeppelin Notebook page: <something-something>:9995/

Shift+Enter runs the cell.
```
%jdbc(hive) show tables // -> show tables

%spark2
val hiveContext = new org.apache.spark.sql.SparkSession.Builder().getOrCreate() // -> instantiate SparkSession

%spark2
hiveContext.sql("show tables").show() // -> show tables ready to be queried

%spark2
val geolocation_temp1 = hiveContext.sql("select * from geolocation") // -> transfer data from table to Spark RDD
geolocation_temp1.createOrReplaceTempView("geolocation_temp1") // -> create temporary table; SQL can only be applied to them

val geolocation_temp2 = hiveContext.sql("SELECT driverid, count(driverid) occurance from geolocation_temp1 where event!='normal' group by driverid") // -> filter data
geolocation_temp2.show(10) // -> an action on a RDD

%spark2
val joined = hiveContext.sql("select a.driverid,a.occurance,b.totmiles from geolocation_temp2 a,drivermileage_temp1 b where a.driverid=b.driverid") // -> join tables, create an RDD

val risk_factor_spark = hiveContext.sql("select driverid, occurance, totmiles, totmiles/occurance riskfactor from joined") // -> compute riskfactor

%spark2
hiveContext.sql("create table finalresults( driverid String, occurance bigint, totmiles bigint, riskfactor double) stored as orc").toDF() // -> create ORC data format table, for permanent Hive storage
risk_factor_spark.write.format("orc").save("risk_factor_spark") // -> convert data to ORC

hiveContext.sql("load data inpath 'risk_factor_spark' into table finalresults") //-> transfer data from temporary table in Spark to permanent table in Hive
hiveContext.sql("create table riskfactor as select * from finalresults").toDF() // -> Create Table As Select (CTAS)
```
Note: Spark can be used from the shell. Connect to the Docker/VirtualBox and type spark-shell.

#### Data Reporting With Zeppelin

Neat way to visualize data.

```
%jdbc(hive)
SELECT * FROM riskfactor
```

Then play with the settings.

#### Data Reporting with Microsoft Excel for Windows

TODO

### [How to Process Data with Apache Hive](https://hortonworks.com/tutorial/how-to-process-data-with-apache-hive/)

Hive and Pig can do the same thing. Hive for SQL, Pig for data flow. Choose which one you prefer.

After Loading/Uploading data to HDFS, open up Hive View.

Hive data model: Apache Hadoop data store, data persist from query to query.  
Pig data model: data exists only in a script.  

```
CREATE TABLE temp_drivers (col_value STRING); // -> create empty table
LOAD DATA INPATH '/user/maria_dev/test-data/drivers.csv' OVERWRITE INTO TABLE temp_drivers; // -> load data from HDFS, consume the data
```

```
CREATE TABLE drivers (driverId INT, name STRING, ssn BIGINT, location STRING, certified STRING, wageplan STRING); // -> create a permanent table
INSERT OVERWRITE TABLE drivers
SELECT
  regexp_extract(col_value, '^(?:([^,]*),?){1}', 1) driverId,  // -> DID NOT EXECUTE
  regexp_extract(col_value, '^(?:([^,]*),?){2}', 1) name,
  regexp_extract(col_value, '^(?:([^,]*),?){3}', 1) ssn,
  regexp_extract(col_value, '^(?:([^,]*),?){4}', 1) location,
  regexp_extract(col_value, '^(?:([^,]*),?){5}', 1) certified,
  regexp_extract(col_value, '^(?:([^,]*),?){6}', 1) wageplan
FROM temp_drivers; // -> extract data from temp table to perma table using regular expressions
```

```
CREATE TABLE temp_timesheet (col_value STRING);
LOAD DATA INPATH '/user/maria_dev/test-data/timesheet.csv' OVERWRITE INTO TABLE temp_drivers;
CREATE TABLE timesheet (driverId INT, week INT, hours_logged INT , miles_logged INT);
INSERT OVERWRITE TABLE timesheet
SELECT
  regexp_extract(col_value, '^(?:([^,]*),?){1}', 1) driverId,
  regexp_extract(col_value, '^(?:([^,]*),?){2}', 1) week,
  regexp_extract(col_value, '^(?:([^,]*),?){3}', 1) hours_logged,
  regexp_extract(col_value, '^(?:([^,]*),?){4}', 1) miles_logged,
FROM temp_timesheet;
```

```
SELECT driverId, sum(hours_logged), sum(miles_logged) FROM timesheet GROUP BY driverId; // -> group and sum
```

```
SELECT d.driverId, d.name, t.total_hours, t.total_miles FROM drivers d
JOIN (SELECT driverId, sum(hours_logged)total_hours, sum(miles_logged)total_miles FROM timesheet GROUP BY driverId ) t
ON (d.driverId = t.driverId); //-> create final table
```

### [How to Process Data with Apache Pig](https://hortonworks.com/tutorial/how-to-process-data-with-apache-pig/)

Scripting language for Apache Hadoop. Data analysis as data flow.

TODO

### [Interactive Query for Hadoop with Apache Hive on Apache Tez](https://hortonworks.com/tutorial/interactive-query-for-hadoop-with-apache-hive-on-apache-tez/)

TODO

### [Interactive SQL on Hadoop with Hive LLAP](https://hortonworks.com/tutorial/interactive-sql-on-hadoop-with-hive-llap/)

Hive LLAP is an interactive query tool.

TODO

### [Loading and Querying Data with Hadoop](https://hortonworks.com/tutorial/loading-and-querying-data-with-hadoop/)

```
CREATE VIEW omniture AS
SELECT col_2 ts, col_8 ip, col_13 url, col_14 swid, col_50 city, col_51 country, col_53 state
FROM omniturelogs
```

```
CREATE TABLE webloganalytics as ... // -> create final table
```

### [Using Hive ACID Transactions to Insert, Update and Delete Data](https://hortonworks.com/tutorial/using-hive-acid-transactions-to-insert-update-and-delete-data/)

Enable ACID Operations in the Config.

TODO

### Manage Files on HDFS via Cli/Ambari Files View

#### Manage Files on HDFS with the Command Line

Use Putty/Browser to get into the HDP Sandbox.

su hdfs // -> switch users  
hdfs dfs -chmod 777 /user // -> set very leisure premissions  

hdfs dfs -help // -> help  

hdfs dfs -mkdir // -> create directories  
hdfs dfs -put // -> transfer data from local to HDFS  
hdfs dfs -ls // -> list directory  
hdfs dfs -du // -> display size  
hdfs dfs -get // -> transfer data from HDFS to local  
hdfs dfs -getmerge // -> concatinate files  
hdfs dfs -cp // -> copy file/directory recursively  
