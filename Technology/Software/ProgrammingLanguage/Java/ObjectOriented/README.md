## Object oriented programming

In Java everything is an object (expect primitives).  

### Object oriented concepts

An object has a state and a behaviour. Objects can be made up of other objects.  
Fields (variables) store a state. Methods (functions) expose behaviour.  
Data encapsulation is hiding an object's state by requiring users to use its methods.  
Class is an object blueprint.  
Objects are instances of a class.  
Inheritance is how classes inherit fields and methods from a superclass (parent). Each class can have one superclass.  
Interface is a group of related unimplemented methods.  
Package is a group of related classes and interfaces.  

### Class

Classes merge a data structure and functions that work on that data structure. Classes model objects in the real world.  
Classes act like blueprint from which objects are instantiated (created).  
Classes have fields (variables) and methods (functions).  
When a class is created, a data type of the same name is also created.  

### Object

An object is instantiated (created) from a class.  
Objects can invoke methods and access fields.  

### Fields

Classes have fields in which they store data.  
Fields can belong to an object (instance variables, non-static fields) or to a class (class variables, static fields).  
Class variables are shared across all objects of the same class.  

### Visibility

Visibility keywords determine who can access a method or a field.

| Modifier | Class | Package | Subclass | World | Explanation |
| :--- | :---: | :---: | :---: | :---: | :--- |
| `public` | Y | Y | Y | Y | everyone |
| `protected` | Y | Y | Y | N | classes who inherit or are in the package |
| no modifier | Y | Y | N | N | same class or classes in the package |
| `private` | Y | N | N | N | only the same class can access it |

### Methods

Methods are function which perform operations on data.  
When fields are private create setter (mutators) and getter (accessors) methods responsible for these fields.  
Getters must return either a primitive or a new object, never a reference because then it can be changed.  

### Constructor method

Constructors are methods that share the same name as the class.  
Constructors are invoked when an object is instantiated from a class.  

### Overriding methods

All classes inherit a class.  
Classes that don't explicitly inherit a class inherit a generic Java class called `Object`.  
Inherited methods such as `equals` and `toString` often get overridden with a more specific and more appropriate method.  
Inherited methods are overridden if the inheritor class has a method of the same name.  
Overridden methods are manually marked with `@Override`.

### Hiding methods

Imagine the following:
* a child class inherits from a parent class
* a child object is created
* the child has a static method with the same name as the parent class

If the child object is stored in a parent reference and the static method invoked, the child's static method will be invoked.  
This is called hiding.  

### Overloading methods

Methods with the same name but different method signature in a class are overloaded.  
Invoking overloaded methods runs the more appropriate one.  

### Static and final keywords

Fields marked with the keyword `static` belong to a class (class variables).  
If any object changes a static field, it changes for all other objects belonging to the same class as well.  
Fields without the keyword `static` are unique to an object (instance variables).  

Methods marked with the keyword `static` can be invoked by a class as well as an object.  
Static methods can be hidden by reference upon inheritance.  
Methods without the keyword `static` can be overridden by an inheritor.  

A static block is a block of statements executed after field declarations.  

Fields marked with the keyword `final` cannot be changed.  
Methods marked with the keyword `final` cannot be overridden or hidden.  
Classes marked with the keyword `final` cannot be inherited.  

Fields and methods can be marked with both `final` and `static` keywords.  
`final` decides if they can be changed while `static` says to whom they belong.  

### Inheritance

Classes can inherit another class.  
A class can inherit only one class.  
When a class inherits another, it gains the other class' fields and methods.  
The inheritor class (child class) can override methods of the inherited class (parent class) if it not marked with `static`.  
If a method is marked with `static`, it can be hidden.  
Inheriting, overriding, hiding and object/reference difference is demonstrated in the `.java` file.  

### Abstract

Abstract classes make the inheritor class implement an abstract method.  
Classes can be marked with the keyword `abstract`.  
Abstract classes cannot be instantiated.  
A class can be abstract even if all its methods are implemented.  
Unimplemented methods must be marked with the keyword `abstract`.  
If a class has at least one abstract method, it has to be marked with the keyword `abstract`.  

### Interface

Interface's methods must be implemented by the inheritor.  
To implement an interface use the `implements` keyword.  

### Difference between an interface and an abstract class

When a class implements an interface:  
* has to implement its methods  

When a class extends an abstract class:  
* it doesn't have to implement all its methods  

### Summary

Object, state, behaviour, field/variable, method, signature, data encapsulation, class, instance, inheritance, interface, package.  
Visibility, belonging, static, final, public, private, protected, no modifier.  
Constructor, destructor, overriding, overloading, hiding.  
Abstract.  
