## Maven

Maven is a Java project management tool. It allows authors to easily publish their work and allows users to automatically fetch all the dependencies.

### Installation

Download Maven. Unpack with "tar xzvf apache-maven-x.y.z-bin.tar.gz".  
Add "export PATH=/your/path/to/apache-maven-x.y.z/bin:$PATH" to .bashrc.  
Set JAVA_HOME if it isn't already with "export JAVA_HOME=/your/path/to/java/jdk-x.y.z" to .bashrc.  
JRE will not do! Use a JDK.  
Test with "mvn -v".  

On the other hand, you could just use an IDE which comes with Maven.

### [Short introduction into Maven](http://java.zemris.fer.hr/nastava/opjj/book-2015-09-30.pdf)

Each project has a groupId, artifactId and version.  
Artifact is just another word for project name.  

Maven Central Repository is a public .jar warehouse where the dependencies dwell.

### [Maven in 5 Minutes](https://maven.apache.org/users/index.html)

Create a directory and execute the following: "mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false".  
Generate is a goal, archetype is a plugin.  

This will create a directory "my-app". In it, there are "src" and "pom.xml" files.  
"pom.xml" is Project Object Model and where the Maven project can be configured.  

By executing a phase "mvn package", Maven will complete all phases up to and including the one specified.

### [Introduction to Maven](https://maven.apache.org/guides/getting-started/index.html)

Archetype is a project template.

"pom.xml" is of extreme importance. Here are some of the more important settings:
* project - top-level element in all Maven poms
* modelVersion - POM version
* groupId - creator's ID
* artifactId -JAR or project name
* packaging - package type for the project (e.g. JAR, WAR, EAR, etc.)
* version - project version
* name - displayed project name
* url - project site location
* description - project description

TODO

### Maven pom.xml

Add the first plugin if you want to run the project with "mvn exec:java".  
Add the second plugin to force the correct Java version.
```
<build>
    <plugins>
        <plugin>
            <groupId>org.codehaus.mojo</groupId>
            <artifactId>exec-maven-plugin</artifactId>
            <version>1.2.1</version>
            <configuration>
                <mainClass>MAIN_CLASS</mainClass>
            </configuration>
        </plugin>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-compiler-plugin</artifactId>
            <version>3.7.0</version>
            <configuration>
                <source>DESIRED_JAVA_VERSION</source>
                <target>DESIRED_JAVA_VERSION</target>
            </configuration>
        </plugin>
    </plugins>
</build>
```

Add to package the project into a specific format. 
```
<packaging>jar</packaging>
```

Add dependencies for each external API.
```
<dependencies>
    <dependency>
        <groupId>GET_FROM</groupId>
        <artifactId>MAVEN</artifactId>
        <version>CENTRAL_REPOSITORY</version>
    </dependency>
</dependencies>
```

### Maven plugins

https://maven.apache.org/plugins/index.html

There are a lot of plugins for Maven.  
Some are officially supported, some are at code.google.com or MojoHaus.  

https://www.mojohaus.org/exec-maven-plugin/usage.html:
* run project from command line with "mvn exec:java"
* add <mainClass> into pom to specify where the main class is located
