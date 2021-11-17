## [Scoop](https://scoop.sh/)

Scoop is a command line installer.  
It works in a fashion similar to Ubuntu's "apt" and Fedora's "dnf".  

### Windows Installation

```
# Note: will be installed in `C:\Users\<user>\scoop`
$: iex (new-object net.webclient).downloadstring('https://get.scoop.sh')
```

### Usage

```
$: scoop install curl

$: scoop add bucket versions
```
