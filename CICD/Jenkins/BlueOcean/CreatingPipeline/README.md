## [Creating a Pipeline](https://jenkins.io/doc/book/blueocean/creating-pipelines/)

```
http://localhost:8080/blue
```

Click create pipeline.  

### Git

#### Local repository

Set a local directory path:
```
file:///home/.../Repo-Name
# Note: there really are three "/"
# Note: if running in Docker add "-v Local-Repo-Path:Docker-Mount-Point"
```

If there is no Jenkinsfile an editor will be opened.  

#### Remote repository

ssh://gituser@git-server-url/git-server-repos-group/my-git-repo
gituser@git-server-url:git-server-repos-group/my-git-repo

TODO

### GitHub

TODO

### Bitbucket Cloud

TODO
