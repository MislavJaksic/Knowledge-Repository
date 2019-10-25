## [Creating and using CI/CD pipelines](https://docs.gitlab.com/ee/ci/pipelines.html)

Claim: Jenkins doesn't scale, is a plugin hell and has many points of failure.  

### Introduction

Pipelines define jobs (eg. compile, test) and stages (eg. run tests after compiling).  

Jobs are executed by Runners.  

### Visualizing pipelines

What is parallel and what is sequential can be visualized.  

A graph can be:
* regular
* mini

### Configuring pipelines

Defined in ".gitlab-ci.yml".  
Additional configs are available though the GitLab UI.  

Pipelines can be set to run only for merge requests.  

### Multi-project pipelines

Paying customer feature.  

### Working with pipelines

Pipelines are executed automatically, however ...  

You can manually execute a pipeline by:
* clicking CICD -> Pipelines -> Run Pipelines
* selecting a branch in "Create for"
* entering environment variables

API endpoints can control pipelines.  

View the latest pipeline on https://gitlab.com/Group-Name/Subgroup-Name/Project-Name/pipelines/Branch-Name/latest.

#### View failure

* in the pipeline graph
* in the pipeline widget (merge requests, commit pages)
* in the job view

#### Pipeline requires manual action before proceeding

Use "when:manual" in ".gitlab-ci.yml".  
Here, you can also specify additional variables.  

Example:
* before deployment

#### Delay a pipeline job

Use "when:delay" in ".gitlab-ci.yml".  

Example:
* gradual code rollout

### Security on protected branches

If the user is allowed to merge or push on a protected branch they can:
* run manual pipelines
* run scheduled pipelines
* run pipelines using triggers
* trigger manual actions on existing pipelines
* retry or cancel existing jobs

### Persistent pipeline refs

For when you are force-pushing (which you shouldn't be doing!).  
