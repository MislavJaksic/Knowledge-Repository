"""Problem: write a function that generates numbers between zero and n and checks if they are odd and divisible by three"""

def Generate(n):
  i = 3
  list = []
  while(i <= n):
    list.append(i)
    i = i + 6
  return list

"""Problem: write a decorator that caches the result
   Discussion: the inner function is executed multiple times, while everything outside it is executed only once"""
def Memoization(cachedFunction):
  dict = {}
  def Caching(n):
    key = dict.get(n)
    if(key):
      print("Return the cache")
      return key
    else:
      dict[n] = cachedFunction(n)
      print("Invoke the function")
      return dict[n]
  return Caching

Generate = Memoization(Generate)
#From now on Generate can only be invoked through the decorator
for n in range(3):
  list = Generate(100)

  for i in list:
    print(i)

