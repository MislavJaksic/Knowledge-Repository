import string
from collections import namedtuple
from functools import lru_cache

# String
str = "heLLo1"
str.capitalize()  # -> "Hello1"
str.title()  # -> 'Hello1'
str.upper()  # -> 'HELLO1'
str.lower()  # -> "hello1"
str.casefold()  # -> "hello1", stronger .lowercase()
str.swapcase()  # -> 'HEllO1'

str.center(10, "i")  # -> 'iiheLLo1ii'
str.ljust(8, "i")  # -> 'heLLo1ii'
str.rjust(8, "i")  # -> 'iiheLLo1'
str.zfill(10)  # -> '0000heLLo1'

str.find("o1", 0, len(str))  # -> 4
str.rfind("o1", 0, len(str))  # -> 4
str.index("o1", 0, len(str))  # -> like .find() but raises an error
str.rindex("o1", 0, len(str))  # -> like .rfind() but raises an error

str.isalnum()  # -> True
str.isalpha()  # -> False
str.isascii()  # -> True, new in 3.7
str.isdecimal()  # -> False
str.isdigit()  # -> False
str.isidentifier()  # -> True
str.islower()  # -> False
str.isnumeric()  # -> False
str.isprintable()  # -> True
str.isspace()  # -> False
str.istitle()  # -> False
str.isupper()  # -> False

str.strip("eh1o")  # -> 'LL'
str.lstrip("eh")  # -> 'LLo1'
str.rstrip("1o")  # -> 'heLL'

str.join(["A", "B", "C"])  # -> "AheLLo1BheLLo1C"
str.split("L")  # -> ['he', '', 'o1']
str.rsplit("L", 1)  # -> ['heL', 'o1'], like .split() but from the right
str.splitlines()  # -> split string into list
str.partition("L")  # -> ('he', 'L', 'Lo1')
str.rpartition("L")  # -> ('heL', 'L', 'o1')

str.count("o1", 0, len(str))  # -> 1
str.translate(str.maketrans("heLo", "merl"))  # -> 'merrl1'
str.replace("L", "l")  # -> 'hello1'
str.startswith(("h", "1"), 0, len(str))  # -> True
str.endswith(("h", "1"), 0, len(str))  # -> True
str.encode(encoding="utf-8", errors="strict")  # -> b'heLLo1'
str.expandtabs(tabsize=8)  # -> replace TAB with whitespace
str.format(*args, **kwargs)  # -> format string
str.format_map(mapping)  # -> format string

# String library
string.ascii_letters  # -> ascii_lowercase + ascii_uppercase
string.ascii_lowercase  # -> abcdefghijklmnopqrstuvwxyz
string.ascii_uppercase  # -> ABCDEFGHIJKLMNOPQRSTUVWXYZ
string.digits  # -> 0123456789
string.hexdigits  # -> 0123456789abcdefABCDEF
string.octdigits  # -> 01234567
string.punctuation  # -> !"#$%&'()*+,-./:;<=>?@[\]^_`{|}~
string.printable  # -> digits + ascii_letters + punctuation + whitespace
string.whitespace  # -> space, tab, linefeed, return, formfeed, vertical tab

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
point = namedtuple("Point", ["x", "y"])
p = Point(11, y=22)
p[0] + p[1]  # -> 33
p.x + p.y  # -> 33
p  # -> point(x=11, y=22)

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
