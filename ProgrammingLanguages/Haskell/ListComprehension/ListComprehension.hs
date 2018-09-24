-- in maths: S = {2*x | x e N, x <= 10}
-- read: S is a set made up of natural numbers less then 10 that are then multiplied by 2
-- result: [2, ..., 20]
-- in Haskell: [<expression> | <elements..>, <predicates..>]
set = [2*x | x <- [1..10]]

highLowOdd numbers = [if x > 20 then "High" else "Low" | x <- numbers, even x]
-- highLowOdd [18..22] -- ->["Low", "Low", "High"]

rightTriangles = [ (a,b,c) | c <- [1..10], b <- [1..c], a <- [1..b], a^2 + b^2 == c^2]



divideByTen :: (Floating a) => a -> a
divideByTen = (/10)

smallList = [20,40,80]

-- filter and map can be used instead of list comprehension
mapResult = map divideByTen smallList -- map applies a function o a list, result=[2,4,8]
filterResult = filter (>20) smallList -- filter filters out those that do not satisfy the predicate, result=[40,80]


-- takeWhile takes a predicate and a list
-- returns all the elements before the predicate became false
whileResult = (takeWhile (<4) [1,2..]) -- [1,2,3,4]