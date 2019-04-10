## Gradle

Gradle packages projects for deployment.  
Gradle has lots of plugins and automation tools.  
Gradle scales as your project grows.  

### [Install Gradle](https://gradle.org/install/)

Make sure you have Java 8 or higher.  

Gradle can be installed:  
* using a package manager such as [Scoop](https://github.com/MislavJaksic/Knowledge-Repository/Scoop)
* manually
* with Gradle Wrapper

Many IDEs come with Gradle already installed.  

### Initialize Gradle project

```
$: gradle init
```

### Common Gradle tasks

Run task:  
```
$: gradlew Task-Name
```

List tasks:  
```
$: gradlew tasks [--all]
```

### Add dependency

Append to build.gradle:  
```
dependencies {
  ...
  api 'Group-ID:jArtifact-ID:Version"
  ...
}
```

```
implementation     -> don't expose its API
api                -> expose its API
testImplementation -> used for testing only
```

### [Gradle plugin portal](https://plugins.gradle.org/)

TODO

### [Gradle CLI](https://docs.gradle.org/4.10-rc-2/userguide/command_line_interface.html)

TODO
