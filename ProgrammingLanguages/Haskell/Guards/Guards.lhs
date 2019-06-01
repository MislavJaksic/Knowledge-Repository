=== GUARDS ===

Similar to pattern matching.
Execute the first pattern that matches.

> grade :: Int -> Int
> grade score 
>   | score < 50 = 1
>   | score < 63 = 2
>   | score < 76 = 3
>   | score < 89 = 4
>   | otherwise  = 5

size :: (RealFloat a) => a -> a -> String
size height width
    | perimiter < 10.0 = "Small rectangle"
    | perimiter < 30.0 = "Medium rectangle"
    | otherwise = "Big rectangle" --catch-all
    where perimiter = 2*height + 2*width
-- where bindings

-- let bindings; let <binding> in <expression>
cylinder :: (RealFloat a) => a -> a -> a
cylinder r h =
    let sideArea = 2 * pi * r * h
        topArea = pi * r ^2
    in  sideArea + 2 * topArea
    