### (Unofficial) installation

https://www.tutorialspoint.com/hive/hive_installation.htm

You need to have both Java and Hadoop installed.

Download Hive. Unpack it with "tar -xzvf apache-hive-x.y.z-bin.tar.gz".

Add to .bashrc:
```
export HIVE_HOME=/path/to/your/hive !!
export PATH=$PATH:$HIVE_HOME/bin
export CLASSPATH=$CLASSPATH:/path/to/your/hadoop/lib/*:.
export CLASSPATH=$CLASSPATH:/path/to/your/hive/lib/*:.

then execute: source ~/.bashrc
```

Check paths and create a config file with:
```
cd $HIVE_HOME/conf
cp hive-env.sh.template hive-env.sh
```

In the following files append the following:

* hive.env.sh
```
export HADOOP_HOME=/path/to/your/hadoop
```

TODO Stopped at Step 8: Verifying Hive Installation ...

### Test installation

Don't forget to run "start-dfs.sh", also known as Hadoop, first.

Test using "bin/hive" in the "/path/to/your/hive" folder.
