## [Gradle](https://gradle.org/)

Pitch:
* accelerate developer productivity
* build anything
* automate everything
* deliver faster

The Gradle User Guide organises Gradle Docs much better then the website.  

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
