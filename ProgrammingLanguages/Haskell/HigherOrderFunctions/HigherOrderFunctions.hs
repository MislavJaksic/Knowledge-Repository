-- a function is of a higher order if it takes a function as input or if it outputs a function
-- currying is when a function that takes multiple parameters is evaluated as a series of functions that take a single paramater
-- partially applied functions are those that have some of its parameters fixed to a single value
multThree :: (Num a) => a -> a -> a -> a
multThree x y z = x * y * z

multTwoWithNine = multThree 9 -- fixed a parameter to 9
result = multTwoWithNine 2 3 -- -> 2*3*9=54

multWithEighteen = multTwoWithNine 2 -- fixed two parameters to 9 and 2
anotherResult = 10 -- -> 10*2*9=180

divideByTen :: (Floating a) => a -> a
divideByTen = (/10)
yetAnotherResult = divideByTen 50 -- 50/10=5

applyTwice :: (a -> a) -> a -> a -- (a -> a) is a function type, so we do need the parentheses
applyTwice f x = f (f x)
