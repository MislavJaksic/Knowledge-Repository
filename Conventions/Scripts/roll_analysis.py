import sys
from random import randint


class Roll2d6(object):
    def __init__(self, modifier, smart_threshold, reroll_penalty):
        self.modifier = modifier
        self.smart_threshold = smart_threshold
        self.reroll_penalty = reroll_penalty

        self.dies = [self.roll_1d6(), self.roll_1d6()]

    def __repr__(self):
        return str(self.__str__())

    def __str__(self):
        return str(self.result())

    def smart_reroll_all(self):
        if sum(self.dies) < self.smart_threshold:
            self.reroll_all()

    def reroll_all(self):
        self.dies = [self.roll_1d6() + self.reroll_penalty, self.roll_1d6()]

    def smart_reroll_smallest(self):
        if sum(self.dies) < self.smart_threshold:
            self.reroll_smallest()

    def reroll_smallest(self):
        if self.dies[0] > self.dies[1]:
            self.dies[1] = self.roll_1d6() + self.reroll_penalty
        else:
            self.dies[0] = self.roll_1d6() + self.reroll_penalty

    def result(self):
        return sum(self.dies) + self.modifier

    def roll_1d6(self):
        return randint(1, 6)


class Rolls2d6(object):
    def __init__(self, sample_size, modifier, smart_threshold, reroll_penalty):
        self.sample_size = sample_size
        self.modifier = modifier
        self.smart_threshold = smart_threshold
        self.reroll_penalty = reroll_penalty

        self.rolls = [Roll2d6(self.modifier, self.smart_threshold, self.reroll_penalty) for _ in range(self.sample_size)]

    def __repr__(self):
        bucket10, bucket79, bucket6 = self.get_buckets()
        output = ""

        output += "mod=" + str(self.modifier) + " " + "count \n"
        output += "10+   " + str(len(bucket10)) + " \n"
        output += "7-9   " + str(len(bucket79)) + " \n"
        output += "6-    " + str(len(bucket6)) + " \n"
        output += "total " + str(self.sample_size) + " \n"

        output += "mod=" + str(self.modifier) + " " + "percentage \n"
        output += "10+   " + str(len(bucket10) / self.sample_size) + " \n"
        output += "7-9   " + str(len(bucket79) / self.sample_size) + " \n"
        output += "6-    " + str(len(bucket6) / self.sample_size) + " \n"
        output += "total " + str(self.sample_size / self.sample_size) + " \n"

        return output

    def __str__(self):
        return self.__repr__()

    def get_buckets(self):
        bucket10 = list(filter(lambda x: x.result() >= 10, self.rolls))
        bucket79 = list(filter(lambda x: x.result() >= 7 and x.result() <= 9, self.rolls))
        bucket6 = list(filter(lambda x: x.result() <= 6, self.rolls))

        return (bucket10, bucket79, bucket6)

    def smart_reroll_all(self):
        for roll in self.rolls:
            roll.smart_reroll_all()

    def reroll_all(self):
        for roll in self.rolls:
            roll.reroll_all()

    def smart_reroll_smallest(self):
        for roll in self.rolls:
            roll.smart_reroll_smallest()

    def reroll_smallest(self):
        for roll in self.rolls:
            roll.reroll_smallest()


def main(args):
    sample_size = 100000
    smart_threshold = 7
    modifier = 0
    reroll_penalty = -1

    # rolls = Rolls2d6(sample_size, modifier, smart_threshold)
    # print(rolls)
    #
    # rolls = Rolls2d6(sample_size, modifier, smart_threshold)
    # rolls.reroll()
    # print(rolls)

    rolls = Rolls2d6(sample_size, modifier, smart_threshold, reroll_penalty)
    rolls.smart_reroll_all()
    print(rolls)


def run():
    sys.exit(main(sys.argv[1:]))


if __name__ == '__main__':
    run()
