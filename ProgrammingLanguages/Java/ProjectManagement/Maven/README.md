## [Maven](https://maven.apache.org/)

Maven is a Java project management tool. It takes care of builds, docs, reports, dependencies, SCMs, releases and distribution.  
Maven allows authors to package and publish projects with all their dependencies and plugins.  
Maven allows users to run the project with out of the box.  

### [Installation](https://maven.apache.org/install.html)

IDEs such as Eclipse Java comes with Maven already preinstalled.  

On Linux (Ubuntu):  
```
:$ mvn ->  sudo apt install maven
:$ sudo apt install maven -> maven is installed
```

On Linux (Ubuntu):  
1) [Download Maven](https://maven.apache.org/download.cgi), suggested archive: binary tar.gz
2) Unpack and install the archive; see [Linux commands](https://github.com/MislavJaksic/Knowledge-Repository/tree/master/Linux)
3) Execute the following commands:
```
:$ pwd -> /
:$ nano .bashrc -> add "export PATH=/your/path/to/apache-maven-x.y.z/bin:$PATH"
                -> add "export JAVA_HOME=/your/path/to/java/jdk-x.y.z"; JRE will not do!
:$ mvn -v -> Apache Maven x.y.z ...
```

### [Maven in 5 Minutes](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html)

To create a Maven Project execute:  
```
:$ mvn archetype:generate -DgroupId=mjaksic -DartifactId=hello-world -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
```
More about the [Archetype plugin](https://maven.apache.org/guides/introduction/introduction-to-archetypes.html).

Some Maven Archetype D parameters:  
```
-DgroupId=_group_id -> author/organisation ID; example "mjaksic"
-DartifactId=_artifact_id -> project ID; example "hello-world"
-DarchetypeArtifactId=_archetype_artifact -> Archetype plugin artifact; example "maven-archetype-quickstart"
-DarchetypeVersion=1.4 -> -
-DinteractiveMode=false -> -
```

Archetype plugin generates a Maven Project.  
Project Object Model (POM) is the most important Maven settings file, "pom.xml".  

Maven Lifecycle Phases (they map to Maven Goals):
1) validate
2) compile
3) test
4) package
5) integration-test
6) verify
7) install
8) deploy

* clean
* site

### [Maven Getting Started Guide](https://maven.apache.org/guides/getting-started/index.html)

Archetype is a Maven plugin, a templating toolkit.  

"pom.xml" contents:  
```
<project xmlns="..."> -> top element
  <modelVersion>4.0.0</modelVersion> -> pom.xml version
  
  <groupId>mjaksic</groupId> -> author/organisation ID
  <artifactId>hello-world</artifactId> -> project ID
  
  <packaging>jar</packaging> -> how to package this project
  
  <version>1.0-SNAPSHOT</version> -> project version
  <name>Maven Quick Start Archetype</name> -> project name
  <url>http://maven.apache.org</url> -> project url
  
  <dependencies> -> project dependencies; enables "import"
    <dependency> -> sample dependency, JUnit 4
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.11</version>
      <scope>test</scope>
    </dependency>
  </dependencies>
</project>
```

To compile/test the project execute:  
```
:$ mvn compile -> compile
:$ mvn test -> compile and test
```

To package/install the project (for example construct a JAR) execute:  
```
:$ mvn package -> pack into JAR/WAR/...
:$ mvn install -> installs the JAR/WAR/...
```

You can add plugins and configure them in "pom.xml" like:  
```
...
<build>
  <plugins> -> plugins; they look like dependencies
    <plugin> -> sample plugin
      <groupId>org.apache.maven.plugins</groupId>
      <artifactId>maven-compiler-plugin</artifactId>
      <version>3.3</version>
      <configuration> -> plugin configuration
        <source>1.5</source>
        <target>1.5</target>
      </configuration>
    </plugin>
  </plugins>
</build>
...
```

You can add resources to the project package (JAR/WAR/...) such as properties.  
Place the properties/settings in:  
```
".../resources/META-INF/_settings_file_name.properties"
```

Build time values can be filtered/referenced from inside the resource file/"pom.xml":
```
<build>
  <resources>
    <resource>
      <directory>src/main/resources</directory>
      <filtering>true</filtering>
    </resource>
  </resources>
</build>
```
```
<properties>
  <_property_name>_property_value</_property_name>
</properties>
```

External dependencies must have at least four elements:  
```
...
<dependency>
  <groupId>mjaksic</groupId>
  <artifactId>hello-world</artifactId>
  <version>0.1</version>
  <scope>compile/test/runtime</scope>
</dependency>
...
```
You can search Maven Repositories for external dependencies.  

Deploy package (JAR/WAR/...) to a remote/private repository.  
TODO  

Generate documentation.  
TODO  

### [Configuring Maven](https://maven.apache.org/guides/mini/guide-configuring-maven.html)

Three levels of configuration.  

TODO

### [Introduction to Repositories](https://maven.apache.org/guides/introduction/introduction-to-repositories.html)

A Maven repository in holds artifacts and dependencies.  

TODO

### [Introduction to the Dependency Mechanism](https://maven.apache.org/guides/introduction/introduction-to-dependency-mechanism.html)

A core feature of Maven.  

TODO  

### [Maven POM XML Descriptor](https://maven.apache.org/ref/3.6.0/maven-model/maven.html)

TODO  

### [Creating a site](https://maven.apache.org/guides/mini/guide-site.html)

TODO

### [Available Plugins](https://maven.apache.org/plugins/)

There are build plugins.  
There are reporting plugins.  
There are unofficial plugins.  

TODO  

### [MojoHaus Plugins](https://www.mojohaus.org/plugins.html)

TODO  

### [Guide to Configuring Plug-ins](https://maven.apache.org/guides/mini/guide-configuring-plugins.html)

TODO

### [Archetype plugin](https://maven.apache.org/guides/introduction/introduction-to-archetypes.html)

Maven Project templating toolkit.  

TODO

### [Maven Release Plugin](https://maven.apache.org/maven-release/maven-release-plugin/)

Release a project with Maven.  

TODO  