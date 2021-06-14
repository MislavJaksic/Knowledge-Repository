## [GitLab Pages](https://docs.gitlab.com/ee/user/project/pages/index.html)

Publish static websites.  

Static Site Generators (SSG):
* `Jekyll`
* `Hugo`
* `Middleman`
* `Harp`
* `Hexo`
* `Brunch`

How it works:  
* create a project
* setup GitLab's CICD `.gitlab-ci.yml` file
* push commits to a branch
* setup the domain
* view `GitLab Pages`

These steps can be tested by creating a GitLab project from a `GitLab Pages` template.  

Things are a bit different if you’re using self-managed instances.  

## [Projects for GitLab Pages and URL structure](https://docs.gitlab.com/ee/user/project/pages/getting_started_part_two.html)

You will need:
* a repository in a project
* `.gitlab-ci.yml`

You can also have:
* a custom domain
* DNS, SSL/TLS certificate

It's suggested you fork an existing project and start from there.  

To create a page from scratch:
* create a project
* create an orphaned pages branch
* setup `.gitlab-ci.yml`
* setup the website content and baseurl configuration
* push the commits
* open the website

[GitLab Pages with Jekyll](../CICDGitLabPages)   
