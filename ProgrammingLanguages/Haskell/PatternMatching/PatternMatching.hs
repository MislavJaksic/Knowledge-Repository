-- match the first paramater pattern from top to bottom
-- extract data and then and execute the expression
addVectors :: (Num a) => (a, a) -> (a, a) -> (a, a)
addVectors (x1, y1) (x2, y2) = (x1 + x2, y1 + y2)

-- "x:y:z:xs" means bind 1. to "x", 2. to "y", 3. to "z" and the rest to "xs"
mySum :: (Num a) => [a] -> a
mySum [] = 0
mySum (x:xs) = x + mySum x

-- "@" means bind the whole list to next identifier and then do the pattern matching
capital :: String -> String
capital "" = "Empty string, whoops!"
capital all@(x:xs) = "The first letter of " ++ all ++ " is " ++ [x]
