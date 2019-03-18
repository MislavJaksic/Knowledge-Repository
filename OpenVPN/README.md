## [OpenVPN](https://openvpn.net/download-open-vpn/)

### [Installation](https://openvpn.net/community-resources/installing-openvpn/)

Tip: you can find "x.y.z" on the download page  

On Windows:  
```
Double click the executable and install OpenVPN
```

On Linux:  
```
$: sudo apt install openvpn
```

Or if you are feeling adventurous:  
```
-> Download openvpn-x.y.z.tar.gz

$: tar xfz openvpn-x.y.z.tar.gz
$: cd openvpn-x.y.z
$: ./configure
$: make
$: make install
```

Error "... no acceptable C compiler in $PATH" is solved by executing:  
```
$: apt-get update
$: apt-get upgrade
$: sudo apt-get install build-essential
```

### Running on Windows

#### [Command Line Interface](https://openvpn.net/community-resources/running-openvpn-from-a-console-window/)

Create a File-Name.ovpn file based on the example in:
```
\Program Files\OpenVPN\config\sample.ovpn.txt
```

Double click the file or execute:
```
openvpn --config File-Name.ovpn
```

#### [Windows Service](https://openvpn.net/community-resources/running-openvpn-as-a-windows-service/)

TODO

### Running on Linux

#### Command Line Interface

Create a File-Name.ovpn file based on the example in:
```
\Program Files\OpenVPN\config\sample.ovpn.txt
```

Tunnel to the remote computer by executing:  
```
$: sudo openvpn --config File-Name.ovpn -> optional: enter password
```

You can check if the connection has been established by executing:
```
$: ifconfig -> show network interfaces; discover tunnel IP
$: route -n -> show IP routing table
```

### Connect to remote computer

Connect to a remote computer:  
* using [Putty](https://github.com/MislavJaksic/Knowledge-Repository/tree/master/RemoteComputing/Putty)
* or [SSH](https://github.com/MislavJaksic/Knowledge-Repository/tree/master/RemoteComputing/SSH)

### Other topics

#### [HOW-TO OpenVPN 2.2.x](https://openvpn.net/community-resources/how-to/)

TODO

#### [Autorun on system startup](https://openvpn.net/community-resources/configuring-openvpn-to-run-automatically-on-system-startup/)

TODO

#### [Client/server quickstart](https://openvpn.net/community-resources/openvpn-quickstart/)

TODO
