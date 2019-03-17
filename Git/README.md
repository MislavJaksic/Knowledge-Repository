## [Git](https://git-scm.com/)

Git is a distributed version control system. It keeps track of changes to files and lets you recall specific version later.  

### [ProGit Book](https://git-scm.com/book/en/v2)

#### Getting started

Git doesn't use delta based version control, that is, it doesn't keep track about changes to each file.  
Instead, Git takes a snapshot of all your files every time you make a commit and references each file.  

Nearly all Git operations are local, ensures integrity using hashes and doesn't delete data.  

Files can occupy one of three stages in Git:  
* committed - stored in a repository  
* modified - changes have not been stored  
* staged - has been marked for committing  

Git is made up of three parts:  
* Git directory - stores metadata and project database  
* working tree - local files  
* staging area / index - what will be committed next to the Git repository  

#### Installing Command Line Git

On Linux just execute:
```
$: sudo dnf install git-all -> Fedora, RHEL, CentOS, ...
$: sudo apt install git-all -> Debian, Ubuntu, ...
```

On Windows:  
* either download and install the executable  
* or get a command line installer such as [Scoop](https://github.com/MislavJaksic/Knowledge-Repository/Scoop) and execute:
```
$: scoop install git
```

To configure Git execute:  
```
$: git config
 -> /etc/gitconfig - configs that apply to every user  
 -> /.gitconfig - configs specific to a user  
 -> config - configs that apply to a Git directory  
 
$: git config --global user.name "MislavJaksic"
$: git config --global user.email jaksicmislav@gmail.com
$: git config --global core.editor "'C:/Program Files/Notepad++/notepad++.exe' -multiInst -nosession"

$: git config --list
```

#### Git Basics

Initialize a Git repository in a folder by executing:  
```
$: git init
```
Don't forget to add a README and a .gitignore file.  

Clone an existing Git repository by executing:
```
$: git clone https://github.com/libgit2/libgit2 [Local-Folder-Name] -> set a folder name
```

List files which are being tracked by Git by executing:
```
$: git status [-s] ; short/verbose version
```

Track a file so you can commit it by executing:
```
$: git add File-Name.any
```

After changing a file you can see the difference between the staged files execute:  
```
$: git diff
$: git difftool -> graphical/external view
```

Commit changes by executing:  
```
$: git commit -m "This is a commit message"
$: git commit [-a] -m "..." -> auto add all files, skip the staging process
```

Remove/stop tracking a file by executing:  
```
$: git rm File-Name.any
```

Rename or move a file by executing:
```
$: git mv ./File-Name.any ./new/path/New-File-Name.any
```

View the commit log by executing:
```
$: git log
$: git log [-p] -> view difference between commits
$: git log [--stat]
$: git log [--graph]
 -> there are a lot of different flags
```

Replace/undo your last commit with a new one by executing:
```
$: git commit -amend             -> replace last commit with this one
$: git reset HEAD File-Name.any  -> unstage file
$: git checkout -- File-Name.any -> discard local changes
```

#### Working with Remotes

List remote repositories by executing:  
```
$: git remote [-v] [show Repository-Name] -> show info about a repository
```

Add a new remote repository by executing:  
```
$: git remote add Repository-Name _url
```

Fetch/pull a remote repository by executing:  
```
$: git fetch Repository-Name
$: git pull Repository-Name -> fetch and merge
```

Push commits by executing:  
```
$: git push Repository-Name Branch-Name
```

#### Git Branching

TODO

#### Git Cheatsheet

```
$: git init -> init local Git repository, add README.md and .gitignore
$: git clone https://github.com/repo-name [Local-Project-Name] -> init existing repository

$: git status -s -> check state
$: git diff / difftool -> commited and staged file difference
$: git add File-Name.any -> track a file
$: git rm File-Name.any -> stop tracking a file
$: git mv ./File-Name.any ./new/path/New-File-Name.any -> rename/move a file

$: git commit [-a] -m "This is a commit message" -> auto add all files, skip the staging process
$: git commit -amend -> replace last commit with this one
$: git reset HEAD File-Name.any -> unstage file
$: git checkout -- File-Name.any -> discard local changes

$: git remote [-v] [show Repository-Name] -> show info about a repository
$: git remote add Repository-Name URL -> add remote repository

$: git fetch Repository-Name -> get files you don't have
$: git pull Repository-Name -> get files you don't have and merge them
$: git push Repository-Name Branch-Name -> set commited files into a Git repositroy

$: git log [-p / --stat / --graph] -> and many more flags to inspect the log
```
