## [Writing Custom Gradle Tasks](https://guides.gradle.org/writing-gradle-tasks/)

Task is an atomic piece of work.  

### Create ad hoc task

Append to build.gradle:  
```
tasks.register("hello") {
  group = "Example"                         -> category in "$: gradlew tasks"
  description = "Produce an example output" -> task description
  
  doLast {
      println "Hello, World!"
  }
}
```

Run task with:  
```
$: gradlew hello
```

### Create task class

A neat way of grouping tasks is to create a class:  
```
class Greeting extends DefaultTask {  
  String message 
  String recipient

  @TaskAction 
  void sayGreeting() {
    println "${message}, ${recipient}!" 
  }
}

tasks.register("hello", Greeting) { 
  group = "Example"
  description = "Produce an example output"
  message = "Hello" 
  recipient = "World"
}

tasks.register("hi", Greeting) { 
  group = "Example"
  description = "Produce another output"
  message = "Hi" 
  recipient = "World"
}
```
