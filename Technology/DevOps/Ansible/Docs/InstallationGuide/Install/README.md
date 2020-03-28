## [Installing Ansible](https://docs.ansible.com/ansible/latest/installation_guide/intro_installation.html)

Ansible is agentless.  
Ansible uses `SSH`.  
Ansible is install on a control node to control managed machines.   

### Prerequisites

Install Ansible on a control node to use SSH to manage managed nodes.  

#### Control node requirements

Python >2.7 and >3.5.  
Supports Red Hat, Debian, CentOS, macOS, any of the BSDs, but not Windows.  

#### Managed node requirements

Python >2.7 and >3.5.  
SSH/SFTP. You configure Ansible to use SCP.  

### Selecting an Ansible version to install

Install using:
* OS package manager
* Python's `pip`
* from source

### Installing Ansible on Ubuntu

```
# Note: you can use `apt-get` instead of `apt`
# Note: you can use `-u` instead of `--update`

$: sudo apt update
$: sudo apt install software-properties-common
$: sudo apt-add-repository --yes --update ppa:ansible/ansible
$: sudo apt install ansible
```

### Ansible command shell completion

Ansible >2.9 has shell completion called `argcomplete`.  

#### Installing argcomplete with apt

```
$: sudo apt install python-argcomplete
```
