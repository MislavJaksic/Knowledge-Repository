## [Log in to the dashboard](https://docs.openstack.org/horizon/train/user/log-in.html)

The dashboard is generally installed on the controller node.  

To log in:
1) get host name/public IP, user name, password and optionally a domain
2) input data into a web browser
3) if logged in as:
    * end user: you will see `Project` and `Identity`
    * admin: you will see `Project`, `Admin` and `Identity`

### Project tab

```
Project: organizational unit, a.k.a. tenants or accounts
User: member of a project, manage instances

API Access: view API endpoints
```

#### Compute tab

```
Overview: view project reports
Instances: manage snapshot instances or connect to them through VNC
Images: manage images and instance snapshots
Key Pairs: manage key pairs
```

#### Volume tab
```
Volumes: manage volumes.
Backups: manage backups
Snapshots: manage volume snapshots
Consistency Groups: manage consistency groups
Consistency Group Snapshots: manage consistency group snapshots
```

#### Network tab

```
Network Topology: view network topology
Networks: manage public and private networks
Routers: manage routers
Security Groups: manage security groups and security group rules
Floating IPs: allocate or release an IP address
```

#### Object Store tab

```
Containers: manage containers and objects
```

### Admin tab

Administrative users can manage instances, volumes, flavours, images, networks, ...

#### Overview tab

```
Overview: view project reports
```

#### Compute tab

```
Hypervisors: view hypervisors
Host Aggregates: manage host aggregates and view the list of availability zones
Instances: manage running instances and view the log for an instance or access an instance through VNC
Flavours: manage flavours, a size of an instance
Images: manage custom images
```

#### Volume tab

```
Volumes: manage volumes
Snapshots: manage volume snapshots
Volume Types: manage volume types
```

#### Network tab

```
Networks: manage networks
Routers: manage routers
Floating IPs: allocate or release an IP address
```

#### System tab

```
Defaults: quotas are hard-coded in OpenStack Compute and define the resource maximum
Metadata Definitions: import namespace and view metadata information
System Information:
    Services: view a list of services
    Compute Services: view a list of all Compute services
    Block Storage Services: view a list of all Block Storage services
    Network Agents: view the network agents
```

### Identity tab

```
Projects: projects and their user members
Users: manage users.
```

### Settings tab

```
User Settings: manage dashboard settings
Change Password: change the password of the user
```
