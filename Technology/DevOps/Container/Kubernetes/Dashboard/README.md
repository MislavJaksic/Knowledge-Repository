## [Kubernetes Dashboard](https://github.com/kubernetes/dashboard)

### Install

```
# Note: install Kubernetes and configure kubectl

$: kubectl apply -f https://raw.githubusercontent.com/kubernetes/dashboard/v2.0.0-rc6/aio/deploy/recommended.yaml  # deploy dashboard
```

### Connect

#### Using kubectl proxy

```
$: kubectl proxy
```

```
http://localhost:8001/api/v1/namespaces/kube-system/services/https:kubernetes-dashboard:/proxy/#!/login
```

#### Using a certificate

```
# Note: find kubectl config file on a remote machine

$: grep 'client-certificate-data' /path/to/config | head -n 1 | awk '{print $2}' | base64 -d >> kubecfg.crt
$: grep 'client-key-data' /path/to/config | head -n 1 | awk '{print $2}' | base64 -d >> kubecfg.key
$: openssl pkcs12 -export -clcerts -inkey kubecfg.key -in kubecfg.crt -out kubecfg.p12

$: sudo scp -i Private-Key.key _username@_ip:/path/to/kubecfg.p12 .
```

Import the `kubecfg.p12` certificate into your browser.  

```
https://Kubectl-Server-IP:Kubectl-Server-Port/api/v1/namespaces/kubernetes-dashboard/services/https:kubernetes-dashboard:/proxy/#!/login
```

[Instructions](Other/RemoteKubernetesDashboard)

### Create a Bearer token

```
$: kubectl apply -f cluster-binding-adminuser.yaml  # see Research
$: kubectl apply -f service-account-adminuser.yaml

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

[Instructions](Docs/UserGuide/AccessControl)
