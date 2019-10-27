## [Linux basics](https://www.fer.unizg.hr/predmet/okosl)

### Chapter 1: basic commands

Stop execution -> CTRL+C

Long options are prefixed with --, short options are prefixed with -.  
Options can be chained together.  
```
$: ls -lh -> same as below
$: ls -l -h -> same as above
```

Basic commands:
```
$: man -> manual; "q" to exit
$: info -> command info
$: ls [-l -h -d] -> list; -l as long, -h as human, -d as describe
$: pwd -> current directory path
$: echo -> print value

$: cd -> change directory
$: mkdir [-p] -> create directory; -p create all directories on path

$: bash -> run script
```

### Chapter 2: directories

Main common root directories:
* /bin -> user and admin tools
* /boot -> OS kernel and bootup tools
* /dev -> files which represent devices
* /etc -> configuration files
* /lib -> operating system modules
* /lost+found -> directories restored after OS failure
* /media -> mobile devices (USB, DVD drives)
* /mnt -> manually add mobile devices (USB, DVD)
* /opt -> for programs not part of the OS
* /proc -> virtual files that change with the state of the OS
* /sbin -> system programs
* /tmp -> temporary files
* /var -> logs, email or other often shifting files
* /srv -> service, HTTP server and FTP files
* /home -> user home directory
* /root -> root user directory
* /usr -> has /bin and /sbin; programs for normal work 

```
touch -> create an empty file; p for named pipeline, d for directory, s for socket, b for block file, c for char file  
file -> find file type
head [-N] -> print few lines; -N for N lines
cat -> read file
stat -> show file details

nano/vim -> text editors

mv -> move/rename file
cp [-r] -> copy directory; -r as recursive copy

rm [-r -f] -> remove directory; -r as recursive delete, -f as force delete
rmdir -> remove directory if empty

df -> show memory by partition
du -> show memory by directory
```

### Chapter 3: command line input and output

stdin -> standard input, number 0  
stdout -> standard output, number 1  
stderr -> standard error, number 2  
All three look like files.  

```
( keyboard --- stdin ) ---> ( cat --- stdout ) ---> ( monitor )
```
STOPPED RIGHT HERE

cat acts as a filter.

\> - write to file operator.
```
ls -l / > /tmp/test != ls -l
```

\>> - append data to a file operator.

< - sent file content to a program operator.
```
cat < /ect/password
```

- represents stdin/stdout operator in commands.
```
wget -O - http://ftp.hr.debian.org/README
```

| - pipe operator.
```
ls -l /lib/ | head
```

ls -l /lib --- stdout ---> --- stdin ---> head ---> monitor

2> - error output redirection operator.
```
ls -l /lib1 2> /tmp/lib5
```

&> - joint stderr and stdout redirection operator.
2>&1 redirect stderr to stdin operator.

tee - redirect stdin to stdout and a file operator.

<< - write a file inline operator (here document).
```
cat << EOF //-> write inline until you input EOF
```

<<< - write a string inline operator (here string).
```
cat <<< 'hello'
```

Use && and || for conditional execution; what comes before && must return 0.
```
false || echo 1
```

wc - word count.
```
ls /usr/include | wc
```

grep - search for a pattern in a file.
```
grep SEEK_SET /usr/include/stdio.h
```

sort - sort lines.

uniq - check if there are duplicate lines; has lot of options.
cut leaves out a character from the file.

find - complex search command; \[-name\], \[-type\], \[-size\], \[-print\].
```
find /ect -type d -a -size +10k
```

locate - a much simpler find.

whereis - locate a manual page for a command.

### Chapter 4: scripts

Linux variables are like Python's.
All variables are strings.
There are global and local shell variables.
_script_name.sh scripts are run with the bash command.
Watch out for whitespaces! They make script execution harder as they confuse the Command Line parser.

= - assignment
$= - redirect output to a variable

export - convert a variable into a global one for child processes

echo $_var_name - show variable's value
local - make a variable local to a script

Conditions and tests are written within \[ \]. There are quite a few operators.
Return 0 if True.
```
\[1 -eq 1\] // -> returns 0, meaning True
```

Wildcards are substitute characters:
? is one character,
* is any character,
\[xyz\] is one among these,
^ is the not operator,
\ is an escape character.

### Chapter 5: regex

Regular expressions:
x - find character x.
^ - at the start of the line.
$ - at the end of the line.
. - find any character.
\[xy\] - find any character in the set.
\[^xy\] - find any character not in the set.
\[ - escape so that you can search by it.
| - OR
x* - appears many times or not at all.
x+ - appears at least once.
x? - appears once or not at all.
x{n} - appears n times.
x{n,m} - appears between n and m times.

```
^foo //-> find characters "foo" at the beginning of the line.
sigh$ //-> find characters "sigh" at the end of the line.
.*\[^aA\]$ //-> find a line that does not end with "a" or "A".
```

grep - use simple regex
egrep - use complex regex

sed - Stream EDitor
```
sed -r "s/windows/linux" file.txt //-> substitute the first appearance of "windows" with "linux" in "file.txt"
```

### Chapter 6: user management

Login with a password; logout using "exit"/"logout"/CTRL+D.
tty0, tty1, tty3, ... are terminal names.
pts/N are emulated terminal names.

"/etc/passwd" stores "name:password:UID:GID:info:main_dir:user_shell".
"/etc/shadow" stores encrypted passwords.
vipw - edit "passwd" file in a secure manner

who - shows info about the users
finger - detailed "who" command

sudo - gain admin privileges
visudo - edit "sudo" in a secure manner

"/etc/group" stores group info.

adduser, passwd, usermod and deluser - user control
su - Switch User; without arguments switches to root; \[_username\] switch to specific user

View permissions with "ls -l".
There are 9 permission characters. 1-3 for user, 4-6 for group, 7-9 for everyone.
"r" for read, "w" for write, "x" for execute.
```
- rw- r-- r-- 1 mislav users 0 Feb 4 20:29 text.txt
```

chmod _mode _object - change a permission (mode)
```
chmod u=x,go=r text.txt
```

TODO page 39 onwards...

### Chapter 7: processes, jobs and shells

Every process has a PID (Process ID).
ps - Process Status, list all processes; \[-e\] list all processes; \[-f\] more info
Process states are R for running, S for sleeping, I for idle, T for stopped, Z for zombie.

Signals allow processes to communicate.
"signal_handler" functions can intercept and interpret signals.
man 7 signal - list all signals
kill _PID - send SIGTERM to a process; \[_signal_code\] send a signal other then SIGTERM

A Parent process can create another process, a Child.
The Child has a PPID (Parent PID).
fork() - Parent creates a Child process
wait()/waitpid() - Parent waits for the Child to terminate

Shells may automate scripts.
There are different shells in Linux: sh, bash, csh, ksh, ...

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

CTRL+Z - suspend process in the foreground
fg/bg - unsuspend process in foreground/background
jobs - list jobs running in the shell

Processes have a PGID (Group PID). 
Groups can be part of a session.

### Chapter 8: environment variables, program installation and networking basics

Env vars (Environment Variables) are values which all processes can access.
echo _var_name - show env var value
printenv - list env vars

export _var_name=_var_value - set env var value for this shell
To set env vars such as PATH, you should edit a login scripts.

make _target - compile and install
tarball - unpack and install
Program package managers: dpkg, RPM, pacman.
Each package manager has a "front end" program: apt, yum, 
Front end program are commands that can be invoked.

Network interfaces: eth0, eth1, ...; - ethernet
                    w10, wifi0, ...; - WLAN
                    lo; - loopback
ifconfig, route or ip - make transient TCP/IP configuration changes
/etc/network/interfaces - interface configuration
```
auto eth0 //-> start eth0 at startup
iface eth0 inet static //-> eth0 is given a static IP
iface eth1 inet dhcp //-> eth1 will look for a dynamic IP
```

/etc/init.d/networking restart - restart networking service
iwconfig, iw - wireless configuration

/etc/resolv.conf - DNS config
```
nameserver 8.8.8.8
nameserver 8.8.4.4
```

dhclient, dhcpcd - DHCP clients

There is a Network manager which has a GUI and does not use the previously mentioned files.