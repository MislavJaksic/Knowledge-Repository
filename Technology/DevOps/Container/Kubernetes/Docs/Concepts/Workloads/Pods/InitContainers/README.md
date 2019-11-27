## [Init Containers](https://kubernetes.io/docs/concepts/workloads/pods/init-containers/)

`Init Container`s run before app `Container`s in a `Pod`.  

TODO

### Understanding init containers

### Using init containers

#### Examples

Ideas for how to use `Init Container`:
* wait for a Service to be created
* register a `Pod` with a remote server from the `Downward API`
* wait before starting the app container
* clone a Git repository into a `Volume`
* inject values into a config file and run a template tool to dynamically generate a config file for the main app container

### Detailed behavior
