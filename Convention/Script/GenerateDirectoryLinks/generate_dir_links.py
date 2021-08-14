import os
import sys
from pathlib import Path
from typing import List
from typing.io import TextIO

import settings


def depth_first_dir_walk(directories: List[str], file: TextIO):
    for directory in directories:
        child_dirs = get_child_dirs(Path(directory))
        if child_dirs:
            absolute_child_dirs = get_absolute_dirs(Path(directory), child_dirs)
            for absolute_child_dir in absolute_child_dirs:
                relative_child_dir = "/".join(
                    absolute_child_dir.as_posix().split("/")[settings.init_dir_offset:]
                )
                print(relative_child_dir)
                dir_name = relative_child_dir.split("/")[-1]

                write_absolute_dir_to_file(absolute_child_dir.as_posix(), file)

                if dir_name not in settings.terminal_dir:
                    depth_first_dir_walk([absolute_child_dir.as_posix()], file)


def get_child_dirs(directory: Path) -> List[str]:
    child_dirs = next(os.walk(directory))[1]
    child_dirs = list(filter(lambda x: x[0] != ".", child_dirs))
    #print("Directory: {}, Child directories: {}".format(directory, child_dirs))
    return child_dirs


def get_absolute_dirs(parent_dir: Path, child_dirs: List[str]) -> List[Path]:
    absolute_dirs = [parent_dir / x for x in child_dirs]
    #print("Parent: {}, Children: {}, Abolute children: {}".format(parent_dir, child_dirs, absolute_dirs))
    return absolute_dirs


def write_absolute_dir_to_file(dir_name, file: TextIO):
    relative_child_dir = "/".join(dir_name.split("/")[settings.init_dir_offset :])

    dir_name = relative_child_dir.split("/")[-1]

    offset = len(relative_child_dir.split("/"))
    whitespace_offset = "    " * (offset - 1)

    if (dir_name in settings.terminal_dir) or (dir_name in settings.semiterminal_dir):
        if dir_name in settings.external_repo:
            link = "[{}]({})".format(dir_name, settings.external_repo.get(dir_name))
        else:
            link = "[{}]({})".format(dir_name, relative_child_dir)
        #print("Directory name: {}, Link: {}".format(dir_name, link))
        file.write(whitespace_offset + "* " + link)
    else:
        #print("Directory name: {}, Link: {}".format(dir_name, None))
        file.write(whitespace_offset + "* " + dir_name)
    file.write("\n")


def main(args):
    with open(settings.output_file, "w") as file:
        depth_first_dir_walk([settings.init_dir], file)


def run():
    sys.exit(main(sys.argv[1:]))


if __name__ == "__main__":
    run()
