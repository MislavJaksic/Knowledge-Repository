### [(Unofficial) installation](https://www.tutorialspoint.com/hive/hive_installation.htm)

You have to install Java.

Download Hadoop. Unpack with "tar -xzvf hadoop-x.y.z.tar.gz".

Set Hadoop to work in pseudo-distributed mode.

Add to .bashrc.
´´´
export HADOOP_HOME=/path/to/your/hadoop
export HADOOP_MAPRED_HOME=$HADOOP_HOME
export HADOOP_COMMON_HOME=$HADOOP_HOME
export HADOOP_HDFS_HOME=$HADOOP_HOME
export YARN_HOME=$HADOOP_HOME
export HADOOP_COMMON_LIB_NATIVE_DIR=$HADOOP_HOME/lib/native export
PATH=$PATH:$HADOOP_HOME/sbin:$HADOOP_HOME/bin
´´´

source ~/.bashrc - refresh the file

In hadoop-env.sh change "export JAVA_HOME=..." to "/where/you/installed/java/jdkx.y.z_version".

In the following files add the following <elements> between <configuration> elements:

* core-site.xml
´´´
<property>
  <name>fs.default.name</name>
  <value>hdfs://localhost:9000</value>
</property>
´´´

* hdfs-site.xml
´´´
<property> 
  <name>dfs.replication</name> 
  <value>1</value> 
</property> 
<property> 
  <name>dfs.name.dir</name> 
  <value>file:///path/to/your/hadoop/hadoopinfra/hdfs/namenode </value>
</property> 
<property> 
  <name>dfs.data.dir</name>
  <value>file:///path/to/your/hadoop/hadoopinfra/hdfs/datanode </value>
</property>
´´´

* yarn-site.xml
´´´
<property> 
  <name>yarn.nodemanager.aux-services</name> 
  <value>mapreduce_shuffle</value> 
</property>
´´´

* mapred-site.xml
Create and rename mapred-site.xml using "cp mapred-site.xml.template mapred-site.xml".
´´´
<property> 
  <name>mapreduce.framework.name</name> 
  <value>yarn</value> 
</property>
´´´


### Test installation

Test one: "hdfs namenode -format"

Desired output:
´´´
...
... INFO util.ExitUtil: Exiting with status 0
...
´´´


Test two: start Hadoop with "start-dfs.sh". Conversely, shut it down with stop-dfs.sh.

Desired output:
´´´
Starting namenodes on [localhost] 
...
Starting secondary namenodes [0.0.0.0]
...
´´´
If the connection is refused do the following:
Add the following lines to "path/to/your/hadoop/etc/hadoop/hadoop-env.sh" file.
´´´
# My addition to solve the refused connection problem when running start-dfs.sh
export HADOOP_SSH_OPTS="-p 22"
´´´
Then, install openssh with "sudo apt-get install openssh-server".


Test three: start YARN with start-yarn.sh.  Conversely, shut it down with stop-yarn.sh.

Desired output:
´´´
...
localhost: starting nodemanager, logging to ...
´´´


Test four: try to access Hadoop and its clusters by visiting "http://localhost:50070/" and "http://localhost:8088/".
