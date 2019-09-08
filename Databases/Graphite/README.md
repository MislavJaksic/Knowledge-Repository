## [Graphite](http://graphiteapp.org/)

Graphite stores, retrieves, shares, and visualizes time-series data.  
A monitoring tool, not a collection agent.  

### Graphite message format

```
metric_path value timestamp\n
```
* metric_path is a metric namespace
* value is the assigned metric value
* timestamp is the number of seconds since unix epoch time; set to -1 to use the time of arrival

### [Graphite Docker](https://hub.docker.com/r/graphiteapp/docker-graphite-statsd/tags)

```
$: docker run -d --name graphite --restart=always -p 80:80 -p 2003-2004:2003-2004 -p 2023-2024:2023-2024 -p 8125:8125/udp -p 8126:8126  -v /tmp/graphite_docker/graphite/conf:/opt/graphite/conf -v /tmp/graphite_docker/graphite/storage:/opt/graphite/storage -v /tmp/graphite_docker/statsd/config:/opt/statsd/config graphiteapp/docker-graphite-statsd
```

#### Feeding metrics

Feed to plaintext:  
```
$: while true; do echo "test.example $((RANDOM % 100)) `date +%s`" | nc -w 1 localhost 2003; done
#: Note: you can substitute `date +%s` with -1
```

Feed to statsd:  
```
$: while true; do echo -n "example:$((RANDOM % 100))|c" | nc -w 1 -u 127.0.0.1 8125; done
```

#### Visualize

```
http://localhost/dashboard
```

#### Configure resolution and retention

```
# Note: stop the container before editing Docker configuration volumes in /tmp/graphite_docker

# The maximum resolution is set by .../statsd/config/udp.js by:
flushInterval: 10000 # -> lower it

# Retentions are set by .../graphite/conf/storage-schemas.conf by:
[default]
pattern = .*
retentions = 10s:6h,1m:6d,10m:1800d -> lower them

# Example of a valid retention: 1s:1h,10s:1d,1m:7d

# After making changes delete all data in .../graphite/storage/whisper/
```
