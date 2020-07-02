## [Ambassador](https://www.getambassador.io/)

### Install

```
$: helm repo add datawire https://www.getambassador.io
$: helm repo update

# Note: if you see `manifest_sorter.go:175: info: skipping unknown hook: "crd-install"`, don't worry, it's not an error

$: kubectl create namespace K8s-Ambassador-Namespace
$: helm install ambassador --namespace K8s-Ambassador-Namespace datawire/ambassador -f config.yaml  # see Research

$: sudo curl -fL https://metriton.datawire.io/downloads/linux/edgectl -o /usr/local/bin/edgectl && sudo chmod a+x /usr/local/bin/edgectl
$: edgectl install
```

[Instructions](Docs/Install/OtherInstallAndUpgrade/KubernetesHelm)

### TLS and HTTPS

TODO

[Instructions](Docs\HOWTOGuides\TLS\TLSTermination)

### Filters and Authentication

[Filters and Authentication](Docs\RunAndUse\Using\FiltersAndAuthentication)  
[Keycloak SSO and Ambassador](Docs\HOWTOGuides\Authentication\SSOKeycloak)  

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

### Errors

`503: Service Unavailable`: check if the `spec.service` is correct  
Did you use `spec.rewrite` and changed the base URL? If not, search the system documentation for how to do it.  
