## [Introduction to Concourse](https://concoursetutorial.com/)

### Getting Started

TODO

### Test Setup

```
http://Concource-Atc-Ip-Port
```

Download the `fly` CLI from the Concourse server's login page.  

#### Linux

```
$: sudo mkdir -p /usr/local/bin

$: sudo mv ~/Downloads/fly /usr/local/bin
$: sudo chmod 0755 /usr/local/bin/fly
OR
$: sudo mv ~/Downloads/fly ~/bin
$: sudo chmod 0755 ~/bin/fly
```

```
$: fly
```

#### Windows

TODO

### Target Concourse

```
$: fly --target Target-Name login --team-name Team-Name --concourse-url Concource-Url [-u _username -p _password]
$: fly --target Target-Name sync

$: cat ~/.flyrc
```
