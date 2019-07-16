=== DEFINING VALUES AND FUNCTIONS ===

Values are functions without parameters:

> string = "String"

Function which takes one parameter:

> double x = x + x

Infix notation:

> one = 5 `div` 3 -- -> 1

Function are declared like so:
_type_declaration :: (_class_constraint)..(_class_constraint) => _param -> .. -> _param -> _output
_function_name _param.._param = _expression

> number :: (Num a) => a -> a -> a -- -> Num is a _class_constraint; x and y are a and a
> number x y = x*10 + y

=== CURRIED FUNCTIONS ===

A higher-order function is a function that takes a function as input or output.
On paper, a function can take only one parameter.
If it takes two or more it has to be curried.

"->" is right associative, meaning they group up to the right:
number :: (Num a) => a -> (a -> a) -- -> takes one parameter, returns a function that takes one parameter and returns a value
EQUAL TO
number :: (Num a) => a -> a -> a -- -> takes two parameters

Function application is right associative.

(number 1) 2 -- -> takes one parameter, returns a function that takes one parameter and returns a value
EQUAL  TO
number 1 2 -- -> takes two parameters

=== PARTIAL APPLICATION ===

Define a new function by giving another function too few arguments.
The order of parameters is important when defining a partially applied function.
This is called eta reduction.

> fifty = number 5 -- -> defined x, but not y
> fiftySeven = fifty 7 -- -> 57

=== SECTIONS ===

Partial application of an infix function.

> addTwo = (+2) -- -> assumes that a parameter, x, is missing

> prependZero :: [Integer] -> [Integer]
> prependZero = (0:)

=== HIGHER-ORDER FUNCTIONS ===

A higher-order function is a function that takes a function as input or output.

> applyTwice :: (a -> a) -> a -> a -- -> mandatory brackets because of right association
> applyTwice f x = f (f x)

Useful HOF functions:
zipWith :: (a -> b -> c) -> [a] -> [b] -> [c]
takeWhile :: (a -> Bool) -> [a] -> [a]
dropWhile :: (a -> Bool) -> [a] -> [a]
break :: (a -> Bool) -> [a] -> ([a], [a]) 
partition :: (a -> Bool) -> [a] -> ([a], [a])
any :: (a -> Bool) -> [a] -> Bool
all :: (a -> Bool) -> [a] -> Bool
findIndices :: (a -> Bool) -> [a] -> [Int]
sortBy :: (a -> a -> Ordering) -> [a] -> [a]
groupBy :: (a -> a -> Bool) -> [a] -> [[a]]
deleteBy :: (a -> a -> Bool) -> a -> [a] -> [a]
maximumBy :: (a -> a -> Ordering) -> [a] -> a
minimumBy :: (a -> a -> Ordering) -> [a] -> a
nubBy :: (a -> a -> Bool) -> [a] -> [a]

comparing :: Ord a => (b -> a) -> b -> b -> Ordering

on :: (b -> b -> c) -> (a -> b) -> a -> a -> c

=== MAP ===

Takes a function and a list, then applies the function.

> map' :: (a -> b) -> [a] -> [b]
> map' _ []     = []
> map' f (x:xs) = f x : map f xs

=== FILTER ===

Takes a predicate functions and a list, then returns a boolean list.

> filter' :: (a -> Bool) -> [a] -> [a]
> filter' _ [] = []
> filter' p (x:xs)
>   | p x       = x : filter p xs
>   | otherwise = filter p xs

=== TAKE WHILE ===

Takes a predicate functions and a list, then returns all elements before the predicate became false.

> whileResult = (takeWhile (<4) [1,2..]) -- [1,2,3,4]

=== LAMBDA EXPRESSIONS ===

Lambda are anonymous, throwaway functions.
Lambda begins with \ and defines parameters before ->.

incList = map (+1)
EQUAL TO
incList = map (\x -> x + 1)

Use sparingly!

=== COMPOSITION AND POINTFREE STYLE ===

Mathematical composition: (f . g . h)(x) = f (g (h x))
Composition is right associative.

> applyTwice' :: (a -> a) -> a -> a
> applyTwice' f = f . f

> increasePositives :: [Integer] -> [Integer]
> increasePositives = map (+1) . filter (>0)

Pointfree style is a way of defining functions without writing parameters.

=== FUNCTION APPLICATION ===

$ is an operator with the lowest infixl (precedence).
Removes the need for brackets.

> fa = sum (map sqrt [1..130])
> fa' = sum $ map sqrt [1..130]

=== FOLD AND SCAN ===

Folds take a binary function, an accumulator starting value and a list.
Folds return a single value, an accumulator.

Right fold takes a combining function, a starting value and a list.
It evaluates to:
f x1 (f x2 (f x3 z))
OR
x1 `f` (x2 `f` (x3 `f` z)))

Left fold takes a combining function, a starting value and a list.
It evaluates to:
f (f (f z x1) x2) x3

> sum'' :: (Num a) => [a] -> a
> sum'' = foldl (+) 0

> map'' :: (a -> b) -> [a] -> [b]
> map'' f xs = foldr (\x acc -> f x : acc) [] xs

foldl is more efficient then foldr.

Scans are similar to folds, but output all intermediate accumulators.
