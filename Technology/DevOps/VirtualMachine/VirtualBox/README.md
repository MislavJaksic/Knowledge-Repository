## [VirtualBox](https://www.virtualbox.org/)

VirtualBox is a virtualization program that manages VMs.

[VirtualBox User Manual](https://www.virtualbox.org/manual/UserManual.html)

### Creating VMs

To create a VM you first need to download a VM image.  
During the VM setup you will be asked to provide a VM image.  
The VM will then be created.  

Check if the VM has enough:
* memory
* disk space
* processor cores

### [Guest additions](https://www.virtualbox.org/manual/ch04.html)

Guest additions allow data to be transferred between the VM and the host OS.  

```
# Install guest additions
Open VM -> "Devices" -> "Insert Guest Additions" -> Install
```

#### Shared clipboard

```
# Share a copy-paste clipboard
Open VM -> "Devices" -> "Shared Clipboard"
```

#### Shared folders

```
# Shared folders
Open VM -> -> "Devices" -> "Shared Folders" -> "Shared Folders Settings" -> "Adds new shared folder"
# Recommended: Auto-mount and Make Permanent
# Restart is required
```

On Ubuntu run `sudo usermod -a -G vboxsf User-Name` to remove the `You do not have the permissions necessary to view the contents of ‘shared_folder'` error.  

### [Networking](https://www.virtualbox.org/manual/ch06.html)

By default, one virtual network card is enabled and it is set to NAT (Network Address Translation).  

| Modes | VM <-> Host | VM1 <-> VM2 | VM -> Internet | VM <- Internet |
| :--- | :---: | :---: | :---: | :---: |
| Host-only | + | + | - | - |
| Internal | - | + | - | - |
| Bridged | + | + | + | + |
| NAT | - | - | + | Port forwarding |
| NAT Network | - | + | + | Port forwarding |

#### NAT

Without port forwarding, the VM will be able to access the Internet.  
With port forwarding, the VM could be accessed from the Internet.  

#### [Port forwarding NAT](https://www.virtualbox.org/manual/ch06.html#natforward)

Port forwarding is telling VirtualBox to which host ports it should listen.  
When the host receives a packet, they are then resent to the VM on the specified port.  
You can never have a service on a VM and on a host listen to the same port.  

To configure port forwarding click on Settings -> Network -> choose a NAT adapter -> expand the options with Advanced -> click Port forwarding

| Examples | Protocol | Host IP | Host Port | Guest IP | Guest IP |
| :--- | :--- | :--- | :--- | :--- | :--- |
| Guest ssh | tcp | - | 2222 | - | 22 |
| Interface | tcp | 127.0.0.1 | 2222 | - | 22 |

`Guest SSH`: forward all TCP traffic arriving on any host interface via port 2222 to port 22 in the guest.  
`Interface`: forward all TCP traffic arriving on the localhost interface (127.0.0.1) via port 2222 to port 22 in the guest.  
