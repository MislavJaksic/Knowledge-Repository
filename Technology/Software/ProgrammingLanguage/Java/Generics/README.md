## Java generics

Generics are similar to data types.  
Interfaces, classes and methods can be generic (parameterised).  
Arrays cannot have generic types.  

### Generic classes

Generic classes are marked with a <T>.  
<T> is a type parameter.  
<T> is replaced at invocation with a concrete type argument.  
<T> can be any data type besides a primitive.

Static attributes and methods cannot share the same generic as the class.

### Generic methods

Methods can be generic even if their classes aren't.  
Generic methods cannot be overloaded.  
If a generic type is being used only to describe the method's argument, the generic type can be a wildcard <?>.  

### Generic reference

Arguments can hold references to generic, parameterised classes.  

### Bounded types

It is possible to restrict data types that can replace the generic.  

### Type parameter naming convention

E - Element (used extensively by the Java Collections Framework)  
K - Key  
N - Number  
T - Type  
V - Value  
S, U, V - 2nd, 3rd, 4th  
