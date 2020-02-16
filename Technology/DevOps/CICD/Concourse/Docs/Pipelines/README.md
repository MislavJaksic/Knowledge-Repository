## [Pipelines](https://concourse-ci.org/pipelines.html)

`Pipeline` is a configured set of `Job`s and `Resource`s.  
`Pipeline`s detect resource versions and queue new builds for jobs.  

```
jobs:
  ..
resources:
  ...
resource_types:
  ...
groups:
  ...
```

### Setting Pipelines

Pipelines are configured entirely via the `fly` CLI.  
There is no GUI.  

#### fly set-pipeline

```
$: fly --target Target-Name set-pipeline --pipeline Pipeline-Name --config pipeline.yml
```

#### Pipeline ((vars))

Template variables take the form of `((foo-bar))`.   
Template variables are replaced with values from:
* `--var`
* `--yaml-var`
* `--load-vars-from`
* at runtime via a credential manager

Credentials are safe this way.  

```
resources:                                   
- name: private-repo                     $: fly --target Target-Name set-pipeline --pipeline Pipeline-Name \
  type: git                                  --config pipeline.yml --var "Repo-Key=$(cat id_rsa)"
  source:                                    
    uri: git@...                         $: fly --target Target-Name set-pipeline --pipeline Pipeline-Name \
    branch: master                           --config pipeline.yml --load-vars-from credentials.yml
    private_key: ((Repo-Key))        

private-repo-key: |
  -----BEGIN RSA PRIVATE KEY-----
  ...
  -----END RSA PRIVATE KEY-----
```

#### fly validate-pipeline

Validate a `Pipeline`.  

```
$: fly validate-pipeline --config pipeline.yml [--strict]
  # --strict: fail on warnings
```

#### fly format-pipeline

Format a `Pipeline` file.  

```
$: fly format-pipeline --config pipeline.yml  [--write]
  # --write: update file, don't print to stdout
```
