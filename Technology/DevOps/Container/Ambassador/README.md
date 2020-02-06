## [Ambassador](https://www.getambassador.io/)

### Install

```
$: helm repo add datawire https://www.getambassador.io
$: helm repo update

$: kubectl create namespace ambassador
$: helm install ambassador --namespace ambassador datawire/ambassador -f config.yaml  # see Research
```

You should also install the `Edge Policy Console`.  

[Instructions](Docs/Install/OtherInstallAndUpgrade/KubernetesHelm)

### TLS and HTTPS

TODO

[Instructions](Docs/Guides/Security/EnablingHTTPS)

### Mapping Service Resource

```
apiVersion: getambassador.io/v2
kind: Mapping
metadata:
  name: Mapping-Name # REQUIRED
  namespace: K8s-Ambassador-Namespace
spec:
  prefix: /url/prefix/  # REQUIRED; https://Ambassador-Hostname/url/prefix/...
  service: 'Service-Name.Namespace:Port'  # REQUIRED; [Scheme://]Service-Name[.Namespace][:Port]
  rewrite: /url/rewrite/  # URL prefix for talking to the service; https://Service-Name.Namespace:Port/url/rewrite/...
```

[Instructions](Docs/References/ConfigK8sService/MappingsServices)
