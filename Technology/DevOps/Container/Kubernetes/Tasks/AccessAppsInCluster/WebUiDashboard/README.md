## [Web UI (Dashboard)](https://kubernetes.io/docs/tasks/access-application-cluster/web-ui-dashboard/)

### Deploy and access

The Kubernetes Dashboard UI is not deployed by default.  

#### Minikube

```
$: minikube dashboard  # enable dashboard add-on and open proxy in browser
```

#### Other

```
$: kubectl apply -f https://raw.githubusercontent.com/kubernetes/dashboard/v2.0.0-beta4/aio/deploy/recommended.yaml
```

[TODO] (https://github.com/kubernetes/dashboard/blob/master/docs/user/access-control/creating-sample-user.md)

```
$: kubectl proxy  #-> localhost:8001/api/v1/namespaces/kubernetes-dashboard/services/https:kubernetes-dashboard:/proxy/
```

### Deploying containerized applications

Dashboard lets you create Deployments and Services.  
Click "+: Create a new resource" in the upper-right corner.  

* From input - YAML or JSON text can specify a resource and namespace
* From file - YAML or JSON file can specify a resource and namespace
* From form - form listed below

```
App name* - add 'app' label to Deployment and Service
Container image* - URL of a public image on a registry (Docker Hub or Google Container Registry); must end with a colon
Number of pods* - target number of Pods
Service - internal or external Service to map an incoming Port to a target Port seen by the container

Description - an annotation to the Deployment
Labels - sample labels are: release, environment, tier, partition,  track, ...
Namespace - virtual clusters on the same physical cluster;  logically named groups
Image Pull Secret - private images require a secret name such as "new.image-pull.secret"
CPU and Memory - set limits
Run command - same as Docker's ENTRYPOINT; cannot be overridden
Run command arguments - same as Docker's CMD; can be overridden
Run as privileged? - if yes: as if it has root privileges
Environment variables - env var for use in the container: can refrence other env var with $(VAR_NAME)
```

### Using the Dashboard

<p align="center">
  <img width="600" src="images/dashboard.png" alt="Kubernetes Minikube dashboard"></a>
</p>

```
Cluster
Overview
Workloads
Discovery and Load Balancing
Config and Storage
Custom Resource Definitions
Settings
```

TODO
