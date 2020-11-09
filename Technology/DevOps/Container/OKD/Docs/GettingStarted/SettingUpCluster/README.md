## [Administrators: Setting Up a Cluster](https://docs.okd.io/3.11/getting_started/administrators.html)

### Overview

Download Release. Mac and Windows versions are CLI only.  

The release for Linux and Mac OS X contain the all-in-one OKD installation `openshift`. All releaseshave the `oc` CLI and `kubectl` Kubernetes client.

### Prerequisites

OKD must run on the Linux operating system.

Install and configure the `CRI-O` or `Docker` container engines.  

OKD and container engines use `iptables` to manage networking. Make sure they aren't modified.  

### On-premise Versus Cloud Providers

OKD can be installed on-premise or on the cloud.  

### (Method 1) Running in a Container

Only supported on Fedora, CentOS, and Red Hat Enterprise Linux (RHEL).  

1) `sudo docker run -d --name "origin" \
        --privileged --pid=host --net=host \
        -v /:/rootfs:ro -v /var/run:/var/run:rw -v /sys:/sys -v /sys/fs/cgroup:/sys/fs/cgroup:rw \
        -v /var/lib/docker:/var/lib/docker:rw \
        -v /var/lib/origin/openshift.local.volumes:/var/lib/origin/openshift.local.volumes:rslave \
        openshift/origin start`
2) `sudo docker exec -it origin bash`

### (Method 2) Installing and Running an All-in-One Server

1a) Download the [Release](https://github.com/openshift/origin/releases)
1b) `tar -xzvf Package-Name` untars the releases
2) `export PATH=$(pwd):$PATH` adds releases to the PATH
3) `sudo ./openshift start` starts OKD, the web console, etcd and Kubernetes (removed in 3.11!)
4a) `export KUBECONFIG=`pwd`/openshift.local.config/master/admin.kubeconfig`
4b) `export CURL_CA_BUNDLE=`pwd`/openshift.local.config/master/ca.crt`
4c) `sudo chmod +r `pwd`/openshift.local.config/master/admin.kubeconfig`

### Try It Out

After starting an OKD instance, you can try it out by creating an end-to-end application demonstrating the full OKD concept chain.
	When running OKD in a VM, you will want to ensure your host system can access ports 8080 and 8443 inside the container for the examples below.

    Log in to the server as a regular user:

    $ oc login
    Username: test
    Password: test

    Create a new project to hold your application:

    $ oc new-project test

    Tag an application image from a container registry into your project:

    $ oc tag --source=docker openshift/deployment-example:v1 deployment-example:latest

    Deploy the application image:

    $ oc new-app openshift/deployment-example

    Note that a service was created and given an IP - this is an address that can be used within the cluster to access the application.

    Display a summary of the resources you created:

    $ oc status

    The container image for your application will be pulled to the local system and started. Once it has started it can be accessed on the host. If this is your laptop or desktop, open a web browser to the service IP and port that was displayed for the application:

    http://172.30.192.169:8080 (example)

    If you are on a separate system and do not have direct network access to the host, SSH to the system and perform a curl command:

    $ curl http://172.30.192.169:8080 # (example)

    You should see the v1 text displayed on the page.

Now that your application is deployed, you can trigger a new version of that image to be rolled out to your host by tagging the v2 image. The new-app command created an image stream which tracks which images you wish to use. Use the tag command to mark a new image as being desired for deployment:

$ oc tag --source=docker openshift/deployment-example:v2 deployment-example:latest

Your application’s deployment config is watching deployment-example:latest and will trigger a new rolling deployment when the latest tag is updated to the value from v2.


You can also use an alternate version of the command:

$ oc tag docker.io/openshift/deployment-example:v2 deployment-example:latest

Return to the browser or use curl again and you should see the v2 text displayed on the page.
	For this next step we’ll need to ensure that Docker is able to pull images from the host system. Ensure you have completed the instructions about setting the --insecure-registry flag from Host Preparation.

As a developer, building new container images is as important as deploying them. OKD provides tools for running builds as well as building source code from within predefined builder images via the Source-to-Image toolchain.

For this procedure, ensure that the container engine is able to pull images from the host system. Also, make sure you have completed the instructions about setting the --insecure-registry flag from Host preparation.

    Switch to the administrative user and change to the default project:

    $ oc login -u system:admin
    $ oc project default

    Set up an integrated container image registry for the OKD cluster:

    $ oc adm registry

    It will take a few minutes for the registry image to download and start - use oc status to know when the registry is started.

    Change back to the test user and test project:

    $ oc login -u test
    $ oc project test

    Create a new application that combines a builder image for Node.js with example source code to create a new deployable Node.js image:

    $ oc new-app openshift/nodejs-010-centos7~https://github.com/sclorg/nodejs-ex.git

    A build will be triggered automatically using the provided image and the latest commit to the master branch of the provided Git repository. To get the status of a build, run:

    $ oc status

    which will summarize the build. When the build completes, the resulting container image will be pushed to the container image registry.

    Wait for the deployed image to start, then view the service IP using your browser or curl.

You can see more about the commands available in the CLI (the oc command) with:

$ oc help

Or connect to another system with:

$ oc -h <server_hostname_or_IP> [...]

OKD includes a web console which helps you visualize your applications and perform common creation and management actions. You can use the test user we created above to log in to the console via https://<server>:8443/console. For more information, see Getting Started for Developers: Web Console.

You can also see the OKD 3 Application Lifecycle Sample for a more in-depth walkthrough.
