### [Exec Maven Plugin](https://www.mojohaus.org/exec-maven-plugin/index.html)

Runs packaged Maven project (jars, wars, ...).  

```
<plugin>
  <groupId>org.codehaus.mojo</groupId>
  <artifactId>exec-maven-plugin</artifactId>
  <version>x.y.z</version>
  <configuration>
    <mainClass>_main_class/_runner_class</mainClass>
  </configuration>
</plugin>
```

### [Usage](https://www.mojohaus.org/exec-maven-plugin/usage.html)

To run the project by executing:  
```
mvn exec:java
```

### Running a JAR

Package the project then execute it using java:
```
mvn package

java -jar _name.jar
```