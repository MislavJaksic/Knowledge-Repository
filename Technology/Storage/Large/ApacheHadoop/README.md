## [Hadoop](http://hadoop.apache.org/)

Apache Hadoop is a distributed computing framework.  
It stores data, executes operations and gathers results
from multiple remote computers.  

| Hadoop components | Description |
| :--- | :--- |
| Hadoop Common | Utility module that supports other modules |
| Hadoop Distributed File System (HDFS) | File system for distributing data in a robust way |
| Hadoop Yet Another Resource Negotiator (YARN) | Cluster manager and job scheduler |
| Hadoop MapReduce | Module for parallel processing |

### [Single cluster installation](http://hadoop.apache.org/docs/current/hadoop-project-dist/hadoop-common/SingleCluster.html)

```
$: sudo apt-get install ssh
$: sudo apt-get install rsync

# Note: download Hadoop
$: tar -xzvf hadoop-x.y.z.tar.gz

# Note: edit /path/to/your/hadoop/etc/hadoop/hadoop-env.sh and add
  # export JAVA_HOME=/path/to/your/java/jre_x.y.z

$: bin/hadoop
```

Hadoop can run in one of three modes:
* standalone (default, as a single Java process)
* pseudo-distributed
* fully-distributed

Execute a MapReduce job:
```
$: mkdir input
$: cp etc/hadoop/*.xml input
$: bin/hadoop jar share/hadoop/mapreduce/hadoop-mapreduce-examples-x.y.z.jar grep input output 'dfs[a-z.]+'
$: cat output/*
```

---

To run Hadoop in pseudo-distributed mode:

```
# Note: add to etc/hadoop/core-site.xml
<configuration>
    <property>
        <name>fs.defaultFS</name>
        <value>hdfs://localhost:9000</value>
    </property>
</configuration>
```

```
# Note: add to etc/hadoop/hdfs-site.xml
<configuration>
    <property>
        <name>dfs.replication</name>
        <value>1</value>
    </property>
</configuration>
```

```
$: shh localhost
  # $: exit

# Note: if you cannot connect do
$: ssh-keygen -t rsa -P '' -f ~/.ssh/id_rsa
$: cat ~/.ssh/id_rsa.pub >> ~/.ssh/authorized_keys
$: chmod 0600 ~/.ssh/authorized_keys
```

---

```
$: bin/hdfs namenode -format  # format the file system
$: sbin/start-dfs.sh  # start NameNode and DataNode daemons
# Note: visit the NameNode at http://localhost:50070/

Note: make HDFS directories
$: bin/hdfs dfs -mkdir /user
$: bin/hdfs dfs -mkdir /user/<username>

Note: execute a MapReduce job
$: bin/hdfs dfs -put etc/hadoop input
$: bin/hadoop jar share/hadoop/mapreduce/hadoop-mapreduce-examples-x.y.z.jar grep input output 'dfs[a-z.]+'

# Note: view the output
$: bin/hdfs dfs -get output output
$: cat output/*

$: sbin/stop-dfs.sh  # stop the deamons
```

---

Setup YARN in pseudo-distributed mode:

```
# Note: add to etc/hadoop/mapred-site.xml
<configuration>
    <property>
        <name>mapreduce.framework.name</name>
        <value>yarn</value>
    </property>
</configuration>
```

```
# Note: add to etc/hadoop/yarn-site.xml
<configuration>
    <property>
        <name>yarn.nodemanager.aux-services</name>
        <value>mapreduce_shuffle</value>
    </property>
</configuration>
```

```
$: sbin/start-dfs.sh  # start NameNode and DataNode daemons
$: sbin/start-yarn.sh  # start ResourceManager and NodeManager daemons
# Note: visit the ResourceManager at http://localhost:8088/

# Note: execute a MapReduce job
$: bin/hadoop jar share/hadoop/mapreduce/hadoop-mapreduce-examples-x.y.z.jar grep input output 'dfs[a-z.]+'

# Note: view the output
$: bin/hdfs dfs -get output output
$: cat output/*

$: sbin/stop-yarn.sh  # stop the YARN deamons
$: sbin/stop-dfs.sh  # stop the DFS deamons
```

### [Cluster setup](http://hadoop.apache.org/docs/current/hadoop-project-dist/hadoop-common/ClusterSetup.html)

The following site configurations are of great import:
* `etc/hadoop/core-site.xml`
* `etc/hadoop/hdfs-site.xml`
* `etc/hadoop/yarn-site.xml`
* `etc/hadoop/mapred-site.xml`

TODO: it continues by talking in greater detail about the configuration.

### Running Hadoop

```
$: sbin/start-dfs.sh  # start NameNode and DataNode daemons
$: sbin/start-yarn.sh  # start ResourceManager and NodeManager daemons

$: bin/hadoop fs -ls /

# Note: visit the NameNode at http://localhost:50070/
# Note: visit the ResourceManager at http://localhost:8088/
```
