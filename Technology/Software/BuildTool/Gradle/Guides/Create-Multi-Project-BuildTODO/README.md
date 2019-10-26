## [Creating Multi-project Builds](https://guides.gradle.org/creating-multi-project-builds/)

### Configure from above

Append to build.gradle:  
```
allprojects { -> apply to all subprojects
  repositories {
    jcenter() 
  }
}
```

Append to settings.gradle:  
```
include "greeting-library"
```

Run the folowing to build all subprojects:  
```
$: gradlew build
```

TODO
