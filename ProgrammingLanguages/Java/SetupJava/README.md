## Setting up Java

Java is an exclusively object oriented compiler language. Object oriented languages model every program as if it were an object in the real world. Compiler languages read and transform a source file into an executable file. In order to compile a program, you need a Java Development Kit.

### Java Development Kit (JDK)

The Kit can be downloaded from the Oracle website. Once installed, Java source can be complied.

### Source and executable file, Java compiler

Java source files are marked with a .java extension, while Java executables have a .class extension. A Java source file can be compiled into a Java executable by positioning the command line into the folder where the Java source file is located and invoking the Java compiler, "javac _file_name.java". A _file_name.class file will then appear in the same folder.

If "javac" is not a recognised command, environment variables (specifically, System variable Path) have to be modified to include ".../Java/jdk<version_number>/bin" and ".../Java/jdk<version_number>/jre/bin".

### Java launcher and program execution

To execute a Java executable, position the command line in the folder where it is located and type "java _file_name _optional_command_line_variables". Forgo writing the .class extension.

### Integrated development environment (IDE)

It is strongly advised to develop Java programs using an IDE. An IDE will make project management, compiling, testing and building a lot easier. The downside is that you will have to remember how to set up your environment when you switch your workplace. Here is a partial list of IDEs:

* IntelliJ IDEA
* Eclipse
* NetBeans

### Apache Maven

It is strongly advised that you get to know what Apache Maven can do for you and your project. In short, it enables you to quickly deploy your programs without having to worry about dependencies as long as they can be found on the Internet.
