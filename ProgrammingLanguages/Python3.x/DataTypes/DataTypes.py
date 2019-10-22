# Data types exist in Pyhon, but don't have to be declared
int(5)
int(5)
float(5)
complex(5, 5)

6/5  # -> 1.2
6.0 / 5  # -> 1.2
1.0/3 - 0.33333333  # -> small number, not zero
2 ** 10  # -> 1024
15 // 4  # -> 3
15 % 2  # -> 1

False or True  # -> True
False and True  # -> False
not False  # -> True
None  # -> None

# String are immutable
string = "String"
string + "1"  # -> "String1"
len(string)  # -> 6
string.lower()  # -> "string"
string.upper()  # -> "STRING"
string.strip()  # -> "String"
string.find("ri")  # -> 2
string.replace("g", "")  # -> "Strin"
string.split("ri")  # -> ["St", "ng"]
string.join(["S", "t", r""])  # -> "Str"
string.isalpha()  # -> False
string.isdigit()  # -> False
string.isspace()  # -> False
string.startswith("St")  # -> True
string.endswith("ng")  # -> True

# String is an array of characters
string[1]  # -> "t"
#  Slicing arrays
#  +---+---+---+---+---+---+
#  | S | t | r | i | n | g |
#  +---+---+---+---+---+---+
#  0   1   2   3   4   5   6
# -6  -5  -4  -3  -2  -1
# The numbers are between the letters
string[2:4]  # -> "ri"
string[-2:]  # -> "ng"

user = "Jane"
action = "buy"
f'user={user}, action={action}'  # -> user=Jane, action=buy


d = 55
d = str(d)  # -> "55"
d = int(d)  # -> 55
d = float(d)  # -> 55.0
