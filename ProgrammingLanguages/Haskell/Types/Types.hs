-- :: reads "has type of"
-- :t 'a'         -- ->'a' :: Char
-- :t True        -- ->True :: Bool
-- :t "HELLO!"    -- ->"HELLO!" :: [Char]
-- :t (True, 'a') -- ->(True, 'a') :: (Bool, Char)
-- :t 4 == 5      -- ->4 == 5 :: Bool

-- types
-- Int, Integer, Float, Double, Bool, Char

-- type variables
-- :t head -- ->head :: [a] -> a; a is a type variable, similar to a generic

-- typeclass is an interface for types; a type that implements a typeclass has its behaviours
-- Eq is used for types that support equality testing
-- Ord is for types that have an ordering
-- Show is for presenting data as strings
-- Read is for taking a string and returning a different type
-- Enum is for sequentially ordered types; useful in list ranges
-- Bounded is for those that have upper and lower bounds
-- Num is for those that need to act like numbers
-- Integral is for those that need to act like whole numbers
-- Floating is for those that need to act like folating numbers

-- :t (==) -- ->(==) :: (Eq a) => a -> a -> Bool; everything before "=>" is a class constraint
           -- ->"==" takes any two inpus of the same type that implement Eg class (class constraint) and returns a Boolean"
printString = show 5.324 -- ->"5.324"
parseNumber = read "5" :: Int -- -> 5; explicit type annotation
