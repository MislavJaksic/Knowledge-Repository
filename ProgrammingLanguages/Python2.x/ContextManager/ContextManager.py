#A solution to temporal coupling: Context Manager
#When functions have to be invoked in an order

class Bee(object):
  
  def __init__(self, role):
    self.role = role
  
  def GetRole(self):
    return self.role

class ManagerClass(object):
  
  def __init__(self, beeRole):
    self.beeRole = beeRole
  
  def __enter__(self):
    print "Enter"
    self.aBee = Bee(self.beeRole)
    return self.aBee
  
  def __exit__(self, exc_type, exc_value, traceback):
    print "Exit"
	
with ManagerClass("Queen") as queenBee:
  print "Object created"
  print queenBee.GetRole()
  
#Output:
#Enter
#Object created
#Queen
#Exit

print
with ManagerClass("Worker") as workerBee:
  print "Object created"
  print workerBee.GetRole()
  raise Exception("Exception raised after exitting")
  print "Will never be printed"
  
#Output:
#Enter
#Object created
#Worker
#Exit
#Exception raised after exitting