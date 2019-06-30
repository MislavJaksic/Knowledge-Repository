## [Git Immersion Tour](http://gitimmersion.com/index.html)

A hands on tour of Git.

### Install Git

```
$: git config --global user.name "Mislav Jaksic"
$: git config --global user.email "jaksicmislav@gmail.com"
```

#### Linux

```
$: git config --global core.autocrlf input
$: git config --global core.safecrlf true
```

#### Windows
```
$: git config --global core.autocrlf true
$: git config --global core.safecrlf true
```

### Tour

Create repository:
$: git init

Undo unstaged file changes:
$: git checkout [_file] [_commit_hash]

Stage a file file:
$: git add [.] [_file]

Undo file staging:
$: git reset [HEAD] [_file]

Undo commit:
$: git revert _commit_hash

Commit staged file:
$: git commit [--amend] -m _commit_message

View repository and working directory status:
$: git status

View commit history:
$: git log

Command aliasing:
In .gitconfig write
[alias]
  _alias = _command
  
Get previous version:
$: git checkout _commit_hash

Get latest version:
$: git checkout master

Create branch:
$: git branch _branch

Switch branch:
$: git checkout _branch

Merge branches:
$: git merge _other_branch

Rebase branches:
$: git rebase _other_branch

Rebase vs merge:
don't rebase when
  - the branch is shared with others
  - commit branch history is important
  
Close repository:
$: git clone _repository [_local_name]

View remote repositories:
$: git remote [show _repository]

Fetch changes (but on't merge them):
$: git fetch 

Fetch changes and merge branches:
$: git pull

Push changes:
$: git push _origin_repo _dest_repo

repository commands

file commands

branch commands

