### Rewriting History

TODO

#### The Nuclear Option: filter-branch

Rewrite many commits.  
Use cases:
* uploaded a large binary file
* change your email address
* uploaded a secret

```
$: git filter-branch --tree-filter "rm -f File-Name" HEAD

$: git filter-branch --tree-filter "rm -rf Directory-Name" HEAD
```
