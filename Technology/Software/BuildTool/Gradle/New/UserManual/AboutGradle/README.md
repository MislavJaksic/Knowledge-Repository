## [What is Gradle?](https://docs.gradle.org/current/userguide/what_is_gradle.html#what_is_gradle)

Gradle is a build automation tool.  
Features:
* high performance
* JVM foundation
* conventions
* extensibility
* IDE support
* insight

### Five things about Gradle

#### 1. Gradle is a general-purpose build tool

Gradle only supports Maven and Ivy repositories.  
Gradle has lots of plugins for conventions and building.  

#### 2. The core model is based on tasks

Gradle models its builds as Directed Acyclic Graphs (DAGs) of tasks (units of work).  

Tasks are:
* Actions: pieces of work that do something, like copy files or compile source
* Inputs: values, files and directories that the actions use or operate on
* Outputs: files and directories that the actions modify or generate

Gradle builds incrementally to save time.  

#### 3. Gradle has several fixed build phases

Gradle's Build Lifecycle phases:
* Initialization: sets up the environment for the build
* Configuration: constructs and configures the task graph order of execution
* Execution: runs the tasks

Avoid expensive work in the configuration phase because it has to run every time.  

#### 4. Gradle is extensible in more ways than one

Ways of extending Gradle:
* custom task types
* custom task actions
* extra properties
* custom conventions
* custom model

#### 5. Build scripts operate against an API

Gradle is powered by its model and API.  
