## [Custom Resource Definitions](https://helm.sh/docs/topics/chart_best_practices/custom_resource_definitions/)

`Custom Resource Definitions` (CRDs)s are:
* declared with a YAML file of `CustomResourceDefinition` `kind`
* used by other YAML files

If CRD defines `foo.example.com/v1` then `apiVersion: example.com/v1` and `kind: Foo` are used

### Install a CRD Declaration Before Using the Resource

CRD declarations must be registered before they are used.  

#### Method 1: Let helm Do It For You

Helm 3 removed `crd-install` hooks.  
Use a `crds/` `Chart` directory instead.  

You cannot upgrade or delete CRDs!  

#### Method 2: Separate Charts

Put CRD definition in one `Chart`, and any resources that use it in another.
