## [Git](https://git-scm.com/)

Git is a Distributed Version Control System (DVCS). It tracks file changes as a stream of snapshots.  

### Branch Workflow

* [github-flow](https://docs.github.com/en/get-started/quickstart/github-flow): simple, for small or web projects
* [git-flow](https://nvie.com/posts/a-successful-git-branching-model/): complex, for when software is explicitly versioned or you need to support multiple versions of your software in the wild

### Guides

* [Git Immersion Tour](http://gitimmersion.com/index.html)

### Lexicon
```
Master Branch: where the main code dwells, the production, the deployment code. You should never attempt to directly change the Master Branch.  
Branch: a modified copy of the Master Branch. It is here that you can add new features or clean up the project.  
Commit: the process of submitting changes to a Branch. It is made up of changes, a comment and a timeline.  
Pull Request: a request for merging two Branches into a single Branch, most often a Master Branch. Pull Requests can be discussed and they have to be approved.  

Merge: a process of combining two Branches into a single Branch.  
Deploy: a phase just before merging when tests are run to insure compatibility and quality of the merging code.  
```

### Install (Command Line) Git

```
$: sudo dnf install git-all  # Fedora, RPM, RHEL, CentOS, ...
$: sudo apt install git-all  # Debian, Ubuntu, ...

$: scoop install git  # Windows
$: scoop install openssh
$: [environment]::setenvironmentvariable('GIT_SSH', (resolve-path (scoop which ssh)), 'USER')
# Note: restart the shell
```

```
$: git config --list --show-origin

$: git config --global user.name "John Doe"
$: git config --global user.email johndoe@example.com

$: git config --global core.editor Your-Editor
```
Visit [AppendixC: config core.editor](https://git-scm.com/book/en/v2/Appendix-C%3A-Git-Commands-Setup-and-Config#_core_editor) for how to setup your favorite editor.  

### Local commands

```
$: git init  # turn current directory to Git repository

$: git clone https://github.com/path/to/repo.git [Directory-Name]
$: git clone git://user@server:path/to/repo.git
```

Create a `.gitignore` file as soon as possible.  
[Sample .gitignore](https://github.com/github/gitignore)  

```
$: git status

$: git add File-Name
$: git rm File-Name
$: git mv old/path/File-Name /new/path/New-File-Name

$: git commit -m "This is a commit message" [--amend]
$: git reset HEAD File-Name  # unstage a file
$: git checkout -- File-Name  # discard local changes

$: git diff

$: git log [-p] [--stat] [--graph] [--since=X.Time-Unit] [--no-merges]

$: git remote [-v]
$: git fetch Repository-Name  # download changes from a remote
$: git pull Repository-Name  # fetch and merge changes
$: git push Repository-Name Branch-Name
```

### Branch commands

```
$: git checkout -b Branch-Name  # create and switch branches

$: git branch Branch-Name  # create a new branch
$: git checkout Branch-Name  # switch branches; revert to a new snapshot

$: git merge Branch-Name  # merge Branch-Name into current branch
# Note: a "fast-forward" merge moves both branches (pointers) forward
# Note: a "recursive" strategy does a three-point merge (common ancestor, snapshot to merge into, snapshot to merge in)
# Note: if there are conflicts, change file contents and use `git add/rm` until there are no unmerged paths and you can perform a `git commit`
```

### Remove big or sensitive files

Download a repository with `git` or `GitHub Desktop`.  

Discover them with `discover_big_files.bash` script.  

Download and use [BFG](https://rtyley.github.io/bfg-repo-cleaner/) to remove big or sensitive files.  

Do `git push --force`.  

Eveyone will have to redownload the repository.  
