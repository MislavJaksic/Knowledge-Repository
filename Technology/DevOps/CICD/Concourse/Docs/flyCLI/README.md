## [The fly CLI](https://concourse-ci.org/fly.html)

[Setup fly](../../Other/ConcourseTutorial)

```
$: fly -h
```

### fly login

Authenticate and save an endpoint under an alias.  
The alias and token are stored in `~/.flyrc`.  

```
$: fly --target Target-Name login --team-name Team-Name --concourse-url Concource-Url [-u _username -p _password] [--ca-cert Ca-Cert]
  # --target: alias
  # --team-name: team name
  # --concourse-url: Concourse endpoint, URL
  # -u, -p: username and password
  # --ca-cert: trust self signed TLS certificate

# Note: follow the command line instructions
```

Authentication methods:
* basic AuthN: username and password
* OAuth: click a link to click
* no AuthN: no prompting

Token in `~/.flyrc` will expire in 1 day.  

Now you can use `--target Target-Name` or `-t Target-Name` to run a command against the saved target.  

### fly targets

List saved targets.  

```
$: fly targets  # ->
  # name          url             team        expiry                       
  # Target-Name   Concource-Url   Team-Name   ...
```

### fly status

Check authentication status.  

```
$: fly --target Target-Name status
```

### fly userinfo

To check what user you're logged in as, as well as which teams you are currently authenticated to and which roles within each team you have, run:

```
$: fly --target Target-Name userinfo  # ->
  # username   team/role
  # ...        ...
```

### fly logout

Delete authentication token.  

```
$: fly --target Target-Name logout
$: fly logout -a
```

### fly edit-target

Modify a target's name, team or URL.  

```
$: fly --target Target-Name edit-target [--target-name New-Target-Name] [--concourse-url New-Concource-Url] [--team-name New-Team-Name]
```

### fly delete-target

Remove target.  

```
$: fly --target Target-Name delete-target
$: fly delete-target -a
```

### fly sync

Check if you are running the latest Concourse version.  

```
$: fly --target Target-Name sync
```

### fly completion

Add autocomplete.  

```
$: source <(fly completion --shell bash)
OR
$: fly completion --shell bash > /etc/bash_completion.d/fly
```
