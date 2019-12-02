## [Access control](https://github.com/kubernetes/dashboard/blob/master/docs/user/access-control/README.md)

TODO

## [Creating sample user](https://github.com/kubernetes/dashboard/blob/master/docs/user/access-control/creating-sample-user.md)

### Create Service Account

```
$: kubectl get serviceaccounts --kubernetes-dashboard kubernetes-dashboard admin-user

$: kubectl apply -f service-account-adminuser.yaml
```

### Create ClusterRoleBinding

```
$: kubectl get clusterrolebindings admin-user

$: kubectl apply -f cluster-binding-adminuser.yaml
```

### Bearer Token

```
$: kubectl -n kubernetes-dashboard describe secret $(kubectl -n kubernetes-dashboard get secret | grep admin-user | awk '{print $1}')  # ->
  # Name:         admin-user-token-ID
  # Namespace:    kubernetes-dashboard
  # Labels:       <none>
  # Annotations:  kubernetes.io/service-account.name: admin-user
  #               kubernetes.io/service-account.uid:  ...
  # Type:  kubernetes.io/service-account-token
  # Data
  # ====
  # ca.crt:     X bytes
  # namespace:  Y bytes
  # token:      Bearer-Token
```

Use the `Bearer-Token` to log in to the Kubernetes Dashboard.  
