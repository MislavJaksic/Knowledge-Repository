class Bee(object):
  
  def __init__(self, role):
    self.role = role
  
  def GetRole(self):
    return self.role

class ManagerClass(object):
  
  def __init__(self, beeRole):
    self.beeRole = beeRole
  
  def __enter__(self):
    print "Opened"
    self.aBee = Bee(self.beeRole)
    return self.aBee
  
  def __exit__(self, exc_type, exc_value, traceback):
    print "Closed"
	
with ManagerClass("Queen") as queenBee:
  print "Created an object"
  print queenBee.GetRole()
  
#The following with be outputted:
#Opened
#Created an object
#Queen
#Closed
#Exception: I'm causing trouble

print
with ManagerClass("Worker") as workerBee:
  print "Created an object"
  print workerBee.GetRole()
  raise Exception("I'm causing trouble")
  
#The following with be outputted:
#Opened
#Created an object
#Worker
#Closed
#Exception: I'm causing trouble