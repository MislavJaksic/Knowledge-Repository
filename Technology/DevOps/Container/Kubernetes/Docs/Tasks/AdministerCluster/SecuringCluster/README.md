## [Securing a Cluster](https://kubernetes.io/docs/tasks/administer-cluster/securing-a-cluster/)

### Controlling access to the Kubernetes API

As Kubernetes is API driven.  
API access control is the first line of defense.  

#### Use Transport Layer Security (TLS) for all API traffic

Encrypted by default with TLS.  

#### API Authentication

Pick an access pattern:
* static Bearer token
* OICD or LDAP server
* or something entirely different

#### API Authorization

Role-Based Access Control (RBAC) combines verbs (`get`, `create`, `delete`) with resources (`Pod`s, `Service`s, `Node`s) and can be `Namespace` scoped.  

Use the `Node` and `RBAC` authorizers together in combination with the `NodeRestriction` admission plugin.  

### Controlling access to the Kubelet

Enable `Kubelet` authentication and authorization.  

### Controlling the capabilities of a workload or user at runtime

Policies are amore powerful control mechanism.  

#### Limiting resource usage on a cluster

`ResourceQuota` limits `Namespace` resources.  
`LimitRange` restrict the maximum or minimum size of some of the resources or provide default values.  

#### Controlling what privileges containers run with

`PodSecurityPolicy` limits security context settings.  

#### Preventing containers from loading unwanted kernel modules

The Linux kernel automatically loads kernel modules.  
Prevent it by using `/etc/modprobe.d/kubernetes-blacklist.conf`.  

#### Restricting network access

`NetworkPolicy` restricts communication between `Namespace`s.  

#### Restricting cloud metadata API access

Cloud platforms (`AWS`, `Azure`, `GCE`, ...) expose metadata to instances.  
Limit permissions given to instance credentials, use a `NetworkPolicy` and avoid using provisioning data to deliver secrets.  

#### Controlling which nodes pods may access

Control `Pod` placement using `nodeSelectors`, `Taint`s and `Toleration`s.  

### Protecting cluster components from compromise

#### Restrict access to etcd

Isolate the `etcd` so that only the `API Server`s may access it.

#### Enable audit logging

Enable audit logger.  

#### Restrict access to alpha or beta features

Alpha and beta features may have security vulnerabilities.  

#### Rotate infrastructure credentials frequently

The shorter the lifetime of a credential the better.  

#### Review third party integrations before enabling them

Integrations may alter the security profile of your cluster.  
Be doubely careful if they live in the `kube-system` `Namespace` or create `Pod`s.  

#### Encrypt secrets at rest

Encryption data in `etcd` at rest.  
