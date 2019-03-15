## SSH

SSH is Secure SHell.

### [The Black Magic of SSH by Bo Jeanes](https://vimeo.com/54505525)

OpenSSH:
Connection fowarder
Transfer protocol
Force command exexution on a per public kay basis

#### Connection fowarding

Remote, local, dynamic X11, agent fowarding

Remote port fowarding / inbound tunneling:
expose local services to remote clients over your connection
makes SSH bind a port on the SSH server

TODO return to it later...

### Connect with a key

Connect by executing:
```
sudo ssh -i _key_file username@IP/NAME
```

The _key_file looks like:  
```
-----BEGIN RSA PRIVATE KEY-----
... lots of random characters ...
-----END RSA PRIVATE KEY-----
```
