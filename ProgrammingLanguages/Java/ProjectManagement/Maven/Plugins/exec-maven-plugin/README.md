### {exec-maven-plugin](https://www.mojohaus.org/exec-maven-plugin/index.html)

For running the packaged Maven project.  

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

To run the package execute:  
```
mvn exec:java
```