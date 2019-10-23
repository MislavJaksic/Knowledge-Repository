## [GitLab Docs](https://docs.gitlab.com/ee/README.html)

GitLab is a Git repository that also covers the entire DevOps Lifecycle.  

DevOps Lifecycle:
* manage: statistics and analytics
* plan: project planning and management
* create: commit code
* verify: test, check quality and CI
* package: package software
* release: app delivery
* configure: configure apps
* monitor: collect metrics
* secure: secure apps

### GitLab Docs: Plan

Paying customer features: Burndown CHarts, Epics, Related Issues (but not cross-referencing), Roadmap, Service Desk.  

### GitLab Docs: Create

#### GitLab Docs: Create: Projects and Groups

Paying customer features: Advanced global search, Advanced syntax search, Contribution analytics, File locking, Issues Analytics.  

### GitLab Docs: Verify

Paying customer features: Code Quality reports, multi-project pipelines.  


## [Generating a new SSH key pair](https://gitlab.com/help/ssh/README#generating-a-new-ssh-key-pair)

Without an SSH key you have to input your username and password every time you execute a git command.  

To avoid this, generate and set an SSH key.  

On Windows:
```
$: git-gui
# Note: Help -> Show SSH Key -> Generate Key -> Copy (Public Key) To Clipboard
```

On Linux:
```
$: ssh-keygen -t ed25519 -C "gitlab-git"  -> generates a public-private key pair
  # Enter file in which to save the key (/home/_user/.ssh/id_ed25519): /home/_user/.ssh/id_ed25519-gl-g
$: cat /home/_user/.ssh/id_ed25519-gl-g.pub  -> prints the PUBLIC key
  # ssh-ed25519 A-Long-String gitlab-git
```

Register the PUBLIC KEY at GitLab: click your profile picture -> Settings -> SSH Keys -> Copy-Paste the PUBLIC key  

```
# Note: make sure to setup your identity
$: git config --global user.name "John Doe"
$: git config --global user.email johndoe@example.com
```

```
$: git fetch origin  #-> test if it works
  # The authenticity of host 'gitlab.com (35.231.145.151)' can't be established.
  # ECDSA key fingerprint is SHA256:HbW3g8zUjNSksFbqTiUWPWg2Bq1x8xdGUrliXFzSnUw.
  # Are you sure you want to continue connecting (yes/no)? yes
  # Warning: Permanently added 'gitlab.com,35.231.145.151' (ECDSA) to the list of known hosts.
OR
$: ssh -T git@gitlab.com
```

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
5) Remove the WIP status of a merge request.
6) Complete the merge request by pressing "Merge".
7) Close the issue if it has been solved and start with step 1) or start again from step 4).
