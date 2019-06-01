=== TYPES ===

A type begins with a capital letter.
Common types: Int, Integer, Float, Double, Bool, Char, Ordering, ().

:: means "has type of".

In the interpreter:
:t 'a'         -- ->'a' :: Char
:t True        -- ->True :: Bool
:t "HELLO!"    -- ->"HELLO!" :: [Char]
:t (True, 'a') -- ->(True, 'a') :: (Bool, Char)
:t 4 == 5      -- ->4 == 5 :: Bool

Functions should have a type declaration.
A function can take multiple parameters.
The last type is the return type.

> addThree :: Int -> Int -> Int -> Int  
> addThree x y z = x + y + z  

> addThree' :: (Int, Int, Int) -> Int  
> addThree' (x y z) = x + y + z  

=== TYPE SYNONYMS ===

A type alias, synonym begins with a capital letter.

> type IdNumber  = Int
> type FirstName = String
> type LastName  = String

> type Address = (String, Int, String)
> type Point = (Int, Int)

> type Person    = (FirstName, LastName)
> type Customer  = (Person, Address)
> type Customers = [Customer]
> type Triangle  = (Point, Point, Point)

=== POLYMORPHIC TYPES ===

A type variable, polymorphic type begins with a lowercase letter.
A generic type.
Polymorphic functions have type variables.

:t head -- ->head :: [a] -> a

> swap' :: (a, b) -> (b, a)
> swap' x = (snd x, fst x)

=== TYPECLASSES AND ANNOTATIONS ===

Typeclass is a type interface.
A type that implements a typeclass supports its behaviour.

Eq type supports equality testing.
Ord type can be ordered.
Show type can be represented as a string.
Read type takes a String type and transforms it into another type.
Enum type enables sequancial enumeration.
Bounded type has a upper and lower bound.
Num type behaves like numbers.
Integral type behaves like a whole number, integer.
Floating type behaves like a floating point number.

Type annotations are explicit annotation after the expression.

read "5" :: Int -- -> 5
read "5" :: Float -- -> 5.0
(read "5" :: Float) * 4 -- -> 20
read "[1,2,3,4]" :: [Int] -- -> [1,2,3,4]
read "(3, 'a')" :: (Int, Char) -- -> (3, 'a')


