## Unit testing

Java program can be tested using the JUnit framework.
Setting up JUnit is as simple as downloading two .jar files and copying them to
...\Java\jre<version>\lib\ext\ and ...Java\jdk<version>\jre\lib\ext\. Both paths should already be included
in the environment variables.

### Running the tests

First, compile the class you want to test. Then, compile the class that tests the other class by typing
"javac -cp .;junit-4.XX.jar <test_name>.java". Run the tests by typing
"java -cp .;junit-4.XX.jar;hamcrest-core-1.3.jar org.junit.runner.JUnitCore <test_name>".

### Suggestion

Testing, organising folders and projects is quite cumbersome without an IDE. Get one.

### Commands

javac -cp .;junit-4.XX.jar <test_name>.java
java -cp .;junit-4.XX.jar;hamcrest-core-1.3.jar org.junit.runner.JUnitCore <test_name>