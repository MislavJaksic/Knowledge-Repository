## [Concourse](https://concourse-ci.org/)

Doesn't work! Memory, volume and Helm errors. Abandoned Helm chart: version: 9.0.0, appVersion: 5.8.0.  

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

#### Usage

```
$: fly --target Target-Name login --team-name Team-Name --concourse-url Concource-Url [-u _username -p _password] [--ca-cert Ca-Cert]
  # --target: alias
  # --team-name: team name
  # --concourse-url: Concourse endpoint, URL
  # -u, -p: username and password
  # --ca-cert: trust self signed TLS certificate

$: fly --target Target-Name edit-target [--target-name New-Target-Name] [--concourse-url New-Concource-Url] [--team-name New-Team-Name]

$: fly --target Target-Name sync

$: fly targets
$: fly --target Target-Name status
$: fly --target Target-Name userinfo

$: fly --target Target-Name logout
$: fly logout -a
$: fly --target Target-Name delete-target
$: fly delete-target -a

$: source <(fly completion --shell bash)
OR
$: fly completion --shell bash > /etc/bash_completion.d/fly
```

[Detailed commands](Docs/flyCLI)

### Pipelines

TODO
