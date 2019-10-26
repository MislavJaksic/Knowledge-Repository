## [Linux Advanced](https://www.fer.unizg.hr/predmet/nkosl)

### Chapter 1

Short version:  
```
Processor reads BIOS/UEFI from ROM.  
BIOS/UEFI find the bootloader using MBR/GPT.  
Bootloader is loaded.  
Bootloader runs the OS.  
OS reads initrd/initramfs which reads the rest of the kernel.  
The kernel runs the init/systemd with PID 1.  
init/systemd runs all the background processes.  
User is given control.  
```

BIOS (Basic Input and Output System) comes with every ROM (Read-Only Memory).  
BIOS will executes POST (Power On Self Test), testing the motherboard and devices connected to it.  
BIOS can configure the bootup.  
BIOS can be configured.  

UEFI (Unified Extensible Firmware Interface) is BIOS but better.  
Both BIOS/UEFI are layers between the OS and firmware.  

Hard disks have file system specified formatted partitions.  
Partitions are used for functional and logic data separation.  
Partition info is stored in MBR/GPT (Master Boot Record)/(GUID Partition Table).  

MBR contains the bootstrap code, partition table and a magic number. Can support up to 4 partitions.  
GPT is a better MBR, but only works with UEFI.  

Bootloader is executed after POST.  
Bootloader runs the OS kernel.  
GRUB (GRand Unified Bootloader) is a well known bootloader.  

Kernel is the core of an OS, in control of every other process with special memory protection.  
Kernel will read the initrd/initramfs (INITial RamDisk).  

initrd assists the kernel in starting the root file system.  
initrd is a small file system which is required to handle a larger file system.  
init is responsible for starting the OS.  
init will start after the kernel.  

systemd is init but better.  
systemd can be configured using unit files.  
systemctl - systemd control  

Add systemd services by adding unit files to "/etc/systemd/system/".  
```
$: systemctl daemon-reload -> restart after adding user files
$: systemctl start Service-Name -> run newly added service
```

Example of a systemd service unit file:  
```
[Unit]
Description=A Short Unit Description
After=network.target # sample restriction: don't run before network design
[Service]
Type=simple
User=my_username
ExecStart=/opt/Service-Name.sh
# You can add lines like:
# ExecStop=/opt/Service-Name.sh --stop # stop a program if it exists
# ExecReload=/opt/Service-Name.sh --reload # restart a program if it exists

# You can specify env vars
Restart=always # systemd will restart a program if it is not alive

[Install]
WantedBy=default.target # to which group does the service belong
```

Modules are pieces of code that extend the kernel without restarting the system.
Located in "/usr/lib/modules/kernel_release".
lsmod - list modules that are loaded
modprobe _module_name _param_name=_param_value - load a module
modprobe -r _module_name - unload module

### Chapter 2

File system determines how data will be read and written.
FAT (File Allocation Table) is a file system standard.

fdisk - tool for partition control
mkfs - create file system
TODO... skipped a lot of strange file system knowledge.

RAID (Redundant Array of Independent Disks) is a method of ensuring speed, capacity and robustness of hard disk memory.
RAID 0 - "stripping"; no redundancy, spread the data blocks among the disks
![RAID_0_image](E:\GreatRepository\Publishing\GitHubRepositories\KnowledgeRepository\Linux\UniversityClass\LinuxAdvanced/RAID_0.png)
RAID 1 - "mirror"; copy all data blocks from one disk to at least one other disk
![RAID_1_image](E:\GreatRepository\Publishing\GitHubRepositories\KnowledgeRepository\Linux\UniversityClass\LinuxAdvanced/RAID_1.png)
RAID 5 - "block-stripping with distributed parity"; calculate a parity block for each data block; cut the data block into equal pieces; do this for every data block; each disk can either have a parity block or a single data block piece of the same type stored on it
![RAID_5_image](E:\GreatRepository\Publishing\GitHubRepositories\KnowledgeRepository\Linux\UniversityClass\LinuxAdvanced/RAID_5.png)
RAID 1 then 0 and RAID 0 then 1 - combine RAID 0 and RAID 1
md - multiple devices; Linux's software for RAID control

LVM (Logical Volume Manager) is a flexible disk manager which uses a device mapper.
PV/LV/VG (Physical Volume)/(Logical Volume)/(Volume Group).
Abstracts logical and physical disk layers. Simplifies physical disk control.

Quotas restrict disk usage.

TODO... advanced file system capabilities.

### Chapter 3 (Helpful Intro to Internet Technologies)

OSI model (Open Systems Interconnection Reference Model) standardised communication.
Layers: application - DNS, DHCP, FTP, HTTP, SMTP
        presentation - MIME
        session - SOCKS, SAP, RTP
        transport - UDP, TCP
        network -  ICMP, IPsec, IPv4, IPv6, AppleTalk
        data link -  Ethernet, ARP, MAC, CSMA/CA
        physical -  Ethernet, USB, ISDN, 802.11, Bluetooth
RFC (Request For Comments) is a publication issued from the Internet governing body, a respected standard.
UDP (User Datagram Protocol) and TCP (Transmission Control Protocol) are the important transport layer protocols.

netcat - does everything involving TCP/UDP/sockets; amazing documentation; [-u] to use UDP instead of TCP; {-t] to send responses to DO and WILL requests
Example: netcat -l -p 1234 - creates a "server" that listens on port 1234
         netcat localhost 1234 - creates a "client" connected to port 1234; can send text between each other
telnet - interactive communication with a server
Example: telnet localhost 1234

TLS (Transport Layer Security) can encrypt data that we send.

HTPP(S) (Hyper Text Transport Protocol [Secure]) is a foundational data transfer protocol.
Example: echo "GET / HTTP/1.0\n\n" | nc google.com 80 - sends a manual HTTP request to google.com on port 80
If we want to use TCL and encrypt the data, we need to do all the work ourselves.
You can use openssl s_client, a SSL/TCL program.
Example: echo "GET / HTTP/1.0\n\n" | openssl s client -ign_eof6 -connect google.com:443

curl - transfer data between a client and a server using one of the many protocols
wget - downloads files from the web

To create your own HTTP server, you just need a few readily available services.
[DigitalOcean](https://www.digitalocean.com/) (among many other) allows you to create a private server.
[Namecheap](https://www.namecheap.com/) (among many other) allows you to register a domain name and offers DNS resolution for free.

SSH (Secure SHell) is a cryptographic network protocol often used to connect to remote computers using TCP and port 22.
ssh_config stores all the ssh keys.
[SSH Tunnel; Local and Remore Port Forwarding Tutorial](https://blog.trackets.com/2014/05/17/ssh-tunnel-local-and-remote-port-forwarding-explained-with-examples.html)

nginx is a free, simple and fast HTTP server.
To protect the communication you can use TCL.
To use TCL you need a Certificate issued by a Certification Authority.
[Let's Encrypt](https://letsencrypt.org/) is a CA that issued certificates for free.  
[nginx and Let's Encrypt Tutorial](https://www.digitalocean.com/community/tutorials/how-to-secure-nginx-with-let-s-encrypt-on-ubuntu-16-04)  
[CertBot and Let's Encrypt](https://certbot.eff.org/)  

DNS (Domain Name System) assignes your IP address a memorable name.
dig - Domain Information Grouper; DNS lookup utility
[dig Tutorial](https://www.madboa.com/geek/dig/)

A very simple way of resolving DNS is to configure /etc/hosts.
/etc/hosts is where you can map IPs to DNS.

SCP (Secure CoPy), FTP(S) (File Transfer Protocol [Secure]) or SFTP (SSH File Transfer Protocol) can be used to interact with files on a server.

(F)CGI ([Fast] Common Gateway Interface) is a way of sending dynamic content to clients.
[nginx and CGI Tutorial](https://www.howtoforge.com/serving-cgi-scripts-with-nginx-on-debian-squeeze-ubuntu-11.04-p3)

SMTP (Simple Mail Transfer Protocol), IMAP (Internet Message Access Protocol) and POP (Post Office Protocol) are used for accessing and writing emails.

WebDAV (Web Distributed Authoring and Versioning) is a HTTP extension for server document handling.
CardDAV (vCard Extensions to WebDAV) and CalDAV (Calendaring Extensions to WebDAV) are extensions to WebDAV.

NTP (Network Time Protocol) can be used to sync computer clocks.
ntpd/systemd-timesyncd - local services for time synchronisation 

VPN (Virtual Private Network) ia a logical network that restricts resource usage to those who are in it.
VPN increase security and privacy.
[OpenVPN](https://openvpn.net/)
[OpenVPN on Ubuntu Tutorial](https://www.digitalocean.com/community/tutorials/how-to-set-up-an-openvpn-server-on-ubuntu-16-04)

[Network Programming Guide](https://beej.us/guide/bgnet/)

### Chapter 4

TCP/IP model layers:
Application
Transport
Internet
Link

MAC (Media Access Control) ensures medium access.
MAC addresses a assigned to each network element. Each MAC address is unique.

Internet layer uses IPv4 and IPv6 addresses.
Examples: IPv4       192.168.100.100
          IPv6 full  fc00:0000:0000:0000:0000:0000:0001:00db
          IPv6 short fc00::1:db

Subnet is a part of a network which has its own IP address interval and subnet mask.
Example:
Network IP:  172.16.64.0   == 10101100.00010000.01000000.00000000
Subnet mask: 255.255.192.0 == 11111111.11111111.11000000.00000000
IPs in subnet:                10101100.00010000.01******.********
CIDR notation: 172.16.64.0/18
A subnet mask must have ones first and tehn zeroes, they cannot be mixed.
CIRD notation says how many ones are in the subnet mask.
The first address 172.16.64.0 and last address, broadcast address, 172.16.127.255, cannot be taken.

Special addresses:
local networks
10.0.0.0/8
172.16.0.0/12
192.168.0.0/16
fc00::/7
link-local networks
169.254.0.0/16
fe80::/10
multicast address
224.0.0.0/4
loopback address
127.0.0.1
::1

IP addresses can be assigned statically or dynamically using DHCP (Dynamic Host Configuration Protocol).
IP config can be done through networking, netctl, systemd-networkd, NetworkManager or wicd.
Examples: auto eth0              - start eth0 at startup
          iface eth0 inet static - eth0 is given a static IP
          iface eth1 inet dhcp   - eth1 will look for a dynamic IP

"/etc/network/interfaces" is read during network adapter shutdown and power up.
ipconfig/ip - used to change IP configuration

Routing is a process of connecting subnets.
route -n/ip route show - list IP routing table

DNS transforms an IP address from numbers into a name.

iptables - firewall, a kernel netfilter framework, which can filter data packets.
Has rule chains and targets, actions which it should take.

NAT (Network Address Translation) connects local networks.
Implemented in iptables.
SNAT and DNAT (Source NAT/Destination NAT).

A single adapter can have multiple IP addresses.

NetworkManager is a program for configuring networks.

WLAN (Wireless Local Area Network) is defined by: SSID (Service Set Identifier), network name; BSSID (Basic Service Sets ID), access point identifier; security level (open, WEP, WPA)
iwlist, iwconfig, wpa_supplicant - WLAN configuration

Logs are used to diagnose problems and monitor complex systems.
"/var/log" stores boot.log, auth.log and dpkg.log logs.
systemd uses journalctl to store logs.

rsyslog is a modern Linux log writer.
"/etc/[r]syslog.conf" stores syslog/rsyslog configuration.
Has a API: "logger [options] [message]".
logrotate - log management
"/etc/logrotate.conf" and "/etc/logrotate.d/" store log manager configuration.

journalctl - used for querying systemd journal

### Chapter 5

top - realtime system resource and process monitoring
htop - better then top
"/proc" is where all data about processes is stored.

strace - traces system calls and signals
Example:
strace uptime 2>&1 | grep open
iotop - input output top
iostat - input output statistics
atop - top for everything

Other monitoring tools:
Zabbix - agent, server, visualisation
Ossec - log supervision, emails
Sentry - error tracking, accumulation, agent, server, plugins
Kibana - visualisation
Grafana - visualisation
Prometheus - visualisation

Virtualisation is the emulation of multiple computers on a single physical computer.
VM are isolated from one another and the physical computer.
VM are more portable which means they are easier to deploy.

Host OS can host many Guest OSs.
Virtualisation software: VirtualBox, VMware.
They are very easy to use, but their performance is terrible.

Hypervisor is a OS built for virtualisation.
Hypervisor software: Xen, HyperV, VMware, ...
They are quite complicated.

Kernel virtualisation is when a Linux kernel is transformed into a hypervisor.
KVM (Kernel-based Virtual Machine)
They are quite complicated and can only be created for Linux.

[QEMU](https://www.qemu.org/) is a machine emulator and virtualisation software.

Shared kernel virtualisation, container, is when VMs share a kernel.
For Linux: lxc, docker, runC, ...
They are easy to use, offer excellent performance, but are OS/kernel dependent.

cgroups - isolation on a process level; limit resources; namespace isolation

### Chapter 6

Namespace isolation is a process which hides resources from processes.

LXC (LinuX Containers) is a shared kernel virtualisation which uses cgroups and namespaces.

Docker can virtualise at the process/application level.
Docker has a lot of useful features for deployment and management.
Docker has: a client, daemon/engine and a hub.
Docker core is the Docker image system on a copy-on-write file system.
Base images are available on [Docker Hub](https://hub.docker.com/).
Dockerfile is a template for Docker image construction.

Example of dockerfile:
```
FROM ubuntu:latest # base Docker image

RUN apt-get update # commands that run when constructing a container
RUN apt-get install -y python-pip \
python-dev \
build-essentials \

COPY . /app # copy host files to container
WORKDIR /app # "cd /app"; change directory

RUN pip install -r requirements.txt
ENV FLASK_APP nkosl-blog.py # env vars

ENTRYPOINT ["python", "-m", "flask", "run"] # describes commands that will run when the container is run
CMD ["--host=0.0.0.0"] # arguments for ENTRYPOINT
```

Docker commands:
docker build -t "my_image" - build Docker image
docker run -p 5000:5000 \
my_image --host=0.0.0.0 - run Docker image
docker ps - list running Docker images

docker-compose - run a system of containers
Use YAML to declare Docker image relationship.

Docker can be used at a very large scale (thousands).
Software tools: Kubernetes, Mesos.
