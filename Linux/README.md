## Linux

Linux is a family of operating systems famous for its kernel.  
Linux comes with a lot of free office, system monitoring and programming tools, such as OpenOffice and process control program top.  

### Linux distributions

There are [many varieties of Linux](https://distrowatch.com/). They range from those that look like Microsoft Windows to those without a GUI.  
Each Linux OS is different, so take care not to mix up installation instructions or command syntax.  

* [Manjaro](https://manjaro.org/) - quite popular
* [Ubuntu](https://www.ubuntu.com/) - Desktop is similar to Windows; Server has no interface
* [CentOS](https://www.centos.org/) - useful as a server
* [Alpine](https://alpinelinux.org) - for routers, firewalls, VPNs and servers; tiny

### Installation

Linux distributions can be installed using a USB, a DVD or a virtualisation software such as [VirtualBox](https://github.com/MislavJaksic/Knowledge-Repository/tree/master/Virtualisation/VirtualMachines/VirtualBox).

### Paths and directories

```
Absolute path -> begins with "/"  
Relative path -> begins without "/"  

Current directory -> is "."
Parent directory -> is ".."
Hidden directory -> begins with "."
```

### Common hotkeys and commands

Common commands:
```
$: man Any-Command -> manual; "q" to exit
$: info Any-Command -> command info

S: pwd -> list directory path
$: ls -> list directory
$: cd /path -> change directory

$: apt/apt-get ... -> Ubuntu package manager
$: yum ... -> CentOS package manager
$: apk ... -> Alpine package manager
$: tar -xzvf Package-Name -> extract/untar

$: bash Script-Name.sh -> run script
$: sh Script-Name.sh

$: sudo Any-Command -> run as admin/superuser
$: chmod Access-Modifiers File-Name -> modify access restrictions



$: mkdir Dir-Name -> create directory
$: cp _source _destination -> copy
$: mv _source _destination -> move/cut

$: echo $Value-Name -> list env var value
$: export Value-Name=_value -> set env var value

$: ps -> list Process IDs (PID)
$: kill PID -> SIGTERM/soft shutdown
$: kill -9 PID -> SIGKILL/hard shutdown

$: uname -a -> Ubuntu OS info
$: lsb_release -a -> Centos OS info
```

Pipe and file commands:
```
| -> pipe output
> -> overwrite a file
>> -> append to file
```

Pattern matching:
```
$: ... | grep "Search-Term" -> filter

$: ... | grep -i "search-term" -> case insensitive

$: ... | grep -v "Search-Term" -> NOT
$: ... | grep "term1\|term2" -> OR
$: ... | grep -E "term1|term2" -> OR
```

Misc hotkeys:
```
Paste -> SHIFT+INSERT
Search -> SHIFT+W

Autocomplete -> TAB; double TAB

Switch workspace -> CTRL+ALT+UP/DOWN
```

### Network commands

```
$: netcat -l -p PORT -> create listener server
$: nc ...

$: ifconfig -> network interfaces
$: netstat -> network statistics
$: ip addr -> 
$: ip link -> 
$: ip route -> 
$: ss -> 
$: ip -s -> 

$: scp [-P PORT] /source/path/File-Name USERNAME@HOST/IP-PORT:/destination/path
```

### Setting PATH and DNS

Set PATH in:
* /etc/environment
* .bashrc which is in root

Set DNS in:
* /etc/hosts
