## [Deploy Tokens](https://docs.gitlab.com/ee/user/project/deploy_tokens/)

Allow without an username and password:
* `git clone`
* push and pull the container image registry

`Deploy Token`s require `Maintainer` permission or greater.

Alternative to [Deploy Keys](../../User/General/SSH).  

### Creating a Deploy Token

```
Select a repository -> Settings -> Repository -> Exapnd Deploy Tokens -> fill in name, date and username; pick scope -> Create Deploy Token
```

### Limiting scopes of a deploy token

| Scope            | Description                                                                                              |
|------------------|----------------------------------------------------------------------------------------------------------|
| read\_repository | Allows read\-access to the repository through `git clone`
                                                 |
| read\_registry   | Allows read\-access to container registry images if a project is private and authorization is required\. |
| write\_registry  | Allows write\-access \(push\) to container registry\.                                                    |

### Usage

### Git clone a repository

```
$: git clone https://Token-Username:Deploy-Token@path/to/git/file.git
```

### Container Registry images

```
$: docker login -u Token-Username -p Deploy-Token Registry-Hostname
```

### Group Deploy Token

TODO

### GitLab Deploy Token

If token name is `gitlab-deploy-token`.  

`Deploy Token`'s username and password are exposed to CI/CD jobs as ENV VAR `CI_DEPLOY_USER` and `CI_DEPLOY_PASSWORD`.  
`read_registry` and `write_registry` scopes are implied.  

```
$: docker login -u $CI_DEPLOY_USER -p $CI_DEPLOY_PASSWORD $CI_REGISTRY
```
