## [Chart Development Tips and Tricks](https://helm.sh/docs/howto/charts_tips_and_tricks/)

### Know Your Template Functions

Helm uses [Go templates](https://pkg.go.dev/text/template) and [Sprig library](https://masterminds.github.io/sprig/) templates.

Special template functions:
* include: call another Template and pass the results
* required: fails the Chart if a value is not provided

### Quote Strings, Don't Quote Integers

This remark does not apply to ENV VARs values which are expected to be string, even if they represent integers.

### Using the `include` Function

ToDo

### Using the `required` function

ToDo

### Using the `tpl` Function

The `tpl` evaluates strings as templates inside a template. It will pass a template string as a value to a Chart!

### Creating Image Pull Secrets

See Research.  

### Automatically Roll Deployments

```
kind: Deployment
spec:
  template:
    metadata:
      annotations:
        checksum/config: {{ include (print $.Template.BasePath "/configmap.yaml") . | sha256sum }}  # checks if an external file changed; if it did, roll the Pod
[...]
```

```
kind: Deployment
spec:
  template:
    metadata:
      annotations:
        rollme: {{ randAlphaNum 5 | quote }}  # always rolls the Pod
[...]
```

### Tell Helm Not To Uninstall a Resource

```
kind: Secret
metadata:
  annotations:
    "helm.sh/resource-policy": keep  # WARNING! This resource is now orphaned will may cause problems in the future!!!
[...]
```

### Using "Partials" and Template Includes

Helper templates and partials are placed in a `_helpers.tpl` file.

### Complex Charts with Many Dependencies

Create a top-level umbrella chart that exposes the global configurations, and then use the `charts/` subdirectory to embed each of the components.

### YAML is a Superset of JSON

Pick which one works best for you.  

### Be Careful with Generating Random Values

There are functions in Helm that allow you to generate random data.  
During upgrades, templates are re-executed.  
When a template run generates data that differs from the last run, that will trigger an update of that resource.  

### Install or Upgrade a Release with One Command

Install or upgrade `helm upgrade --install Release-Name --values values.yaml Chart-Dir`.  
