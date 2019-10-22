import sys
from pathlib import Path  # for working with paths


for command_line_arg in sys.argv:
    # sys.argv[0] is always the script name
    print(command_line_arg, end=' ')  # prints "$: InputOutputAndFiles.py <first_command_line_arg> <second_...>"

print(input("Type something in:"))  # -> what the user inputs

file = open("file_name.txt", "rU")  # "r", "w", "a" options
print(file.read(1))  # -> 'A'; the first char in the file
file.close()
# OR
with open("file_name.txt", "rU") as file:
    print(file.read(1))  # -> A

file = open("file_name.txt", "w")  # destroy an existing file and create a new empty file
file.write("ABCD")
file.close()


user = "Jane"
action = "buy"
print("user={}, action={}".format(user, action))  # -> user=Jane, action=buy
# OR
f"user={user}, action={action}"  # -> user=Jane, action=buy
