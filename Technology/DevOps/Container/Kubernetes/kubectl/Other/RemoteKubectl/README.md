## [Using kubectl to Control a Remote Kubernetes](https://imti.co/kubectl-remote/)

```
# Note: kubectl `config` location: `~/.kube/config`
# Note: installing minikube will create the directory

$: kubectl config view  # list `config`
$: kubectl config view --minify  # list `current-context`

$: kubectl config use-context Context-Name  # change `current-context` field
$: kubectl --kubeconfig=/path/to/config  # manipulate specific kubectl `config`

# Note: each `config` can have multiple `context`s
```

### Add a new Cluster, User and Context

Access can be further restricted to certain `Namespace`s.  

```
# Note: use `*.crt` and `*.key` file or plaintext string commands
# Note: the `*-data` suffix

$: kubectl config set-cluster Remote-Cluster --server https://Remote-Ip:Remote-Port --certificate-authority-data=Long-Ca-String
$: kubectl config set-cluster Remote-Cluster --server https://Remote-Ip:Remote-Port --certificate-authority=/path/to/Remote-Ca.crt

$: kubectl config set-credentials Remote-User --client-certificate-data=Long-User-Crt-String --client-key-data=Long-User-Key-String
$: kubectl config set-credentials Remote-User --client-certificate=/path/to/Remote-User-Crt.crt --client-key=/path/to/Remote-User-Key.key

$: kubectl config set-context Remote-Context --cluster=Remote-Cluster --user=Remote-User
```
