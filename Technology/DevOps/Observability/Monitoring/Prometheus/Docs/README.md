## [Prometheus Documentation](https://prometheus.io/docs/introduction/overview/)

Prometheus is a monitoring and alerting toolkit.  
Features:
* high-dimension time series data
* `PromQL`, a query language
* no reliance on distributed storage
* pull model over HTTP
* pushing is supported via a gateway
* target and service discovery
* graphing and dashboarding

Components:
* Prometheus server: scrapes and stores time series data
* client libraries: instrument code
* a push gateway for supporting short-lived jobs
* special-purpose exporters for services like `HAProxy`, `StatsD`, `Graphite`, etc.
* an `AlertManager` to handle alerts
