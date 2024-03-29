=== IF-THEN-ELSE ===

Else is mandatory.

> doubleSmall x = if x > 100
>                   then x
>                   else x + x

Avoid explicitly returning True or False.

> bigBad x = if x > 100
>              then True
>              else False

> bigGood x = x > 100

=== PATTERN MATCHING ===

Execute the first pattern that matches.
Should have a catch all pattern.

> say :: (Integral a) => a -> String
> say 1 = "One"
> say 2 = "Two"
> say x = "Not one or two"

Value unpacking through pattern matching:

> addVectors :: (Num a) => (a, a) -> (a, a) -> (a, a)
> addVectors (x1, y1) (x2, y2) = (x1 + x2, y1 + y2)

_ means: ignore this value.
: in pattern matching means: separate head from rest.

> sum' :: (Num a) => [a] -> a
> sum' [] = 0
> sum' (x:xs) = x + sum' xs

> tell :: (Show a) => [a] -> String
> tell [] = "Empty"
> tell (x:[]) = "One element"
> tell (x:y:[]) = "Two elements"
> tell (x:y:_) = "At least two elements"

Pattern (as-pattern) is an annotation.
Pattern (as-pattern) is made up of a name and @.
The name references the pattern.

> capital :: String -> String
> capital "" = "Empty string, whoops!"
> capital all@(x:xs) = "The first letter of " ++ all ++ " is " ++ [x]

=== CASE EXPRESSION ===

Pattern matching is syntactic sugar for case expressions.

> say' :: (Integral a) => a -> String
> say' x = case x of 1 -> "One"
>                    2 -> "Two"
>                    x -> "Not one or two"

Case is more powerful then pattern matching.
Case is pattern matching that can be used anywhere.  

=== GUARDS ===

Similar to pattern matching.
Execute the first pattern that matches.

> say'' :: (Integral a) => a -> String
> say'' x
>   | x == 1 = "One"
>   | x == 2 = "Two"
>   | otherwise = "Not one or two"
