class Bee(object):
    def __init__(self, role):
        self.role = role

    def get_role(self):
        return self.role


class ManagerClass(object):
    def __init__(self, bee_role):
        self.bee_role = bee_role

    def __enter__(self):
        print("Enter")
        self.bee = Bee(self.bee_role)
        return self.bee

    def __exit__(self, exc_type, exc_value, traceback):
        print("Exit")


with ManagerClass("Queen") as queen_bee:
    print("Queen created")
    print(queen_bee.get_role())  # -> "Enter", "Queen created", "Queen", "Exit"

with ManagerClass("Worker") as workerBee:
    print("Worker created")
    print(workerBee.get_role())  # -> "Enter", "Worker created", "Worker", "Exit"
    raise Exception("Exception raised after exitting")  # raises an exception
    print("Will never be printed")
