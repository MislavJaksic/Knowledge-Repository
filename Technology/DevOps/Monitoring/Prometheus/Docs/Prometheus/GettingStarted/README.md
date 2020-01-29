## [Getting Started](https://prometheus.io/docs/prometheus/latest/getting_started/)

```
$: ./prometheus --config.file=prometheus.yml  # start Prometheus
# Note: visit http://localhost:9090/metrics
```

```
# Note: see prometheus.rules.yml
groups:
- name: example
  rules:
  - record: job_service:rpc_durations_seconds_count:avg_rate5m
    expr: avg(rate(rpc_durations_seconds_count[5m])) by (job, service)
```
Don't forget to add the rule to `prometheus.yml`.  
