## [GitLab](https://gitlab.com/)

GitLab is a Git repository which covers the entire DevOps Lifecycle.  

TODO: remap relative links!  

### Project

#### Setup

* create a `dev` branch; it will be forked by `feature` branches
* make `dev` a `Protected branch` and `Default branch`
* add `Milestones` and `Labels` (eg. `To Do`, `Doing`, `QA`, `Rejected`)
* add `.gitignore`
* invite GitLab members

#### GitLab Workflow

1) Review the milestones.
2) Review and/or create an issue (task).
    1) Take a task from the `Issue Board`'s' `To Do` pile and put it into the `Doing` pile.
    2) Assign the chosen task to yourself.
3) Create a `New branch and merge request` with `dev` as its source; click on the `V` arrow.
4) `Check out branch` and do `Step 1: Fetch and check out...` in your terminal.
    1) Construct software and put knowledge to paper.
    2) In issues: ask questions, find microtasks (require up to 15min of effort) and bugs. Solve them.
    3) Stage all your work with `git add .`.
    4) Commit your work with `git commit -m 'Descriptive commit message'`.
    5) Push it to a remote branch with `git push`.
    6) Resolve merge conflicts.
5) Click `Mark as ready`.
6) Complete the merge request by pressing `Merge` and ticking the box `Delete source branch`.
7) Repeat until the task or milestone are complete.

GitLab workflow ties together GitLab and Git:
* milestones
* issues
* branches
* merge requests
* git
* CICD

#### GitLab CICD

```
# Note: for publishing Jekyll `GitLab Pages`
image: ruby:2.6.5  # Docker image

pages:  # job name
  stage: deploy  # stage name
  script:  # what should be run
  - bundle install  # install dependencies
  - bundle exec jekyll build -d public  # build the website in "public"
  artifacts:
    paths:
    - public  # location of the website
  only:
  - pages  # run job only after pushing to the "pages" branch
```

TODO: a gitlab-ci that covers "all" (most) functionalities: when:manual, when:delay, junit test reports ...

#### Permissions

If a GitLab project is private then:
* the public only see public GitLab pages
* Guest permission users:
    * DO see: activity, issues, wiki pages
    * DON'T see: code, branches, commits, confidential issues, merge requests
* higher permission users can see almost everything

#### Project Import and Export

```
Settings -> General -> Advanced -> Export
```

```
New Project -> Import project -> select export type -> follow instructions ...
```

[Project import/export](Docs/UseGitLab/OrganizeWorkWithProjects/17ProjectImportExport)

#### Other

[Web IDE](Docs/Projects/Repositories/WebIDE)

[GitLab Pages](Docs/CICD/GitLabPages/CICD/GitLabPages)

[JUnit reports](Docs/CICD/JUnitTestReports)

### Authentication

#### Create an OAuth2/Access token

```
User Settings -> Access Tokens
```

#### [Create and add your SSH public key](https://docs.gitlab.com/ee/gitlab-basics/create-your-ssh-keys.html)

To use Git over SSH you need to:
*  [generate and add an SSH key](Docs/User/General/SSH)
* setup Git over SSH

Check if you are using Git over SSH:
```
$: git remote -v  # ->
  # origin	git@_domain:path/to/file.git (fetch)
  # origin	git@_domain:path/to/file.git (push)
```

#### Deploy Token

[Create and use a Deploy Token](Docs/Projects/DeployTokens)  
