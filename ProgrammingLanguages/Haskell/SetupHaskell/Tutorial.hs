-- boolean algebra
&&
||
not

-- equality
==
/=

-- successor
succ

-- extremes
min
max

-- function definition
double x = x + x
addTwo x y = x + y
doubleThenAdd x y = double x + double y

-- if
isBig x = if x > 100 then True else False

-- constant
constantString = "HELLO"

-- list
list = [1,2,3,4,5]
list ++ [6,7,8]
0:list
list !! 3
list > [2,0]

-- list functions
head
tail
last
init
length
null
reverse
take
drop
maximum
minimum
sum
product
elem

-- list
[1..20]
[2,4..20]
[2,4..]

-- list functions
cycle
repeat
replicate

div 6 2
6 `div` 2

[if x*y `mod` 2 /= 0 then True else False | x <- [1..10], y <- [1..10], x*y /= 1, x*y /= 100]

[(1,2),('A','B')]

fst
snd
zip

:t
:r
:l

-- read "::" as "has type of"
addThree :: Int -> Int -> Int -> Int
addthree = x y z = x + y + z

Int
Integer
Float
Double
Bool
Char


Eq
Ord
Show
Read
Enum
Bounded
Num
Integral
Floating

fromIntegral

lucky :: (Integral a) => a -> String  
lucky 7 = "LUCKY NUMBER SEVEN!"  
lucky x = "Sorry, you're out of luck, pal!"   

addVectors :: (Num a) => (a, a) -> (a, a) -> (a, a)  
addVectors (x1, y1) (x2, y2) = (x1 + x2, y1 + y2)  

xs = [(1,3), (4,3), (2,4), (5,3), (5,6), (3,1)]  
[a+b | (a,b) <- xs]  

:
_

head' :: [a] -> a  
head' [] = error "Can't call head on an empty list, dummy!"  
head' (x:_) = x  

capital :: String -> String  
capital "" = "Empty string, whoops!"  
capital all@(x:xs) = "The first letter of " ++ all ++ " is " ++ [x]  

max' :: (Ord a) => a -> a -> a  
max' a b   
    | a > b     = a  
    | otherwise = b  
    
myCompare :: (Ord a) => a -> a -> Ordering  
a `myCompare` b  
    | a > b     = GT  
    | a == b    = EQ  
    | otherwise = LT  
    
bmiTell :: (RealFloat a) => a -> a -> String  
bmiTell weight height  
    | bmi <= skinny = "You're underweight, you emo, you!"  
    | bmi <= normal = "You're supposedly normal. Pffft, I bet you're ugly!"  
    | bmi <= fat    = "You're fat! Lose some weight, fatty!"  
    | otherwise     = "You're a whale, congratulations!"  
    where bmi = weight / height ^ 2  
          (skinny, normal, fat) = (18.5, 25.0, 30.0) 
          
initials :: String -> String -> String  
initials firstname lastname = [f] ++ ". " ++ [l] ++ "."  
    where (f:_) = firstname  
          (l:_) = lastname    
          
cylinder :: (RealFloat a) => a -> a -> a  
cylinder r h = 
    let sideArea = 2 * pi * r * h  
        topArea = pi * r ^2  
    in  sideArea + 2 * topArea  

(let a = 100; b = 200; c = 300 in a*b*c, let foo="Hey "; bar = "there!" in foo ++ bar)

calcBmis :: (RealFloat a) => [(a, a)] -> [a]  
calcBmis xs = [bmi | (w, h) <- xs, let bmi = w / h ^ 2, bmi >= 25.0]  

describeList :: [a] -> String  
describeList xs = "The list is " ++ case xs of [] -> "empty."  
                                               [x] -> "a singleton list."   
                                               xs -> "a longer list."  
                                               
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



