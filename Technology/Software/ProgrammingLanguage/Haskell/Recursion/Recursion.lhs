=== RECURSION ===

A recursive function is one which calls itself.
Most problems can be solved recursively.
Solve the simplest base case first, then the edge case.
The output is smaller then the input.

> factorial :: (Integral a) => a -> a
> factorial 0 = 1
> factorial x = x * factorial (x - 1)

> fibonacci :: (Integral a) => a -> a
> fibonacci 0 = 1
> fibonacci 1 = 1
> fibonacci x = fibonacci (x - 1) + fibonacci (x - 2)

Structural recursion processes a data structure.

> getMax :: (Ord a) => [a] -> a
> getMax [x] = x
> getMax (x:xs) = max x (getMax xs)

=== ACCUMULATOR RECURSION ===

Return the result once you've hit the base case.
Don't traverse upwords if you don't have to.

> sum' :: Num a => [a] -> a
> sum' xs = sum xs 0
>   where sum []     s = s
>         sum (x:xs) s = sum xs (x + s)

> reverse' :: [a] -> [a]
> reverse' xs = rev xs []
>   where rev []     ys = ys
>         rev (x:xs) ys = rev xs (x:ys)

Save memory and time.

=== CORECURSION ===

Opposite of recursion.
Construct rather then decompose.
The output is larger then the input.

> cycle' :: a -> [a]
> cycle' x = x : cycle' x

> nats :: [Integer]
> nats = 0 : next nats
>   where next (x:xs) = x + 1 : next xs
