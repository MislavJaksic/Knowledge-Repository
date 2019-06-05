=== DEFINING VALUES AND FUNCTIONS ===

Parameterless function, a constant value:

> string = "String"

Function which takes one parameter:

> double x = x + x

Infix function notation:

> one = 5 `div` 3 -- -> 1

Function declaration:
_type_declaration :: (_class_constraint)..(_class_constraint) => _param.._param -> _output
_function_name _param.._param = _expression

> number :: (Num a) => a -> a -> a
> number x y = x*10 + y

=== CURRIED FUNCTIONS ===

A higer-order function is a function that returns a function and/or takes a function as argument.
A function can take only one parameter.
If it takes more, it has been curried.

"->" is right associative, meaning they group up to the right:
number :: (Num a) => a -> a -> a -- -> takes two parameters
is the same as
number :: (Num a) => a -> (a -> a) -- -> takes one parameter, returns a function that takes one parameter and returns a value

Function application is right associative.

number 1 2 -- -> takes two parameters
is the same as
(number 1) 2 -- -> takes one parameter, returns a function that takes one parameter and returns a value

=== PARTIAL APPLICATION ===

You can define a new function by giving an old function too few arguments.
The order of parameters is important when defining a function.
This is called eta reduction.

> fifty = number 5 -- -> defined x, but not y
> fiftySeven = fifty 7 -- -> 57

=== SECTIONS ===

Partial application of an infix function.

> addTwo = (+2)

> prependZero :: [Integer] -> [Integer]
> prependZero = (0:)

=== HIGHER-ORDER FUNCTIONS ===

A higer-order function is a function that returns a function and/or takes a function as argument.

> applyTwice :: (a -> a) -> a -> a -- -> mandatory brackets because of right association
> applyTwice f x = f (f x)

=== MAP ===

Takes a function and lists of equal length, then joins the while applying the function.

> map' :: (a -> b) -> [a] -> [b]
> map' _ []     = []
> map' f (x:xs) = f x : map f xs

=== FILTER ===

Take a predicate functions and a list, then returns a truth list.

> filter' :: (a -> Bool) -> [a] -> [a]
> filter' _ [] = []
> filter' p (x:xs)
>   | p x       = x : filter p xs
>   | otherwise = filter p xs

=== TAKE WHILE ===

Take a predicate functions and a list, then returns all elements before the predicate became false.

> whileResult = (takeWhile (<4) [1,2..]) -- [1,2,3,4]

=== LAMBDA EXPRESSIONS ===

Lambdas are anonymous, throwaway functions.
Lambdas begin with \ and define paramaters before ->.

Lambda of:
incList = map (+1)
is:
incList = map (\x -> x + 1)

Use sparelingly!

=== COMPOSITION AND POINTFREE STYLE ===

Composition of functions: (f . g . h)(x) = f (g (h x))
Composition is right associative.

> applyTwice' :: (a -> a) -> a -> a
> applyTwice' f = f . f

> increasePositives :: [Integer] -> [Integer]
> increasePositives = map (+1) . filter (>0)

Pointfree style is a way of writing which leaves out arguments.

=== FUNCTION APPLICATION ===

$ is the lowest operator.
Removes the need for brackets.

> fa = sum (map sqrt [1..130])
> fa' = sum $ map sqrt [1..130]

=== FOLD AND SCAN ===

Folds take a binary function, a starting value and a list.
Folds return a single value, an accumulator.

sum'' :: (Num a) => [a] -> a
sum'' = foldl (+) 0

map'' :: (a -> b) -> [a] -> [b]
map'' f xs = foldr (\x acc -> f x : acc) [] xs

foldl is more efficient then foldr.

Scans are similar to folds.
Scans output all intermediate accumulators.
