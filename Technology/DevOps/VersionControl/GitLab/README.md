## [GitLab](https://gitlab.com/)

GitLab is a Git repository which covers the entire DevOps Lifecycle.  

### GitLab Workflow

1) Review the milestones.
2) Review and/or create an issue (task).
    1) Take a task from the "Issue Board's" "To Do" pile and put it into the "Doing" pile.
    2) Label the task with your "Doing::Your-Name" label.
    3) Assign it to yourself.
3) Create a "New branch and merge request" with "dev" as its source by clicking on the "V" arrow.
4) Click "Check out branch" and execute "Step 1: Fetch and check out..." in your computer terminal.
    1) Construct software and put knowledge to paper.
    2) In issues: ask questions, find microtasks (up to 15min tasks) and bugs. Solve them.
    3) Stage all your work with "git add .".
    4) Commit your work with "git commit -m 'Example commit message'".
    5) Push it to a remote branch with "git push".
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

To use Git over SSH you need to create and add your SSH PUBLIC key.  

```
# Note: make sure to setup your Git identity
$: git config --global user.name "User-Name"
$: git config --global user.email User-Name@Email-Domain
```

[Instructions](Docs/User/General/SSH)

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

TODO (see nothing, see docs/wiki, see everything)
