## [Charts](https://helm.sh/docs/topics/charts/)

`Chart`s describe a set of Kubernetes resources.  

### The Chart File Structure

```
Chart-Name/
  Chart.yaml          # Information about the chart
  LICENSE             # OPTIONAL: Chart license
  README.md           # OPTIONAL: README file
  values.yaml         # Chart's default configuration values
  values.schema.json  # OPTIONAL: values.yaml's JSON Schema
  charts/             # Dependency Charts
  crds/               # Custom Resource Definitions (CRDs)
  templates/          # These templatescombined with values generate Kubernetes resources
  templates/NOTES.txt # OPTIONAL: Usage notes
```

### The Chart.yaml File

```
apiVersion (required): v1 or v2
name (required): Chart name
version (required): SemVer 2 Chart version
kubeVersion: eg. ">= 1.13.0 < 1.14.0 || >= 1.14.1 < 1.15.0"
description: single-sentence description of this project
type: application or library
keywords:
  - Project-Keyword
home: project's home page URL
sources:
  - Source-Code-Url
dependencies:
  - name (required): Chart name
    version (required): Chart version
    repository (required): Repository link or local Repository name
    condition: enable Chart based on path in parent's values, only considers the first valid path
    tags: Chart labels
      - Tag-Name
    enabled: should Chart be loaded
    import-values:
      - child: Child-Value-Prefix
        parent: Parent-Value-Prefix
    alias: alternative Chart name
maintainers:
  - name (required): maintainer's name
    email: maintainer's email
    url: maintainer's URL
icon: URL to an SVG or PNG image to be used as an icon
appVersion: app version
deprecated: deprecates the Chart
```

#### Charts and Versioning

Every `Chart` must have a version number.  
A version must follow the `SemVer 2` standard: eg. 1.2.3.  

#### The `apiVersion` Field

`apiVersion` field is `v2` for Helm `Chart`s that require at least Helm 3.  

#### The `appVersion` Field

`appVersion` field is for app version information.  

#### The `kubeVersion` Field

`kubeVersion` field constrains supported Kubernetes versions.  

#### Deprecating Charts

`deprecated` field deprecates a `Chart` version.  
If the latest version is `deprecated` the whole `Chart` is deprecated.  

#### Chart Types

`type` field can be `application` or `library`.  
Default value `application` can be installed and operated.  
`library` `Chart` has no resource object and cannot be installed.  

### Chart LICENSE, README and NOTES

`LICENSE` contains the license for the `Chart`.  
`README` is formatted in Markdown and contains:
* `Chart` description: what does it provide?
* prerequisites or requirements
* `values.yaml`'s default values and options description
* information relevant to the installation or configuration

`templates/NOTES.txt` file is printed after installation and when viewing `Release` status.  

### Chart Dependencies

Managed through the `dependencies` field or in `charts/` directory.  

#### Managing Dependencies with the dependencies field

```
dependencies:
  - name (required): Chart name
    version (required): Chart version
    repository (required): Repository link or local Repository name
    condition: enable Chart based on path in parent's values, only considers the first valid path
    tags: Chart labels
      - Tag-Name
    enabled: should Chart be loaded
    import-values:
      - child: Child-Value-Prefix
        parent: Parent-Value-Prefix
    alias: alternative Chart name
```

```
$: helm dependency update Chart-Name  # download dependency Charts to charts/
```

##### Tags and Condition fields in dependencies

```
# parentchart/Chart.yaml                                        # parentchart/values.yaml

dependencies:                                                   subchart1:
      - name: subchart1                                           enabled: true
        repository: http://localhost:10191                      tags:
        version: 0.1.0                                            front-end: false
        condition: subchart1.enabled, global.subchart1.enabled    back-end: true
        tags:                                                   
          - front-end                                           
          - subchart1                                           

      - name: subchart2                                         
        repository: http://localhost:10191                      
        version: 0.1.0                                          
        condition: subchart2.enabled,global.subchart2.enabled   
        tags:                                                   
          - back-end                                            
          - subchart2                                           
```

All `Chart`s with the `tag` `front-end` are disabled.  
`subchart1.enabled` path evaluates to `true`. It overrides the `front-end` `tag` and `subchart1` is enabled.  

`subchart2` is enabled because` back-end` `tag` is `true`.  

```
$: helm install --set tags.front-end=true --set subchart2.enabled=false
```

Considerations:
* `condition`s override `tags`. The first condition path that exists wins and subsequent ones for that chart are ignored
* `tags` are evaluated as "if any of the chart’s tags are true then enable the chart"
* `tags` and `condition`s are set in the top parent’s values
* `tags` must be a top level key; `global`s and nested `tags` tables are not  supported

##### Importing Child Values via dependencies

```
# parent's Chart.yaml file              # subchart1's values.yaml file

dependencies:                           default:
  - name: subchart1                       data:
    repository: http://localhost:10191      myint: 999
    version: 0.1.0                          mybool: true
    ...                                 
    import-values:                      
      - child: default.data             
        parent: myimports               
```

```
# parent's values.yaml file  # parent's final values

myimports:                   myimports:
  myint: 0                     myint: 999
  mybool: false                mybool: true
  mystring: "helm rocks!"      mystring: "helm rocks!"
```

#### Managing Dependencies manually via the charts/ directory

Manually manage dependencies by copying `Chart`s into `charts/`.  
Use `helm pull`.  

#### Operational aspects of using dependencies

`helm install` and `helm upgrade` will:
* bundle all parent and dependency Kubernetes resources by type into a file
* sort resources in the file by type, then by name

### Templates and Values

Uses the `Go` templating language.  
Templates are stored in `templates/`.  
Template values are given either in `values.yaml` and overridden during `helm install`.  

#### Template Files

```
apiVersion: v1
kind: ReplicationController
metadata:
  name: deis-database
  namespace: deis
  labels:
    app.kubernetes.io/managed-by: {{ default "deis" .Values.managed }}
spec:
  replicas: 1
  ...
```

values.yaml:
```
managed: "by-me!"
```

#### Predefined Values

Access values using `.Values`.  
Pre-defined, non-overridable values:
* `Release.Name`: name of the `Release`
* `Release.Namespace`: namespace the chart was released to
* `Release.Service`: service that conducted the `Release`
* `Release.IsUpgrade`: `true` if the current operation is an upgrade or rollback
* `Release.IsInstall`: `true` if the current operation is an install
* `Chart`: contents of `Chart.yaml`, eg. `Chart.Version`, `Chart.Maintainers`
* `Files`: map-like object, has `{{ index .Files "file.name" }}`/`{{ .Files.Get name }}`/`{{ .Files.GetString name }}`/`{{ .Files.GetBytes }}`
* `Capabilities`: map-like, has `{{ .Capabilities.KubeVersion }}` and `{{ .Capabilities.APIVersions.Has "batch/v1" }}`

#### Values files

```
# values.yaml

managed: "deis"
```

Can be overridden by the user in `helm install`.  

#### Scope, Dependencies, and Values

`values.yaml` defines values for all `Chart`s.  
Parent `Chart` can access values of its dependencies.  
`global` values are avaiblable to all `Chart`s.  

```
title: "My WordPress Site"  # sent to the WordPress template
global:
  app: MyWordPress
mysql:
  max_connections: 100  # sent to MySQL
apache:
  port: 8080  # sent to Apache
```

#### Schema Files

`values.schema.json` file contains `values.yaml` schemas.  
`helm install`, `helm upgrade`, `helm lint` and `helm template` care about schemas.  

### Custom Resource Definitions (CRDs)

Place CRDs in `crds/`.  
CRDs are installed before any other resource.  
CRD files cannot be templated!  

### Using Helm to Manage Charts

```
$: helm create Chart-Name
$: helm lint Chart-Name
$: helm package Chart-Name
```

### Chart Repositories

A HTTP server.  
Helm doesn't manage them in any way.  

Has `index.yaml` that lists all of the packages supplied by the `Repository`.  
Clients access it using `helm repo`.  

### Chart Starter Packs

```
$: helm create Chart-Name --starter
```

In `$XDG_DATA_HOME/helm/starters`.  
Starter `Chart`'s:
* `Chart.yaml` will be overwritten
* documentation should be extensive
* `<CHARTNAME>` will be replaced
