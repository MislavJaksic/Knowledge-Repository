-- folds take a binary function, a starting value and a list
-- they return a single value, an accumulator
sumAll :: (Num a) => [a] -> a
sumAll xs = foldl (+) 0 xs -- foldl == left fold, there is also a foldr == right fold

-- fold right is much more efficient with : then a fold left with ++ when building a list



--scanl and scanr are just like foldl and foldr but they all intermidiate values as a list instead of a single value
scanResult = scanl (+) 0 [3,5,2,1] -- [0,3,8,10,11]
