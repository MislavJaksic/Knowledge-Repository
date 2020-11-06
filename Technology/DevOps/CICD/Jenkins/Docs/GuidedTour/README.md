## [Getting Started](https://jenkins.io/doc/pipeline/tour/getting-started/)

Prerequisites:
* 512MB RAM
* 10 GB of hard disk space
* Java 8 or 11, JDE or JDK
* [Docker](../../../../Container/Docker)

Download and run Jenkins in `.war` by:
* Downloading [jenkins.war](https://www.jenkins.io/download/)
* Open up a terminal in the download directory
* Run `java -jar jenkins.war --httpPort=Jenkins-Port`
* Browse to http://localhost:Jenkins-Port
* Follow the instructions to complete the installation

Remember the username and password!

## [Creating your first Pipeline](https://jenkins.io/doc/pipeline/tour/hello-world/)

A Jenkins Pipeline is a automated expression of your process for getting software from version control right through to your users and customers.  

Pipelines are defined using Jenkinsfiles.  

## [Running multiple steps](https://jenkins.io/doc/pipeline/tour/running-multiple-steps/)

A Pipeline has a series of stages made from steps.  


```
pipeline {
    agent any
    stages {
        stage("Build") {
            steps {
                sh "echo "Hello World""
            }
        }
        stage("Deploy") {
            steps {  # retry up to 5 times or until 3min passed
              timeout(time: 3, unit: "MINUTES") {
                  retry(5) {
                      sh "./flakey-deploy.sh"
                  }
              }
            }
        }
    }
    post {
        always {
            echo "This will always run"
        }
        success {
            echo "This will run only if successful"
        }
        failure {
            echo "This will run only if failed"
        }
        unstable {
            echo "This will run only if the run was marked as unstable"
        }
        changed {
            echo "This will run only if the state of the Pipeline has changed"
            echo "For example, if the Pipeline was previously failing but is now successful"
        }
    }
}
```

## [Defining execution environments](https://jenkins.io/doc/pipeline/tour/agents/)

TODO
