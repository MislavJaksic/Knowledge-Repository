=== LIST COMPREHENSION ===

[ _expression | _element.._element, _predicate.._predicate]

> trueFalse = [x*y `mod` 2 == 0 | x <- [1..3], y <- [1..3], x*y /= 1, x*y /= 9] -- -> [T, F, T, T, T, F, T]
