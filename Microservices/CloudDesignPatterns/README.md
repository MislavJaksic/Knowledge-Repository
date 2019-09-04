## [Cloud Design Patterns](https://docs.microsoft.com/en-us/azure/architecture/patterns/)

### [Availability](https://docs.microsoft.com/en-us/azure/architecture/patterns/category/availability)

Proportion of time that the system is working, uptime.  

Throttling: control the consumption of resources.  

### [Data Management](https://docs.microsoft.com/en-us/azure/architecture/patterns/category/data-management)

Data is in different locations for reasons such as performance, scalability or availability. Consistency is the problem.  

Cache-aside: load data into a cache from a data store.  

Sharding: divide a data store into a set of horizontal partitions.  

### [Design and Implementation](https://docs.microsoft.com/en-us/azure/architecture/patterns/category/design-implementation)

Consistency, coherence, deployment, maintainability, administration and reusability are all effected by design.  

Backends for Frontends: create separate backend services to be consumed by specific frontend applications.  

### [Messaging](https://docs.microsoft.com/en-us/azure/architecture/patterns/category/messaging)

Messaging infrastructure must connect loosely coupled services, maximize scalability and be as asynchronous as possible. Ordering of messages, poison message management, idempotency and many more are all difficult concepts to solve.

### [Management and Monitoring](https://docs.microsoft.com/en-us/azure/architecture/patterns/category/management-monitoring)

Management and monitoring must be able to fulfill business requirements and customization without requiring the app to be stopped or redeployed.

Priority Queue: prioritize requests sent to services so that requests with a higher priority are received and processed more quickly than those with a lower priority.  

Publisher/Subscriber: enable an application to announce events to multiple interested consumers asynchronously, without coupling the senders to the receivers.  

### [Performance and Scalability](https://docs.microsoft.com/en-us/azure/architecture/patterns/category/performance-scalability)

Performance is about responsiveness, while scalability is the ability to handle increases in load.

Cache-aside: load data into a cache from a data store.  

Priority Queue: prioritize requests sent to services so that requests with a higher priority are received and processed more quickly than those with a lower priority.  

Sharding: divide a data store into a set of horizontal partitions.  

Throttling: control the consumption of resources.  

### [Resiliency](https://docs.microsoft.com/en-us/azure/architecture/patterns/category/resiliency)

Ability to gracefully handle and recover from failures.  

Bulkhead: isolate elements of an application into pools so that if one fails, the others will continue to function.  

Circuit Breaker: handle faults that might take a variable amount of time to fix when connecting to a remote service or resource.  

Retry: enable an application to handle anticipated, temporary failures when it tries to connect to a service or network resource by transparently retrying an operation that's previously failed.  

### [Security](https://docs.microsoft.com/en-us/azure/architecture/patterns/category/security)

Capability to prevent malicious from effecting the system.  


