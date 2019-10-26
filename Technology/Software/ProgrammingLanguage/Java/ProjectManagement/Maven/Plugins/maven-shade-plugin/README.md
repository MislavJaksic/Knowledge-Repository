## [Maven Shade Plugin](http://maven.apache.org/plugins/maven-shade-plugin/)

For creating an uber jar, a jar that contains all the other jars.  
An uber jar doesn't need to download any additional dependencies.  

May solve the dreded "NoClassDefFoundError".  

```
<plugin>
  <groupId>org.apache.maven.plugins</groupId>
  <artifactId>maven-shade-plugin</artifactId>
  <version>3.2.1</version>
  <configuration>
    <!-- put your configurations here -->
  </configuration>
  <executions>
    <execution>
      <phase>package</phase>
      <goals>
        <goal>shade</goal>
      </goals>
    </execution>
  </executions>
</plugin>
```

### [Selecting contents for the UBER jar](https://maven.apache.org/plugins/maven-shade-plugin/examples/includes-excludes.html)

To only include selected artifacts:
```
...
  <configuration>
    <artifactSet>
      <includes>
        <include>Group-ID:Artifact-ID</include>
      </includes>
    </artifactSet>
  </configuration>
...
```

### [Usage](http://maven.apache.org/plugins/maven-shade-plugin/usage.html)

TODO

### [Executable JAR](http://maven.apache.org/plugins/maven-shade-plugin/examples/executable-jar.html)

TODO