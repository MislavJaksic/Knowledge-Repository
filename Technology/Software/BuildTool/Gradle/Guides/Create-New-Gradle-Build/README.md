## [Creating New Gradle Builds](https://guides.gradle.org/creating-new-gradle-builds/)

### Init Gradle project

Generate a project:  
```
$: gradle init
  -> Choose: basic
  -> Choose: groovy
  -> Choose: default
```

The project has:  
```
build.gradle    -> project config
gradle
  wrapper
    gradle-wrapper.jar        -> Gradle Wrapper JAR
    gradle-wrapper.properties -> Gradle Wrapper config
gradlew         -> Gradle Wrapper for Unix
gradlew.bat     -> Gradle Wrapper for Windows
settings.gradle -> Gradle build config
```

### Create Gradle task

Append to build.gradle:
```
task copy_from_source_to_destination(type: Copy, group: "Custom", description: "Copies from source to destination") {
    from "source"
    into "destination"
}
```

To run the task:
```
$: gradlew copy_from_source_to_destination
```

### Apply a plugin

Insert in front to build.gradle:  
```
plugins {
    id "base"
}
```

When you run the task zip_source, the zip will be located in build/distributions.  
```
task zip_source(type: Zip, group: "Archive", description: "Archives sources in a zip file") {
    from "source"
    setArchiveName "my-small-archive.zip"
}
```

### Other CLI commands

```
$: gradlew tasks -> list tasks
$: gradlew properties -> list properties
```
