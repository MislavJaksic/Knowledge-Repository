=== LOCAL DEFINITIONS, WHERE BINDINGS ===

Compute a value once in the "where" block.

Good reasons to use "where":
* if an expression is being repeated locally
* if this makes your code more comprehensive
* for documentation

> tripCost :: Int -> Double -> Double -> String
> tripCost days hotel travel
>   | cost <= i = "Extremely cheap vacation"
>   | cost <= j = "Cheap vacation"
>   | otherwise = "Expensive vacation"
>   where hotelCost = hotel * realToFrac days
>         cost  = hotelCost + travel
>         (i,j) = (100,500)

=== LET-IN ===

"let" is extremely local and used a few times.
Similar to "where".

Difference between "where" and "let":
* "where" is declared at the end of a function and is visible only to the last clause, including the guards
* "let" can be declared everywhere and is by itself an expression

Use "where" over "let".

> cylinder :: (RealFloat a) => a -> a -> a
> cylinder r h =
>     let sideArea = 2 * pi * r * h -- bindings
>         topArea = pi * r ^ 2
>     in  sideArea + 2 * topArea -- return expression
