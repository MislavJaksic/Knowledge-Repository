## [Git](https://git-scm.com/)

Git is a distributed version control system. It tracks file changes and lets you recall previous version.  

### Install

#### Linux

```
$: sudo dnf install git-all -> Fedora, RHEL, CentOS, ...
$: sudo apt install git-all -> Debian, Ubuntu, ...
```

#### Windows

To install:  
* either download and install the executable  
* or get a command line installer such as [Scoop](https://scoop.sh/) and execute:
```
$: scoop install git
$: scoop install openssh
$: [environment]::setenvironmentvariable('GIT_SSH', (resolve-path (scoop which ssh)), 'USER')
# Note: restart the shell
```

#### Post-installation setup

```
$: git config --list

$: git config --global user.name "Mislav Jaksic"
$: git config --global user.email jaksicmislav@gmail.com

$: git config _option
  # _options:
    # /etc/gitconfig - lists configs that apply to every user  
    # /.gitconfig - lists configs specific to a user  
    # config - lists configs that apply to a Git directory  
```
