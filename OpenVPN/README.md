## [OpenVPN](https://openvpn.net/download-open-vpn/)

### [Installation](https://openvpn.net/community-resources/installing-openvpn/)

Tip: you can find out "x.y.z" by visiting the download page  

On Windows:  
```
Double click the executable and install OpenVPN.
```

On Linux:  
```
$: sudo apt install openvpn
```

Or if you are feeling adventureuos:  
```
-> Download openvpn-x.y.z.tar.gz

$: tar xfz openvpn-x.y.z.tar.gz
-> Descend into openvpn-x.y.z folder
$: ./configure
$: make
$: make install
```

If you get an error "... no acceptable C compiler in $PATH" execute:  
```
$: apt-get update
$: apt-get upgrade
$: sudo apt-get install build-essential
```

### Running on Windows

#### [Command Line Interface](https://openvpn.net/community-resources/running-openvpn-from-a-console-window/)

Create a _file_name.ovpn file based on the example in:
```
\Program Files\OpenVPN\config\sample.ovpn.txt
```

Double click on the file or execute:
```
openvpn --config _file_name.ovpn
```

#### [Windows Service](https://openvpn.net/community-resources/running-openvpn-as-a-windows-service/)

TODO

### Running on Linux

#### Command Line Interface

Create a _file_name.ovpn file based on the example in:
```
\Program Files\OpenVPN\config\sample.ovpn.txt
```

Connect to the client/server by executing:  
```
$: sudo openvpn --config _file_name.ovpn
```

A few useful command for checking if the connection has been established are:
```
$: ifconfig -> show network interfaces
$: route -n -> show IP routing table
```

#### [How to for OpenVPN 2.2.x](https://openvpn.net/community-resources/how-to/)

TODO

#### [Autorun on system startup](https://openvpn.net/community-resources/configuring-openvpn-to-run-automatically-on-system-startup/)

TODO

#### [Client/server quickstart](https://openvpn.net/community-resources/openvpn-quickstart/)

TODO
