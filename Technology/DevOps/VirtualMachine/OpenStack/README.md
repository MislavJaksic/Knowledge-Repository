## [OpenStack](https://www.openstack.org/)

TODO

### Configure access and security for instances

Secure OpenStack with a private-public key pair and connect with SSH.  

[Instructions](Docs/TrainRelease/DashboardHorizon/UserDocs/ConfigureAccessAndSecurity)



TODO

### Create an Image Instance

Instances are Virtual Machines.  

Project -> Compute -> Images -> Choose a Base Image:  
```
Details - fill in Instance Name
Source - select Create New Volume: No
Flavour - pick a size
Networks - pick MGMT first, DEV second
Key Pairs - choose a key for authentication
```

### Connect to an Image Instance

Connect to a remote computer:  
* using [Putty](../../Security/Putty)
* or [SSH](../../Security/SSH)  

Connect using MGMT network IP. DEV network is for intra cluster communication.  
You may need to provide a key for authentication.  

### Transfer file to and from an Image Instance

If logged in to the <source> system:  
```
$: sudo scp -i Optional-Key /path/to/_file_name username@IP/NAME:/path/to/destination
```

If permission is denied execute:  
```
$: sudo chmod 777 /path/to/destination
```
