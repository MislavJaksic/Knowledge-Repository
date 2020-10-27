## [OKD](https://docs.okd.io/)

### Install

OKD must run on the Linux operating system.
Install and configure the `CRI-O` or `Docker` container engines.  
OKD and container engines use `iptables` to manage networking. Make sure they aren't modified.  

1a) Download the [Release](https://github.com/openshift/origin/releases)
1b) `tar -xzvf Package-Name` untars the releases
2) `export PATH=$(pwd):$PATH` adds releases to the PATH
3) `sudo ./openshift start` starts OKD, the web console, etcd and Kubernetes (removed in 3.11!)
4a) `export KUBECONFIG=`pwd`/openshift.local.config/master/admin.kubeconfig`
4b) `export CURL_CA_BUNDLE=`pwd`/openshift.local.config/master/ca.crt`
4c) `sudo chmod +r `pwd`/openshift.local.config/master/admin.kubeconfig`

#### Alternative install for 3.10

Only supported on Fedora, CentOS, and Red Hat Enterprise Linux (RHEL).  

1) `sudo docker run -d --name "origin" --privileged --pid=host --net=host -v /:/rootfs:ro -v /var/run:/var/run:rw -v /sys:/sys -v /sys/fs/cgroup:/sys/fs/cgroup:rw -v /var/lib/docker:/var/lib/docker:rw -v /var/lib/origin/openshift.local.volumes:/var/lib/origin/openshift.local.volumes:rslave openshift/origin start`
2) `sudo docker exec -it origin bash`

### Error

Version 3.10:  
```
failed to run Kubelet: failed to create kubelet: misconfiguration: kubelet cgroup driver: "systemd" is different from docker cgroup driver: "cgroupfs"
```
