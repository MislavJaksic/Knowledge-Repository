## "Clean code" from Clean Code

Clean code is written by Robert C. Martin.  
It is code that can be easily read and understood by programmers.  
Clean code is easier to maintain.  

### Meaningful names

```
Names are descriptive; reveal intent.  
Names are distinct.  
Avoid encoding names.  
Names don't have a prefix or suffix.  
Have a consistent lexicon; get or fetch, choose one.  
Same name, same purpose, same semantics.  
Use solution domain names: algorithm and pattern names.  
Use domain specific names when there are no solution domain names.  
Provide context to the variables with other names; create a structure.  
```

### Functions

```
Functions are short; 4 lines tops.  
Functions have no more then 2 indent levels.  
Functions do only one thing at the current level of abstraction.  
Functions have all statements at one level of abstraction.  
Construct functions as if they are TO paragraphs; the Stepdown rule.  
Bury switch/if-else chains deep down in an ABSTRACT FACTORY.  
Functions have descriptive names; they do what you expect.
Functions have no, one or two arguments; monadic: ask a question or transform the argument and return it, not both.  
If a function has more then two arguments, order them or wrap them in a structure.  
Don't pass flag arguments.  
Have no side effects; do only what the function name promises.  
Avoid output arguments: DON'T appendFooter(report), DO report.appendFooter().  
Functions should either answer a question or perform an action, never both.  
Prefer exceptions to returning error codes.  
Extract error handling code into a function.  
Eliminate code duplication; do not repeat yourself.  
```

### Comments

```
Good comments inform, explain, clarify, warn and amplify. Everything else is a bad comment.
```

### Formatting

```
Small files are better then big files.  
Files should be treated like articles; headline at the top, minutia at the bottom.  
Separate concepts with a blank line.  
Declare local variables just before they are used.  
Instance variables should be declared at the top of the class.  
The caller function should be above the called function and as close as possible.  
Lines should not be longer then 80 characters; have a good reason to break the rule.  
Agree upon and stick to formatting rules; do not be tempted to break them.  
```

### Objects and data structures

```
Abstract data through an interface; do not allow other function to know how you store your data.  
Data structures expose data and have no functions.  
Objects hide data and expose it through functions.  
Data structures and objects are polar opposites.  
Procedural code makes adding functionality easy; OO code makes adding new classes (data) easy.  
Procedural code makes adding new data structures hard; OO code makes adding new functions hard.  
Avoid hybrids; they are the worst of both procedural and OO worlds.  
Follow the Law of Demeter; function f of class C should only call functions of: C, objects that are instance variables of C and objects created by or passed to f.  
Data transfer objects (DTO, no functions), beans (only getters and setters) and active records (beans with some other functions).  
Treat all of the above like data structures; do not put business rules into them.  
```

### Error handling

```
Use exceptions, not return codes.  
If you are going to handle errors, start the function by writing the try block.  
Only use unchecked exceptions; those that are not checked at runtime.  
Create informative error messages.  
Define exceptions by how they are caught.  
Define the normal flow and the rest using SPECIAL CASE PATTERN.  
Do not return or pass null; throw an exception or return an object.  
```

### Boundaries

```
Wrap third party code into a class.
Write learning tests, tests for third party code.
If you don't know what another part of the program is going to look like, create an interface.
```

### Unit tests

```
TDD laws: fail a test before writing production code,
          write a test only until it can fail,
          write production code until it passes the test.
Test are as important as production code. Keep them clean.
Build test data, operate on test data and check results.
Strive for one assert and one concept per test.
Remember, tests are what makes your code flexible and resistant to bugs in the face of change.
```

### Classes

```
Class variables should be written at the start of the class.
Classes should have as few responsibilities as possible.
A class has only one reason to change (Single Responsibility Principle).
A system is made up of many small classes, not a few large ones.
Aim for high cohesion: most functions use most instance variables.
Transform parameters into instance variable -> class looses cohesion -> split it into multiple classes.
Classes should be open for extension but closed for modification (Open Closed Principle).
Classes should depend upon abstract classes or interfaces (Dependency Inversion Principle).
```

### Systems

TODO

### Emergence

TODO

### Concurrency

TODO

### Successive refinement

TODO

### Smells and Heuristics

TODO

PATTERNS: abstract factory, special case pattern, adapter pattern, build operate check pattern, template method pattern, strategy pattern, decorator
