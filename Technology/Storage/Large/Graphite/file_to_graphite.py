import sys
import time
import json
import graphyte


def main(args):
    graphyte.init("localhost", prefix="test")

    with open("/tmp/docker-kafka/kafka-metrics.json") as file:
        while True:
            line = file.readline()
            if line not in ("", "\n", "\r"):
                try:
                    dict = json.loads(line)
                    extract_data(dict)
                except(Exception):
                    pass
            else:
                time.sleep(1)
                print("no more metrics")


def extract_data(dict):
    id = dict["identifier"]
    ts = dict["timestamp"]
    name = dict["name"]
    values = dict["values"]

    send_metric(id, ts, name, values)


def send_metric(id, ts, name, values):
    short_name = ""
    value = ""

    if "ActiveControllerCount" in name:
        short_name = "ActiveControllerCount"
        value = values["Value"]
    elif "IsrExpandsPerSec" in name:
        short_name = "IsrExpandsPerSec"
        value = values["Count"]
    elif "IsrShrinksPerSec" in name:
        short_name = "IsrShrinksPerSec"
        value = values["Count"]
    elif "OfflinePartitionsCount" in name:
        short_name = "OfflinePartitionsCount"
        value = values["Value"]
    elif "UncleanLeaderElectionsPerSec" in name:
        short_name = "UncleanLeaderElectionsPerSec"
        value = values["Count"]
    elif "UnderReplicatedPartitions" in name:
        short_name = "UnderReplicatedPartitions"
        value = values["Value"]

    if value != "":
        path = id + "." + short_name
        graphyte.send(path, int(value), timestamp=ts)


def run():
    sys.exit(main(sys.argv[1:]))


if __name__ == "__main__":
    run()
