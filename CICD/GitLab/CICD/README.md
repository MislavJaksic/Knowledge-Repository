## [GitLab CI/CD](https://docs.gitlab.com/ee/ci/README.html)

CI and CD refers to:
* Continuous Integration (CI)
* Continuous Delivery (CD)
* Continuous Deployment (CD)

Principle: push small chunks of code and run it through a pipeline (test, verify, deploy, ...).

### Getting started

GitLab CICD is configured in a file called ".gitlab-ci.yml".  
The script is executed by a GitLab Runner.  

Create pipelines by:
* migrating from Jenkins
* using a template
* creating it from scratch

CI minute quota is 2000 CI minutes per month per group for private projects.  

GitLab CICD has a lot of configurations and features.  

Example projects can be found [here](https://gitlab.com/gitlab-examples).  
