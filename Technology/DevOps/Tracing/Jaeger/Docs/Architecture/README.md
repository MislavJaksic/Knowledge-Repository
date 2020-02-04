## [Architecture](https://www.jaegertracing.io/docs/1.16/architecture/)

### Terminology

See [OpenTracing Specification](https://github.com/opentracing/specification/blob/master/specification.md).  

#### Span

Logical unit of work.  
May be nested and ordered.  
Has:
* an operation name
* the start time of the operation
* the duration

#### Trace

Data/execution path through the system.  
A directed acyclic graph (DAG) of `Span`s.  

### Components

Deploy as a:
* all in one process solution
* scalable distributed system

Collectors write to:
* storage
* to `Apache Kafka` as a buffer

#### Jaeger client libraries

Language specific implementations of `OpenTracing`.  
Instrument manually or using frameworks such as `Flask`, `Dropwizard`, `gRPC` and others.  

Apps create `Span`s when receiving new requests.
Apps attach context information (trace id, span id, and baggage) to outgoing requests.  
Only ids and baggage are propagated with requests.  
All operation names, logs, etc. are not propagated.  
Sampled spans are transmitted out of process asynchronously, in the background, to Jaeger `Agent`s.  

The instrumentation has very little overhead, and is designed to be always enabled in production.  

Note that while all traces are generated, only a few are sampled.  
Sampling a trace marks the trace for further processing and storage.  
By default, Jaeger client samples 0.1% of traces (1 in 1000), and has the ability to retrieve sampling strategies from the `Agent`.  

#### Agent

A network daemon that listens for `Span`s sent over UDP which it batches and sends to the `Collector`.  
It abstracts the routing and discovery of the `Collector`s.  

#### Collector

Receives `Trace`s from `Agent`s and runs them through a processing pipeline. Currently our pipeline validates traces, indexes them, performs any transformations, and finally stores them.  

Jaeger’s storage is a pluggable component which currently supports `Cassandra`, `Elasticsearch` and `Kafka`.

#### Query

A service that retrieves `Trace`s from storage and hosts a UI to display them.  

#### Ingester

A service that reads from `Kafka` topic and writes to another storage backend (`Cassandra`, `Elasticsearch`).  
