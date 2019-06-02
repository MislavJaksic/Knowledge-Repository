=== DEFINING VALUES AND FUNCTIONS ===

Parameterless function, a constant value:

> string = "String"

Function which takes one parameter:

> double x = x + x

Infix function notation:

> one = 5 `div` 3 -- -> 1

Function type declaration:
_type_declaration :: (_class_constraint)..(_class_constraint) => _param.._param -> _output
_function_name _param.._param = _expression

> doubleAndAddTwo :: (Num a) => a -> a -> a
> doubleAndAddTwo x y = 2*x + 2*y



-- function application is using $ as the lowest operator instead of using parentheses
equal = (sqrt (3 + 4 + 9)) == (sqrt $ 3 + 4 + 9)

-- function composition means (f . g)(x) = f(g(x))
result = map (negate . abs) [2,-4,-6] -- map abs first, then map negate to the result, [-2,-4,-6]




divideByTen :: (Floating a) => a -> a
divideByTen = (/10)

smallList = [20,40,80]

-- filter and map can be used instead of list comprehension
mapResult = map divideByTen smallList -- map applies a function o a list, result=[2,4,8]
filterResult = filter (>20) smallList -- filter filters out those that do not satisfy the predicate, result=[40,80]


-- takeWhile takes a predicate and a list
-- returns all the elements before the predicate became false
whileResult = (takeWhile (<4) [1,2..]) -- [1,2,3,4]