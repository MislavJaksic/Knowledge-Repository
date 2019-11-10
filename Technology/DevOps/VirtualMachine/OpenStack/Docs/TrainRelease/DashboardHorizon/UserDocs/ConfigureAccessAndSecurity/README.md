## [Configure access and security for instances](https://docs.openstack.org/horizon/train/user/configure-access-and-security-for-instances.html)

Add security group rules to enable users to ping and use SSH to connect to the instance.  
Security groups are sets of IP filter rules that define networking access.  

Key pairs are injected into an instance using the `cloud-init` package.  
A key pair belongs to an individual user. To share a key pair across multiple users, each user needs to import that key pair.  

A fixed IP address and a floating IP address can be attached to an instance.  

### Add a rule to the default security group

Enables:
* SSH
* ICMP (ping)

The rules apply to all instances within a given project.  
Rules require a protocol and a destination or source port.  

1) Project tab -> Network tab -> Security Groups tab
2) Select the default security group and click Manage Rules
3) To allow SSH access, click Add Rule
4) Enter the following values:
    * Rule: SSH
    * Remote: CIDR
    * CIDR: 0.0.0.0/0 (specifies a range of IP addresses which are accepted)
5) Click Add. Instances will now have SSH port 22 open for requests from any IP address (if CIDR: 0.0.0.0/0)
6) To add an ICMP rule, click Add Rule
7) Enter the following values:
    Rule: All ICMP
    Direction: Ingress
    Remote: CIDR
    CIDR: 0.0.0.0/0
8) Click Add. Instances will now accept all incoming ICMP packets.

### Add a key pair

1) Project tab -> Compute tab -> Key Pairs tab -> Create Key Pair
2) Enter a name and click Create Key Pair.
3) The private key (`OpenStack-Private.pem`) will be downloaded automatically.  
4) Make the key pair known to SSH with:
```
$: ssh-add OpenStack-Private.pem
```

```
On Windows use `PuTTYgen` to convert `OpenStack-Private.pem` to `OpenStack-Private.ppk`
```

[Using PuTTYgen](https://winscp.net/eng/docs/ui_puttygen)

### Import a key pair

1) Project tab -> Compute tab -> Key Pairs tab -> Import Key Pair
2) Enter a name, copy the public key and click Import Key Pair

### Allocate a floating IP address to an instance

An instance is assigned a fixed IP address in the network to which the instance is assigned.  
Assigned floating IP addresses can have their association modified.  

1) Project tab -> Network tab -> Floating IPs tab
2) Click Allocate IP To Project.
3) Choose the pool from which to pick the IP address.
4) Click Allocate IP.
5) In the Floating IPs list, click Associate.
6) In the Manage Floating IP Associations dialog box, choose the following options:
    * The IP Address field is filled automatically, but you can add a new IP address by clicking the + button.
    * In the Port to be associated field, select a port from the list.
    * The list shows all the instances with their fixed IP addresses.
7) Click Associate/Disassociate.

To release the floating IP address back into the floating IP pool, click the `Release Floating IP` option in the `Actions` column.  
