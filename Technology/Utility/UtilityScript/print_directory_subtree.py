import os


def print_directory_subtree(file, path, spacing):
    dirs_files = os.listdir(path)
    dirs, files = split_dirs_files(dirs_files)
    for filename in files:
        file.write(spacing + filename + "\n")
    for dir in dirs:
        file.write(spacing + dir + "\n")
        print_directory_subtree(file, path + "/" + dir, spacing + "  ")


def split_dirs_files(dirs_files):
    dirs = [x for x in dirs_files if x.find(".") == -1]
    files = [x for x in dirs_files if x.find(".") != -1]
    return (dirs, files)


path = "your-path"
spacing = ""

file = open("pretty_print.txt", "w")
print_directory_subtree(file, path, spacing)
file.close()
