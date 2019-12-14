=== TYPE ===

A type begins with a capital letter.
Common types are: Int, Integer, Float, Double, Bool, Char, Ordering, ().

:: means: has type of.

In the interpreter:
:t 'a'         -- -> 'a' :: Char
:t True        -- -> True :: Bool
:t "HELLO!"    -- -> "HELLO!" :: [Char]
:t (True, 'a') -- -> (True, 'a') :: (Bool, Char)
:t 4 == 5      -- -> 4 == 5 :: Bool

Functions should have a type declaration.
A function can take multiple parameters.
The last type is the return type.

> addThree :: Int -> Int -> Int -> Int
> addThree x y z = x + y + z

> addThree' :: (Int, Int, Int) -> Int
> addThree' (x y z) = x + y + z

=== TYPE SYNONYM ===

A type alias (synonym) begins with a capital letter.

> type IdNumber  = Int
> type FirstName = String
> type LastName  = String

> type Address = (String, Int, String)
> type Point = (Int, Int)

> type Person    = (FirstName, LastName)
> type Customer  = (Person, Address)
> type Customers = [Customer]
> type Triangle  = (Point, Point, Point)

=== TYPE VARIABLE ===

A type variable, polymorphic type, begins with a lowercase letter.
A generic type.
Polymorphic functions have type variables.

:t head -- -> head :: [a] -> a

> swap' :: (a, b) -> (b, a)
> swap' x = (snd x, fst x)

=== TYPECLASS AND ANNOTATION ===

Typeclasses are a set of types. Typeclasses are interfaces from the OO world.
Types are a set of values. They are classes from the OO world.

Typeclass is a type interface.
A type that implements a typeclass instances its behaviour.

Eq         - support equality testing.
Ord        - can be ordered.
Show       - can be represented as a string.
Read       - take a String type and transform it into another type.
Enum       - has predecessors and successors.
Bounded    - has an upper and lower bound.
Num        - behaves like a number.
Integral   - behaves like a whole number, integer.
Floating   - behaves like a decimal number, floating point.
Fractional - can be divided

Type annotations are explicit annotation after the expression.

read "5" :: Int -- -> 5
read "5" :: Float -- -> 5.0
(read "5" :: Float) * 4 -- -> 20
read "[1,2,3,4]" :: [Int] -- -> [1,2,3,4]
read "(3, 'a')" :: (Int, Char) -- -> (3, 'a')

Don't write typeclasses in data declarations.

=== NEW DATA TYPES ===

Algebraic data types enumerate all possible values.

> data Tricolour = Red | Green | Blue

New type: "Tricolour".
Data constructors: "Red", "Green" and "Blue".
Nullary constructors, parameterless functions, values: "Red", "Green" and "Blue".
Data constructors are functions just like any other.

When there is only one data constructor type and data constructor have the same name ("Point").
"Circle" and "Rectangle" are data constructors of type "Shape".
An analogy: "True" and "False" are of type "Bool".

Types can derive typeclasses (Show, Ord, ...).

> data Point = Point Float Float deriving (Show, Eq)
> data Shape = Circle Point Float | Rectangle Point Point deriving (Show, Eq)

> surface :: Shape -> Float
> surface (Circle _ r) = pi * r ^ 2
> surface (Rectangle (Point x1 y1) (Point x2 y2)) = (abs $ x2 - x1) * (abs $ y2 - y1)

=== ALGEBRAIC DATA TYPES ===

=== RECORDS ===

An alternative way of defining a type.

A bad, tedious and wordy way:
  data Car = Car String String Int deriving (Show)

  company :: Car -> String
  company (Car c _ _) = c

  model :: Car -> String
  model (Car _ m _) = m

  year :: Car -> Int
  year (Car _ _ y) = y

A better way:

> data Car = Car { company :: String
>                , model :: String
>                , year :: Int
>                } deriving (Show)

> oldTimer = Car {year=1967, model="Mustang", company="Ford"}
> oldTimer' = Car 1967 "Mustang" "Ford"

Partial initialization is allowed but data will be "undefined".

> partDef = Car {company="Ford", year=2000}

Record data can be modified by returning a new record.
You can set default values in the same way.

> newTimer = oldTimer {year=2000}

=== TYPE PARAMETER ===

Type constructors take types as parameters and output a type.

> data Vector a = Vector a a a deriving (Show)

> vplus :: (Num t) => Vector t -> Vector t -> Vector t
> (Vector i j k) `vplus` (Vector l m n) = Vector (i+l) (j+m) (k+n)

Vectors can be of any type as long as they are a Num.

=== MAYBE AND EITHER TYPE ===

"Maybe" is used when a value is optional or when an error can occur.

data Maybe a = Nothing | Just a

"Either" is used when we want to return an error message.

data Either a b = Left a | Right b

=== INFIX OPERATORS ===

> infixr 5 :-:
> (:-:) = Cons

> concat = 1 :-: 2 :-: []

Operator priority ranges from 0 to 9.

=== RECURSIVE DATA STRUCTURE ===

A binary search tree.
A "Tree" is either "EmptyTree" or is a "Node" with value "a", left sub-"Tree" and right sub-"Tree".

> data Tree a = EmptyTree | Node a (Tree a) (Tree a) deriving (Show, Read, Eq)

Singleton is just a "Node" with value "a".

> singleton :: a -> Tree a
> singleton x = Node x EmptyTree EmptyTree

Either insert value "a" into an "EmptyTree" or value "a" into a "Node".

> treeInsert :: (Ord a) => a -> Tree a -> Tree a
> treeInsert x EmptyTree = singleton x
> treeInsert x (Node a left right)
>     | x == a = Node x left right
>     | x < a  = Node a (treeInsert x left) right
>     | x > a  = Node a left (treeInsert x right)

> treeElem :: (Ord a) => a -> Tree a -> Bool
> treeElem x EmptyTree = False
> treeElem x (Node a left right)
>     | x == a = True
>     | x < a  = treeElem x left
>     | x > a  = treeElem x right

> nums = [8,6,4,1,7,3,5]
> numsTree = foldr treeInsert EmptyTree nums -- -> constructs a complex tree

=== NEW TYPECLASS ===

"Class" is used to define a new typeclass.
"a" is a type variable that will become an instance of typeclass "Eq".
Function type declarations follow.

class Eq a where
    (==) :: a -> a -> Bool
    (/=) :: a -> a -> Bool
    x == y = not (x /= y)
    x /= y = not (x == y)

data TrafficLight = Red | Yellow | Green

A type can be made an instance of a typeclass.
Typeclass functions are made specifically for the type.
Minimal complete definition is the minimum number of functions a typeclasse has to implement.

instance Eq TrafficLight where
    Red == Red = True
    Green == Green = True
    Yellow == Yellow = True
    _ == _ = False

instance Show TrafficLight where
    show Red = "Red light"
    show Yellow = "Yellow light"
    show Green = "Green light"

Subclass is a typeclass defined with another typeclass.

class (Eq a) => Num a where
   ...

TYPE CONSTRUCTORS /= TYPE VALUE! Remember that well.

Bad definition:
  instance Eq Maybe where
      ...

Better definition:
  instance (Eq m) => Eq (Maybe m) where
      Just x == Just y = x == y
      Nothing == Nothing = True
      _ == _ = False

> class YesNo a where
>   yesno :: a -> Bool

> instance YesNo Int where
>     yesno 0 = False
>     yesno _ = True

> instance YesNo (Maybe a) where
>     yesno (Just _) = True
>     yesno Nothing = False

> yesnoIf :: (YesNo y) => y -> a -> a -> a
> yesnoIf yesnoVal yesResult noResult = if yesno yesnoVal then yesResult else noResult

=== KIND ===

Kinds are "types of types".
"Int", "Maybe", and "Either" are type constructors of different kind.

Int :: * -- -> this kind is an ordinary type
Maybe :: * -> * -- -> this kind is an unary type: input and output an ordinary type

=== FUNCTOR ===

Types that can be mapped over.

class Functor f where
    fmap :: (a -> b) -> f a -> f b

> instance Functor Tree where
>     fmap f EmptyTree = EmptyTree
>     fmap f (Node x leftsub rightsub) = Node (f x) (fmap f leftsub) (fmap f rightsub)

=== FOLDABLE ===
