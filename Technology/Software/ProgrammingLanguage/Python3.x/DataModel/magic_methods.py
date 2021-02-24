class LazyClass:
    def __getattr__(
        self, attribute
    ):  # called when there is no such attribute set; for lazy instantiation
        if attribute == "be_lazy":
            value = self.expensive_operation()
            setattr(self, attribute, value)  # sets the attribute
            print("Set " + str(attribute) + " to " + str(value))
            return value
        else:
            raise AttributeError

    def expensive_operation(self):
        return "Expensive Operation"


lazy_class = LazyClass()
print(lazy_class.be_lazy)  # Set be_lazy to Expensive Operation, Expensive Operation
print(lazy_class.be_lazy)  # Expensive Operation
