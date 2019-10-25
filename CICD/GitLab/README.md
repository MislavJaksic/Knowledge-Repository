## [GitLab](https://gitlab.com/)

GitLab is a Git repository which covers the entire DevOps Lifecycle.  

### [Create and add your SSH public key](https://docs.gitlab.com/ee/gitlab-basics/create-your-ssh-keys.html)

To use Git over SSH you need to create and add your SSH PUBLIC key.  

```
# Note: make sure to setup your Git identity
$: git config --global user.name "User-Name"
$: git config --global user.email User-Name@Email-Domain
```

[Instructions file](Docs/User/General/SSH/README.md)

[Instructions folder](Docs/User/General/SSH)

### GitLab Workflow

1) Review the milestones.
2) Review and/or create an issue(task).
    1) Take a task from the "Issue Board's" "To Do" pile and put it into the "Doing" pile.
    2) Label the task with your "Doing::Your-Name" label.
    3) Assign it to yourself.
3) Create a "New branch and merge request" with "dev" as its source by clicking on the "V" arrow.
4) Click "Check out branch" and execute "Step 1: Fetch and check out..." in your computer terminal.
    1) Do work and document it in an issue: ask questions, find microtasks(15min chunks of work) and bugs, solve them.
    2) Stage all your work with "git add .".
    3) Commit your work with "git commit -m 'Example commit message'".
    4) Push it to a remote branch with "git push".
5) Remove the Work In Progress(WIP) status of a merge request.
6) Complete the merge request by pressing "Merge".
7) Close the issue if it has been solved and start with step 1) or start again from step 4).
