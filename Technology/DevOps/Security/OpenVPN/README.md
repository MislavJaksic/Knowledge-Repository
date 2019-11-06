## [OpenVPN](https://openvpn.net/download-open-vpn/)

### [Installation](https://openvpn.net/community-resources/installing-openvpn/)

#### Windows

Download, double click the executable and install OpenVPN.  

#### Linux

```
$: sudo apt install openvpn

# Note: if you get an error "... no acceptable C compiler in $PATH" do:
$: apt-get update
$: apt-get upgrade
$: sudo apt-get install build-essential
```

### Running

#### Windows

```
# An example of a Microsoft Windows OpenVPN configuration

# Set remote host or comment out to enter a listening server mode
remote myremote

# Default port number is 1194
; port 1194

# Default protocol is udp
; proto [tcp-server | tcp-client | udp]

# tap: VPN, ethernet bridging or route broadcast
# tun: IP , efficient and requires configuration, Solaris/OpenBSD/Mac OS X
dev [tap | tun]

# dev tap configuration
# Create a virtual ethernet subnet
# 10.3.0.1 is the local VPN IP address
# 255.255.255.0 is the VPN subnet
ifconfig 10.3.0.1 255.255.255.0

# dev tun configuration
# Create a point-to-point IP link
# 10.3.0.1 is the local VPN IP address
# 10.3.0.2 is the remote VPN IP address
# A remote machine must have tun-mtu first while a client machine must have ifconfig first... or the other way around
; tun-mtu 1500
; ifconfig 10.3.0.1 10.3.0.2

# For Path MTU discovery lower the TCP MSS and internally fragment non-TCP protocols
; fragment 1300
; mssfix

# If you have more than one TAP-Win32 adapter refer to it by name
; dev-node my-tap

# You can generate a secret key with openvpn --genkey secret key.txt
# Place key.txt in the same directory as this config file on both the remote computer and the client
secret key.txt

# For a more reliable detection when a system loses its connection
; ping-restart 60
; ping-timer-rem
; persist-tun
; persist-key
; resolv-retry 86400

# keep-alive ping
ping 10

# enable LZO compression
comp-lzo

# moderate verbosity
verb 4
mute 10
```

##### [Command Line Interface](https://openvpn.net/community-resources/running-openvpn-from-a-console-window/)

Double click the file or execute:
```
$: openvpn --config File-Name.ovpn
```

##### [Windows Service](https://openvpn.net/community-resources/running-openvpn-as-a-windows-service/)

TODO

### Linux

##### Command Line Interface

Tunnel to the remote computer by executing:  
```
$: sudo openvpn --config File-Name.ovpn --auth-user-pass Username-Password-File.txt  #-> Enter Auth ...
```

You can check if the connection has been established by executing:
```
$: ifconfig -> show network interfaces; discover tunnel IP
$: route -n -> show IP routing table
```

### Connect to remote computer

Connect to a remote computer:  
* using [Putty](../Putty)
* or [SSH](../SSH)

### Other topics

#### [HOW-TO OpenVPN 2.2.x](https://openvpn.net/community-resources/how-to/)

TODO

#### [Autorun on system startup](https://openvpn.net/community-resources/configuring-openvpn-to-run-automatically-on-system-startup/)

TODO

#### [Client/server quickstart](https://openvpn.net/community-resources/openvpn-quickstart/)

TODO
