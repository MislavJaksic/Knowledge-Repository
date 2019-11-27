## [Getting Started](https://git-scm.com/book/en/v2/Getting-Started-About-Version-Control)

### About version control

Version control: records file changes.  
Use cases:
* revert changes
* compare changes
* who made the change
* recover files

`Version Control Systems` (VCS):
* local: copy files to another directory. Like [RCS](https://www.gnu.org/software/rcs/).  
* centralized: better for security and collaboration, but a single point of failure. Like CVS, Subversion, and Perforce.  
* distributed: clients mirror the whole history. Can have hierarchical workflows. Like Git, Mercurial, Bazaar or Darcs.  

### What is Git?

Git thinks about its data more like a stream of snapshots.  
Git takes a snapshot of every file every time you make a commit and references each file.  

Git operations are local. No need for a connection.  
Git ensures integrity using hashes.  
Git appends data. Git never deletes data.  

Files are in one of three stages:  
* `modified` - changes have not been committed  
* `staged` - changes are marked and will go into your next commit snapshot  
* `committed` - changes are stored in your local database

Git is made up of three parts:  
* `working tree` - local files  
* `staging area` or `index` - stores what will go into your next commit to the Git repository  
* `Git directory` - stores metadata and project database  

(Basic) Git workflow:
* modify files in `working tree`
* select changes to go to your `staging area`
* commit: take changes in the `staging area` and store that snapshot permanently to your `Git directory`

### Installing (Command Line) Git

```
$: sudo dnf install git-all  # Fedora, RPM, RHEL, CentOS, ...
$: sudo apt install git-all  # Debian, Ubuntu, ...

$: scoop install git  # Windows
$: scoop install openssh
$: [environment]::setenvironmentvariable('GIT_SSH', (resolve-path (scoop which ssh)), 'USER')
# Note: restart the shell
```

### First-Time Git Setup

Git's configuration variables are in three places:
* `/etc/gitconfig` file
* `~/.gitconfig` or `~/.config/git/config` file
* `.git/config` of a repository you are currently using

```
$: git config --list --show-origin

$: git config --global user.name "John Doe"
$: git config --global user.email johndoe@example.com

$: git config --global core.editor Your-Editor
```
Visit [AppendixC: config core.editor](https://git-scm.com/book/en/v2/Appendix-C%3A-Git-Commands-Setup-and-Config#_core_editor) for how to setup your favourite editor.  

### Getting Help

```
$: git help _verb
$: git _verb --help
$: man git-_verb
```
