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
```
Sample Username: mjaksic
Sample Password: 12345
```

## [Creating your first Pipeline](https://jenkins.io/doc/pipeline/tour/hello-world/)

Jenkins `Pipeline` is a description of your process for getting software from version control to your users.  

Pipelines are defined using `Jenkinsfiles`.  

Steps:
* Paste an [example](https://www.jenkins.io/doc/pipeline/tour/hello-world/#examples) `Jenkinsfiles`
* In Jenkins click `New Item` -> enter name -> `Multibranch Pipeline` -> `Add Source` -> `Save`

## [Running multiple steps](https://www.jenkins.io/doc/pipeline/tour/running-multiple-steps/)

Pipeline are up of steps.  
Steps is a single command.  
If a step fails, the Pipeline will fail.

Wrap steps:
* `retry`: attempt multiple times
* `timeout`: fail after a set amount of time
* `post`: cleanup steps

```
pipeline {
    agent any
    stages {
        stage("Build") {
            steps {
                sh "echo "Hello World""
                sh '''
                    echo "Multiline shell steps works too"
                    ls -lah
                '''
            }
        }
        stage("Deploy") {
            steps {  // spend no more then 3 min retrying 5 times
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

## [Defining execution environments](https://www.jenkins.io/doc/pipeline/tour/agents/)

`agent` wrap step tells Jenkins where to execute the Pipeline.  
There are many ways to define an `agent`.  
Docker images are isolated environments that you can use to execute your Pipeline.  

Steps will be executed as soon as the Jenkins Executor Node is free.  

Workspace is allocated so the Pipeline has a place to be executed.  

```
pipeline {
    agent {
        docker { image 'node:14-alpine' }
    }
    stages {
        stage('Test') {
            steps {
                sh 'node --version'
            }
        }
    }
}
```

## [Using environment variables](https://www.jenkins.io/doc/pipeline/tour/environment/)

Can be set globally or per stage.  
They can be set manually or by Jenkins plugins.  
[Credential handling](https://www.jenkins.io/doc/book/pipeline/jenkinsfile/#handling-credentials) is a special case.  

```
pipeline {
    agent {
        label '!windows'
    }

    environment {
        DISABLE_AUTH = 'true'
        DB_ENGINE    = 'sqlite'
    }

    stages {
        stage('Build') {
            steps {
                echo "Database engine is ${DB_ENGINE}"
                echo "DISABLE_AUTH is ${DISABLE_AUTH}"
                sh 'printenv'
            }
        }
    }
}
```

## [Recording tests and artifacts](https://www.jenkins.io/doc/pipeline/tour/tests-and-artifacts/)

Jenkins can publish test results if they are recorded in a file.  
`junit` wrap step can read JUnit-style XML reports, but you can find additional plugins.  
If a test fails the Pipeline is marked as `UNSTABLE`.  

`archiveArtifacts` stores and grabs artifacts generated during Pipeline execution.

```
pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh './gradlew build'
            }
        }
        stage('Test') {
            steps {
                sh './gradlew check'
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'build/libs/**/*.jar', fingerprint: true
            junit 'build/reports/**/*.xml'
        }
    }
}
```

## [Cleaning up and notifications](https://www.jenkins.io/doc/pipeline/tour/post/)

You can send notifications about the Pipeline.  

```
post {
    failure {
        mail to: 'team@example.com',
             subject: "Failed Pipeline: ${currentBuild.fullDisplayName}",
             body: "Something is wrong with ${env.BUILD_URL}"
    }
}
```

## [Deployment](https://www.jenkins.io/doc/pipeline/tour/deployment/)

`input` wrap step asks for human input to proceed.  

```
pipeline {
    agent any
    stages {
        /* "Build" and "Test" stages omitted */

        stage('Deploy - Staging') {
            steps {
                sh './deploy staging'
                sh './run-smoke-tests'
            }
        }

        stage('Sanity check') {
            steps {
                input "Does the staging environment look ok?"
            }
        }

        stage('Deploy - Production') {
            steps {
                sh './deploy production'
            }
        }
    }
}
```
