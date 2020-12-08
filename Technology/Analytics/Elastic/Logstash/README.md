## [Logstash](https://www.elastic.co/logstash)

### Install

#### Kubernetes

```
$: helm repo add elastic https://helm.elastic.co

$: helm install logstash elastic/logstash -f config.yaml -n K8s-Elastic-Namespace [--version Chart-Version]  # see Research
```

[Installation instructions](Docs/GettingStarted/Install)

### Usage

Connect Logstash plugins to create a data pipeline.  

```
$: bin/logstash -e 'input { stdin { } } output { stdout { } }' [--path.data Writable-Path]
```

Place pipeline `.conf` files into `/etc/logstash/conf.d`.  

[Plugins](Docs/Plugins)

### Configure

See Research.  

[Configuration files](Docs/SetupAndRun/ConfigFiles)  
[ENV VARs](Docs/Configuring/EnvVars)  
