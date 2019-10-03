import sys
from functools import reduce


input_file = "input.txt"
left_right_delimiter = "$$$\n"
output_file = "output.txt"
additional_spacing = 4


def main(args):
    align_vertically()


def align_vertically():
    lines_left, lines_right = read_input()

    lines_left = rstrip_list(lines_left)
    lines_right = rstrip_list(lines_right)

    lines_left, lines_right = equalize_length((lines_left, lines_right))

    max_left_len = max_length(lines_left)

    lines_left = pad_list(lines_left, max_left_len)

    lines_both = merge_lists((lines_left, lines_right))

    write_output(lines_both)


def read_input():
    with open(input_file, "r") as file:
        lines_left = []
        for line in file:
            if line == left_right_delimiter:
                break
            lines_left.append(line)

        lines_right = []
        for line in file:
            lines_right.append(line)

    return (lines_left, lines_right)


def rstrip_list(string_list):
    return list(map(lambda x: x.rstrip("\n"), string_list))


def equalize_length(lines_left_right):
    lines_left, lines_right = lines_left_right

    lines_diff_len = len(lines_right) - len(lines_left)
    if (lines_diff_len > 0):
        for n in range(lines_diff_len):
            lines_left.append("")
    else:
        for n in range(abs(lines_diff_len)):
            lines_right.append("")

    return (lines_left, lines_right)


def max_length(lines):
    lines_len = list(map(lambda x: len(x), lines))
    max_len = reduce(lambda x, y: max(x, y), lines_len)
    return max_len + additional_spacing * 2


def pad_list(lines, padding):
    return list(map(lambda x: x + " " * (padding - len(x)), lines))


def merge_lists(lines):
    lines_left, lines_right = lines
    return list(map(lambda x_y: x_y[0] + x_y[1], zip(lines_left, lines_right)))


def write_output(lines):
    with open(output_file, "w") as file:
        for line in lines:
            file.write(line)
            file.write("\n")


def run():
    sys.exit(main(sys.argv[1:]))


if __name__ == "__main__":
    run()
