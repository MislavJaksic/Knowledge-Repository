## [Kubernetes Dashboard is forbidden](https://www.australtech.net/kubernetes-unable-to-login-to-the-dashboard/)

```
# Note: response to URL https://Kubectl-Server-IP:Kubectl-Server-Port/api/v1/namespaces/kubernetes-dashboard/services/https:kubernetes-dashboard:/proxy/#!/login
{
  "kind": "Status",
  "apiVersion": "v1",
  "metadata": {

  },
  "status": "Failure",
  "message": "services \"https:kubernetes-dashboard:\" is forbidden: User \"system:anonymous\" cannot get resource \"services/proxy\" in API group \"\" in the namespace \"kube-system\"",
  "reason": "Forbidden",
  "details": {
    "name": "https:kubernetes-dashboard:",
    "kind": "services"
  },
  "code": 403
}
```

```
# Note: verify that the Dashboard is running
$: kubectl -n kube-system get pod  # ->
  # ...
```

```
# Note: verify that `kubectl` can access Kubernetes locally
$: kubectl cluster-info
```

```
# Note: locate your kubeconfig or config file
# Note: most likely locations are `~/.kube/config`, `/home/ubuntu/.kube`, `/etc/kubernetes/# admin.conf`, ...

$: grep 'client-certificate-data' ~/.kube/config | head -n 1 | awk '{print $2}' | base64 -d >> kubecfg.crt
$: grep 'client-key-data' ~/.kube/config | head -n 1 | awk '{print $2}' | base64 -d >> kubecfg.key
$: openssl pkcs12 -export -clcerts -inkey kubecfg.key -in kubecfg.crt -out kubecfg.p12
```

```
# Note: get `Kubernetes-Certificate.p12` and `.kube/config` from remote machine
$: scp -i Private-Key.key _username@_ip:/path/to/.kube/kubecfg.p12 .
$: scp -i Private-Key.key _username@_ip:/path/to/.kube/config .
```

Import the `Kubernetes-Certificate.p12` into your browser.  

```
# Note: visit https://_ip:_port/api/v1/namespaces/kubernetes-dashboard/services/https:kubernetes-dashboard:/proxy/#!/login
# Note: login using Kubeconfig
```

To log in using a Bearer Token see [instruction](../DashboardDocs/UserGuide/AccessControl).

## [Kubernetes Dashboard. Installation Deep Dive](http://www.joseluisgomez.com/containers/kubernetes-dashboard/)

TODO

## [Installing the Kubernetes web-based dashboard](https://www.ibm.com/support/knowledgecenter/en/SSYGQH_6.0.0/admin/install/cp_prereqs_dashboards_kubernetes.html)

TODO
