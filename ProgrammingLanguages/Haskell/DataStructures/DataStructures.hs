import qualified Data.List as hs.list
import qualified Data.Char as hs.char
import qualified Data.Map as hs.map
import qualified Data.Set as hs.set

-- lists are homogenous
numbers = [1,2,3]
stringList = "hello"

appendLists = [1,2,3] ++ [4,5,6] -- ++ is append to end
appendStrings = "hello" ++ " " ++ "world" 
appendToBegining = (-2) : (-1) : 0 : [1,2,3] -- : is add to begining

accessMember = [1,2,3] !! 1 -- !! is access member

-- lists can be compared with <,>, == , /=

getHead = head [1,2,3] -- -> 1
getTail = tail [1,2,3] -- -> [2,3]
getLast = last [1,2,3] -- -> 3
getInit = init [1,2,3] -- -> [1,2]

getLength = length [1,2,3]  -- -> 3
isNull = null [1,2,3]  -- -> False
reverseNumbers = reverse [1,2,3]  -- -> [3,2,1]
takeFirstTwo = take 2 [1,2,3]  -- -> [1,2]
dropFirstTwo = drop 2 [1,2,3]  -- -> [3]
getMax = maximum [1,2,3]  -- -> 3
getMin = minimum [1,2,3]  -- -> 1
getSum = sum [1,2,3]  -- -> 6
getProduct = product [1,2,3]  -- -> 6
isElemInList = 2 `elem` [1,2,3]  -- -> True

-- ranges, [<from>, <step_to>..<limit>]
stepTwoFromTwoToTen = [2,4..10] -- ->[2,4,8,10]
stepOneFromTwoToFive = [2,3..5] -- ->[2,3,4,5]

firstSixElemOfInfiniteList = take 6 [5,10..] -- ->first 6 elements in an infinite list of multiples of 5
firstTwelveCharInInfiniteCycleList = take 12 (cycle "ab ") -- ->"ab ab ab ab "
firstFourNumInInfiniteRepeat = take 4 (repeat 5) -- ->[5,5,5,5]



-- tuples
-- heterogenous, finite
aTuple = ("bee", "queen", 1)
pairThem = zip [1,2] ["one", "two", "three", "four"] -- ->[(1,"one"),(2,"two")]



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
