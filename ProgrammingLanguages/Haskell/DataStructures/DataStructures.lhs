import qualified Data.List as hs.list
import qualified Data.Char as hs.char
import qualified Data.Map as hs.map
import qualified Data.Set as hs.set

=== LISTS ===

Lists are homogenous.

> numbers = [1,2,3]
> string = "hello"

Extend lists:

> extendNumber = [1,2,3] ++ [4,5,6] -- -> [1,2,3,4,5,6]
> extendString = "hello" ++ " " ++ "world" -- -> "hello world"

Add value to beginning:

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

=== LIST RANGES ===

> firstSecondHighNumber = [2,4..11] -- -> [2,4,8,10]
> firstSecondHighChar = ['K'..'Z'] -- -> "KLMNOPQRSTUVWXYZ"
> firstSecondHighReverse = [5,3..(-2)] -- -> [5,3,1,-1]

Infinite ranges:

> takeInfinite = take 4 [5,10..] -- -> [5,10,15,20]
> takeCycle = take 4 (cycle [1,2,3]) -- -> [1,2,3,1]
> takeRepeat = take 4 (repeat 5) -- -> [5,5,5,5]

=== TUPLES ===

Tuples are heterogenous and finite.

> tuple = ('A', 2)

> f = fst tuple -- -> 'A'
> s = snd tuple -- -> 2
> pairs = zip [1,2] ["one", "two", "three", "four"] -- -> [(1,"one"),(2,"two")]



hs.list.intersperse
hs.list.intercalate
hs.list.transpose
hs.list.concat
hs.list.concatMap
hs.list.and
hs.list.or
hs.list.any
hs.list.iterate
hs.list.splitAt
hs.list.takeWhile
hs.list.dropWhile
hs.list.span
hs.list.break
hs.list.sort
hs.list.group
hs.list.inits
hs.list.tails
hs.list.isInfixOf
hs.list.isPrefix
hs.list.isSuffixOf
hs.list.elem
hs.list.notElem
hs.list.partition
hs.list.find
hs.list.elemIndex
hs.list.elemIndicies
hs.list.findIndex
hs.list.findIndices
hs.list.zip3
hs.list.zip4
hs.list.zipWith3
hs.list.zipWith4
hs.list.lines
hs.list.unlines
hs.list.words
hs.list.unwords
hs.list.nub
hs.list.delete
hs.list.\\
hs.list.union
hs.list.intersect
hs.list.insert



hs.char.isControl
hs.char.isSpace
hs.char.isLower
hs.char.isUpper
hs.char.isAlpha
hs.char.isAlphaNum
hs.char.isPrint
hs.char.isDigit
hs.char.isOctDigit
hs.char.isHexDigit
hs.char.isLetter
hs.char.isMark
hs.char.isNumber
hs.char.isPunctuation
hs.char.isSymbol
hs.char.isSeparator
hs.char.isAscii
hs.char.isLatin1
hs.char.isAsciiUpper
hs.char.isAsciiLower

hs.char.toUpper
hs.char.toLower
hs.char.toTitle
hs.char.digitToInt
hs.char.intToDigit
hs.char.ord



hs.map.empty
hs.map.insert
hs.map.null
hs.map.size
hs.map.singleton
hs.map.lookup
hs.map.member
hs.map.map
hs.map.filter
hs.map.toList
hs.map.keys
hs.map.elems
hs.map.fromListWith
hs.map.insertWith



hs.set.fromList
hs.set.intersection
hs.set.difference
hs.set.union
hs.set.null
hs.set.size
hs.set.member
hs.set.empty
hs.set.singleton
hs.set.insert
hs.set.delete
hs.set.map
hs.set.filter
hs.set.toList
