## [Pipeline](https://jenkins.io/doc/book/pipeline/)

A continuous delivery Pipeline.  
Defined by a Jenkinsfile.  

```
Pipeline: defines the process
Node: machine that executes a Pipeline
Stage: groups of tasks that have to be performed
Step: a single task
```

```
pipeline {  # Declerative Pipeline
    agent any  # allocate an executor and workspace
    options {
        skipStagesAfterUnstable()
    }
    stages {
        stage('Build') {
            steps {
                sh 'make'
            }
        }
        stage('Test'){
            steps {
                sh 'make check'
                junit 'reports/**/*.xml'
            }
        }
        stage('Deploy') {
            steps {
                sh 'make publish'
            }
        }
    }
}
```
