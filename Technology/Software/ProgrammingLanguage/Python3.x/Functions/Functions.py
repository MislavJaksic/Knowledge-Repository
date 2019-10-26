from functools import reduce


def main():
    outside_array = [0, 1, 2]

    change_pointer(outside_array)
    print(outside_array)  # -> [0, 1, 2]; no change

    change_array(outside_array)
    print(outside_array)  # -> [0, 1, 2, 3]; array passed by reference

    outside_string = "abdcba"
    print(check_palindrome(outside_string))  # -> "No"
    print(check_palindrome(string="nonnon"))  # -> "Yes"

    store_function = check_palindrome  # functions are values
    print(store_function("abba", 1, "Other", "arguments"))  # -> "Yes"

    functional_programming()


def change_pointer(inputArray):
    inputArray = [0, 1, 2, 3]


def change_array(inputArray):
    inputArray.append(3)


def check_palindrome(string, check_position=0, *many_args):
    """Default arguments are evaluated only once -> check_position.
       If it was a list, it would accumulate data in subsequent calls.
       Variable number of arguments are stored in *many_args.
    """
    if many_args is not ():
        print(many_args)  # -> ("Other", "arguments")
    string_length = len(string)
    if string_length % 2 == 1:
        return "No"
    if string_length/2 < check_position:
        return "Yes"
    if string[check_position] == string[string_length - check_position - 1]:
        return check_palindrome(string, check_position + 1)
    else:
        return "No"


def functional_programming():
    numbers = range(1, 3)

    list(map(lambda x: x**2, numbers))  # -> [1, 4, 9]

    list(filter(lambda x: x < 2, numbers))  # -> [1]

    reduce((lambda x, y: x * y), numbers)  # -> 1*2*3=6

    # List comprehension
    [x**2 for x in range(0, 29) if x % 2 == 0 if x % 3 == 0]  # -> [0, 36, 144, 324, 576]


# Tell the program where to begin
# Must be at the bottom of the program
if __name__ == '__main__':
    main()
