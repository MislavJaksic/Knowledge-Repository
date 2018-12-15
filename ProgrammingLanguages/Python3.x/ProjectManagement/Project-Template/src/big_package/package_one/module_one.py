from big_package.package_two import module_two

def Add(x, y):
  return module_two.AddTwoNumbers(x, y)
  
def Multiply(x, y):
  return module_two.MultiplyTwoNumbers(x, y)
  
  
  
def RaiseException():
  raise SystemExit(1)