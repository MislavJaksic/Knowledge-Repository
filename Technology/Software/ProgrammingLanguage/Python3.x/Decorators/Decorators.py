# Decorator is a function that changes another function at definition time
# Decoration example: memoization; cache an expensive calculation
#                   : alter or add functionality
# See https://book.pythontips.com/en/latest/decorators.html#use-cases

from functools import wraps  # Indispensible library for universal decorating


def decorator(outer_f):
    @wraps(outer_f)
    def inner_f(*args, **kwargs):
        print("Decorator value")
        outer_f(*args, **kwargs)

    return inner_f


def argument_decorator(decorator_arugment_value):
    def inner_decorator(outer_f):
        @wraps(outer_f)
        def inner_f(*args, **kwargs):
            print(decorator_arugment_value)
            print("Outer decorator value")
            outer_f(*args, **kwargs)

        return inner_f

    return inner_decorator


class DecorationHolder:
    @argument_decorator("Decorator argument value")
    @decorator
    def decorated_m(self, argument_value):
        print("Method value")
        print(argument_value)


argument_value = "Argument Value"
holder = DecorationHolder()
holder.decorated_m(argument_value)


@argument_decorator("Decorator argument value")
@decorator
def decorated_f(argument_value):
    print("Function value")
    print(argument_value)


decorated_f(argument_value)  # "Inner value"\n"Outer value"
# @ is syntactic sugar for:
#     decorated_f = decorator(decorated)
#     decorated_f(argument_value)

# Memoization
def generate_odd_div_three(n):
    return [x for x in range(3, n + 1, 6)]


def memoization(cached_function):
    cache = {}

    def caching(n):
        value = cache.get(n)
        if value:
            print("Cache found!")
            return value
        else:
            cache[n] = cached_function(n)
            return cache[n]

    return caching


generate_odd_div_three = memoization(
    generate_odd_div_three
)  # -> can only be invoked through a Decorator

generate_odd_div_three(100000)  # -> slow
generate_odd_div_three(100000)  # -> fast, because of memoization
