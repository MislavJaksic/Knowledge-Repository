## [Starting the Kubernetes Dashboard](https://docs.cloud.oracle.com/en-us/iaas/Content/ContEng/Tasks/contengstartingk8sdashboard.htm)

[Download the `kubeconfig` file](../DownloadKubeconfig)

```
$: kubectl apply -f oke-admin-service-account.yaml  # see Research

$: kubectl -n kube-system describe secret $(kubectl -n kube-system get secret | grep oke-admin | awk '{print $1}')  # copy Bearer Token in `token:`
```

```
$: kubectl proxy
# Note: visit http://localhost:8001/api/v1/namespaces/kube-system/services/https:kubernetes-dashboard:/proxy/#!/login
```
