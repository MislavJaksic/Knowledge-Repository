from collections import namedtuple
from functools import lru_cache

# List
# Like arrays, lists or queues
zero = [5]
one[0] = 0  # -> one = [0]
one[0]  # -> 0
one = zero  # Assign a reference, not a copy!
one.append(1)  # Append element to the end
zero.extend(one)  # Joins two lists
one.insert(len(one), 2)  # Insert before the index
one.remove(2)  # Delete first occurance or error
one.pop()  # -> 1;
one.clear()  # Delete all items
zero.index(1)  # Get index of first occurence or error
zero.count(1)  # Count occurances
zero.sort(key=str, reverse=False)  # Sort by function modified key
zero.reverse()  # Reverse elements

# Slicing (same as strings)
#   [| 0 | 1 | 2 | 3 | 4 |]
# i= 0   1   2   3   4   5
# i=-5  -4  -3  -2  -1
zero_to_five = [0, 1, 2, 3, 4, 5]
zero_to_five[2:4]  # -> [2, 3]
zero_to_five[-4:-3]  # -> [1]

first, _, third, *_ = range(10)
first, third  # -> 0 2

# List Comprehension
zeros_ones = [0, 1, 0, 1]
[True if x == 1 else False for x in zeros_ones if x == 0]

# Tuple
# Immutable
single_item_tuple = (1,)
tuples = (1, 2, "Hello")
tuples[2]  # -> "Hello"
# tuples[2] = 3 # -> Error! Cannot be changed!

# Set
# Only unique values
set([1, 1, 5, 8, 8])  # -> [1, 5, 8]

# Named tuples
# Create a data object
Point = namedtuple("Point", ["x", "y"])
p = Point(11, y=22)
p[0] + p[1]  # -> 33
p.x + p.y  # -> 33
p  # -> Point(x=11, y=22)

x, y = p  # tuple unpacking

# Dictionary
# Hash table
dict = {"1": "One"}
dict["2"] = "Two"

dict["1"]  # -> "One"
dict.get("3")  # -> None

list(dict.keys())  # -> ['1', '2']
list(dict.values())  # -> ['One, 'Two']
list(dict.items())  # -> [('1', 'One'), ('2', 'Two')]


@lru_cache(maxsize=512)  # memoize with a least recently used cache
def fib_memoization(number):
    if number == 0:
        return 0
    if number == 1:
        return 1

    return fib_memoization(number - 1) + fib_memoization(number - 2)
