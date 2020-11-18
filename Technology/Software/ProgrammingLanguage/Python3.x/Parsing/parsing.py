import re

# Regular expressions

str = "purple alice-b@google.com monkey dishwasher"
match = re.search(r"([\w.-]+)@([\w.-]+)", str)
if match:
    print match.group()  ## 'alice-b@google.com' (the whole match)
    print match.group(1)  ## 'alice-b' (the username, group 1)
    print match.group(2)  ## 'google.com' (the host, group 2)
