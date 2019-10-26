## SSH

SSH stands for Secure SHell.  

### [The Black Magic of SSH by Bo Jeanes](https://vimeo.com/54505525)

OpenSSH:  
* connection forwarder  
* transfer protocol  
* force command execution on a per public kay basis  

#### Connection forwarding

Remote, local, dynamic X11, agent forwarding  

Remote port forwarding / inbound tunnelling:  
expose local services to remote clients over your connection  
makes SSH bind a port on the SSH server  

TODO  

### Connect with a key

Connect by executing:
```
$: sudo ssh -i Key-File username@IP/NAME
```

The Key-File looks like:  
```
-----BEGIN RSA PRIVATE KEY-----
... lots of random characters ...
-----END RSA PRIVATE KEY-----
```
