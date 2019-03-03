## [Scoop](https://scoop.sh/)

Scoop is a command line installer.
It works in a fashion similar to Ubuntu's "apt" and Fedora's "dnf".

### Windows Installation

To install in "C:\Users\<user>\scoop", open PowerShell and execute:
```
$: iex (new-object net.webclient).downloadstring('https://get.scoop.sh')
```

### Usage

For example, to install "curl" execute:
```
$: scoop install curl
```