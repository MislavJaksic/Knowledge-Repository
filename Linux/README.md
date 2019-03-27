## Linux

Linux is a family of operating systems famous for its kernel.  
Linux comes with a lot of free office, system monitoring and programming tools, such as OpenOffice and
process control program top.  

### Linux distributions

There are [many varieties of Linux](https://distrowatch.com/). They range from those that look like Windows
to those without a graphical interface.  
Each Linux OS is different, so take care not to mix up installation instructions or command syntax.  

[Manjaro](https://manjaro.org/) - quite popular

[Ubuntu](https://www.ubuntu.com/) - Desktop is similar to Windows; Server has no interface

[CentOS](https://www.centos.org/) - useful as a server

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

Hotkeys:
```
Paste -> SHIFT+INSERT
Autocomplete -> TAB; double TAB
```

Common commands:
```
$: sudo Any-Command -> admin access

$: man Any-Command -> manual; "q" to exit
$: info Any-Command -> command info
$: ls -> list
S: pwd -> current directory path
$: echo $Value-Name -> print value

$: cd /path -> change directory
$: mkdir Name -> create directory

$: bash Script-Name.sh -> run script

$: ps -> list PIDs
$: kill PID -> SIGTERM/soft shutdown
$: kill -9 PID -> SIGKILL/hard shutdown

$: apt ... -> Ubuntu install manager
$: apk ... -> 
$: yum ... -> Centos install manager
$: tar -xzvf _program_name.tar.gz Package.tar.gz -> install/unpack

$: find /root/of/search -iname "File-Name.*" -> find file

$: uname -a -> Ubuntu OS info
$: lsb_release -a -> Centos OS info
```

### Network command

```
$: netcat -l -p PORT -> create listener server

$: ifconfig -> network interfaces
$: netstat -> network statistics
$: ip addr -> 
$: ip link -> 
$: ip route -> 
$: ss -> 
$: ip -s -> 

$: scp [-P PORT] /source/path/File-Name USERNAME@HOST/IP-PORT:/destination/path
```

### Editing files

Hotkeys:
```
Search -> SHIFT+W
```

### Setting PATH and DNS

Set PATH in:
* /etc/environment
* .bashrc which is in root

Set DNS in:
* /etc/hosts
