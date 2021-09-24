### [Architecture](https://flink.apache.org/flink-architecture.html)

Stateful computations over data streams. 

#### Bounded and Unbounded

Simple.  

#### Deploy Apps Anywhere

Flink integrates with all common cluster resource managers:
* Hadoop YARN
* Apache mesos
* Kubernetes
* Stand-alone Flink also exists

Flink applications request resources from resource managers.  

#### Run Applications at any Scale

Designed to run stateful streaming applications in a distributed environment and conncurrently.

#### Leverage In-Memory Perofmrance

Optimized for local state access.  
Garantees exactly-once state consistency thanks to aynchhronious checkpointing the local state to durable storage.  
