"""Also known as the anonymous function"""
def NamedFunc(n):
  if(n % 2 == 0):
    return True
  else:
    return False

boolean = NamedFunc(1024)
anonymousFunc = (lambda n: (n % 2 == 0))

if(boolean == anonymousFunc(1024)):
  print("They are the same")