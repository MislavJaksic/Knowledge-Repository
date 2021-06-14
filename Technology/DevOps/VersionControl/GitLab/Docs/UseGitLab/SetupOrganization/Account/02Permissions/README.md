## [Permissions](https://docs.gitlab.com/ee/user/permissions.html)

Permissions allow users to perform actions.  

The highest permission level is used if a user is both in a group’s project and the project itself.  

On public and internal projects the Guest role is not enforced.

### [Permission principles](https://about.gitlab.com/handbook/product/#permissions-in-gitlab)

```
1. Guests are not active contributors in private projects. They can only see, and leave comments and issues.
2. Reporters are read-only contributors: they can't write to the repository, but can on issues.
3. Developers are direct contributors, and have access to everything to go from idea to production, unless something has been explicitly restricted (e.g. through branch protection).
4. Maintainers are super-developers: they are able to push to master, deploy to production. This role is often held by maintainers and engineering managers.
5. Admin-only features can only be found in /admin. Outside of that, admins are the same as the highest possible permission (owner).
6. Owners are essentially group-admins. They can give access to groups and have destructive capabilities.
```

### Project member permissions

```
(1): Guest users are able to perform this action on public and internal projects, but not private projects.
(2): Guest users can only view the confidential issues they created themselves
(3): If Public pipelines is enabled in Project Settings > CI/CD
(4): Not allowed for Guest, Reporter, Developer, Maintainer, or Owner. See Protected Branches.
```

| Action                                                           | Guest   | Reporter | Developer | Maintainer | Owner |
|------------------------------------------------------------------|---------|----------|-----------|------------|-------|
| Download project                                                 | ✓ \(1\) | ✓        | ✓         | ✓          | ✓     |
| Leave comments                                                   | ✓ \(1\) | ✓        | ✓         | ✓          | ✓     |
| View Insights charts
                                           | ✓       | ✓        | ✓         | ✓          | ✓     |
| View approved/blacklisted licenses
                             | ✓       | ✓        | ✓         | ✓          | ✓     |
| View License Compliance reports
                                | ✓ \(1\) | ✓        | ✓         | ✓          | ✓     |
| View Security reports
                                          | ✓ \(3\) | ✓        | ✓         | ✓          | ✓     |
| View Dependency list
                                           | ✓ \(1\) | ✓        | ✓         | ✓          | ✓     |
| View licenses in Dependency list
                               | ✓ \(1\) | ✓        | ✓         | ✓          | ✓     |
| View Design Management pages
                                   | ✓ \(1\) | ✓        | ✓         | ✓          | ✓     |
| View project code                                                | ✓ \(1\) | ✓        | ✓         | ✓          | ✓     |
| Pull project code                                                | ✓ \(1\) | ✓        | ✓         | ✓          | ✓     |
| View GitLab Pages protected by access control
                   | ✓       | ✓        | ✓         | ✓          | ✓     |
| View wiki pages                                                  | ✓ \(1\) | ✓        | ✓         | ✓          | ✓     |
| See a list of jobs                                               | ✓ \(3\) | ✓        | ✓         | ✓          | ✓     |
| See a job log                                                    | ✓ \(3\) | ✓        | ✓         | ✓          | ✓     |
| Download and browse job artifacts                                | ✓ \(3\) | ✓        | ✓         | ✓          | ✓     |
| Create new issue                                                 | ✓ \(1\) | ✓        | ✓         | ✓          | ✓     |
| See related issues                                               | ✓       | ✓        | ✓         | ✓          | ✓     |
| Create confidential issue                                        | ✓ \(1\) | ✓        | ✓         | ✓          | ✓     |
| View confidential issues                                         | \(2\)   | ✓        | ✓         | ✓          | ✓     |
| Assign issues                                                    |         | ✓        | ✓         | ✓          | ✓     |
| Label issues                                                     |         | ✓        | ✓         | ✓          | ✓     |
| Lock issue threads                                               |         | ✓        | ✓         | ✓          | ✓     |
| Manage issue tracker                                             |         | ✓        | ✓         | ✓          | ✓     |
| Manage related issues
                                          |         | ✓        | ✓         | ✓          | ✓     |
| Manage labels                                                    |         | ✓        | ✓         | ✓          | ✓     |
| Create code snippets                                             |         | ✓        | ✓         | ✓          | ✓     |
| See a commit status                                              |         | ✓        | ✓         | ✓          | ✓     |
| See a container registry                                         |         | ✓        | ✓         | ✓          | ✓     |
| See environments                                                 |         | ✓        | ✓         | ✓          | ✓     |
| See a list of merge requests                                     |         | ✓        | ✓         | ✓          | ✓     |
| View project statistics                                          |         | ✓        | ✓         | ✓          | ✓     |
| View Error Tracking list                                         |         | ✓        | ✓         | ✓          | ✓     |
| Pull from Conan repository, Maven repository, or NPM registry
  |         | ✓        | ✓         | ✓          | ✓     |
| Publish to Conan repository, Maven repository, or NPM registry
 |         |          | ✓         | ✓          | ✓     |
| Upload Design Management files
                                 |         |          | ✓         | ✓          | ✓     |
| Create new branches                                              |         |          | ✓         | ✓          | ✓     |
| Push to non\-protected branches                                  |         |          | ✓         | ✓          | ✓     |
| Force push to non\-protected branches                            |         |          | ✓         | ✓          | ✓     |
| Remove non\-protected branches                                   |         |          | ✓         | ✓          | ✓     |
| Create new merge request                                         |         |          | ✓         | ✓          | ✓     |
| Assign merge requests                                            |         |          | ✓         | ✓          | ✓     |
| Label merge requests                                             |         |          | ✓         | ✓          | ✓     |
| Lock merge request threads                                       |         |          | ✓         | ✓          | ✓     |
| Manage/Accept merge requests                                     |         |          | ✓         | ✓          | ✓     |
| Create new environments                                          |         |          | ✓         | ✓          | ✓     |
| Stop environments                                                |         |          | ✓         | ✓          | ✓     |
| Add tags                                                         |         |          | ✓         | ✓          | ✓     |
| Cancel and retry jobs                                            |         |          | ✓         | ✓          | ✓     |
| Create or update commit status                                   |         |          | ✓         | ✓          | ✓     |
| Update a container registry                                      |         |          | ✓         | ✓          | ✓     |
| Remove a container registry image                                |         |          | ✓         | ✓          | ✓     |
| Create/edit/delete project milestones                            |         |          | ✓         | ✓          | ✓     |
| Use security dashboard
                                         |         |          | ✓         | ✓          | ✓     |
| View vulnerabilities in Dependency list
                        |         |          | ✓         | ✓          | ✓     |
| Create issue from vulnerability
                                |         |          | ✓         | ✓          | ✓     |
| Dismiss vulnerability
                                          |         |          | ✓         | ✓          | ✓     |
| Apply code change suggestions                                    |         |          | ✓         | ✓          | ✓     |
| Create and edit wiki pages                                       |         |          | ✓         | ✓          | ✓     |
| Rewrite/remove Git tags                                          |         |          | ✓         | ✓          | ✓     |
| Use environment terminals                                        |         |          |           | ✓          | ✓     |
| Run Web IDE’s Interactive Web Terminals
                        |         |          |           | ✓          | ✓     |
| Add new team members                                             |         |          |           | ✓          | ✓     |
| Enable/disable branch protection                                 |         |          |           | ✓          | ✓     |
| Push to protected branches                                       |         |          |           | ✓          | ✓     |
| Turn on/off protected branch push for devs                       |         |          |           | ✓          | ✓     |
| Enable/disable tag protections                                   |         |          |           | ✓          | ✓     |
| Edit project                                                     |         |          |           | ✓          | ✓     |
| Add deploy keys to project                                       |         |          |           | ✓          | ✓     |
| Configure project hooks                                          |         |          |           | ✓          | ✓     |
| Manage Runners                                                   |         |          |           | ✓          | ✓     |
| Manage job triggers                                              |         |          |           | ✓          | ✓     |
| Manage variables                                                 |         |          |           | ✓          | ✓     |
| Manage GitLab Pages                                              |         |          |           | ✓          | ✓     |
| Manage GitLab Pages domains and certificates                     |         |          |           | ✓          | ✓     |
| Remove GitLab Pages                                              |         |          |           | ✓          | ✓     |
| Manage clusters                                                  |         |          |           | ✓          | ✓     |
| Manage license policy
                                          |         |          |           | ✓          | ✓     |
| Edit comments \(posted by any user\)                             |         |          |           | ✓          | ✓     |
| Manage Error Tracking                                            |         |          |           | ✓          | ✓     |
| Delete wiki pages                                                |         |          |           | ✓          | ✓     |
| View project Audit Events                                        |         |          |           | ✓          | ✓     |
| Manage push rules
                                               |         |          |           | ✓          | ✓     |
| Switch visibility level                                          |         |          |           |            | ✓     |
| Transfer project to another namespace                            |         |          |           |            | ✓     |
| Remove project                                                   |         |          |           |            | ✓     |
| Delete issues                                                    |         |          |           |            | ✓     |
| Disable notification emails                                      |         |          |           |            | ✓     |
| Force push to protected branches \(4\)                           |         |          |           |            |       |
| Remove protected branches \(4\)                                  |         |          |           |            |       |

### Project features permissions

#### Wiki and issues

Can be hidden.  

Project visibility settings:
* disabled
* only team members
* everyone with access
* everyone

#### Protected branches

Restrict merging and pushing for Maintainers and Developers on a per-branch basis.  

#### Cycle Analytics

Can be restricted.  

#### Issue board

Can be restricted.  

#### File Locking

Paying customer feature.  

#### Confidential Issues

Can be accessed by Reporters or higher permission levels.  

#### Releases

Can be read by project members.  

### Group members permissions

```
(1): Groups can be set to allow either Owners or Owners and Maintainers to create subgroups
(2): Introduced in GitLab 12.2.
(3): Default project creation role can be changed at:
         The instance level.
         The group level.
```

| Action                                      | Guest | Reporter | Developer | Maintainer | Owner   |
|---------------------------------------------|-------|----------|-----------|------------|---------|
| Browse group                                | ✓     | ✓        | ✓         | ✓          | ✓       |
| View Insights charts
                      | ✓     | ✓        | ✓         | ✓          | ✓       |
| View group epic
                           | ✓     | ✓        | ✓         | ✓          | ✓       |
| Create/edit group epic
                    |       | ✓        | ✓         | ✓          | ✓       |
| Manage group labels                         |       | ✓        | ✓         | ✓          | ✓       |
| Create project in group                     |       |          | ✓ \(3\)   | ✓ \(3\)    | ✓ \(3\) |
| Create/edit/delete group milestones         |       |          | ✓         | ✓          | ✓       |
| Enable/disable a dependency proxy
         |       |          | ✓         | ✓          | ✓       |
| Use security dashboard
                    |       |          | ✓         | ✓          | ✓       |
| Create subgroup                             |       |          |           | ✓ \(1\)    | ✓       |
| Edit group                                  |       |          |           |            | ✓       |
| Manage group members                        |       |          |           |            | ✓       |
| Remove group                                |       |          |           |            | ✓       |
| Delete group epic
                         |       |          |           |            | ✓       |
| Edit epic comments \(posted by any user\)
 |       |          |           | ✓ \(2\)    | ✓ \(2\) |
| View group Audit Events                     |       |          |           |            | ✓       |
| Disable notification emails                 |       |          |           |            | ✓       |
| View/manage group\-level Kubernetes cluster |       |          |           | ✓          | ✓       |

### External users

Only for self-managed GitLab.  

### Free Guest users

Paying customer feature.  

### Auditor users

Paying customer feature.  

### GitLab CI/CD permissions

```
(1): Only if the job was triggered by the user
```

| Action                        | Guest, Reporter | Developer | Maintainer | Admin |
|-------------------------------|-----------------|-----------|------------|-------|
| See commits and jobs          | ✓               | ✓         | ✓          | ✓     |
| Retry or cancel job           |                 | ✓         | ✓          | ✓     |
| Erase job artifacts and trace |                 | ✓ \(1\)   | ✓          | ✓     |
| Remove project                |                 |           | ✓          | ✓     |
| Create project                |                 |           | ✓          | ✓     |
| Change project configuration  |                 |           | ✓          | ✓     |
| Add specific runners          |                 |           | ✓          | ✓     |
| Add shared runners            |                 |           |            | ✓     |
| See events in the system      |                 |           |            | ✓     |
| Admin interface               |                 |           |            | ✓     |
