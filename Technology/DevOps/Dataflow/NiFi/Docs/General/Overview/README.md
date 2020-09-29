## Apache NiFi Overview

### What is Apache NiFi?

Automates the flow of data between systems.  

Challenges:
* Systems fail
* Data access exceeds capacity to consume
* Boundary conditions are mere suggestions
* What is noise one day becomes signal the next
* Systems evolve at different rates
* Compliance and security
* Continuous improvement occurs in production

Solutions on the rise:
* Service Oriented Architecture
* APIs
* Internet of Things
* Big Data

### The core concepts of NiFi

Similar to Flow Based Programming.  

| NiFi Term          | FBP Term           | Description                                                                                                                                                                                                                                                                                                                                                           |
|--------------------|--------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| FlowFile           | Information Packet | A FlowFile represents each object moving through the system and for each one, NiFi
keeps track of a map of key/value pair attribute strings and its associated
content of zero or more bytes\.                                                                                                                                                                        |
| FlowFile Processor | Black Box          | Processors actually perform the work\.  In Enterprise Integration Pattern terms a processor is
doing some combination of data routing, transformation, or mediation between
systems\.  Processors have access to attributes of a given FlowFile and its
content stream\.  Processors can operate on zero or more FlowFiles in a given unit of work
and either commit that work or rollback\. |
| Connection         | Bounded Buffer     | Connections provide the actual linkage between processors\.  These act as queues
and allow various processes to interact at differing rates\.  These queues
can be prioritized dynamically and can have upper bounds on load, which enable
back pressure\.                                                                                                            |
| Flow Controller    | Scheduler          | The Flow Controller maintains the knowledge of how processes connect
and manages the threads and allocations thereof which all processes use\.  The
Flow Controller acts as the broker facilitating the exchange of FlowFiles
between processors\.                                                                                                                    |
| Process Group      | subnet             | A Process Group is a specific set of processes and their connections, which can
receive data via input ports and send data out via output ports\.  In
this manner, process groups allow creation of entirely new components simply by
composition of other components\.                                                                                               |

Benefits:
* visual management of graphs
* asynchronous which allows for high throughput and buffering
* concurrent
* cohesive and loosely coupled components
* constrained connections make critical functions such as back-pressure and pressure release natural and intuitive
* fine grained error handling
* tracks data flow

### NiFi Architecture

Components:
* Web Server: hosst NiFi’s HTTP-based command and control API
* Flow Controller: provides threads for extensions to run on, and manages the schedule of when extensions receive resources to execute
* Extensions: operate and execute within the JVM
* FlowFile Repository: keeps track of the state of each FlowFile; default approach is a persistent Write-Ahead Log
* Content Repository: where FlowFiles live
* Provenance Repository: where provenance event data is stored

In a cluster:
* Zero-Leader Clustering
* nodes do the same work on different set of data
* Apache ZooKeeper elects a single node as the Cluster Coordinator and one as a Primary Node

### Performance Expectations and Characteristics of NiFi

TODO

### High Level Overview of Key NiFi Features

* Flow Management
    * Guaranteed Delivery
    * Data Buffering w/ Back Pressure and Pressure Release
    * Prioritized Queuing
    * Flow Specific QoS (latency v throughput, loss tolerance, etc.)
* Ease of Use
    * Visual Command and Control
    * Flow Templates
    * Data Provenance
    * Recovery / Recording a rolling buffer of fine-grained history
* Security
    * System to System
    * User to System
    * Multi-tenant Authorization
* Extensible Architecture
    * Extension
    * Classloader Isolation
    * Site-to-Site Communication Protocol
* Flexible Scaling Model
    * Scale-out (Clustering)
    * Scale-up & down
