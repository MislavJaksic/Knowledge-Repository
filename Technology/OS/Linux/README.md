## Linux

Linux is a family of operating systems famous for its kernel.  
Linux comes with a lot of free office, system monitoring and programming tools, such as `OpenOffice` and process control program `top`.  

### Linux distributions

There are [many varieties of Linux](https://distrowatch.com/). They range from those that look like Microsoft Windows to those without a GUI.  
Each Linux OS is different, so take care not to mix up installation instructions or command syntax.  

* [Manjaro](https://manjaro.org/) - popular
* [Ubuntu](https://www.ubuntu.com/) - Desktop is like Windows, Server has no GUI
* [CentOS](https://www.centos.org/) - for servers
* [Alpine](https://alpinelinux.org) - tiny OS for container images, routers, firewalls, VPNs and servers

### Installation

Linux distributions can be installed using a USB, a DVD or a virtualisation software such as [VirtualBox](../../DevOps/VirtualMachines/VirtualBox).  

### Paths and directories

```
Absolute path: prefixed with /  
Relative path: without prefix /  

Current directory: .
Parent directory: ..
Hidden directory: prefixed with .
```

### Common Hotkeys

```
Paste: SHIFT+INSERT
Search: SHIFT+W

Autocomplete: TAB; double TAB

Switch workspace: CTRL+ALT+UP/DOWN
```

### Common Commands

```
$: man Command-Name  # show manual; "q" to exit
$: info Command-Name  # show command info

$: ls [-l] [-d] [-R]  # list directory contents
  # -l: show permissions, owner, ...
  # -d: describe current directory
  # -R: recursive
$: pwd  # show current directory path
$: cd /path/to  # change directory

$: apt/apt-get: Ubuntu package manager
$: yum: CentOS package manager
$: apk: Alpine package manager
$: tar -xzvf Package-Name  # extract/untar

$: bash Script-Name  # run script
$: sh Script-Name  # run script

$: sudo Command-Name  # run as admin/superuser
$: chmod Access-Modifiers File-Name  # modify access restrictions
$: sudo su - # login as root/superuser


$: touch File-Name  # create a file
$: cat File-Name  # show file
$: mv /path/to/Old-Dir-Name /path/to/New-Dir-Name  # move or rename file
$: cp /path/to/Dir-Name /path/to/New-Dir-Name [-r]  # copy directory
  # -r: recursive
$: rm /path/to/Dir-Name [-r] [-f]  # remove directory
  # -r: recursive
  # -f: force delete
$: rmdir /path/to/Dir-Name  # remove directory if empty

$: nano File-Name  # text editor
$: vim File-Name  # text editor


$: env  # print all ENV VAR
$: printenv  # print all ENV VAR
$: echo Value-Literal  # print value
$: echo $Value-Name  # list ENV VAR value
$: export Value-Name=_value  # set ENV VAR value

$: ps  # list Process IDs (PID)
$: kill PID  # SIGTERM/soft shutdown
$: kill -9 PID  # SIGKILL/hard shutdown

$: find / -name 'Search-Name'

$: lsb_release -a  # OS info
$: uname -m  # list architecture
  # armv5* == armv5
  # armv6* == armv6
  # armv7* == arm
  # aarch64 == arm64
  # x86 == 386
  # x86_64 == amd64
  # i686 == 386
  # i386 == 386
```

```
|: pipe output
>: overwrite a file
>>: append to file
```

```
$: ... | grep "Search-Term"  # filter

$: ... | grep -i "search-term"  # case insensitive

$: ... | grep -v "Search-Term"  # NOT
$: ... | grep "term1\|term2"  # OR
$: ... | grep -E "term1|term2"  # OR
```

### Network commands

```
$: netcat -l -p PORT  # create listener server
$: nc ...

$: ifconfig  # network interfaces
$: netstat  # network statistics
$: netstat -plunt  # discover which service exposes which port
$: ip addr  #
$: ip link  #
$: ip route  #
$: ss  #
$: ip -s  #

$: scp [-i Private-Key][-P Port] /source/path/File-Name User-Name@_ip:/destination/path
  # @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
  # @         WARNING: UNPROTECTED PRIVATE KEY FILE!          @
  # @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
  # ...
  # Note: use $: sudo chmod 600 Private-Key

$: sftp -oPort=Post-Number User-Name@Host-Name  # manipulate files on a remotely
```

### Setting PATH and DNS

Place an executable in `/usr/local/bin` and you'll be able to run it.  

Set `ENV VAR` in `sudo nano ~/.bashrc`.

Set `PATH` in:
* `/etc/environment`
* `.bashrc` which is in root

Set DNS in:
* `/etc/hosts`

### Generating an SSH key pair

#### Windows

See [PuTTY](../../DevOps/Security/Putty).  

```
$: git-gui
# Note: Help -> Show SSH Key -> Generate Key -> Copy (Public Key) To Clipboard
```

#### Linux

```
$: ssh-keygen -t ed25519 -C "SSH-Key-Name"   # generates a public-private key pair
  # Enter file in which to save the key (/home/_user/.ssh/id_ed25519): /home/_user/.ssh/id_ed25519-Name
$: cat /home/_user/.ssh/id_ed25519-Name.pub   # prints the PUBLIC key
  # ssh-ed25519 A-Long-String SSH-Key-Name
```
