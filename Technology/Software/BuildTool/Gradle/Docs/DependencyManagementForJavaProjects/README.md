## [Dependency Management for Java Projects](https://docs.gradle.org/current/userguide/dependency_management_for_java_projects.html)

Add a dependency by appending:  
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

Specify a repository from which dependencies will be downloaded by appending:  
```
repositories {
  ...
  mavenCentral()
  ...
}
```