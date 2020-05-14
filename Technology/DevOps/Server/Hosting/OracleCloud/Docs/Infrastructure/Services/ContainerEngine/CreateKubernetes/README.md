## [Creating a Kubernetes Cluster](https://docs.cloud.oracle.com/en-us/iaas/Content/ContEng/Tasks/contengcreatingclusterusingoke.htm#create-quick-cluster)

You can create a cluster only if:
* you belong to the tenancy's Administrators group
* you belong to a group to which a policy grants the `CLUSTER_MANAGE` permission

### Using the Console to create a 'Quick Cluster' with Default Settings

```
Console -> Navigation menu -> Solutions and Platform -> Developer Services -> Container Clusters -> Compartment -> Cluster List -> Create Cluster -> Create Cluster Solution -> Quick Create -> Launch Workflow -> Create Cluster
```

Fill out:
* Name
* Compartment
* Kubernetes Version: 1.13.x, 1.14.x, 1.15.x as of 16.03.2020.
* Visibility Type: public or private regional subnet to host worker nodes
* Shape
* Number of Nodes

Under Advanced Options:
* Public SSH Key
* Kubernetes Labels

Activate Add Ons:
* `Kubernetes Dashboard`: disable! Its version is ancient
* `Tiller` (for `Helm` 2.x): disable! Use `Helm` 3.x

```
Next -> Submit -> scroll to bottom -> Close
```

Cluster will have a `Creating` status. Wait until it changes to `Active`.  
[Get a kubeconfig file and access the cluster](../DownloadKubeconfig)  

### Using the Console to create a 'Custom Cluster' with Explicitly Defined Settings

TODO

### Using the API

TODO
