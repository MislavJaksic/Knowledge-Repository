## [Git Branching](https://git-scm.com/book/en/v2/Git-Branching-Branches-in-a-Nutshell)

Git's "killer" feature. Very cheap.  

### Branches in a Nutshell

Git stores data as a series of snapshots.  
Commit points to the snapshot of the content you staged.  
Branch is just a movable commit pointer.  

`master` in the initial branch.  
`HEAD` is a pointer. It points to a local branch you are currently on.  

```
$: git branch Branch-Name  # create a new branch; it points where `HEAD` points
$: git checkout Branch-Name  # switch branches; revert to a new snapshot; moves `HEAD`

$: git checkout -b Branch-Name  # create and switch branches
```

### [Basic Branching and Merging](https://git-scm.com/book/en/v2/Git-Branching-Basic-Branching-and-Merging)

```
$: git checkout -b Branch-Name  # create and switch branches

$: git merge Branch-Name  # merge Branch-Name into current branch
# Note: a "fast-forward" merge moves both branches (pointers) forward
# Note: a "recursive" strategy does a three-point merge (common ancestor, snapshot to merge into, snapshot to merge in)
# Note: if there are conflicts, change file contents and use `git add/rm` until there are no unmerged paths and you can perform a `git commit`
```

### Branch Management

TODO
