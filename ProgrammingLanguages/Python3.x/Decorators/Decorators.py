# Decorator is a function that changes another function
# Decoration example: memoization; cache an expensive calculation


def generate_odd_div_three(n):
    return [x for x in range(3, n+1, 6)]


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


generate_odd_div_three = memoization(generate_odd_div_three)  # -> can only be invoked through a Decorator

generate_odd_div_three(100000)  # -> slow
generate_odd_div_three(100000)  # -> fast, becasue of memoization
