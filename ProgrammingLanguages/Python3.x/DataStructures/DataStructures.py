from collections import namedtuple
from functools import lru_cache

# https://docs.python.org/3.8/tutorial/datastructures.html#%20more-on-lists

# Python lists are both arrays and lists
list_one = [0, 1, 2, 3, 4]  # or list_one = range(0, 5, 1)
# Assign a reference; doesn't copy the object!
list_two = list_one
list_two.append(5)  # Changes both lists
list_one  # -> [0, 1, 2, 3, 4, 5]
list_two  # -> [0, 1, 2, 3, 4, 5]

list_one.pop()  # -> 5
list_one[0] = 99  # -> [99, 1, 2, 3, 4]
list_one[0]  # -> 99
list_two[2]  # -> 2

#  Slicing (same as strings)
#  [| 0 | 1 | 2 | 3 | 4 |]
#   0   1   2   3   4   5
#  -5  -4  -3  -2  -1
list_one[2:4]  # -> [2, 3]
list_two[-4:-3]  # -> [1]

first, _, third, *_ = range(10)
first, third  # -> 0 2


# Tuple are immutable; useful for passing data around the program
tuples = (1, 2, "Hello")
tuples[2]  # -> "Hello"
# tuples[2] = 3 # -> Error! Cannot be changed!


# Dictionary is Python's hash table
dict = {'1': 'One'}
dict['2'] = 'Two'

dict['1']  # -> "One"
dict.get('3')  # -> None

list(dict.keys())  # -> ['1', '2']
list(dict.values())  # -> ['One, 'Two']
list(dict.items())  # -> [('1', 'One'), ('2', 'Two')]


# Sets are unique
set([1, 1, 5, 8, 8])  # -> [1, 5, 8]


# https://docs.python.org/3/library/collections.html

# Named tuples are useful when creating data objects
Point = namedtuple('Point', ['x', 'y'])
p = Point(11, y=22)
p[0] + p[1]  # -> 33
p.x + p.y  # -> 33
p  # -> Point(x=11, y=22)

x, y = p  # tuple unpacking


@lru_cache(maxsize=512)  # memoize with a least recently used cache
def fib_memoization(number):
    if number == 0:
        return 0
    if number == 1:
        return 1

    return fib_memoization(number-1) + fib_memoization(number-2)
