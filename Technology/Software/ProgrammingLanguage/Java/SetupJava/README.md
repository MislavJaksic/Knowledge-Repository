## Setting up Java

To compile a program, you need a Java Development Kit (JDK).

### Install the Java Development Kit (JDK)

```
# Note: check if you have the JDK installed already
$: java -version
$: javac -version
```

#### Windows

[Download](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) the JDK from the website.  

Setup your environment variables:
* add `/path/to/Java/jdk-x.y.z/bin` to PATH
* add `/path/to/Java/jdk-x.y.z/jre/bin` to PATH

#### Linux

```
$: sudo apt-get update
$: sudo apt-get install openjdk-8-jdk openjdk-8-jre
```

### Java files

```
*.java: source
*.class: executable
*.jar, *.war: package
```

### Compiling

```
$: javac File-Name.java  # a File-Name.class will appear
```

### Executing a program

```
$: java File-Name [-command-line-variables]  # executes File-Name.class
```

### Integrated Development Environment (IDE)

I recommend using an IDE when working on Java programs.  
It makes project management, compiling, testing and packaging a lot easier.  
The downside is the IDE overhead and complexity.  

### Build tools

I recommend using a built tool when working on Java programs.  
