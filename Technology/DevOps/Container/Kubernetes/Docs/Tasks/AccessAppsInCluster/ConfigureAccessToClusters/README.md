## [Configure Access to Multiple Clusters](https://kubernetes.io/docs/tasks/access-application-cluster/configure-access-multiple-clusters/)

Using `config` files with `cluster`, `user` and `context` definitions you can switch between Kubernetes with:
```
$: kubectl version

$: kubectl config use-context Context-Name
```

### Define cluster, user, and context triple

Kubernetes access can be configured to use:
* a certificate
* a username and password

```
$: kubectl config view  # list `config` all (cluster, use, context) triples
$: kubectl config view --minify  # list `current-context` (cluster, use, context) triple

$: kubectl config use-context Context-Name  # change `current-context` field
```

If certificates and keys are in base64:
* use `certificate-authority-data`, not `certificate-authority`
* use `client-certificate-data`, not `client-certificate`
* use `client-key-data`, not `client-key`

```
$: kubectl config set-cluster development --server=https://1.2.3.4 --certificate-authority=fake-ca-file
$: kubectl config set-cluster scratch --server=https://5.6.7.8 --insecure-skip-tls-verify

$: kubectl config set-credentials developer --client-certificate=fake-cert-file --client-key=fake-key-seefile
$: kubectl config set-credentials experimenter --username=exp --password=some-password

$: kubectl config set-context dev-frontend --cluster=development --namespace=frontend --user=developer
$: kubectl config set-context dev-storage --cluster=development --namespace=storage --user=developer
$: kubectl config set-context exp-scratch --cluster=scratch --namespace=default --user=experimenter

# Note: see the resulting `config` in config-dev-scr file
```

### Create a second configuration file

You can create a second `config` file and reference it with:
```
$: kubectl --kubeconfig=/path/to/Second-Kubectl-Config  # manipulate specific kubectl `config`
```

### Set the KUBECONFIG environment variable

TODO

### Explore the $HOME/.kube directory

TODO

### Append $HOME/.kube/config to your KUBECONFIG environment variable

TODO
