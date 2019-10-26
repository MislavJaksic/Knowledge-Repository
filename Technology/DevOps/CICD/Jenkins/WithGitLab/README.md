## [Create a CI Pipeline with GitLab and Jenkins](https://docs.bitnami.com/aws/how-to/create-ci-pipeline/)

### Setup

Get a GitLab project SSH URL (under the blue "Clone" button).  

Generate a SSH key pair for between Jenkins and GitLab.  
```
$: ssh-keygen -t ed25519 -C "gitlab-jenkins"
$: cat /home/_user/.ssh/id_ed25519.pub  #-> print the PUBLIC key
```
Register the PUBLIC KEY at GitLab: Profile -> Settings -> SSH Keys -> Copy-Paste a PUBLIC key  

Install plugins in Manage Jenkins -> Manage Plugins -> Available -> then search for:
* [GitLab plugin](https://plugins.jenkins.io/gitlab-plugin)
* [Git plugin](https://plugins.jenkins.io/git)

Go to Manage Jenkins -> Configure System -> Git and set the Jenkins server username and email (maybe create an email for it?).  

### Add a project

In Jenkins click New Item -> Freestyle project -> Source Code Management ->  Git -> fill out the project SSH URL and create a "SSH Username with private key" credential with the generated SSH key.  
Additionally, check Build Triggers and find the Jenkins service URL.  
Optionally, under Additional Behaviours check Merge before build to merge new changes into a branch before building.  
Optionally, click Add post-build action -> Git Publisher -> check Push only if build succeeds and Merge Results to merge successful builds back into a production branch.  
At the end click Save.  

In GitLab go to the project click Settings -> Integrations -> paste the Jenkins service URL and check at least one event.  
