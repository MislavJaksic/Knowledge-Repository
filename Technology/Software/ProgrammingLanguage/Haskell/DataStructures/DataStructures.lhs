> import qualified Data.List as L
> import qualified Data.Char as C
> import qualified Data.Map as M
> import qualified Data.Set as S

=== LISTS ===

Lists are homogeneous and may be infinite.

> numbers = [1,2,3]
> string = "hello"

Values can be added to existing lists.

> extendNumber = [1,2,3] ++ [4,5,6] -- -> [1,2,3,4,5,6]
> extendString = "hello" ++ " " ++ "world" -- -> "hello world"

> headNumber = (-2) : (-1) : 0 : [1,2,3] -- -> [-2,-1,0,1,2,3]
> headString = 'H' : "askell" -- -> "Haskell"
> headEmpty = 1 : 2 : 3 : [] -- -> [1,2,3]

Access list member:

> two = [1,2,3] !! 1 -- -> 2

Compare lists in lexicographical order:

> true1 = [3,2,1] > [2,10,100] -- -> True
> true2 = [3,4,2] > [3,4] -- -> True

Basic functions:

> getHead = head [1,2,3] -- -> 1
> getTail = tail [1,2,3] -- -> [2,3]
> getLast = last [1,2,3] -- -> 3
> getInit = init [1,2,3] -- -> [1,2]

> getLength = length [1,2,3]  -- -> 3
> isNull = null [1,2,3]  -- -> False
> reverseNumbers = reverse [1,2,3]  -- -> [3,2,1]
> takeFirstTwo = take 2 [1,2,3]  -- -> [1,2]
> dropFirstTwo = drop 2 [1,2,3]  -- -> [3]
> getMax = maximum [1,2,3]  -- -> 3
> getMin = minimum [1,2,3]  -- -> 1
> getSum = sum [1,2,3]  -- -> 6
> getProduct = product [1,2,3]  -- -> 6

> isElemInList = 2 `elem` [1,2,3]  -- -> True
> withoutDuplicates = L.nub [1, 2, 3, 1, 1, 2]  -- -> [1,2,3]
> concatLists = L.concat [[1,2],[3,4,5]] -- -> [1,2,3,4,5]
> splitList = splitAt 3 [1,2,3,4,5] -- -> ([1,2,3],[4,5])

=== LIST RANGES ===

> firstSecondHighNumber = [2,4..11] -- -> [2,4,8,10]
> firstSecondHighChar = ['K'..'Z'] -- -> "KLMNOPQRSTUVWXYZ"
> firstSecondHighReverse = [5,3..(-2)] -- -> [5,3,1,-1]

Infinite ranges:

> takeInfinite = take 4 [5,10..] -- -> [5,10,15,20]
> takeCycle = take 4 (cycle [1,2,3]) -- -> [1,2,3,1]
> takeRepeat = take 4 (repeat 5) -- -> [5,5,5,5]

=== LIST COMPREHENSION ===

List comprehension are a mathematical construct:
[ _expression | _element.._element, _predicate.._predicate]

> trueFalse = [p `mod` 2 == 0 | x <- [1..3], y <- [1..3], let p = x*y, p /= 1, p /= 9] -- -> [T, F, T, T, T, F, T]

=== TUPLES ===

Tuples are heterogeneous and finite.

> tuple = ('A', 2)

> f = fst tuple -- -> 'A'
> s = snd tuple -- -> 2
> pairs = zip [1,2] ["one", "two", "three", "four"] -- -> [(1,"one"),(2,"two")]

"()" is called a unit. An empty tuple type.

=== DATA.LIST FUNCTIONS ===

L.intersperse
L.intercalate
L.transpose
L.concat
L.concatMap
L.and
L.or
L.any
L.iterate
L.splitAt
L.takeWhile
L.dropWhile
L.span
L.break
L.sort
L.group
L.inits
L.tails
L.isInfixOf
L.isPrefix
L.isSuffixOf
L.elem
L.notElem
L.partition
L.find
L.elemIndex
L.elemIndicies
L.findIndex
L.findIndices
L.zip3
L.zip4
L.zipWith3
L.zipWith4
L.lines
L.unlines
L.words
L.unwords
L.nub
L.delete
L.\\
L.union
L.intersect
L.insert

=== DATA.CHAR FUNCTIONS ===

C.isControl
C.isSpace
C.isLower
C.isUpper
C.isAlpha
C.isAlphaNum
C.isPrint
C.isDigit
C.isOctDigit
C.isHexDigit
C.isLetter
C.isMark
C.isNumber
C.isPunctuation
C.isSymbol
C.isSeparator
C.isAscii
C.isLatin1
C.isAsciiUpper
C.isAsciiLower

C.toUpper
C.toLower
C.toTitle
C.digitToInt
C.intToDigit
C.ord

=== DATA.MAP FUNCTIONS ===

M.empty
M.insert
M.null
M.size
M.singleton
M.lookup
M.member
M.map
M.filter
M.toList
M.keys
M.elems
M.fromListWith
M.insertWith

=== DATA.SET FUNCTIONS ===

S.fromList
S.intersection
S.difference
S.union
S.null
S.size
S.member
S.empty
S.singleton
S.insert
S.delete
S.map
S.filter
S.toList
