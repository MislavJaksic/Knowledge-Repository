## Clean Code

Clean Code is written by Robert C. Martin.  
It is code that can be easily read and understood by programmers.  
Clean code is easier to maintain.  

### Introduction

Craftsmanship: knowledge and work:
* Know your principles and patterns
* Work hard, practice, watch yourself and others fail

Takeaway lesson: heuristics must be applied to concrete problems to be useful
Reading chapter two and following along in the thinking process is paramount!

### 1 Clean Code

There will always be code.  
Bad code will catch up to you.  
Develop a code-sense: identify and express what's wrong with the code.  
Code is read far more then it is written.  


### 2 Meaningful names

```
Names are descriptive; reveal intent.  
Use names consistently.
Names are distinct and can be easily distinguished.
Create pronounceable and searchable names.
Create long names for long scoped names.
Avoid encoding scope or type into names as prefixes or suffixes. [1]
Names come from the solution or problem domain.
Class names are evocative nouns, methods are verbs.
Use get, set, is prefixes according to standard.
Have a consistent lexicon; retrieve or fetch, manager or controller, choose one.  
Same name, same purpose, same semantics.  
Use solution domain names: algorithm and pattern names. [2]
Use domain specific names when there are no solution domain names.  
Provide context to the variables with other names and structures.  
Don't add unnecessary context.  
```

[1] Interfaces and their implementations are an exception: prefer ClassImpl over IInterface. Why? It hides that you are giving an interface, reduces difference between abstract classes and interfaces, prefixes are harder to ignore then suffixes.  
[2] Because programmers will read your code. Don't make them ask the customer about every single concept.

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
Abstract data through an interface and getters/setters; do not allow other function to know how you store your data.  
Data structures expose data and have no functions.  
Objects hide data and expose it through functions.  
Data structures and objects are polar opposites.  
Procedural code makes adding functionality easy, but adding new data structures to use them is hard.
OO code makes adding new classes and reusing functions easy, but makes adding and overriding a new functions in every single previous class hard.  
Avoid hybrids; they are the worst of both procedural and OO worlds.  
Follow the Law of Demeter; function f of class C should only call functions of: C, objects that are instance variables of C and objects created by or passed to f.  
Treat all of the following as data structures; do not put business rules into them: Data transfer objects (no functions), Beans (only getters and setters) and Active Records (beans with some other functions)
```

### Error handling

```
Use exceptions, not return codes.  
If you are going to handle errors, start the function by writing the try block.  
Only use unchecked exceptions; those that are not checked at runtime.  
Create informative error messages.  
Define exceptions by how they are caught.  
Define the normal flow and the rest using SPECIAL CASE PATTERN.  
Do not return or pass null; throw an exception or return an object instead.  
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
