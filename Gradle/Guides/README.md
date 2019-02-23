## [Gradle guides](https://gradle.org/guides/)

### [Build scans](https://guides.gradle.org/creating-build-scans/)

Build scan is a record of a build: what happened and why.  

Construct it with:  
```
./gradlew build --scan
```
They can be published to a [website](https://scans.gradle.com/).  
It is recommended you create a .gradle/init.d script to automate the process.  

### [New Gradle build](https://guides.gradle.org/creating-new-gradle-builds/)

Create a folder.  
Initialize a Gradle project with:  
```
gradle init
```
Select the desired options.  
To create a task modify the "build.gradle" script.  
Execute the script with:
```
./gradlew _task_name
```
To add a plugin modify the "build.gradle" script.  

There are a number of Gradle commands such as: tasks, _task_name --scan, properties.  

### [Gradle and Java](https://guides.gradle.org/building-java-libraries/)

Create a folder.  
Initialize a Java library project with:  
```
gradle init
```
Select the desired options.  

Build the project with:  
```
./gradlew build
```
The build command generates a test report under "build/reports/...".  
The build command also generates a _project_name.jar file.  

To modify the behaviour of jar command modify the "build.gradle" script.  
To generate javadocs use the javadoc command.  

### [Gradle Java dependency management](https://docs.gradle.org/current/userguide/dependency_management_for_java_projects.html)

TODO

### [Publishing](https://docs.gradle.org/5.0/userguide/publishing_overview.html#publishing_overview)

TODO