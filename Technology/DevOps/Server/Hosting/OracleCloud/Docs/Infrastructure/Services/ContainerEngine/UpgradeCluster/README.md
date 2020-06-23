## [Upgrading Clusters to Newer Kubernetes Versions](https://docs.cloud.oracle.com/en-us/iaas/Content/ContEng/Concepts/contengaboutupgradingclusters.htm)

You need to upgrade both master and worker `Node`s.  

Initiate the upgrade manually.  
Master `Node`s cannot be downgraded.  
Master and worker `Node` versions must be within one minor version!  
Kubernetes `Dashboard` `Service` must be `ClusterIP`.  

## [Upgrading the Kubernetes Version on Master Nodes in a Cluster](https://docs.cloud.oracle.com/en-us/iaas/Content/ContEng/Tasks/contengupgradingk8smasternode.htm)

### Using the Console

```
Log In -> Console -> Navigation -> Solutions and Platform -> Developer Services -> Container Clusters -> Compartment -> pick a cluster -> Upgrade Cluster-> pick the new Kubernetes version
```

## [Upgrading the Kubernetes Version on Worker Nodes in a Cluster](https://docs.cloud.oracle.com/en-us/iaas/Content/ContEng/Tasks/contengupgradingk8sworkernode.htm)

Upgrade paths:
* in-place: modify the existing `Node` pool
* out-of-place: replace the old `Node` pool with a new pool

### In-Place

Steps:
* pick an old `Node`
* drain `Pod`s from a `Node`
* delete `Node`
* repeat!

```
Log In -> Console -> Navigation -> Solutions and Platform -> Developer Services -> Container Clusters -> Compartment -> pick a cluster -> Node Pool -> Edit
```

```
$: kubectl get nodes

# Note: repeat for every Node

$: kubectl drain Node-Name [--ignore-daemonsets] [--delete-local-data]

Node Pool -> Nodes -> select drained Node -> Instances -> Terminate
```
