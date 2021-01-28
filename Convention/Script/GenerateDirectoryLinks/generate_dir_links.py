import os
import sys

import settings


def depth_first_dir_walk(dirs, file):
    for dir in dirs:
        child_dirs = get_child_dirs(dir)
        if child_dirs:
            absolute_child_dirs = get_absolute_dirs(dir, child_dirs)
            for absolute_child_dir in absolute_child_dirs:
                relative_child_dir = "/".join(
                    absolute_child_dir.split("/")[settings.init_dir_offset :]
                )
                dir_name = relative_child_dir.split("/")[-1]

                write_absolute_dir_to_file(absolute_child_dir, file)

                if dir_name not in settings.terminal_dir:
                    depth_first_dir_walk([absolute_child_dir], file)


def get_child_dirs(dir):
    child_dirs = next(os.walk(dir))[1]
    child_dirs = list(filter(lambda x: x[0] != ".", child_dirs))
    child_dirs = list(filter(lambda x: not x[0].islower(), child_dirs))
    return child_dirs


def get_absolute_dirs(parent_dir, child_dirs):
    absolute_dirs = [parent_dir + "/" + x for x in child_dirs]
    return absolute_dirs


def write_absolute_dir_to_file(dir_name, file):
    relative_child_dir = "/".join(dir_name.split("/")[settings.init_dir_offset :])

    dir_name = relative_child_dir.split("/")[-1]

    offset = len(relative_child_dir.split("/"))
    whitespace_offset = "    " * (offset - 1)

    if (dir_name in settings.terminal_dir) or (dir_name in settings.semiterminal_dir):
        if dir_name in settings.external_repo:
            link = "[{}]({})".format(dir_name, settings.external_repo.get(dir_name))
        else:
            link = "[{}]({})".format(dir_name, relative_child_dir)
        file.write(whitespace_offset + "* " + link)
    else:
        file.write(whitespace_offset + "* " + dir_name)
    file.write("\n")


def main(args):
    with open(settings.output_file, "w") as file:
        depth_first_dir_walk([settings.init_dir], file)


def run():
    sys.exit(main(sys.argv[1:]))


if __name__ == "__main__":
    run()
