-- functions: <function_name> <params..> = <xpression>
doubleTwo :: (Num a) => a -> a -> a
doubleTwo x y = 2*x + 2*y -- read: "doubleTwo" take parameters "x y" and returns the result of "2*x + 2*y"

-- function application is using $ as the lowest operator instead of using parentheses
equal = (sqrt (3 + 4 + 9)) == (sqrt $ 3 + 4 + 9)

-- function composition means (f . g)(x) = f(g(x))
result = map (negate . abs) [2,-4,-6] -- map abs first, then map negate to the result, [-2,-4,-6]
