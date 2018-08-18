## Linux

Linux is a free operating system. There are many varieties of Linux, from those without a GUI to those that
look and operate in a similar way to Windows. Many Linux operating systems are free and come with a plethora of
free tools, such as OpenOffice instead of Microsoft Office.

Each operating system is a bit different, so take care when executing commands.

### [Distribution list](https://distrowatch.com/)

You can look up Linux distribution on the website.

[Manjaro](https://manjaro.org/) - quite popular

[Ubuntu](https://www.ubuntu.com/) - similar to Windows

### Installation

There are different ways of installing each Linux distribution.
They can be installed from a USB, using a DVD or using a virtualisation software.

### Tips and Tricks

Commands:
* paste text with Shift+Insert
* Tab to automatically complete words
* "sudo -i" on Ubuntu to gain admin access
* "ps" to show which processes are running
* "kill" to shutdown a process

Running and installing software:
* _script_name.sh is a script
* install _program_name.tar.gz software with "tar -xzvf _program_name.tar.gz"

Paths and files:
* absolute paths begins with / and relative paths don't
* .. is the parent directory, . is the current directory
* hidden directories are prefixed with a dot (.)
* by convention, put personal non-binary files into /opt 

PATH and network:
* set PATH in /etc/environment or, even better, .bashrc located in root
* set DNS resolution in /etc/hosts so you can use names instead of numbers
* "scp [-P _port] _file_name _username@_hostname_OR_IP:/opt/_filename" to transfer files to the remote host (including Docker)
* often used ports are 22 and 2222
* "ifconfig" to look up IPs and other network interface information
* "netstat" to look up network statistics
* "ip addr", "ip link", "ip -s" supercede "ifconfig"
* "ip -s", "ss", "ip route" supercede "netstat"

Editing:
* search in nano with CTRL+W
* scite is an alternative to Notepad++ on Linux
