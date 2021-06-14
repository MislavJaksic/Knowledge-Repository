## [Project import/export](https://docs.gitlab.com/ee/user/project/settings/import_export.html)

### Important notes

* Importing GitLab version must be greater than or equal to the Exporting GitLab version

### Between Community Edition (CE) and Enterprise Edition (EE)

You may lose data if importing a EE project to CE.  

### Exported contents

The following items are exported:
* Project and wiki repositories
* Project uploads
* Project configuration, excluding integrations
* Issues with comments, merge requests with diffs and comments, labels, milestones, snippets, time tracking, and other project entities
* Design Management files and data
* LFS objects
* Issue boards
* Pipelines history
* Push Rules
* Awards

The following items are not exported:
* Build traces and artifacts
* Container registry images
* CI/CD variables
* Webhooks
* Any encrypted tokens
* Merge Request Approvers

### Exporting a project and its data

Done by maintainers or owners.  

```
Settings -> General -> Advanced -> Export
```

### Importing the project

```
New Project -> Import project -> select export type -> follow instructions ...
```
