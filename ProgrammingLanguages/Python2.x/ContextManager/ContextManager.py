class SequenceClass(object):
  def __init__(self):
    self.value = 10
  
  def __enter__(self):
    print "Opened"
  
  def __exit__(self, exc_type, exc_value, traceback):
    print "Closed"
	
with SequenceClass() as anObject:
  print "Created an object"
  raise Exception("I'm causing trouble")
  
#The following with be outputted:
#Opened
#Created an object
#Closed
#Exception: I'm causing trouble