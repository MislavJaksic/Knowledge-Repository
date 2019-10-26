class Mom(object):
    class_field = "MOM CLASS VALUE"

    def __init__(self, mom_param, *args):
        print("MOM INIT")
        super(Mom, self).__init__(*args)
        self.instance_field = mom_param

    def mom_function(self):
        print("MOM FUNCTION")

    def parent_function(self):
        print("MOM SHARED FUNCTION")


class Dad(object):
    class_field = "DAD CLASS VALUE"

    def __init__(self, dad_param, *args):
        print("DAD INIT")
        super(Dad, self).__init__(*args)
        self.instance_field = dad_param

    def dad_function(self):
        print("DAD FUNCTION")

    def parent_function(self):
        print("DAD SHARED FUNCTION")


class Child(Mom, Dad):  # multiple inheritance
    class_field = "CHILD CLASS VALUE"

    def __init__(self, child_param, mom_param, dad_param):
        print("CHILD INIT")
        super(Child, self).__init__(mom_param, dad_param)
        self.instance_field = child_param

    def child_function(self):
        print("CHILD FUNCTION")

    def _private_function(self):
        pass


print(Mom.class_field)  # -> "MOM CLASS VALUE"
print(Dad.class_field)  # -> "DAD CLASS VALUE"
print(Child.class_field)  # -> "CHILD CLASS VALUE"

mom_object = Mom("Alice")
dad_object = Dad("Bob")
child_object = Child("Charlie", "Alice", "Bob")  # -> CHILD INIT, MOM INIT, DAD INIT

# Multiple inheritence -> function search
# Depth search for a class with a function, from left to right
child_object.parent_function()  # -> MOM SHARED FUNCTION

stored_function = mom_object.mom_function
stored_function()  # -> MOM FUNCTION

mom_object.extra_object_field = "EXTRA"
print(mom_object.extra_object_field)
del mom_object.extra_object_field


# Data model and "magic methods"
# Python supports operator overloading; operators are +, /, ==, >, ...
# __init__ -> initialize
# __str__ -> readable string
# __repr__ -> unambiguous string
# __getitem__ -> access by index
# __setitem__ -> set by index
