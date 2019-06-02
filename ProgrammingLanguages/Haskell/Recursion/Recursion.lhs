=== RECURSION ===

Most problems can be solved recursively.
Solve the simplest, base case.
Solve the edge cases.

> factorial :: (Integral a) => a -> a
> factorial 0 = 1
> factorial x = x * factorial (x - 1)

> fibbonaci :: (Integral a) => a -> a
> fibbonaci 0 = 1
> fibbonaci 1 = 1
> fibbonaci x = fibbonaci (x - 1) + fibbonaci (x - 2)

Structural recursion processes a data structure.

> getMax :: (Ord a) => [a] -> a
> getMax [x] = x
> getMax (x:xs) = max x (getMax xs)

=== CORECURSION ===

Opposite of recursion.
The output is larger then the input.
Construct reather then decompose.

> cycle' :: a -> [a]
> cycle' x = x : cycle' x

> nats :: [Integer]
> nats = 0 : next nats
>   where next (x:xs) = x + 1 : next xs
