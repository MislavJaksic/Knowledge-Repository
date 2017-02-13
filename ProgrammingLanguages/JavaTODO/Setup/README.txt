How to setup Java
=================

Java is an exclusivley object oriented compiler language. Object oriented languages model every program as if it were an object in the real world. Compiler languages read and transform a source file into an executable file. Java source files are marked with a .java extension, while Java executables have a .class extension. In order to compile a program, Java Development Kit is needed.

Java Development Kit
--------------------
The Kit can be downloaded from the Oracle website. Once installed, Java source can be complied.

Java compiler, source and executable file
-----------------------------------------
A file with a .java extension can be compiled into an .class file by position the command window in the folder where the .java file is and typing "javac <file_name>.java". A <file_name>.class file should appear in the folder.
If javac is not a recognised command, environment variables (specifically, System variable Path) have to be modified to include ".../Java/jdk<version_number>/bin" and ".../Java/jdk<version_number>/jre/bin".

Execute a program
-----------------
To execute a Java .class file, position the command window in the folder where it is located and type "java <file_name> <optional_command_line_variables>". Forgo writing the .class extension.