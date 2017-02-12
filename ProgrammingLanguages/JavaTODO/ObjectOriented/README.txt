Introduction to object oriented programming in Java
===================================================
In Java everything has to be contained in a class, no matter how simple the program.

Class
-----
A class is a merger of a data structure and functions associated with that data. A class models an object in the real world. Classes act like blueprint from which objects are instantiated (created).
Classes have attributes (fields) and methods (functions).
When a class is created, a data type of the same name is also created.

Object
------
An object is instantiated (created) from a class. Objects can invoke methods and access attributes.

Attributes
----------
Classes have attributes in which they store data. Attributes can belong to an object (instance variables, non-static attribute) or to a class (class variables, static attribute). Class variables are shared across all objects of the same class.

Visibility
----------
Visibility keywords determine who can access a method or an attribute.
            Class Package Subclass World Explanation
public	      Y	     Y       Y       Y   - everyone
protected     Y	     Y       Y       N   - classes who inherit or are in the package
no modifier   Y	     Y       N       N   - same class or classes in the package
private	      Y	     N       N       N   - only the same class can access it

Methods
-------
Methods are function who perform operations on data.
It is common to set an attribute to private and to then make setter (mutators) and getter (accessors) methods who will change the data in the private attributes.
Getters should always try to return either just the data or a new object and should never return the reference to a private attribute (because then an attribute can be changed by accessing its reference).

Constructor method
------------------
Constructors are methods who share the same name as the class. They are invoked when an object is instantiated from a class.

Overriding methods
------------------
All classes inherit some other class. Classes who don't explicitly inherit any other class inherit a generic Java class Object. Inherited methods such as equals and toString often get overridden with a more specific and more appropriate implementation. Inherited methods are overridden if the inheritor class has a method of the same name. Overridden methods are manually marked with @Override.

Hiding methods
---------------
Imagine that a child class inherits from a parent class and then a child object is created. Assume a child has a static method of the same name as the parent class.
If the child object is stored in a variable whose reference is that of a parent class, invoking the child's static method will instead invoke the parent's static method. That is called hiding.

Overloading methods
-------------------
When two methods share the same name within the same class, but have different method signatures, they are said to be overloaded. When invoking these methods the more appropriate one will be called.

Static and final
----------------
Attributes marked with the keyword static belong to a class (class variables). If any object changes a static attribute, it changes for all other objects beloninging to the same class as well.
Attributes without the keyword static belong to an object (instance variables).
Methods marked with the keyword static can be invoked by a class as well as an object. Static methods can be hidden by a reference upon inheritance.
Methods without the keyword static can be overridden by an inheritor.
A static block is a block of statements executed after attribute declaration.

Attributes marked with the keyword final cannot be changed.
Methods marked with the keyword final cannot be overridden or hidden.
Classes marked with the keyword final cannot be inherited.

Attributes and methods can be marked with both final and static keywords. Final decides if they can be changed while static says to whose they belong.

Inheritance
-----------
Classes can inherit another class. Java forbids multiple inheritance. When a class inherits another, it gains the other classes' attributes and methods. The inheritor class (child class) can override methods of the inherited class (parent class) if it not marked with static. If a method is marked with static, it can be hidden.
Inheriting, overriding, hiding and object/reference difference is demonstrated in a .java file.

Abstract
--------
The purpose of abstract classes is to make the inheritor class implement an abstract method.
Classes can be marked with the keyword abstract. Objects cannot be created from abstract classes. A class can be abstract even if it has implemented all of its methods.
Methods that are not implemented have to be marked with the keyword abstract. If a class has at least one abstract method, it has to be marked with the keyword abstract.


Interface
---------
Interface is similar to an inherited class only interfaces are implemented. If a class implements an interface it has to implement all of its methods. An interface can already have some methods implemented.

Difference between an interface and an abstract class
-----------------------------------------------------
When a class implements an interface it has to implement of of its methods, while a class that extends an abstract class can be abstract itself and can keep the abstract methods abstract (unimplemented).