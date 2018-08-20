## Hadoop

Apache Hadoop is a framework for distributed computing. It stores data, executes operations and gathers results
from multiple remote computers.
> Hadoop components:
> Hadoop Common: utility module that supports other modules.
> Hadoop Distributed File System (HDFS): file system for distributing data in a robust way.
> Hadoop Yet Another Resource Negotiator (YARN): cluster manager and job scheduler.
> Hadoop MapReduce: module for parallel processing.

### [Single cluster installation](http://hadoop.apache.org/docs/current/hadoop-project-dist/hadoop-common/SingleCluster.html)

Both Java and ssh must be installed.

Install them with:
sudo apt-get install ssh
sudo apt-get install rsync

Download Hadoop. Unpack with "tar -xzvf hadoop-x.y.z.tar.gz".

Edit "/path/to/your/hadoop/etc/hadoop/hadoop-env.sh" by adding "export JAVA_HOME=/path/to/your/java/jre_x.y.z"
Test changes using "bin/hadoop". A short list should appear.

Hadoop can run in one of three modes: standalone (default, as a single Java process), pseudo-distributed or fully-distributed.

You should be able to execute the following MapReduce job:
´´´
mkdir input
cp etc/hadoop/*.xml input
bin/hadoop jar share/hadoop/mapreduce/hadoop-mapreduce-examples-x.y.z.jar grep input output 'dfs[a-z.]+'
cat output/*
´´´

If you want Hadoop to work in pseudo-distributed mode, do the following.

Change the following files:

* etc/hadoop/core-site.xml
´´´
<configuration>
    <property>
        <name>fs.defaultFS</name>
        <value>hdfs://localhost:9000</value>
    </property>
</configuration>
´´´

* etc/hadoop/hdfs-site.xml
´´´
<configuration>
    <property>
        <name>dfs.replication</name>
        <value>1</value>
    </property>
</configuration>
´´´

Try to connect to localhost with "shh localhost".
Once connected, use "exit" to logout from the session.
If you cannot, that is you need to authorise a key, execute:
´´´
ssh-keygen -t rsa -P '' -f ~/.ssh/id_rsa
cat ~/.ssh/id_rsa.pub >> ~/.ssh/authorized_keys
chmod 0600 ~/.ssh/authorized_keys
´´´

Format the file system with "bin/hdfs namenode -format". (Warning: this will wipe all folders on the HDFS!)
Start NameNode and DataNode daemons with "sbin/start-dfs.sh".
Browse the NameNode at "http://localhost:50070/".

Make HDFS directories:
´´´
bin/hdfs dfs -mkdir /user
bin/hdfs dfs -mkdir /user/<username>
´´´

Test the settings by executing a MapReduce job:
´´´
bin/hdfs dfs -put etc/hadoop input
bin/hadoop jar share/hadoop/mapreduce/hadoop-mapreduce-examples-x.y.z.jar grep input output 'dfs[a-z.]+'
´´´

View the output with:
´´´
bin/hdfs dfs -get output output
cat output/*
´´´

When done, use "sbin/stop-dfs.sh" to stop the deamons.

Additionally, you can set up YARN to work in pseudo-distributed mode.

Change the following files:

* etc/hadoop/mapred-site.xml
´´´
<configuration>
    <property>
        <name>mapreduce.framework.name</name>
        <value>yarn</value>
    </property>
</configuration>
´´´

* etc/hadoop/yarn-site.xml
´´´
<configuration>
    <property>
        <name>yarn.nodemanager.aux-services</name>
        <value>mapreduce_shuffle</value>
    </property>
</configuration>
´´´

Start ResourceManager and NodeManager daemon with "sbin/start-yarn.sh".
Browse the ResourceManager at "http://localhost:8088/".

(Warning: both "start-dfs.sh" and "start-yarn.sh" have to be running!)
Try executing a MapReduce job: bin/hadoop jar share/hadoop/mapreduce/hadoop-mapreduce-examples-x.y.z.jar grep input output 'dfs[a-z.]+'

View the output with:
´´´
bin/hdfs dfs -get output output
cat output/*
´´´

When done, use "sbin/stop-yarn.sh" and "sbin/stop-dfs.sh" to stop the deamons.

### [Cluster setup](http://hadoop.apache.org/docs/current/hadoop-project-dist/hadoop-common/ClusterSetup.html)

The following site configurations are of great import:
* etc/hadoop/core-site.xml
* etc/hadoop/hdfs-site.xml
* etc/hadoop/yarn-site.xml
* etc/hadoop/mapred-site.xml

TODO: it continues by talkin in greater detail about the configuration.

### Running Hadoop

Run "start-dfs.sh".
Run "start-yarn.sh".
Execute "bin/hadoop fs -ls /".
Visit "http://localhost:50070/".
Visit "http://localhost:8088/".
If all outputs are normal, your Hadoop is ready to execute queries.
