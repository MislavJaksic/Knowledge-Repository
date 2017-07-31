## Java generics

A generic is a data type, but written as if it was a parameter. Interfaces, classes and methods can be generic
(parameterised). There can be more then one generic at the same time. Arrays cannot have generic types.

### Generic classes

Generic classes are marked by <T>, where T stands for any non primitive data type. When you crate an object
from a generic class you have to specifiy a data type that will replace the parameter T. Object data have
replaced the generic data type with different data types are not the same.
Static attributes and methods annot share the same generic as the class.

### Generic methods

Methods can be generic even if their classes aren't. Methods that have parameterised arguments cannot be
overloaded. If a generic type is being used only to describe the method's argument, the generic type can
be written as <?>.

### Generic reference

Arguments can hold references to generic, parameterised classes.

### Bounded types

It is possible to restrict which data types can replace the generic.