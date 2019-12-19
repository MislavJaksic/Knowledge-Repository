## [Concourse](https://concourse-ci.org/)

Use:
* `Resource`
* `Task`
* `Job`

Do:
* CI
* CD

Features:
* configuration as code
* visualisation
* configuration under Source Control
* reproducible
* rapid iteration
* bring your own integration


### Install

[Instructions](Docs/Install)

### fly CLI

#### Setup

Download the `fly` CLI from the Concourse server's login page.  

[Instructions](Other/ConcourseTutorial)

##### Linux

```
$: sudo mkdir -p /usr/local/bin

$: sudo mv ~/Downloads/fly /usr/local/bin
$: sudo chmod 0755 /usr/local/bin/fly
OR
$: sudo mv ~/Downloads/fly ~/bin
$: sudo chmod 0755 ~/bin/fly
```
