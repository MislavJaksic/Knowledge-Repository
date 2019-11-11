## [GitLab](https://gitlab.com/)

GitLab is a Git repository which covers the entire DevOps Lifecycle.  

### Setup a new project

* Create a new `dev` branch from which `feature` branches will fork
* Make `dev` a protected branch to prevent improper commits and merges
* Make `dev` the `Default branch` instead of `master`

* Create `Milestones` and `Labels` (`ToDo`, `Doing`)

### GitLab Workflow

1) Review the milestones.
2) Review and/or create an issue (task).
    1) Take a task from the "Issue Board's" "To Do" pile and put it into the "Doing" pile.
    2) Label the task with your "Doing::Your-Name" label.
    3) Assign it to yourself.
3) Create a "New branch and merge request" with "dev" as its source by clicking on the "V" arrow.
4) Click "Check out branch" and execute "Step 1: Fetch and check out..." in your computer terminal. You may need to clone the git repository first.
    1) Construct software and put knowledge to paper.
    2) Open and comment on issues: ask questions, find 15min sub-tasks and bugs. Solve them.
    3) Stage all your work with "git add .".
    4) Commit your work with "git commit -m 'Example-Commit-Message'".
    5) Push commits to a remote branch with "git push".
5) Remove the Work In Progress (WIP) status of a merge request.
6) Complete the merge request by pressing "Merge".
7) Repeat appropriate steps until the task and milestone are satisfied.

GitLab workflow ties together GitLab and Git:
* milestones
* issues
* branches
* merge requests
* git
* CICD

### [Create and add your SSH public key](https://docs.gitlab.com/ee/gitlab-basics/create-your-ssh-keys.html)

To use Git over SSH you need to:
*  [generate and add an SSH key](Docs/User/General/SSH)
* setup Git over SSH

Check if you are using Git over SSH:
```
$: git remote -v  # ->
  # origin	git@_domain:path/to/file.git (fetch)
  # origin	git@_domain:path/to/file.git (push)
```

### Web IDE

For tiny commits you can use your browser.  

[Instructions](Docs/Projects/Repositories/WebIDE)

### GitLab Pages

For when you want to publish a static website.  

[Instructions](Docs/CICD/GitLabPages/CICD/GitLabPages)

### JUnit reports

If you want JUnit test results displayed on a merge request after every push.  

[Instructions](Docs/CICD/JUnitTestReports)

### GitLab CICD

```
# Note: for publishing Jekyll GitLab Pages
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

### Permissions

If a GitLab project is private then:
* the public only see public GitLab pages
* Guest permission users:
    * DO see: activity, issues, wiki pages
    * DON'T see: code, branches, commits, confidential issues, merge requests
* higher permission users can see almost everything
