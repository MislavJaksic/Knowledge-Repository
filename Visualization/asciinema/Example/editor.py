import sys
import json


class AsciinemaText(object):
    def __init__(self, header, time, text):
        self.header = header
        self.time = time
        self.text = text

        self.metadata = "o"

    def extend(self, lines):
        self.text.extend(lines)

    def insert(self, index, lines):
        """Before insert:
           0 1 2 3
           |a|b|c|
           After insert at 2:
           0 1 2 3 4
           |a|b|A|c|
        """
        for n in range(len(lines)):
            self.text.insert(n + index, lines[n])

    def print_slice(self, start, stop):
        for n in range(start, stop):
            print(str(n) + "  " + self.text[n])

    def __repr__(self):
        for n in range(len(self.text)):
            print(str(n) + "  " + self.text[n])

    def write_to_file(self, filename):
        with open(filename, "w") as file:
            file.write(json.dumps(self.header))
            file.write("\n")

        self.append_to_file(filename)

    def append_to_file(self, filename):
        asciinema_lines = list(map(lambda x: json.dumps([self.time, self.metadata[0], x]), self.text))

        with open(filename, "a") as file:
            for line in asciinema_lines:
                file.write(line)
                file.write("\n")


def main(args):
    header, asciinema_lines = read_asciinema("demo-edit.cast")

    header["height"] = 24
    header["width"] = 120
    header["idle_time_limit"] = 10.0

    times = [0.1, 7.5]
    for n in range(4):
        times.append(times[1] + 5.0 * n)

    text = list(map(lambda x: x[2], asciinema_lines))
    logo_text = read_text("logo_full.txt")
    texts = [logo_text, text[0:9], text[9:18], text[18:27], text[27:36]]

    asciinema_texts = []
    for text, time in zip(texts, times):
        asciinema_texts.append(AsciinemaText(header, time, text))

    intro = []
    intro.append("\r\n")
    intro.append("=== STARTING CHAOS TEST: UNCLEAN LEADER ELECTION ===\r\n")
    intro.append("\r\n")
    asciinema_texts[0].extend(intro)

    before_zookeeper = create_before_zookeeper()
    for text in asciinema_texts[1:]:
        text.insert(5, before_zookeeper)

    attention_string_create = ["||||                                                   |||||||    |||||||||",
                               "VVVV                                                   VVVVVVV    VVVVVVVVV"]
    before_blockade = create_before_blockade(attention_string_create, "PHASE 1: CREATE A KAFKA CLUSTER")
    asciinema_texts[1].insert(0, before_blockade)

    attention_string_slow = ["                                                       |||||||",
                             "                                                       VVVVVVV"]
    before_blockade = create_before_blockade(attention_string_slow, "PHASE 2: TURN ON NETWORK BLOCKADE")
    asciinema_texts[2].insert(0, before_blockade)

    attention_string_partition = ["                                                                  |||||||||",
                                  "                                                                  VVVVVVVVV"]
    before_blockade = create_before_blockade(attention_string_partition, "PHASE 3: ISOLATE KAFKA BROKER")
    asciinema_texts[3].insert(0, before_blockade)

    attention_string_normal = ["                                                       |||||||    |||||||||",
                               "                                                       VVVVVVV    VVVVVVVVV"]
    before_blockade = create_before_blockade(attention_string_normal, "PHASE 4: RESTORE NETWORK")
    asciinema_texts[4].insert(0, before_blockade)

    print(len(asciinema_texts[2].text))

    outro = []
    outro.append("\r\n")
    asciinema_texts.append(AsciinemaText(header, times[5], outro))

    asciinema_texts[0].write_to_file("output.cast")
    for asciinema_text in asciinema_texts[1:]:
        asciinema_text.append_to_file("output.cast")


def read_asciinema(filename):
    with open(filename, "r") as file:
        header = file.readline()
        display_lines = []
        for line in file:
            display_lines.append(line)

    header = json.loads(header)
    display_lines = list(map(lambda x: json.loads(x), display_lines))

    return (header, display_lines)


def read_text(filename):
    lines = []
    with open(filename, "r") as file:
        for line in file:
            lines.append(line)

    return lines


def create_before_blockade(attention_string, phase_string):
    before_blockade = []
    before_blockade.append("\r\n")
    before_blockade.append("\r\n")
    before_blockade.append("=== " + phase_string + " ===\r\n")
    before_blockade.append("\r\n")
    before_blockade.append("=== === BLOCKADE: INSPECT KAFKA CLUSTER === ===\r\n")
    before_blockade.append(attention_string[0] + "\r\n")
    before_blockade.append(attention_string[1] + "\r\n")

    return before_blockade


def create_before_zookeeper():
    before_zookeeper = []
    before_zookeeper.append("\r\n")
    before_zookeeper.append("\r\n")
    before_zookeeper.append("=== === ZOOKEEPER: INSPECT TOPICS === ===\r\n")
    before_zookeeper.append("                                                |||||||||       ||||||||||||||||||||||||||\r\n")
    before_zookeeper.append("                                                VVVVVVVVV       VVVVVVVVVVVVVVVVVVVVVVVVVV\r\n")

    return before_zookeeper


def run():
    """Entry point for the runnable script (defined in setup.py)
    """
    sys.exit(main(sys.argv[1:]))


if __name__ == '__main__':
    """main calls run().
    """
    run()
