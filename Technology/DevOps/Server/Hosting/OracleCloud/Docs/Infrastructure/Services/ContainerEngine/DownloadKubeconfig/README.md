## [Downloading a Kubeconfig File to Enable Cluster Access](https://docs.cloud.oracle.com/en-us/iaas/Content/ContEng/Tasks/contengdownloadkubeconfigfile.htm#DownloadingaKubeconfigFiletoEnableClusterAccess)

`kubeconfig` file allows access to Kubernetes.  

### Step 1: Generate an API signing key pair

[Instructions](../../../DeveloperResources/ToolsConfiguration/KeysAndOCIDs)

### Step 2: Upload the public key of the API signing key pair

[Instructions](../../../DeveloperResources/ToolsConfiguration/KeysAndOCIDs)

### Step 3: Install and configure the Oracle Cloud Infrastructure CLI

[Install Oracle CLI](../../../DeveloperResources/SDKAndCLI/CLI/Quickstart)

### Step 4: Download the kubeconfig file

```
Navigation menu -> Solutions and Platform -> Developer Services -> Container Clusters -> Compartment -> select a cluster -> Access Cluster
```

```
# Note: merge or create a `kubeconfig` file
$: oci ce cluster create-kubeconfig --cluster-id Very-Long-String --file $HOME/.kube/config --region Region-Name --token-version 2.0.0
```

### Step 5: Verify that kubectl is available

```
$: kubectl version
```

### Notes about kubeconfig Files

`kubeconfig` file:
* has many contexts
* includes Oracle tokens
* are not `ServiceAccount` tokens (e.g. used in CICD)
