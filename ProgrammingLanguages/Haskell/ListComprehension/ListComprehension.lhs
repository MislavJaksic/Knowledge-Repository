=== LIST COMPREHENSION ===

[ _expression | _element.._element, _predicate.._predicate]

> trueFalse = [x*y `mod` 2 == 0 | x <- [1..3], y <- [1..3], x*y /= 1, x*y /= 9] -- -> [T, F, T, T, T, F, T]




divideByTen :: (Floating a) => a -> a
divideByTen = (/10)

smallList = [20,40,80]

-- filter and map can be used instead of list comprehension
mapResult = map divideByTen smallList -- map applies a function o a list, result=[2,4,8]
filterResult = filter (>20) smallList -- filter filters out those that do not satisfy the predicate, result=[40,80]


-- takeWhile takes a predicate and a list
-- returns all the elements before the predicate became false
whileResult = (takeWhile (<4) [1,2..]) -- [1,2,3,4]