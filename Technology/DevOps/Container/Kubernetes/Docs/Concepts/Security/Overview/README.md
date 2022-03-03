## [Overview of Cloud Native Security](https://kubernetes.io/docs/concepts/security/overview/)

The overview will construct a mental model for Cloud Native Security.  

### The 4C's of Cloud Native Security

Security in layers is known as Defense in Depth.  
The 4C's are:
* Cloud (outermost)
* Clusters
* Containers
* Code (innermost)

### Cloud

Must be secure if you are going to build anything on top of it.  
Each Cloud Provider has their own set of security recommendations.  

#### General Infrastructure Guidance Table

See a Recommendation for each Area of Concern.  

Areas of Concern:
* Network access to `API Server` (`Master`s): not public and restricted to a small set of IP addresses
* Network access to `Node`s (`Worker Servers`): not public, accepts connections from the `Master`s on the specified ports and from `NodePort` and `LoadBalancer` `Service`s
* Kubernetes access to Cloud Provider API:	follow the principle of least privilege
* Access to `etcd`: limit to the `Master`s only
* `etcd` Encryption: encrypt data at rest

### Cluster

#### Components of the Cluster

See [Securing a Cluster](../../../Tasks/AdministerCluster/SecuringCluster).  

#### Components in the Cluster (your application)

TODO: see all the different links!  
RBAC Authorization (Access to the Kubernetes API)	https://kubernetes.io/docs/reference/access-authn-authz/rbac/
Authentication	https://kubernetes.io/docs/reference/access-authn-authz/controlling-access/
Application secrets management (and encrypting them in etcd at rest)	https://kubernetes.io/docs/concepts/configuration/secret/
https://kubernetes.io/docs/tasks/administer-cluster/encrypt-data/
Pod Security Policies	https://kubernetes.io/docs/concepts/policy/pod-security-policy/
Quality of Service (and Cluster resource management)	https://kubernetes.io/docs/tasks/configure-pod-container/quality-service-pod/
Network Policies	https://kubernetes.io/docs/concepts/services-networking/network-policies/
TLS For Kubernetes Ingress	https://kubernetes.io/docs/concepts/services-networking/ingress/#tls

### Container

You must run code in a container.  

Areas of Concern:
* Container Vulnerability Scanning and OS Dependency Security: scan containers before deployment
* Image Signing and Enforcement: sign containers and enforce that only signed containers can run in the cluster
* Disallow privileged users	When constructing containers, consult your documentation for how to create users inside of the containers that have the least level of operating system privilege necessary in order to carry out the goal of the container.

[Clair](https://github.com/quay/clair)  
[Portieris](https://github.com/IBM/portieris)  

### Code

Areas of Concern:
* Access over TLS only: use TCP and mTLS
* Limiting port ranges of communication: only expose essential ports
* 3rd Party Dependency Security: scan dependencies for vulnerabilities
* Static Code Analysis: scan your codebases for common security errors
* Dynamic probing attacks: attack your own programs

[Linkerd](https://linkerd.io/)  
[Istio](https://istio.io/)  
[Source Code Analysis Tools](https://owasp.org/www-community/Source_Code_Analysis_Tools)  
[OWASP Zed Attack](https://owasp.org/www-project-zap/)

### Robust automation

Consider [Continuous Hacking](https://thenewstack.io/beyond-ci-cd-how-continuous-hacking-of-docker-containers-and-pipeline-driven-security-keeps-ygrene-secure/).  
