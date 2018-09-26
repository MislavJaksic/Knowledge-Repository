#A Decorator is a function that changes another function
#Memoization example: cache an expensive calculation and return it
#rather then calculating it on every invocation

def GenerateOddAndDivByThree(n):
  return [x for x in range(3, n+1, 6)]

def Memoization(cachedFunction):
  cache = {}
  
  def Caching(n):
    value = cache.get(n)
    if value:
      print "Cache found!"
      return value
    else:
      cache[n] = cachedFunction(n)
      return cache[n]
      
  return Caching

GenerateOddAndDivByThree = Memoization(GenerateOddAndDivByThree) #-> can only be invoked through a Decorator

GenerateOddAndDivByThree(100000)
GenerateOddAndDivByThree(100000)
