import sys
import yaml

input_file = "File-Name.yaml"


def main(args):
    with open(input_file, 'r') as read_stream:
        try:
            documents = yaml.safe_load_all(read_stream)
            transform(documents)
        except yaml.YAMLError as exc:
            print(exc)


def transform(documents):
    counter = 0
    for document in documents:
        file_name = get_name(document, counter)
        counter = counter + 1
        with open(file_name, 'w') as write_stream:
            yaml.dump(document, write_stream)


def get_name(document, counter):
    if counter < 10:
        string_counter = "0" + str(counter)
    else:
        string_counter = str(counter)
    name = string_counter + document["kind"] + "-" + document["metadata"]["name"] + ".yaml"
    return name


def run():
    sys.exit(main(sys.argv[1:]))


if __name__ == '__main__':
    run()
