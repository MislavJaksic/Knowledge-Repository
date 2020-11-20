## [Jenkins](https://jenkins.io/)

TODO


Steps:
* Turn on Contabo VPN
* Visit Jenkins on http://10.64.1.83:8080/
* Login using Jenkins user credentials
* Click `New Item` -> enter the Jenkins item name -> `Pipeline`
* Click checkbox `GitHub project`, select `GitLab` as `GitLab Connection` and enter project's `Clone with HTTPS` URL in `Project url`
* Under `Build Triggers` pick when you want the pipeline to run and create a webhook for the repository
    * Recommended: check `Build when a change is pushed to GitLab`, then check only `Opened Merge Request Events` and set `Rebuild open Merge Requests` to `On push to source branch`
    * In repository under `Settings` -> `Webhooks` -> check `Merge request events` only, copy `GitLab webhook URL: <URL>` from Jenkins to Webhook's `URL` field and under Jenkins `Advanced...` click `Generate` to create a `Secret token` for the Webhook's `Secret Token` field
    * Feel free to `Test` the newly created webhook
    * Add `jenkins-ai-soft` user to your GitLab project with at least the Developer privileges
 * In Jenkins under `Pipeline` `Definition` select `Pipeline script from SCM`: you will store the Jenkinsfile Pipeline script in the Git repository (not Jenkins itself)
    * `SCM` should be Git; enter project's `Clone with HTTPS` URL in `Repository URL`
    * `Credentials` is an account authorized to access the GitLab project ???
    * `Branches to build`, `Branch Specifier (blank for 'any')` leave blank or specify a subset of branches you want to monitor
    * Make sure you uncheck `Lightweight checkout`
