## Reporters

### Metrics Reporter

For Broker, Consumer, Producer, Stream, Connect and AdminClient.  

Configuration description:  
```
metric.reporters

Class to use as metrics reporter.
Implements org.apache.kafka.common.metrics.MetricsReporter.
Classes is notified of new metric creation.
```

Jar should be placed in:  
```
kafka_x.y.z/libs/*.jar
```

If an error occures, this might be cause by a dependency conflict. Don't use an UBER jar.  

Order of execution:  
1) configure()  
2) init()  
3) metricChange()  
4) metricRemoval()  
5) close()  

### Kafka Metrics Reporter

For Broker.  

Configuration description:  
```
kafka.metrics.reporters

Class to use as Yammer metrics reporter.
Implement kafka.metrics.KafkaMetricsReporter.
To expose JMX operations construct an MBean class.
MBean class implements kafka.metrics.KafkaMetricsReporterMBean.
```

Order of execution:  
1) init()  
