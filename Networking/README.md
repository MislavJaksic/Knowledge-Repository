## Networking

### Internet to router

The ISP has a big pool of IP addresses. Each router is assigned an IP address by an ISP. This address can be
static or it can change.
You can lookup your router's IP address by either searching for "external IP address" or you can look it up on
the router's interface.

### Router to device

The router routes data depending on its configuration. In order to let incoming traffic through to a port, you
need to forward a port on a router.
Routers have different port forwarding rules. You can look them up [here](https://portforward.com/).

After forwarding aport it is also a good idea to assign a machine that will receive incoming traffic a static
IP address within the routers subnetwork. Again, different routers do it in different ways, however on Windows
the procedure is as follows:
```
Control Panel -> Network and Internet -> Network and Sharing Centre -> Change adapter settings ->
Right click the Internet Network Connection -> Properties -> Internet Protocol Version 4 -> Properties ->
Use the following IP address

IP address: 192.168.xxx.yyy #xxx is a set number #yyy is a number you choose
Subnet mask: 255.255.255.255
Default gateway: ...TODO
Preferred DNS server: ...
Alternative DNS server: ...
```
[Look up additional instructions](https://portforward.com/networking/static-ip-windows-10.htm).

### Device to virtual machine

If you want to forward traffic to the virtual machine you have to open a port on the virtual machine.

#### VirtualBox port forwarding

[VirtualBox: Port forwarding NAT](https://github.com/MislavJaksic/KnowledgeRepository/tree/master/Virtualisation/VirtualMachines/VirtualBox/README.md)

#### VMWare

### Virtual machine to Docker


