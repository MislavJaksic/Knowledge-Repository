## [Go](https://golang.org/)

Also known as `golang`.  

### Uninstall and install

#### Linux

```
$: sudo rm -Rf /usr/local/go

Note: delete Go's `/bin` from `/etc/profile`
Note: delete Go's `/bin` from `$HOME/.profile`
```

```
Note: download the binary

$: sudo tar -C /usr/local -xzf gox.y.z.linux-amd64.tar.gz
```

Add `export PATH=$PATH:/usr/local/go/bin` to `$HOME/.profile`.  
Restart your computer.  

```
$: go version
```
