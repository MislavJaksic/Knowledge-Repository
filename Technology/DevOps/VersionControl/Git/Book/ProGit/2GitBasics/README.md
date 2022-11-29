## [Git Basics](https://git-scm.com/book/en/v2/Git-Basics-Getting-a-Git-Repository)

Basics are:
* configure and initialize a repository
* begin and stop tracking files
* stage and commit changes
* set up Git to ignore files
* how to undo mistakes
* browse the history of your project
* view changes between commits
* push and pull from remote repositories

### Getting a Git Repository

Either by:
* `clone`ing an existing repostiory
* of by `init`ializing a repository

```
$: git init  # turn current directory to Git repository

$: git clone https://github.com/path/to/repo.git [Directory-Name]
$: git clone git://user@server:path/to/repo.git
```

### Recording Changes to the Repository

```
Untracked to Staged: add
Unmodified to Modified: adit
Modified to Staged: stage
Unmodified to Untracked: remove
Staged to Unmodified: commit
```

Create a `.gitignore` file as soon as possible.  
[Sample .gitignore](https://github.com/github/gitignore)  

```
# ignore all .a files
*.a
# but do track lib.a, even though you're ignoring .a files above
!lib.a
# only ignore the TODO file in the current directory, not subdir/TODO
/TODO
# ignore all files in any directory named build
build/
# ignore doc/notes.txt, but not doc/server/arch.txt
doc/*.txt
# ignore all .pdf files in the doc/ directory and any of its subdirectories
doc/**/*.pdf
```

```
$: git status

$: git add File-Name
$: git rm File-Name
$: git mv old/path/File-Name /new/path/New-File-Name

$: git commit -m "This is a commit message"

$: git diff
$: git difftool  # graphical/external view
```

### Viewing the Commit History

```
$: git log [-p] [--stat] [--graph] [--since=X.Time-Unit] [--no-merges]
  # -p: difference between commits
  # --stats: file statistics
  # --graph: draw graph
  # --since=X.Time-Unit: apply time filter
  # --no-merges: filter out merge commits
```

### Undoing Things

Careful. You may not undo some of the undos.  

```
$: git commit --amend  # add commit to the previous commit

$: git reset HEAD File-Name  # unstage a file
$: git checkout -- File-Name  # discard local changes
```

### Working with Remotes

```
$: git remote show Repository-Name  # show info about a repository
$: git remote [-v]
  # -v: show remote URLs

$: git remote add Repository-Name Repo-URL
$: git remote rename Old-Repository-Name New-Repository-Name
$: git remote remove Repository-Name

$: git fetch Repository-Name  # download changes from a remote
$: git pull Repository-Name  # fetch and merge changes

$: git push Repository-Name Branch-Name
```

### Tagging

TODO

### Git Aliases

TODO
