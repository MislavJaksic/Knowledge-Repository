## Code Complete

Code Complete, written by Steve McConnell, explains why planning software construction is important.  
It describes how to build large maintainable projects.  
Code Complete argues that software construction is important because it is the only activity that is guaranteed to happen.  

## Chapter 3: Measure twice, cut once

When are you ready to begin construction?

Prerequisites and preparation: risk reduction.

Chapter 3 describes how writing prerequisites and careful preparation reduce
risk of failure and allow construction to happen smoothly from beginning until
the end. There are two ways in which prerequisites can be written: sequentially
or iteratively. Sequential approach is appropriate if the application area is
familiar, the system design is understood well and if there is little risk that
the project will fail. Iterative approach is appropriate if the opposite is true
and when making changes is cheap and predictability is not important.

### Prerequisites

Prerequisites are an important part of preparing for a project as they are the
foundation upon which the software is going to be built.

Problem definition prerequisites should define the problem without referencing
a solution.

Requirements describe what the software will do and are specified as
functionalities that the user wants. Requirements often change and those changes
should be managed. Requirement changes are managed by assessing the quality of
existing requirements and then altering them if they are not good enough,
setting up a change control procedure if they come from clients, by making the
system flexible enough to easily accommodate changes and keeping an eye on the
business case for the project. Requirements are also important because they
allows users to agree to them and they avoid arguments about what functionality
should be implemented.

Architecture determines the integrity of the system and if the correct solution
has been found. Architecture is made up of the following components:
- Program organisation - present evidence of considering alternative program
organisation, describe the role of each program, describe major building blocks
and make sure each requirement is covered by at least one building block,
specify how building blocks interact with each other. Each building block
should have only one area of responsibility and should know as little as
possible about other building blocks.

- Major classes - specify how the classes should be used, describe the
responsibility of each class, specify how classes interact with each other,
describe alternative class designs.

- Data design - describe major files and structures to se used, describe
alternatives to the chosen data structures, specify contents of databases, why
is a database used (instead of a flat file), what views were created and so on.
Data should be accessed only by one class.

- Business rules - identify them, describe their impact upon the system.

- User interface - specify major elements, modularise the architecture, make it
flexible so UI element can be swapped, discarded and added without a lot of
code changes.

- Resource management - describe how database connections, threads and handles
are used, estimated memory requirements for extreme and nominal cases.

- Security - how are handle buffers, untrusted inputs, encryption and error
messages handled.

- Performance - speed vs memory vs cost analysis.

- Scalability - describe how the system grow.

- Internationalisation and localisation - describe which character set is being
used, how would translations impact the system, how are strings stored (in a
resource file or class and why). Important in interactive systems.

- Input and output - where are input and output errors detected.

- Error processing - is error detection corrective or detective, passive or
active, how are error messages handled, what about exceptions, at what level
are errors handled, who has the responsibility to validate inputs. Very
important subject!

- Fault tolerance - how error resistant is the system, describe the collection
of techniques that increase system reliability by detecting errors, recovering
from them and containing their bad effect.

- Architectural feasibility - demonstrate that it is possible to complete the
project through explaining how will the system meet the resource constraints,
performance targets and other risks.

- Overengineering and robustness - will the system continue to work if it
detects an error, how overengineered should the system be to ensure robustness.
Decide whether to make the system robust or to make it as simple as possible.

- Buy vs build decision - which programs should be built and which should
be bought of the shelf. If some are built, state how they are going to
surpass the ready made libraries and components.

- Reuse decision - what programs are going to be reused and how.

- Change strategy - describe how changes will be handled, that possible
enhancements were considered and how much they would change the system, how are
new data or changes to existing data been anticipated, how much does the code
have to change to if functionalities were altered. Limit the number of places
where code will have to change.

- General architectural quality - characterised by discussions of classes,
information that is hidden in them and reasons why classes are designed in a
particular way, architecture's objectives should be clearly stated, architecture
should describe the motivations for all major decisions, architecture should be
machine and language independent, architecture should explicitly identify risky
areas and should contain multiple views.

## Chapter 4: Key Construction Decisions

Working in a familiar programming language increases productivity and so does
working in a highly expressive language.

### Programming conventions

Specify all programming conventions before a project, so that programs can have
excellent integrity and cohesion at code level. Specify how variables will be
named, classes, routines and comments.

### Programming into a language

Most of the important programming principles depend not on specific languages
but on the way you use them. If your language lacks constructs that you want to
use or is prone to other kinds of problems, try to compensate for them. Invent
your own coding conventions, standards, class libraries, and other augmentations.

## Chapter 5: Design in Construction

Design is a scheme for turning specifications into a working program. Mistakes
in design are to be expected and it is much better to make them in design then
in construction because it is cheaper to correct them.

There are two types of difficulty in design: accidental and essential. Essential
referes to essential property, a property an object must have to be that object.
Accidental or optional refers to accidental property, a property that an object
just happens to have. Fred Brooks argues in his "No Silver Bullet" paper that
accidental problems in software construction have been solved and that all that
remains is to solve essential problems. Solving essential programs is difficult
because software development consists of working out all the details of a highly
intricate, interlocking set of concepts. In one word, the problem is complexity
and solving it would be to manage complexity.

Ineffective designs arise from three sources: a complex solution to a simple
problem, an incorrect simple solution to a complex problem and an inappropriate
complex solution to a complex solution. Complexity can therefor be managed by
minimizing the amount of essential complexity you have to deal with at any one
time and keeping accidental complexity from proliferating.

### Desirable Characteristics of a Design

- Minimal complexity - don't make a clever design, make it simple and easy to
understand. You know your design is good if you can ignore most other parts of
the program when you focus on one specific part.

- Ease of maintenance - design a self explanatory system that can be easily
maintained.

- Loose coupling - design so that you hold connections among different parts of
the program to a minimum.

- Extensibility - make it so that the most likely changes or enhancements cause
the system the least trauma.

- Reusability - design the system so pieces of the program can be used again.

- High fan-in - fan in refers to a utility program or a class being used by many
other classes or programs.

- Low-to-medium fan-out - refers to a program or a class using many other
programs or classes. This should be avoided.

- Portability - design a system so it can be easily moved to another environment.

- Leanness - make sure nothing can be taken away or deleted from the system and
everything that can be, should be removed to reduce complexity and the need for
testing.

- Stratification - the level of abstraction should be consistent throughout the
program layer.

- Standard techniques - using a standardized, familiar approach will make the
system easier to understand.

### Levels of Design

1) Software system - the whole system

2) Division into Subsystems/Packages  - identify major subsystems, how they are
going to interact and communicate, make sure their communication is restricted
as much as possible. Think about it in terms of pulling out a subsystem... how
much work is required to get the rest of the system working again?

3) Division into Classes - identify all classes in the system and define their
interfaces. Partition the subsystem into smaller parts you can implement.

4) Division into Routines - each class is divided into routines (methods,
functions). A class interface defined in 3) will define some routines.

5) Internal Routine Design - design the detailed functionality of an individual
routine.

### Design Building Blocks

Design is not a deterministic and should be done through the application of
heuristics. Here are some of them:
- Find Real World Objects - a by the book approach of finding objects in the
real world that can be mapped through methods and attributes to synthetic
software object and classes. The mapping activities are: identify the objects
and their attributes, determine what can be done to each object and what each
object is allowed to do to other objects, determined which parts of the object
will be visible to other objects, define each object's interface.

- Form Consistent Abstractions - abstractions allows you to ignore irrelevant
details.

- Encapsulate Implementation Details - encapsulation forbids you to look at the
complexity.

- Inheritance Simplifies the Design - polymorphism. Inheritance allows you to
write a general routine to handle general properties of many classes.

- Hide Secrets - information hiding. Each class should hide design decisions
from all other classes. Decide which methods can be seen from the outside. Don't
let other programs know what they don't have to know because then if you make a
change the effects of it would be localised. For example, instead of declaring
an attribute int you could declare it as AttType.

Barriers to information hiding are excessive distribution of information such as
exposing details about implementation and having literals instead of constants.
Circular dependencies, using class data as global data and prematurely worrying
about performance penalties. Ask "What should I hide?" to dissolve many
difficult design issues.

- Identify Areas Likely to Change - identify, separate and isolate items that
are likely to change. To more easily identify changes, imagine making a small
change and then think about what you will have to change to accommodate the
improvement.

- Keep Coupling Loose - classes should be loosely related to other classes. The
same applies to methods. Minimize the number of connections to other modules,
make connections visible and obvious, make sure many other modules can call the
module as easily as possible. Semantic coupling should be avoided because it
makes a module know something about the inner workings of another module.

- Look for Common Design Patterns - design pattern an solve many existing
problems. Patterns reduce complexity because they are well known abstractions,
they reduce errors, they will suggests design alternatives.

Other Heuristics:
- Aim for Strong Cohesion - methods should support a central purpose
- Build Hierarchies - make a method hierarchy based on which methods calls
which, keep the most abstract program, class and method on top.  
- Formalize Class Contracts - through interfaces
- Assign Responsibilities - ask what are the classes' responsibilities.
- Design for Test - think about how you are going to test a class and methods.
- Avoid Failure - consider how software might fail, don't just copy what is
successful.
- Choose Binding Time Consciously - think about when should a value be bounded
to a variable.
- Make Central Points of Control - make it so that when you have to make a
change, you can make it in a single place.
- Consider Using Brute Force - do it. A simple solution that works is better
then an elegant solution that doesn't.
- Draw a Diagram - pictures are easier to understand then long sentences.
- Keep Your Design Modular - make a system out of black boxes. You know what
goes in and comes out but not what goes on in there... until you open up the
black box.

At the end of the day, don't get stuck by using a single approach. Try different
ones if the first one doesn't work.

### Design Practices

Iterating a design will yield better result every time. If you equipped yourself
with additional knowledge after designing the system once, go improve it.

Divide and conquer the program. Divide it into smaller programs and then solve
each one separately, then look at the bigger picture and solve the more abstract
puzzle.

Top down approach decomposes the problem into smaller parts until the design
seems far too simple and easy. The problem should be decomposed into many levels
of decreasing complexity. It is easy to do because details are left for a later
stage.

Buttom up approach starts at the level of responsibilities which are assigned to
concrete classes. Ask yourself what functionality should the system implement,
identify objects, group up common objects and continue to do so until you
packaged a large part of the system. It identifies utility functionalities early
which results in a well designed high level classes.  However, its weakness is
its overwhelming complexity.

Bottom up and top down approaches complement each other. Use both of them. Do
bottom up until the system becomes to complex, then switch to top down, until
it is too easy, so you switch back to bottom up.

Experimental prototyping is used to partially solve a problem so that you know
if your design will work. Prototyping is writing the least amount of throwaway
code that is needed to answer a specific design question. Design questions must
be specific, the code should be thrown away and you should write the absolute
minimum amount of code.

Collaborative design can greatly improve the design. For quality assurance use
formal inspections, but if you want to generate design alternatives, you can use
a less formal approach.

Capturing your design work can consist of inserting design decisions into the
program itself in a form of a comment, you could have a Wiki or a collection of
web pages, use a camera to photo drawings or some other method such as using
cards or UML.

## Chapter 6: Working Classes

Class is a collection of data and routines. Classes are a tool that allows
programmers to ignore parts of the program while they are working on another
part of it.

### Abstract Data Types (ADT)

Abstract data type is a collection of data and operations that work on that data.
In ADT, data can be a window, font or connection to a database. ADTs allow you
to work in the problem domain instead of low level implementation (add a cell
instead of adding an atom to a linked list).

If you use ADTS you benefit from hiding implementation details, changes don't
affect the whole program, can make the interface more informative, the programs
will be more obviously correct, programs become self documenting, you don't have
to pass data around the whole program and you will work with domain specific
entities rather then implementation details.

Low level data types should be treated as ADTs, common objects such as files
should also be treated as ADTs and ADTs are independent of the medium (a file
can be stored in a database today, but in a file tomorow).

In non object oriented languages class instances, objects can be handled in the
following ways: you pass an ID to all the functions together with other
parameters, you can create a data type that will keep track of the ID for you
and pass it to functions or can create a function that will change the current
instance to another instance (not recommended).

Classes can thought of as ADTs plus inheritance and polymorphism.

### Good Class Interfaces

An interface (a collection of public routines) should group routines that
clearly belong together, expose them to the public and force a class to
implement the routines.

### Good Abstraction

Each class should implement only one ADT at a consistent level of abstraction
and the interface should support this by hiding implementation details.

Make sure you implement the correct abstraction.

Pair up opposite methods. If there is a method that turns the light on there
should be a method that turns the light off.

If some methods are working with half the data and another half are working the
the other half of the data, split the class into two different classes.

There are two parts to an interface: the programmatic and the semantic part. The
programmatic part can be enforced by the compiler, while the semantic part
consists of assumptions about how the interface will be used. If methodA needs
to used before methodB, that is a semantic part. Try to make sure there are as
few semantic parts to an interface as possible.

Avoid eroding a class' abstraction through modification. Consider abstraction
and cohesion together, a class that has good abstraction is likely to have
strong cohesion.

### Good Encapsulation

Encapsulation of implementation details prevents you from looking at the details
which creates good abstractions.

Minimizing accessibility to the methods and data, the stricter the better.
Preserve a good abstraction by exposing a few cohesive methods.

Avoid putting private implementation details into a class's interface. Hide how
the class performs a function as it will decrease complexity by a lot.

Don't make assumptions about the users. They can and will use methods in the
unintended order.

Avoid friend classes.

Favor writing classes and routines that can be read quickly and easily rather
then those that can be written quickly and easily.

Semantic violations of encapsulation occures when the user is aware of how the
methods work. For example, instead of using Connect(), the user uses FindInDB()
because they know FindInDB() performs Connect() automatically. Avoid such
violations by hiding implementation details and exposing how the class works
through the interface documentation.

Make coupling loose by making sure the class offers all the methods other
classes need. Loose coupling is the culmination of being mindful of all the
above.

### Design and Implementation Issues

Containment, inheritance, member functions and data, class coupling,
constructors, and value-vs.-reference objects are as important as defining
a good interface.

### Containment

Containment ("has a" relationship) is when a class contains a primitive data
element or object.

Containment should be implemented thought member data. Avoid doing it though
private inheritance as it will violate encapsulation.

A class shouldn't have more then about seven data members.

### Inheritance

Inheritance ("is a" relationship) is the creation of specialised classes from
more general ones. Base classes specify common elements.

Inheritance should be implemented when the child class is a more specialised
class of the parent class.

Inheritance should be either prohibited or designed and documented.

Observe the Liskov Substitution Principle(LSP). All the routines defined in the
parent class should mean the same thing when they're used in each of the child
classes.

Don't inherit an implementation because you want to inherit an interface or the
other way around. If you want to use the implementation but not the interface,
use containment.

Don't reuse names of methods that cannot be overridden in the child classes.

Consider if you can create an object instead of a new class. There shouldn't be
a class which has only one instance. A Singleton is an exception.  

Don't create inheritance structure that isn't necessary. There shouldn't be a
single child class that inherits the parent class.

Don't override a method and make it do nothing. Search for the source of the
problem and solve it in the parent class.

Avoid making the inheritance tree more then three layers deep.

Instead of checking type, use inheritance and polymorphism. However, there are
cases where it is important to distinguish types because they are not similar.

Avoid using protected data, use protected accessor methods instead.

Avoid multiple inheritance like the plague!

Make sure inheritance doesn't break the primary imperative: reduce complexity.
Use inheritance when multiple classes share either data, methods or both or when
you want the parent class to control the interface.

### Member Functions and Data

Keep the number of routines in a class small.

Disallow uses by declaring the constructor, assignment operator, or other
function or operator private if you find you don't want the user to use them.

Minimize the number of different routines called by a class. Minimize the number
of routine calls to other classes. Observe the Law of Demeter which in a
simplified form says that an object can call its own methods and the methods of
the objects it has created.

Minimize the extent to which classes collaborate by keeping the number of kinds
of instantiated objects low, as well as the number of routine calls to
instantiated objects and the number of calls on objects returned by other
instantiated objects.

### Constructors

Initialize all data members in a constructor.

Enforce a singleton by making a constructor private and exposing a GetInstance()
method.

Prefer deep copies of object to shallow reference/pointer copy until proven
otherwise.

### Reasons to Create a Class

To model a real world object.

To model abstract objects, for example Shape for concrete objects such as
Circle and Square. Good abstract objects are hard to come up with.

To reduce complexity, to hide information, to forget the details that hide
within it. It is also valid to create a class to minimize code size, improve
maintainability.

To isolate complicated algorithms, large data set and strange communication
protocols. If they are in only one class, replacing them will be easier.

To limit the effect changing the code will have on the system as a whole. Parts
of the system that are likely to change should be isolated from those that
aren't.

To hide global data behind accessor methods.

To centralize control over a task, be it accessing a database or a printer.
Centralize control is an important tool, just like information hiding.

To enable a class to be reused somewhere else. Even if the program is used only
once in the project it might be better to put it into a class if you see that it
can be used somewhere else later down the line.
Instead of preparing classes for reuse while working on a project, prepare them
after the project has been completed or at the beginning of another project to
make sure you don't gold plate classes that you aren't going to use after all.

Plan for a family of programs by isolating only those programs that are specific
to each customer while keeping all other classes the same.

Classes to avoid:
don't create god classes that do everything, eliminate irrelevant classes and
avoid classes named after verbs.

## Chapter 7: High Quality Routines

A routine is an individual method or procedure invokable for a single purpose.

A low quality routine has, for example the following characteristics: unclear
routine name, an inconsistent layout, changes input variables, writes to global
data, doesn't have a single purpose, doesn't handle errors, has hard coded magic
numbers, has parameters that are not used, has many parameters, parameters are
poorly ordered.

### Valid Reasons to Create a Routine

One might think that the only reason why a routine should be created is to avoid
code duplication. This makes modification easier and testing simpler. That is a
reason, but there are many more.

Reduce complexity by hiding information and implementation details. A routine
needs to be broken down if it deeply nests loop and conditions.

Introduce intermediate abstractions that will enable you to read the routine as
if it was programmed in English.

Support subclassing by making sure well factored routines are overridden.

Hide sequences of events that have to happen one after another.

Hide pointer manipulation as it is hard to read and error prone. If the
operation is performed in one place, it will be easier to change.

Improve portability by isolating parts that depend of the environment.

Simplify complicated boolean tests as naming a function explains the purpose of
the test and makes sure the details are out of the way.

Improve performance as inefficient code can be more easily replaced.

NOT to ensure all routines are small. Some jobs are performed better in large
routines. There are plenty of other reasons why you should put code into a
routine. This is in contrast to the opinion given in Clean Code by Robert

Martin.
However, you shouldn't be reluctant to put small pieces of code into their own
routine, even if it has a single line of code.

### Design at the Routine Level

Cohesion refers to how closely the operations in a routine are related. A
Cosine() routine is highly cohesive, while CosineAndTang() is less so.

Functional cohesion is the strongest and best kind of cohesion, occurring when
a routine performs one and only one operation.

There are cohesions that are undesirable:
Sequential cohesion exists when a routine contains operations that must be
performed in a specific order and that share data from step to step. It is
solved by creating separate routines for each of the operations. That way other
routines will be able to call one of them without invoking the other.

Communicational cohesion occurs when operations in a routine make use of the
same data and aren't related in any other way. Split it into separate routines
and make another higher level routine that would call both of them.

Temporal cohesion occurs when operations are combined into a routine because
they are all done at the same time. There routines should only call other
routines, as if they were event organisers and shouldn't perform any operation
themselves.

There are cohesions that must be avoided:
Procedural cohesion occurs when operations in a routine are done in a specified
order. The routine has procedural cohesion because it puts a set of operations
in a specified order and the operations don't need to be combined for any other
reason. Solve it by separating the routines.

Logical cohesion occurs when several operations are stuffed into the same
routine and one of the operations is selected by a control flag that's passed in.
Break it into multiple routines. The only exception is if the routine is an
event handler that only executes other routine and doesn't do anything itself.

Coincidental cohesion occurs when the operations in a routine have no
discernible relationship to each other.

At the end, it is far better to concentrate of functional cohesion rather then
learning the terminology of what to avoid.

### Good Routine Names

Describe all the outputs and side effects of a routine in its name. If the name
and long and silly, the routine should be broken up into smaller pieces.

Use clear verbs and nouns, avoid vague words and names. It could be that a vague
name has to be given to a routine because that's what it does, but that is then
a symptom of a unclear purpose.

If a name of a routine has to be long, make it long. Its better then not
describing the side effects or using a vague word.

Name a procedure by using a strong verb followed by an object. If you are naming
methods, you don't have to use encode the name of the object in the routine's
name because in order to invoke the method, you'll have to perform it on an
object.

Use opposites precisely.

Find conventional names for common operations. Databases have names such as
Find(), Insert(), Create(), Remove(), Delete() and so on. Not thinking about the
syntax saves a lot of brain power.

### How Long Can a Routine Be?

Let them grow to about 100, 200 lines. Anything more and you should try to break
it up.

### How to Use Routine Parameters

Order routine parameters by the sequence of operations: input, modify and output.

Similar routines should have their parameters ordered in similar ways.

Always use all the parameters. If you don't use a parameter, don't pass it to
the routine.

Don't use parameters as working variables. Use local variables as working
variables. Write distinguishable names for input and working variables.

Explicitly document your assumptions about the parameters, what values should
and shouldn't appear, meaning of status codes, which ones are input, output and
modify parameters and others.

If you are passing the same data over multiple routines, group up the routines
into a class. Limit the amount of parameters a routine can have. The less
parameters there are the better.

Prefix input, output and modify variables. This advice should be avoided!

When thinking whether to pass an object or just some of its data members to a
routine, think what would better maintain the interface abstraction.

If you can, explicitly state which actual parameter will be assigned to a formal
parameter. (INVOKE fun1(xCord = latitude, yCord = longitude, zCord = elevation))

Make sure that the type of both formal and actual parameters match.

### Special Considerations in the Use of Functions

A function is a routine that returns a value; a procedure is a routine that does
not.

Use a function if the primary purpose of the routine is to return the value
indicated by the function name. Otherwise, use a procedure.

### Macro Routines and Inline Routines

Use macros very sparingly as they are hard to understand, test and debug. The
same is true of inline routines as they break encapsulation.

## Chapter 8: Defensive Programming

Assume that bad data will be passed to your routines and prepare the routines for
handling bad data.

### Protecting Your Program from Invalid Inputs

Check values from external sources.

Check values of routine input parameters.

Decide what to do when you detect bad data.

### Assertions

Assertions state that a condition is true. Often used to document and check if
ana sumption is satisfied.

Use error handling for conditions you expect to occur and assertions for
conditions that should NEVER occur.

Don't put executable code into an assertion.

Preconditions are what the calling code promises will be true before calling the
routine. Postconditions are what the routine promises will be true after it is
finished executing. Handle them with assertions if the data is coming from a
trusted routine and with error handling code if the data is coming from an
external source.

It might be beneficial to use both error handling code and assertions to handle
the same error.

### Error Handling Techniques

Return a neutral value, a value that is known to be harmless.

Ignore an incorrect value in a stream of values and take the next value that is
correct.

Return a value that you returned previously.

Substitute the incorrect value with the closest acceptable value.

Log a warning message to a file.

Return an error code by setting a value, returning an error value or raising an
exception. It is important to decide which part of the system will handle the
errors and which one will just report them.

Call a central error handling routine. This will couple the error handling
routine to the routines that use it.

Display an error message when an error has occurred. This might make the GUI
inconsistent and hard to localize.

Shutting down is also an option and a very desirable one if you are developing a
safety critical application.

Robustness is favored by safety critical applications as it emphasises that the
result must always be correct and if it isn't, its better to shut down.
Correctness is favored by consumer applications as they emphasize that any
result is better then shutting down.

Decide on the error handling design at the architecture level and follow it
consistently throughout the system.

### Exceptions

Exceptions are a specific means by which code can pass along errors or
exceptional events to the code that called it.

Notify other parts of the program about an error.

Throw an exception only for exceptional conditions, for conditions that cannot
be addressed with any other coding practice.

Always handle exceptions locally if it is possible to handle them locally.

Avoid throwing exceptions in constructors and destructors due to the complicated
nature of how exceptions are processed in these methods.

Make sure the exception is on a consistent level of abstraction with the class
interface.

Include in the exception message all the info that led to the exception.

Avoid empty "catch" blocks.

Know the exceptions thrown by the library code you use. If you don't know them,
create a prototype to flush them out.

Make a centralised exception handler, but know that it will tightly couple all
the programs that use it.

Standardize the use of exceptions in your project.

Always consider using the alternative to exceptions. It is perfectly valid to
abort and release all resources when a condition isn't satisfied and let the
user rerun the program with correct input.

### Barricade Your Program to Contain the Damage Caused by Errors

Barricade are a set of programs that check all input data and only allow data
past the barricade if and only if it is clean and safe.

Convert input data to the correct type as soon as possible.

Routines outside the barricade can never assume the data is clean and have to
use error handling code, but routines inside the barricade should use assertions
as they assume the data is clean and that the barricades are working properly.

### Debugging Aids

Use some resources during development to make sure you can find error easily.

Use offensive programming. Try to make the program fail. Fill up the memory,
assert conditions, make the program fail hard if it detects an error.

### Determining How Much Defensive Programming to Leave in Production Code


## Chapter 9: Pseudocode Programming Process


A way of designing, documenting and improving classes and routines.

Steps in creating a class:
- Create a general design for a class: define the class's specific
responsibilities, define what secrets it will hide and what abstractions will
the class interface capture. Is the class derived or will others be allowed to
derive from it? Identify the public methods and non trivial data members.
- Construct each routine within the class: some routines need other routines and
these needs can ripple back to the design.
- Review and test the class as a whole: after testing each routine individually.

Good pseudocode:
- use English like sentences that precisely describe specific operations
- avoid syntactic elements, work at the higher level
- write it at the level of intent, describe the meaning of the approach rather
then the implementation
- write at a low enough level that generating code from it will be nearly
automatic

Using pseudocode makes reviews easier, it supports iterative refinement, makes
changes easier, minimizes commenting effort and is easier to maintain.

Steps in building a routine:
- Design the routine:
  - check for prerequisites by making sure it fits well into the design as well
as checking that it is necessary.
  - define the problem the routine will solve, what info it hides, its inputs
and outputs, preconditions it requires and post conditions it guarantees
  - name the routine with a clear unambiguous name
  - decide on how to test the routine
  - make sure you aren't implementing a routine that is already implemented in
the languages standard library
  - think about bad inputs, invalid returns
  - think about efficiency, about speed and memory goals
  - research the algorithms and data types
  - write pseudocode and review it
  - try different ideas in pseudocode and keep the best
- Code the routine:
  - write the routine declaration
  - turn the pseudocode into comments
  - fill in the code below each comment
  - check if the code should be further factored
- Check the code:
  - manually check the routine for errors, excellent programs understand why the
routine works
  - compile it only after you have checked that routine manually first
  - you can go through the routine line by line in the debugger
  - test the code using test cases
  - remove any detected errors and see what caused it
- Clean up leftovers:
  - check the interface, parameters, input and output data
  - check if it does only one thing, that it is loosely coupled, designed
defensively
  - check the variables
  - check statements and logic
  - check the layout
  - check the documentation
  - remove redundant comments

Alternative routine designs:
- test first development: write a test first, then make sure the routine passes
it
- refactoring: use semantic preserving transformations to remove code and make
it better
- design by contract: each routine should have pre and postconditions that then
get verified
- hacking?: compile to find errors, it if works don't change it, but because
it is not systematic, this approach will drive you into a corner

## Chapter 10: General Issues in Using Variables


### Initializing Variables

You should declare variables even if the compiler doesn't require you to.

Initialize each variable as it's declared.

Initialize each variable close to where it's first used. Principle of Proximity:
keep related actions together.

Use final or const when possible. If not, use a coding convention such as
capitalize a name if it is a constant.

Make sure counters are reset at proper times.

Initialize a class's member data in its constructor.

Don't ignore your compiler's warnings when it comes to variables.

Initialize working memory at the beginning of your program. Fill it with zeroes
as it is a neutral value.

### Scope

Scope or visibility refers to the extent to which your variables are known and
can be referenced throughout a program.

Keep the variable "alive" for as short a time as possible.

Minimize the scope by:
Initialize variables used in a loop immediately before the loop.

Assign a value to a variable just before the value is used.

Group related statements.

Break groups of related statements into separate routines.

Begin with most restricted visibility, and expand the variable's scope only if
necessary.

By minimizing scope, it is harder to write the program because the area where
you can access the variable is limited, however, the program becomes much easier
to read.

### Persistence

Until the end of the block of code, until they are explicitly deleted, until the
end of the program or they persist forever.
Make sure variables persist for the shortest possible time.

### Binding time

Describes when the variable and its value are bound together. It is better to
bind them later, so your code can be more flexible.

### Relationship Between Data Types and Control Structures

Sequential data translates to sequential statements in a program.

Selective data translates to if and case statements in a program.

Iterative data translates to for, repeat, and while looping structures in a
program.

### Each Variable for Exactly One Purpose

Use a single variable for a single purpose.

Avoid hidden meanings in variables such as using it to store a return value,
unless it is  1 which means that an error occurred. It is fine to return an error
code, but you must catch it as soon as possible to avoid confusion.

Make sure that all declared variables are used.

## Chapter 11: The Power of Variable Names


### Choosing Good Names

The name should fully and accurately describe the entity the variable represents.

Names should be specific, descriptive and as short as possible. Don't use
abbreviations.

Get names from the problem domain rather then from the solution domain.

The length of the name should be tied to the length of its scope. Short names
for short scopes, longer names for longer scopes.

Qualifiers such as Max, Total, Average should be at the end of the name, unless
there is a very specific reason why it shouldn't be.

### Naming Specific Types Of Data

Loop indexes: if loops are nested, use descriptive names, but if there is a
single simple loop, you can use one letter names.

Status variables: don't name them flags! Use a descriptive name.

Temporary variables: try not to use them.

Boolean variables: done, error, found and success/ok are all excellent boolean
names. They should imply true or false. Use positive boolean names (not negative
such as notFound, notSuccess).

Enumerated types: erm... try not to use them. If you do, you will have to
remember to sets of names and the way they are paired up.

Constants: capitalized and descriptive, not literal (FIVE is bad, CYCLES_NEEDED
is good).

### Naming conventions

They create an easily recognisable pattern which aids the reader.

Differentiate between variable names and routine names. Example: variableName vs.
RoutineName().

Differentiate between classes and objects, types and variables.

Identify global variables, member variables, type definition, named constants,
enumerated types, input only parameters.

Format names by using either CamelCase or underscore (_). Underscore (_) seems
to be a more readable.

### Kinds of name to avoid

Avoid misleading names or abbreviations. Avoid names with similar meanings.
Avoid variables with different meanings but similar names.

Avoid numerals in names. Avoid misspelled words in names.

Don't differentiate variable names solely by capitalization.

Don't use names that are totally unrelated to what the variables represent.

## Chapter 12: Fundamental Data Types


### Numbers in general

Avoid magic number because they are hard to maintain. Zeroes and ones are
alright to use.

Anticipate divide by zero errors. Wherever division happens, this error could
occur.

Avoid mixed type comparison. Comparing a float to an integer will almost always
result in a false value.

### Integers

Be careful with integer division and overflow.

### Float

Avoiding adding or subtracting number that have greatly different magnitudes.

Avoid equality comparisons, as they will almost always be false.

Anticipate rounding errors. There are language libraries which implement data
types sensitive to these errors.

### Characters and strings

Avoid magic characters and string.

Watch for off by one errors.

Know how your language handles Unicode.

Decide on an internationalization/localization strategy early in the lifetime of
a program.

Decide on a consistent conversion strategy among string types.

### Boolean variables

Use boolean variables to indicate what the if test is suppose to do (check for
completion, error condition or something else).

Use boolean variables to simplify tests with many comparisons.

Create your own boolean type if there is no such thing in the language.

### Enumerated types


### Named constants

Use named constants in data declarations as well as in parts of the program that
needs them.

Avoid literal values. Make them into constants.

### Arrays

Make sure that all array indexes are within the bounds of the array.

Consider using container classes that can only be accessed sequentially instead
of arrays. Stacks, queues, sets and similar data structures.

Check the end point of an array.

If an array is multidimensional, understand the correct order of subscripts.

### Creating Your Own Types

Create your own type even if it is the same as integer or float. This is because
if you ever need to change the data type, you can simply change the type of your
custom created type, whereas if you didn't create a custom type, you would have
to search for all the types and change them.

## Chapter 13: Unusual Data Types
