## [RBAC Configuration](https://argoproj.github.io/argo-cd/operator-manual/rbac/)

The RBAC restricts access to Argo CD resources.  
RBAC is configured after SSO or `Local User`s have been setup.  
SSO groups and `Local User`s can be mapped to RBAC.  

### Basic Built-in Roles

Pre-defined roles:
* `role:readonly`: read-only access
* `role:admin`: unrestricted access

See `builtin-policy.csv` in `Research/`.  

#### RBAC Permission Structure

Permissions definition:
* Resource (except applications) permissions:
    * `p, <role/user/group>, <resource>, <action>, <object>`
* Application permissions:
    * `p, <role/user/group>, <resource>, <action>, <appproject>/<object>`

#### RBAC Resources and Actions

Resources:
* `clusters`
* `projects`
* `applications`
* `repositories`
* `certificates`

Actions:
* `get`
* `create`
* `update`
* `delete`
* `sync`
* `override`
* `action`

### Tying It All Together

See `argocd-rbac-cm` in `Research/`.  

### Anonymous Access

`users.anonymous.enabled` in `argocd-cm.yaml`.  
