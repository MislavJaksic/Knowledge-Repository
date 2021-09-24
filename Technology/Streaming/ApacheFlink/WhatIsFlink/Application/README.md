### [Applications](https://flink.apache.org/flink-applications.html)

#### Building Blocks for Streaming Applications

##### Streams

Types:
* bounded and unbounded
* real-time and recorded

##### State

Only applications that apply a transformation don't have a state.  
Applciation state is a first class citizen.  
Features:
* state primitives: values, maps, lists, ...
* state backends: stores state in custom beckends or [RocksBD](https://rocksdb.org/)
* exactly-once consistency: in case of failiure

##### Time

Event-time vs processing time.  
Features:
* event time model: based on event timestamps
* watermark support: trades latency and complteness
* late data handling: can reroute or side input or update a completed result
* processing time mode: based on wall-clock timestamps

#### Layered APIs

##### The ProcessFunctions

[ProcessFunctions](https://ci.apache.org/projects/flink/flink-docs-release-1.13/docs/dev/datastream/operators/process_function/):
* processes windowed groups of evetns or input streams
* modifies state and registers timers for callback functions

##### The DataStream API

[DataStream API]():
* windowing
* transformations
* enrich data though external sources
* based on map, reduce and aggregate

##### SQL & Table API

[SQL & Table API](https://ci.apache.org/projects/flink/flink-docs-release-1.13/docs/dev/table/overview/):
* designed for data analytics, data pipelining, and ETL applications

#### Libraries

* [Complex Event Processing (CEP)](https://ci.apache.org/projects/flink/flink-docs-release-1.13/docs/libs/cep/) for Pattern detection
* [DataSet API](https://ci.apache.org/projects/flink/flink-docs-release-1.13/docs/dev/dataset/overview/)for batch processing
* [Gelly](https://ci.apache.org/projects/flink/flink-docs-release-1.13/docs/libs/gelly/overview/) for scalable graph processing and analysis