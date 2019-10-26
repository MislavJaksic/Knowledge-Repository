## Java generics

Generics are similar to data types. They allow you to specify what is stored in a data structure. Interfaces,
classes and methods can be generic (parameterised). There can be more then one generic at the same time. Arrays
cannot have generic types.

### Generic classes

Generic classes are marked with a <T>. <T> is a type parameter. <T> has to be replaced at invocation with an
actual type argument. <T> can be replaced by any data type that is not a primitive.

Static attributes and methods cannot share the same generic as the class.

### Generic methods

Methods can be generic even if their classes aren't. Methods that have parameterised arguments cannot be
overloaded. If a generic type is being used only to describe the method's argument, the generic type can
be written as <?>.

### Generic reference

Arguments can hold references to generic, parameterised classes.

### Bounded types

It is possible to restrict which data types can replace the generic.

### Type parameter naming convention

E - Element (used extensively by the Java Collections Framework)
K - Key
N - Number
T - Type
V - Value
S,U,V,... - 2nd, 3rd, 4th, ...
