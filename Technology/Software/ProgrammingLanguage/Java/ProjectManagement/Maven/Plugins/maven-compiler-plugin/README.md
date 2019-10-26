## [Maven Compiler Plugin](https://maven.apache.org/plugins/maven-compiler-plugin/index.html)

Forces Maven to compile the project with a specific Java version.  

```
<plugin>
  <groupId>org.apache.maven.plugins</groupId>
  <artifactId>maven-compiler-plugin</artifactId>
  <version>x.y.z</version>
  <configuration>
    <source>_java_version</source>
    <target>_java_version</target>
  </configuration>
</plugin>
```