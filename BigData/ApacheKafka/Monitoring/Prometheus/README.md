## Prometheus monitoring Kafka

### Setup

You will need to download a number of files:  
* Kafka; comes with Zookeeper  
* JMX Prometheus Java Agent  
* JMX Prometheus Java Agent YAML Configuration  
* Prometheus  

Start Zookeeper:  
```
$: ./bin/zookeeper-server-start.sh config/zookeeper.properties
```

Start Kafka and attach the Java Agent to Kafka:  
```
$: KAFKA_OPTS="$KAFKA_OPTS -javaagent:$PWD/jmx_prometheus_javaagent-x.y.z.jar=_metrics_port:$PWD/kafka-a_b_c.yml" ./bin/kafka-server-start.sh config/server.properties
```

Change the "prometheus.yml" like so:  
```
global: # -> 
  scrape_interval:     15s
  evaluation_interval: 15s
#   external_labels:
#     monitor: 'codelab-monitor'

rule_files:
#  - 'prometheus.rules.yml'

scrape_configs:
  - job_name: prometheus
#     scrape_interval: 5s
    static_configs:
      - targets: ['localhost:_metrics_port']
#         labels:
#           group: 'production'
```

Start Prometheus by executing:
```
./prometheus --config.file=prometheus.yml
```

View metrics using the Prometheus' expression browser:  
```
http://localhost:9090/graph
```