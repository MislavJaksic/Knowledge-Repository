## [9 Kubernetes Security Best Practices Everyone Must Follow](https://www.cncf.io/blog/2019/01/14/9-kubernetes-security-best-practices-everyone-must-follow/)

### Upgrade to the Latest Version

Upgrade once per quarter in sync with Kubernetes quarterly updates.  

### Enable Role-Based Access Control (RBAC)

On by default from 1.6+.  
Use `Namespace`, not cluster-wide permissions.  
Avoid giving admin privileges.  
Give the smallest set of permissions needed.  

```
$: kubectl get clusterrolebinding --all-namespaces
$: kubectl get rolebinding --all-namespaces
```

### Use Namespaces to Establish Security Boundaries

Create `Namespace`s for each set of components.  

### Separate Sensitive Workloads

`Pod`s can be access from a compromised `Node`.  
Avoid running a workload on many `Node`s and stay clear of other sensitive workloads.  
Make use of `NodePool`s, `Namespace`s, `Taint`s and `Toleration`s.  

### Secure Cloud Metadata Access

Conceal Kubernetes metadata using GKE’s metadata concealment feature or a similar mechanism.  

### Create and Define Cluster Network Policies

`NetworkPolicy` controls network access.  

### Run a Cluster-wide Pod Security Policy

`PodSecurityPolicy` admission controller sets defaults for how workloads are allowed to run.   

### Harden Node Security

Three steps:
* Ensure the host is secure and configured correctly by using a `CIS Benchmark`
* Control network access to sensitive ports like 10250 and 10255
* Minimize administrative access to Kubernetes `Node`s, even for debugging purposes

### Turn on Audit Logging

Enable audit logs and monitor API calls. Pay attention to the `Forbidden` status message.  
