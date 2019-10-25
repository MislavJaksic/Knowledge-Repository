## [Creating and Tweaking GitLab CI/CD for GitLab Pages](https://docs.gitlab.com/ee/user/project/pages/getting_started_part_four.html)

### Jekyll GitLab Pages with GitLab CICD

```
# Note: first, create a project
$: git clone https://gitlab.com/Repository-Name  # make a local copy
$: cd Repository-Name

$: git checkout --orphan pages  # create a separate branch

# Note: copy the jekyll-gitlab-page directory into the git directory

$: git add .
$: git commit -m "Created GitLab 'Hello world' page"
$: git push --set-upstream origin pages  # if it's your first branch push
```

To visit the website click Project -> Settings -> Pages -> GitLab Pages public link.  
