=== LIST COMPREHENSION ===

List comprehension are a mathematical construct:
[ _expression | _element.._element, _predicate.._predicate]

> trueFalse = [p `mod` 2 == 0 | x <- [1..3], y <- [1..3], let p = x*y, p /= 1, p /= 9] -- -> [T, F, T, T, T, F, T]
