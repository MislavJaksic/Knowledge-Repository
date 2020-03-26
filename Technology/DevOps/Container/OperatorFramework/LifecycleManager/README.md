## [Operator Lifecycle Manager (OLM)](https://github.com/operator-framework/operator-lifecycle-manager)

[Releases on GitHub](https://github.com/operator-framework/operator-lifecycle-manager/releases)

### Install OLM

#### Manual (causes errors on uninstall)

```
$: kubectl create -f crds.yaml  # see Research
$: kubectl create -f olm.yaml
```

#### Scripted (how do you uninstall it?)

```
$: curl -sL https://github.com/operator-framework/operator-lifecycle-manager/releases/download/0.14.1/install.sh | bash -s 0.14.1
```

### Install Operators

Visit [Operator Hub](https://operatorhub.io/).  
Pick an Operator.  
Click `Install` and copy-paste the install strings `2.` and `3.` .  

### Errors

```
$: kubectl api-resources  # ->
  # error: unable to retrieve the complete list of server APIs: packages.operators.coreos.com/v1: the server is currently unable to handle the request
```

```
$: kubectl get apiservices v1.packages.operators.coreos.com -o yaml  # ->
  # ...
  # message: service/v1-packages-operators-coreos-com in "olm" is not present
  # ...
```
Force delete the `Terminating` namespace.  
