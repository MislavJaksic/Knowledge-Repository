## [Putty](https://www.chiark.greenend.org.uk/~sgtatham/putty/)

PuTTY is a Windows `Telnet` and `SSH` client.  
A program for connecting to a remote computer.  
Uses `SSH` (Secure SHell) and `telnet`.  

TODO

### Install

[Download MSI Installer](https://www.chiark.greenend.org.uk/~sgtatham/putty/latest.html)  

### Generate key pair

```
$: puttygen  # -> a window pops up
```

Select key type.  
Press `Generate`.  
Enter a comment and a passphrase.  
Press `Save private key` (in `*.ppk` format).  

### Transfer files

```
$: pscp [-i Private-Key Source-File] User-Name@Host-Name:Destination-Path
```
