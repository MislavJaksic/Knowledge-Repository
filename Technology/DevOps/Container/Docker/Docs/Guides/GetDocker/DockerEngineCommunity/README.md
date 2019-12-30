## [Install Docker](https://docs.docker.com/install/)

### [Windows](https://docs.docker.com/docker-for-windows/install/)

Prerequisites:
* Windows 10 64-bit: Pro, Enterprise, or Education (Home will not do!)
* Hyper-V and Containers Windows are enabled

Follow the link.  
Login to` Docker Hub`.  
Download the installer.  
Double-click the `*.exe`.  

### Linux

#### [Ubuntu Linux](https://docs.docker.com/install/linux/docker-ce/ubuntu/)

```
$: sudo apt-get remove docker docker-engine docker.io containerd runc  # uninstall older Docker
```

```
$: sudo apt-get update
$: sudo apt-get install apt-transport-https ca-certificates curl software-properties-common
$: curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
$: sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable"
```

```
$: sudo apt-get update
$: sudo apt-get install docker-ce docker-ce-cli containerd.io
$: sudo docker run hello-world
```

#### [Post-installation for Linux](https://docs.docker.com/install/linux/linux-postinstall/)

Non-root users will have to prefix every command with `sudo`.  
Avoid this by executing:
```
$: sudo groupadd docker
$: sudo usermod -aG docker $USER
# Note: restart "Linux"
$: docker run hello-world
```
