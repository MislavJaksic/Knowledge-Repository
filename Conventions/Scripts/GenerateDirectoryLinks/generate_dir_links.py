import os
import sys


output_file = "Contents.md"
init_dir = "E:/GreatRepository/Publishing/GitHubRepositories/Knowledge-Repository"
init_dir_offset = 5
semiterminal_dir = ["Linux"]
terminal_dir = ["Jekyll", "RubyOnRails", "RESTFulWebServices", "Postman", "Grafana", "OpenShot", "OBS", "Scoop", "Chocolatey", "HomeNetworking", "ApacheSpark", "Python3.x", "Lisp", "JavaScript", "Java", "Haskell", "Elm", "C++", "ABAP", "MicroserviceGuide", "ComputerVision", "CodeComplete", "CleanCode", "Maven", "Bazel", "Ubuntu", "ShellScripting", "MSYS2", "Cygwin", "IntelliJIDEA", "Eclipse", "CodeBlocks", "Atom", "VMWare", "VirtualBox", "OpenStack", "GitLab", "GitHub", "Git", "Nginx", "SSH", "Putty", "OpenVPN", "Prometheus", "Portainer", "Kubernetes", "Helm", "Docker", "Ambassador", "Jenkins", "SQLite", "Redis", "PostgreSQL", "MongoDB", "Graphite", "ApacheHive", "ApacheHadoop", "ApacheDruid", "LeadershipTheoryAndPractice", "Kanban", "AgileManifesto", "Conventions"]


def main(args):
    with open(output_file, "w") as file:
        depth_first_dir_walk([init_dir], file)


def depth_first_dir_walk(dirs, file):
    for dir in dirs:
        child_dirs = get_child_dirs(dir)
        if child_dirs:
            absolute_child_dirs = get_absolute_dirs(dir, child_dirs)
            for absolute_child_dir in absolute_child_dirs:
                relative_child_dir = "/".join(absolute_child_dir.split("/")[init_dir_offset:])
                dir_name = relative_child_dir.split("/")[-1]

                write_absolute_dir_to_file(absolute_child_dir, file)

                if dir_name not in terminal_dir:
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
    relative_child_dir = "/".join(dir_name.split("/")[init_dir_offset:])

    dir_name = relative_child_dir.split("/")[-1]

    offset = len(relative_child_dir.split("/"))
    whitespace_offset = "    " * (offset - 1)

    if (dir_name in terminal_dir) or (dir_name in semiterminal_dir):
        link = "[" + dir_name + "]" + "(" + relative_child_dir + ")"
        file.write(whitespace_offset + "* " + link)
    else:
        file.write(whitespace_offset + "* " + dir_name)
    file.write("\n")


def run():
    sys.exit(main(sys.argv[1:]))


if __name__ == "__main__":
    run()
