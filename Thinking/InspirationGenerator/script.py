import re


# str = 'an example word:cat!!'
# match = re.search(r'word:\w\w\w', str)
# # If-statement after search() tests if it succeeded
# if match:
#   print('found', match.group()) ## 'found word:cat'
# else:
#   print('did not find')

def ironsworn_to_number_text():
    with open("output_file.txt", "w") as output_file:
        with open("input_file.txt", "r", encoding="utf8") as input_file:
            for line in input_file:
                match = re.search(r'([\d]+)-([\d]+) (.*)\n', line)
                if match:
                    print(match.group())  ## 'alice-b@google.com' (the whole match)
                    print(match.group(1))  ## 'alice-b' (the username, group 1)
                    print(match.group(2))  ## 'google.com' (the host, group 2)
                    print(match.group(3))
                    if int(match.group(2)) == 0:
                        second = 100
                    else:
                        second = int(match.group(2))

                    for x in range(int(match.group(1)), second + 1):
                        output_file.write("{} {}\n".format(x, match.group(3)))
                else:
                    output_file.write(line)


def number_text_to_dict():
    with open("seperated", "w") as output_file:
        with open("output_file.txt", "r") as input_file:
            for line in input_file:
                match = re.search(r'([\d]+) (.*)\n', line)
                if match:
                    print(match.group())  ## 'alice-b@google.com' (the whole match)
                    print(match.group(1))  ## 'alice-b' (the username, group 1)
                    print(match.group(2))  ## 'google.com' (the host, group 2)
                    output_file.write("{}:'{}',\n".format(match.group(1), match.group(2)))
                else:
                    output_file.write(line)
            # match = re.search(r'([\d]+)-([\d]+) (.*)\n', line)
            # if match:
            #     print(match.group())   ## 'alice-b@google.com' (the whole match)
            #     print(match.group(1))  ## 'alice-b' (the username, group 1)
            #     print(match.group(2))  ## 'google.com' (the host, group 2)
            #     print(match.group(3))
            #     if int(match.group(2)) == 0:
            #     	second = 100
            #     else:
            #     	second = int(match.group(2))

            #     for x in range(int(match.group(1)), second + 1):
            #     	output_file.write("{} {}\n".format(x, match.group(3)))
            # else:
            # 	output_file.write(line)


ironsworn_to_number_text()
number_text_to_dict()

