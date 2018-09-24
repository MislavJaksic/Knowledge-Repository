-- guards are made up of a condition and an expression
-- if a condition is True, execute the expression; if it is False, check the next guard's condition
rectanglePerimiter :: (RealFloat a) => a -> a -> String
rectanglePerimiter height width
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
    