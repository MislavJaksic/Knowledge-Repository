returnMaximum :: (Ord a) => [a] -> a
returnMaximum [] = error "maximum of empty list"
returnMaximum [x] = x
returnMaximum (x:xs)
    | x > maxTail = x
    | otherwise = maxTail
    where maxTail = returnMaximum xs
-- example: [4,3,2,5]
-- long form:
-- [4,3,2,5] -> x = 4, xs = [3,2,5]
-- 4 > <recusrive_call_1>
-- [3,2,5] -> x = 3, xs = [2,5]
-- 3 > <recusrive_call_2>
-- [2,5] -> x = 2, xs = 5
-- 2 > 5, False
-- return 5; <recusrive_call_2> = 5
-- 3 > 5, False
-- return 5; <recusrive_call_1> = 5
-- 4 > 5, False
-- return 5;
-- short form:
-- 2 > 5, return 5
-- 3 > 5, return 5
-- 4 > 5, return 5

takeFirstN :: (Num i, Ord i) => i -> [a] -> [a]  
takeFirstN n list
    | n <= 0   = []
takeFirstN n [] = []
takeFirstN n (x:xs) = x : takeFirstN (n-1) xs
-- example: 2, [4,3,2,5]
-- 2, [4,3,2,5] -> 2, x = 4, xs = [3,2,5]
-- 4 : <recusrive_call_1>
-- 1, [3,2,5] -> 1, x = 3, xs = [2,5]
-- 1 : <recusrive_call_2>
-- 0, [2,5] -> 0, [2,5]
-- return []; <recusrive_call_2> = []
-- return 1 : [], <recusrive_call_1> = 1 : []
-- return 4 : 1 : []

