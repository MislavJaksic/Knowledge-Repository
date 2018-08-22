## Linux

Linux is a free operating system famous for its kernel. There are [many varieties of Linux](https://distrowatch.com/). There are those that
look like Windows to those without a graphical interface. Linux comes with a plethora of free office, system
monitoring and programming tools, such as OpenOffice and top.

Each Linux operating system is a bit different, so take core not to mix up installation instructions or
command syntax.

### Linux distributions

You can look up Linux distribution on the website.

[Manjaro](https://manjaro.org/) - quite popular

[Ubuntu](https://www.ubuntu.com/) - Desktop is similar to Windows; Server has no interface

[CentOS](https://www.centos.org/) - useful as a server

### Installation

Linux distribution can be installed from a USB, using a DVD or using virtualisation software.

### Tips and Tricks

Commands:
* SHIFT+INSERT to paste
* TAB automatically completes words
* "sudo _command" to grant admin access to "_command"
* "ps" list running processes
* "kill" to quit a process
* "find / -iname '*_file_name*' -path '*_path_to_file_name*' > _output_file" for searching
* "bash _script_name.sh" runs a script

Installing software:
* "_script_name.sh" is a script
* "tar -xzvf _program_name.tar.gz" will install "_program_name.tar.gz"

Paths and files:
* absolute paths begin with "/", relative paths don't
* ".." is the parent directory, "." is the current directory
* hidden directories are prefixed with "."

PATH and network:
* set PATH in "/etc/environment" or ".bashrc" located in root
* set DNS in "/etc/hosts"
* "scp [-P _port] _file_name _username@_hostname_OR_IP:/opt/_filename" to transfer files
* SSH port is 22
* "ifconfig" to look up IPs and other network interface information
* "ip addr", "ip link", "ip -s" supercede "ifconfig"
* "netstat" to look up network statistics
* "ip -s", "ss", "ip route" supercede "netstat"

Editing:
* CTRL+W to search in nano
* scite is an alternative to Notepad++ on Linux
