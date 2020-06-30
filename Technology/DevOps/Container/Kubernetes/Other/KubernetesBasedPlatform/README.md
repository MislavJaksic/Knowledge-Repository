## [Building a Kubernetes-Based Platform: Progressive Delivery, the Edge, and Observability](https://www.getambassador.io/resources/building-kubernetes-based-platform/)

`Cloud Native Computing Foundation` (CNCF) stewards `Kubernetes`.  

Capabilities of a cloud native platform:
* `Progressive Delivery` using `Continuous Delivery` pipelines
* `Edge Management` using an edge stack
* `Observability` using an observability stack

### Kubernetes

`Container` is a standard unit, `artifact`, of cloud deployment.  
`Container`:
* requires less resources to run than a VM
* manifests, `Dockerfile`, abstract configuration
* is easily assembled, shared and searched via `Container Registry`s

`Container`s don't operate themselves, like restarting or rescheduling.  

#### Control Loops and Shared Abstractions

`Kubernetes` orchestrates `Container`s.  
Developers define `Liveness Probe`s, `Readiness Probe`s and resource requirements.  
`Kubernetes` matches the state of the cluster to the defined specification.  
Operators can define global access and deployment policies using `role-based access control` (RBAC) and `Admission Webhook`s.  

`Kubernetes` abstractions:
* the `Container` is the unit of deployment
* the `Pod` is the component of runtime configuration
* the `Service` is the business-focused component

#### Kubernetes-as-a-Service or Self-Hosted

Hosted offering:
* `Google GKE`
* `Amazon EKS`
* `Azure AKS`

Or go self-manage with `kops` and `kubeadm`.  

What distribution of Kubernetes is right for you?
`Red Hat`? `Rancher`? `Pivotal`?

#### Avoiding Platform Antipatterns

Threats:
* siloed ownership
* micro-platforming
* slow feedback loop

Use local-to-remote development tools:
* [Telepresence](https://www.telepresence.io/)
* [Skaffold](https://skaffold.dev/)
* [Garden](https://garden.io/)

### Continuous Delivery Pipelines

Iterating faster provides a competitive advantage.  

#### Improving the Feedback Loops

`Progressive Delivery` extends the approach of `Continuous Delivery`.  
It takes advantage of traffic control and `Observability`.  
Developers must be able to define, modify and maintain pipelines that codify all of the build, quality and security assertions.  

#### Evolving an Organisation’s Approach to Continuous Delivery

Jenkins X is Jenkins that supports Kubernetes natively.  
Jenkins X supports `Progressive Delivery`.  

#### Avoiding Platform Antipatterns

Threats:
* siloed ownership
* one-size fits all
* slow feedback loop

Platform teams can work with development teams to provide code build-packs and templates.  

### The Edge Stack

Kubernetes cluster edge:
* control the release
* ensure security and reliability
* assist with onboarding

#### Separate Release from Deployment

`Continuous Delivery` pipeline handles the build, verification and deployment.  
Release is when end users experience a change.  

Use dark launches and canary releases.  

#### Scaling Edge Operations with Self-Service

Scale and support multiple architectures.  

#### Avoiding Platform Antipatterns

Threats:
* expose every service with SOAP or REST
* ticket based problem solving

Make use of `WebSockets`, `gRPC`, and `CloudEvents`.  
Centralize authentication and authorization.  

### The Observability Stack

`Observability` is a measure of how well internal states of a system can be inferred from knowledge of its external outputs.  
`Observability` tools include monitoring, logging and tracing.

`Service Level Indicator`s (SLI) shows system consumers the health of a system.  
Goals of `Observability`:
* improve SLI
* restore SLI

`Observability` stack must provide:
* detection, precisely measure SLIs
* refinement, reduce root cause search space

#### Understandability, Auditability and Debuggability

Users won't trust a system they don't understand.  
You must prove or disprove a system acted incorrectly.  

#### Three Pillars of Observability: One Solution

Integrate monitoring, logging and distributed tracing.  

Monitoring: `Prometheus`, `statsd` protocol
Logging: `Elasticsearch`, `Logstash` and `Kibana` (ELK) stack; `Fluentd` in place of `Logstash`
Distributed tracing: `OpenZipkin`, `Jaegar`

#### Avoiding Platform Antipatterns

Threats:
* ticket based problem solving

Allow developers to service themselves.  
