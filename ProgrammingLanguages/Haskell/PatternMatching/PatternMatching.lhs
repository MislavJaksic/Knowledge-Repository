=== PATTERN MATCHING ===

Execute the first pattern that matches.
Should have a catch all pattern.

> say :: (Integral a) => a -> String
> say 1 = "One"
> say 2 = "Two"
> say x = "Not one or two"

Value unpacking through pattern matching.

> addVectors :: (Num a) => (a, a) -> (a, a) -> (a, a)  
> addVectors (x1, y1) (x2, y2) = (x1 + x2, y1 + y2)  

_ means "ignore this value".
: in pattern matching means "seperate head from rest".

> sum' :: (Num a) => [a] -> a  
> sum' [] = 0  
> sum' (x:xs) = x + sum' xs

Pattern, as-pattern is an annotation.
Pattern, as-pattern is made from a name and @.
The name references the pattern.

> capital :: String -> String  
> capital "" = "Empty string, whoops!"  
> capital all@(x:xs) = "The first letter of " ++ all ++ " is " ++ [x]  
