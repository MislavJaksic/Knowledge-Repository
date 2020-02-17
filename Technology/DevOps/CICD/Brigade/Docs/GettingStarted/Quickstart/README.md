## [Brigade Quickstart](https://docs.brigade.sh/intro/quickstart/)

### Install Brigade

```
$: helm repo add brigade https://brigadecore.github.io/charts
$: helm install brigade brigade/brigade -n K8s-Cicd-Namespace

# Note: genericGateway.enabled=true if activating Generic Gateway
```

### Install brig

See [releases](https://github.com/brigadecore/brigade/releases/) for each:
* OS
* Brigade version

```
$: wget -O brig https://github.com/brigadecore/brigade/releases/download/v1.2.1/brig-linux-amd64
$: chmod +x brig
$: mv brig /bin
```

### Using Brigade with a Version Control System

#### Creating A New Project - using a Version Control System

```
$: brig project create -n K8s-Cicd-Namespace  #->
  # ... just press `Enter`
  # Project ID: Very-Long-Project-Id-String
```

```
$: brig project list -n K8s-Cicd-Namespace  #->
  # NAME            ID                           REPO
  # Project-Name    Very-Long-Project-Id-String  ...
```

#### Creating Your First Brigade Build

Brigade `Build` instructions are written in `JavaScript`.  
Think of them as jobs/tasks/pipelines.  

```
const { events, Job } = require("brigadier");     const { events, Job } = require("brigadier");
events.on("exec", () => {                         events.on("Event-Name", () => {
  var job = new Job("do-nothing", "alpine:3.8");    var job = new Job("Pod-Name", "Image-Name");
  job.tasks = [                                     job.tasks = [
    "echo Hello",                                     ... work ...
    "echo World"                                      ... work ...
  ];                                                ];
  job.run();                                        job.run();
});                                               });
```

#### Running a Build

```
$: brig run Project-Name -f Brigade-Js -n K8s-Cicd-Namespace
```

```
$: brig build list -n K8s-Cicd-Namespace  #->
  # ID     TYPE    PROVIDER       PROJECT                        STATUS    AGE
  # ...    exec    brigade-cli    Very-Long-Project-Id-String    ...       ...
```

Uses `git-sidecar` as its `initContainer`. `git-sidecar` pulled the source code from the master branch and stored it in an `emptyDir` `Volume`.  
If using a private repo answer `Yes` to `Configure GitHub Access?`.  
Brigade listens to events (and triggers `Build`s) from `VCS` via a `Gateway` (`GitHub`, `GitLab`, `BitBucket`).  

### Using Brigade with Generic Gateway (no Version Control System)

TODO

### Kashti

`Kashti` dashboard for Brigade `Build`s.  

```
$: kubectl port-forward service/brigade-kashti 8000:80 -n K8s-Cicd-Namespace
```

```
http://localhost:8000/
```

### Vacuum

`Vacuum` cleans up `Build`s: `Secret`s and `Pod`s.  
Default `Helm Chart` values:
* clean up every hour
* delete those older then 30 days (720 hours)

### Cleanup

```
$: helm uninstall brigade -n K8s-Cicd-Namespace
```
