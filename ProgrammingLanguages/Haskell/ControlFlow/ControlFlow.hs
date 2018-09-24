doubleSmall x = if x > 100
                  then x
                  else x + x -- else is mandatory; "if" is an expression

-- case expressions
describeList :: [a] -> String
describeList xs = "The list is " ++ case xs of [] -> "empty."
                                               [x] -> "a singleton list."
                                               xs -> "a longer list."

-- there is no such thing as a for loop in Haskell
-- instead, think recursively
maximum' :: (Ord a) => [a] -> a
maximum' [] = error "maximum of empty list"
maximum' [x] = x
maximum' (x:xs)
    | x > maxTail = x
    | otherwise = maxTail
    where maxTail = maximum' xs
    