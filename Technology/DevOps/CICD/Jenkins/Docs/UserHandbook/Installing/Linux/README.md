## [Linux](https://www.jenkins.io/doc/book/installing/linux/)

### Installation of Java

```
$: sudo apt update
$: sudo apt search openjdk
$: sudo apt install openjdk-8-jdk
$: java -version
```

### Debian/Ubuntu

```
$: wget -q -O - https://pkg.jenkins.io/debian-stable/jenkins.io.key | sudo apt-key add -
$: sudo sh -c 'echo deb https://pkg.jenkins.io/debian-stable binary/ > /etc/apt/sources.list.d/jenkins.list'
$: sudo apt-get update
$: sudo apt-get install jenkins
```

The package will:
* Setup Jenkins as a daemon launched on start, see `/etc/init.d/jenkins`
* Create a `jenkins` user to run this service
* Direct console log output to the file `/var/log/jenkins/jenkins.log` for troubleshooting
* Populate `/etc/default/jenkins` with configuration parameters
* Set Jenkins to listen on port 8080 (in `/etc/init.d/jenkins` you can change it to another port)

### Start Jenkins

```
$: sudo systemctl start jenkins
$: sudo systemctl status jenkins
```
