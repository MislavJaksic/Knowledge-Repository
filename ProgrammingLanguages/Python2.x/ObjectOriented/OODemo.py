#Class is a blueprint for creating objects
#All classes inherit some other class
#Python "object" != object
#Python "object" is a generic base Python class
#Object is what is created (instantiated) from a class
class Camera(object): #inherit a Python "object"
  #Class variables are shared by all objects
  manufacturer = "Nokia"

  #Constructor method: called first after creating an object
  def __init__(self, size, memory, quality):
    #Assign a value to an instance variable (data Varribute)
	#Instance variables are unique to each object
    #self.size != size
    #self.size is an instance variable
    #size is a parameter given upon object creation
    self.size = size
    self.memory = memory
    self.quality = quality
	#Composition, camera has a lens
    self.Lens = Lens(720)

  #Method
  #self is a reference to the object that is calling the method
  #All methods must have self as their first parameter
  def PrintData(self):
    print "Printed by Camera"
    print "Class variable is {}.". format(self.manufacturer)
    print "Instance variables are {} {} {}".format(self.size,
    self.memory, self.quality)

  def ImpliedAction(self):
    print "Camera implied"
	
  def OverridenAction(self):
    print "Camera overriden"
	
  def AlteredAction(self):
    print "Camera altered"

#Each Camera has one
#Demonstrates composition
class Lens(object):
  
  def __init__(self, resolution):
    self.resolution = resolution

  def TakePhoto(self):
    print "Photo taken"
	
#Inheritance, it can imply, override or alter an action of the parent
#If a child class doesen't have a method you called, a parent method will be called
class ChildCamera(Camera):
  
  def __init__(self, size, memory, quality):
    #super invokes the parent constructor
    super(ChildCamera, self).__init__(size, memory, quality)
	
  def PrintData(self):
    print "Printed by ChildCamera"
    print "Class variable is {}.". format(self.manufacturer)
    print "Instance variables are {} {} {}".format(self.size,
    self.memory, self.quality)
	
  #ImpliedAction has been inherited from Camera

  def OverridenAction(self):
    print "ChildCamera overriden"
	
  def AlteredAction(self):
    print "ChildCamera before Camera altered"
    super(ChildCamera, self).AlteredAction()
    print "ChildCamera after Camera altered"
	

#Create an object from a class Camera
camOne = Camera(-12, 5, 6)
camTwo = Camera(7, -9, -8)
#Access class variable
print Camera.manufacturer #-> Nokia
#Access instance variable
print camOne.size #-> -12
#Use an object's method
#Methods can be stored just like functions
storeMethod = camOne.PrintData()
storeMethod #-> Camera, Nokia, -12 5 6

#Add an instance variable to an object
camOne.anotherVar = 5
print camOne.anotherVar #-> 5

#Changing a class variable changes it for all objects
Camera.manufacturer = "BLANK" # != camOne.manufacturer = "BLANK" !!!
print camOne.manufacturer #-> BLANK
print camTwo.manufacturer #-> BLANK

#Create a child class
camThree = ChildCamera(555, 87, 1235)
print ChildCamera.manufacturer #-> BLANK
ChildCamera.manufacturer = "RUS"
print ChildCamera.manufacturer #-> RUS
print Camera.manufacturer #-> BLANK