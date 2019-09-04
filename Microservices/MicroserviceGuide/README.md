## [Microservices Guide](https://martinfowler.com/microservices/)

### [Microservices](https://martinfowler.com/articles/microservices.html)

```
Microservice architecture - a suite of small services each running in their own process communicating with HTTP
Service - built around business capabilities, automatic deployment and decentralized management using a variety of tools
Monolith - has a client-side, a server-side and a database; any change to the server-side app requires total redeployment; not modular; can scale everything or nothing
Microservice - deployable, scalable, modular, built in a variety of languages, managed by different teams
```

#### Characteristics of a Microservice Architecture

```
Component - a unit of software that is independently replaceable and upgradeable
Library - component that is linked into a program and called using in-memory function calls
Service - component who communicates with HTTP request-response or a binary protocol
Service over library - easier redeployment, explicit interface, but expensive API calls and high risk of failure

Conway's law - software design mirrors organisational structure
Organize around business capabilities - cross-functional teams over specialist teams; each team has a variety of skills

Product over project - you build it, you run it; development and operations are one and the same

Smart endpoint - decoupled and cohesive service; service acts like a function
Dumb pipe - HTTP request-response and binary protocol; message bus such as RabbitMQ; coarse grain communication is required because fine grained will flood the network

Decentralized governance - technological variety; develop tools and share them; consumer driven contract pattern; you build it, you run it

Decentralized data management - data is seen from different points of view; domain driven design; use a variety of storage solutions; accept eventual consistency

Infrastructure automation - CIDC is a must; automate testing; requires skillful operations team

Design for failure - need high robustness; emergent, unexpected behaviour; circuit breaker pattern

Evolutionary design - replacement and upgradeability; modular design
```