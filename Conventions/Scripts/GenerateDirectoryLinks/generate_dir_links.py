import os
import sys


output_file = "Contents.md"
init_dir = "E:/GreatRepository/Publishing/GitHubRepositories/Knowledge-Repository"
init_dir_offset = 5
external_repo = {
    "Jekyll": "https://github.com/MislavJaksic/Jekyll-Tutorial",
    "ApacheKafka": "https://github.com/MislavJaksic/Kafka-In-Theory-And-Practice",
    "ABAP": "https://github.com/MislavJaksic/SAP-ABAP-Development/tree/master/ABAP",
    "Gradle": "https://github.com/MislavJaksic/Gradle-Tutorial",
    "GraphQL": "https://github.com/MislavJaksic/GraphQL-Tutorial",
    "Flask": "https://github.com/MislavJaksic/Flask-Tutorial",
    "Latex": "https://github.com/MislavJaksic/Latex-Overleaf",
    "DesignPatterns": "https://github.com/MislavJaksic/Design-Patterns",
    "Spring": "https://github.com/MislavJaksic/Spring-Guides-Tutorials",
    "SAP": "https://github.com/MislavJaksic/SAP-ABAP-Development",
    "CollageLabs": "https://github.com/MislavJaksic/College-Labs",
    "Practise": "https://github.com/MislavJaksic/Practise",
    "Maven": "https://github.com/MislavJaksic/Maven-Tutorial",
    "Selenium": "https://github.com/MislavJaksic/Selenium-Tutorial",
}
semiterminal_dir = ["Argo", "Linux", "Java"]
terminal_dir = [
    "Jekyll",
    "Selenium",
    "RubyOnRails",
    "Flask",
    "DomeneHR",
    "Ghost",
    "RESTFulWebServices",
    "GraphQL",
    "Postman",
    "Grafana",
    "OpenShot",
    "OBS",
    "Practise",
    "Asciinema",
    "Scoop",
    "Chocolatey",
    "Latex",
    "HomeNetworking",
    "CollageLabs",
    "ApacheSpark",
    "ApacheKafka",
    "Python3.x",
    "Lisp",
    "JavaScript",
    "Spring",
    "Haskell",
    "Elm",
    "C++",
    "ABAP",
    "MicroserviceGuide",
    "DesignPatterns",
    "ComputerVision",
    "CodeComplete",
    "CleanCode",
    "Maven",
    "Gradle",
    "Bazel",
    "Ubuntu",
    "ShellScripting",
    "MSYS2",
    "Cygwin",
    "IntelliJIDEA",
    "Eclipse",
    "CodeBlocks",
    "SAP",
    "Atom",
    "VMWare",
    "VirtualBox",
    "OpenStack",
    "GitLab",
    "GitHub",
    "Git",
    "Jaeger",
    "Nginx",
    "OracleCloud",
    "DigitalOcean",
    "SSH",
    "Putty",
    "OpenVPN",
    "Prometheus",
    "Portainer",
    "OperatorFramework",
    "Linkerd",
    "Kubernetes",
    "Helm",
    "Harbor",
    "Docker",
    "Concourse",
    "Brigade",
    "Ambassador",
    "Jenkins",
    "ArgoCD",
    "SQLite",
    "Redis",
    "PostgreSQL",
    "MongoDB",
    "Graphite",
    "ApacheHive",
    "ApacheHadoop",
    "Elastic",
    "ApacheDruid",
    "LeadershipTheoryAndPractice",
    "Kanban",
    "AgileManifesto",
    "Conventions",
]


def main(args):
    with open(output_file, "w") as file:
        depth_first_dir_walk([init_dir], file)


def depth_first_dir_walk(dirs, file):
    for dir in dirs:
        child_dirs = get_child_dirs(dir)
        if child_dirs:
            absolute_child_dirs = get_absolute_dirs(dir, child_dirs)
            for absolute_child_dir in absolute_child_dirs:
                relative_child_dir = "/".join(
                    absolute_child_dir.split("/")[init_dir_offset:]
                )
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
        if dir_name in external_repo:
            link = "[" + dir_name + "]" + "(" + external_repo.get(dir_name) + ")"
        else:
            link = "[" + dir_name + "]" + "(" + relative_child_dir + ")"
        file.write(whitespace_offset + "* " + link)
    else:
        file.write(whitespace_offset + "* " + dir_name)
    file.write("\n")


def run():
    sys.exit(main(sys.argv[1:]))


if __name__ == "__main__":
    run()
