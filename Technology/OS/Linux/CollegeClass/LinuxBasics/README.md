## [Linux basics](https://www.fer.unizg.hr/predmet/okosl)

### Chapter 1: basic commands

Stop execution with `CTRL+C`.  

Prefixes:
* long options: `--`  
* short options: `-`  

Options can be chained together.  

```
$: ls -ld  # chained options
$: ls -l -d  # unchained options
```

```
$: man Command-Name  # show manual; "q" to exit
$: info Command-Name  # show command info
$: ls [-l] [-d] [-R]  # list directory contents
  # -l: show permissions, owner, ...
  # -d: describe current directory
  # -R: recursive
$: pwd  # show current directory path
$: echo Value-Literal  # print value

$: cd /path/to  # change directory
$: mkdir /path/to/Dir-Name [-p]  # create directory
  # -p: create all directories on path

$: bash Script-Name  # run script
```

### Chapter 2: directories

Common root directories:
* `/bin`: user and admin tools
* `/boot`: OS kernel and bootup tools
* `/dev`: files which represent devices
* `/etc`: configuration files
* `/lib`: operating system modules
* `/lost+found`: directories restored after OS failure
* `/media`: mobile devices (USB, DVD drives)
* `/mnt`: manually add mobile devices (USB, DVD)
* `/opt`: for programs not part of the OS
* `/proc`: virtual files that change with the state of the OS
* `/sbin`: system programs
* `/tmp`: temporary files
* `/var`: logs, email or other often shifting files
* `/srv`: service, HTTP server and FTP files
* `/home`: user home directory
* `/root`: root user directory
* `/usr`: has `/bin` and `/sbin`; programs for normal work

```
$: touch File-Name  # create a file
$: file Resource-Name  # show resource type
$: head [-N]  # show a few file lines
  # -N: print N lines
$: cat File-Name  # show file
$: stat File-Name  # show file details

$: nano File-Name  # text editor
$: vim File-Name  # text editor

$: mv /path/to/Old-Dir-Name /path/to/New-Dir-Name  # move or rename file
$: cp /path/to/Dir-Name /path/to/New-Dir-Name [-r]  # copy directory
  # -r: recursive

$: rm /path/to/Dir-Name [-r] [-f]  # remove directory
  # -r: recursive
  # -f: force delete
$: rmdir /path/to/Dir-Name  # remove directory if empty

$: df Resource-Name  # show memory by partition
$: du Resource-Name  # show memory by directory
```

### Chapter 3: command line input and output

```
stdin: standard input, number 0  
stdout: standard output, number 1  
stderr: standard error, number 2
```
All three look like files.  

```
keyboard  --stdin-->  [cat]  --stdout-->  monitor
```
`cat` acts as a filter.  

File operators:
* `>`: create and write to a file
* `>>`: append data to a file
* `<`: sent file content to a program
* `-`: represents `stdin` or `stdout` in commands

```
$: ls -l / > /tmp/test
$: ls -l /bin/ >> /tmp/test
$: cat < /ect/password
$: wget -O - http://ftp.hr.debian.org/README
```

More file operators:
* `|`: pipe operator
* `2>`: error output redirection
* `&>`: joint `stderr` and `stdout` redirection
* `2>&1`: redirect `stderr` to `stdin`
* `tee`: redirect `stdin` to `stdout` and a file
* `<<`: write a file inline (`here document`)
* `<<<`: write a string inline operator (`here strings`)

```
$: ls -l /lib/ | head -5
### [ls -l /lib]  --stdout-->--stdin-->  [head -5]  --->  monitor

$: ls -l /lib1 2> /tmp/lib5
### [ls -l /lib1/]  --stdout-->  monitor
###                 --stderr-->  /tmp/lib5

$: cat << EOF  # write inline until you input EOF
$: cat <<< 'hello'
```

```
$: false && echo 1  # conditional execution
$: false || echo 1  # conditional execution

$: ls /usr/include | wc  # counts characters, words and lines

$: grep SEEK_SET /usr/include/stdio.h  # search for a pattern in a file
$: cat File-Name | grep pass123

$: sort File-Name  # sort lines

$: uniq File-Name  # check if there are duplicate lines; has lot of options.
$: cut File-Name  # leaves out a character from the file.

$: find /ect -type d -a -size +10k  # complex search command
  # -name: name
  # -type: type
  # -size: size
  # -print: show size

$: locate  # a much simpler find

$: which
$: whereis  # locate a manual page for a command
```

### Chapter 4: scripts

Linux variables are like Python's.  
All variables are strings.  
There are global and local `shell` variables.  
`Script-Name.sh` scripts are run with the `bash` command.  
Watch out for whitespaces! They make script execution harder as they confuse the Command Line parser.  

`=`: assignment
`$=`: redirect output to a variable

`export`: convert a variable into a global one for child processes

`echo $Var-Name`: show variable's value
`local`: make a variable local to a script

Conditions and tests are written within `[ ]`. There are quite a few operators.
Return 0 if True.
```
[1 -eq 1]  # returns 0, meaning True
```

Wildcards are substitute characters:
* `?`: one character
* `*`: any character
* `[xyz]`: one among these
* `^`: the not operator
* `\`: an escape character

### Chapter 5: regex

Regular expressions:
* `x`: find character x
* `^`: at the start of the line
* `$`: at the end of the line
* `.`: find any character
* `[xy]`: find any character in the set
* `[^xy]`: find any character not in the set
* `[`: escape so that you can search by it
* `|`: OR
* `x*`: appears many times or not at all
* `x+`: appears at least once
* `x?`: appears once or not at all
* `x{n}`: appears n times
* `x{n,m}`: appears between n and m times

Regex patterns:
* `^foo`: find characters "foo" at the beginning of the line
* `sigh$`: find characters "sigh" at the end of the line
* `.*\[^aA\]$`: find a line that does not end with "a" or "A"

`grep`: use simple regex
`egrep`: use complex regex

```
$: sed -r "s/windows/linux" file.txt  # substitute the first appearance of "windows" with "linux" in "file.txt"
```

### Chapter 6: user management

Login with a password.  
Logout using `exit` or `logout` or `CTRL+D`.  
`tty0`, `tty1`, `tty3`, ... are terminal names.  
`pts/N` are emulated terminal names.  

`/etc/passwd`: stores `name:password:UID:GID:info:main_dir:user_shell`.
`/etc/shadow`: stores encrypted passwords.
`vipw `: edit `passwd` file in a secure manner

`who`: shows info about the users
`finger`: detailed `who` command

`sudo`: gain admin privileges
`visudo`: edit `sudo` in a secure manner

`/etc/group`: stores group info

`adduser`, `passwd`, `usermod` and `deluser`: user control
`su` [User-Name]: Switch User, switch to root by default
  # User-Name: switch to specific user

There are 9 permission characters:  
* 1-3 for user
* 4-6 for group
* 7-9 for everyone

Mode types:  
* `r`: read
* `w`: write
* `x`: execute

```
$: ls -l  # -> view permissions
   # - rw- r-- r-- 1 testuser users 0 Feb 4 20:29 text.txt
```

```
$: chmod Mode-Type Resource-Name  # change a permission (mode)
$: chmod u=x,go=r text.txt
```

TODO page 39 onwards...
STOPPED HERE

### Chapter 7: processes, jobs and shells

Every process has a PID (Process ID).  
```
$: ps [-e] [-f]  # -> process states: R for running, S for sleeping, I for idle, T for stopped, Z for zombie
  # -e: list all processes
  # -f: more info
```

Signals allow processes to communicate.  
`signal_handler` functions can intercept and interpret signals.  
```
$: man 7 signal  # list all signals
$: kill _PID [Signal-Code]  # send SIGTERM to a process
  # Signal-Code: send a signal other then SIGTERM
```

A Parent process can create another process, a Child.  
The Child has a PPID (Parent PID).  
```
$: fork()  # Parent creates a Child process
$: wait()/waitpid()  # Parent waits for the Child to terminate
```

Shells may automate scripts.  
There are different shells in Linux:
* sh
* bash
* csh
* ksh
* ...

Bash is a popular shell.  
Can be used interactively.  
Each script can specify a preferred shell.  
```
#! /bin/bash
```

When a shell executes a process it creates a job.  
Jobs can be executing in the background.  
```
_command &
```

```
CTRL+Z  # suspend process in the foreground

$: fg/bg  # unsuspend process in foreground/background
$: jobs  # list jobs running in the shell
```

Processes have a PGID (Group PID).  
Groups can be part of a session.  

### Chapter 8: environment variables, program installation and networking basics

ENV VARs (Environment Variables) are values which all processes can access.  
```
$: echo _var_name  # show ENV VAR value
$: printenv  # list ENV VARs
$: export _var_name=_var_value  # set ENV VAR value for this shell
```
To set ENV VARs such as PATH, you should edit a login scripts.  

```
$: make _target  # compile and install
$: tarball  # unpack and install
```

Program package managers:
* dpkg
* RPM
* pacman

Each package manager has a "front end" program:
* apt
* yum

Front end program are commands that can be invoked.  

Network interfaces:
* eth0, eth1, ...;  # ethernet
* w10, wifi0, ...;  # WLAN
* lo;               # loopback

```
$: ifconfig, route or ip  # make transient TCP/IP configuration changes

/etc/network/interfaces  # interface configuration
```

```
$: auto eth0  # start eth0 at startup
$: iface eth0 inet static  # eth0 is given a static IP
$: iface eth1 inet dhcp  # eth1 will look for a dynamic IP
```

```
$: /etc/init.d/networking restart  # restart networking service
$: iwconfig, iw  # wireless configuration

/etc/resolv.conf  # DNS config
nameserver 8.8.8.8
nameserver 8.8.4.4
```

DHCP clients:
* dhclient
* dhcpcd

There is a Network manager which has a GUI and does not use the previously mentioned files.  
