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
> equal = (sqrt (3 + 4 + 9)) == (sqrt $ 3 + 4 + 9)

-- function composition means (f . g)(x) = f(g(x))
> result = map (negate . abs) [2,-4,-6] -- map abs first, then map negate to the result, [-2,-4,-6]
