multThree :: (Num a) => a -> a -> a -> a  
multThree x y z = x * y * z  

multTwoWithNine = multThree 9  
multTwoWithNine 2 3  

multWithEighteen = multTwoWithNine 2  
multWithEighteen 10  

divideByTen :: (Floating a) => a -> a  
divideByTen = (/10)  

applyTwice :: (a -> a) -> a -> a  
applyTwice f x = f (f x) 

zipWith' :: (a -> b -> c) -> [a] -> [b] -> [c]  
zipWith' _ [] _ = []  
zipWith' _ _ [] = []  
zipWith' f (x:xs) (y:ys) = f x y : zipWith' f xs ys

flip' :: (a -> b -> c) -> b -> a -> c  
flip' f y x = f x y  

map filter
takeWhile


numLongChains :: Int  
numLongChains = length (filter (\xs -> length xs > 15) (map chain [1..100]))

zipWith (\a b -> (a * 30 + 3) / b) [5,4,3,2,1] [1,2,3,4,5]  

map (\(a,b) -> a + b) [(1,2),(3,5),(6,3),(2,6),(2,5)]  

foldl
foldr
foldl1
foldr1
scanl
scanr

$
.


