#Class is a blueprint for creating objects
#All classes inherite from some other class
#Python "object" != object
#Python "object" is a generic base Python class
#Object is what is created from a class
class Satellite(object): #this is a Python "object"
  #Class variables are the same for all objects
  manufacturer = "NASA"
  
  #(Attribute) methods are shared between objects
  #Special method: Called first after creating an instance
  def __init__(self, velocity, startLongitude, startLatitude):
    #Assign a value to an instance variable (data attribute)
	#Instance variables are unique to each object
    #self.velocity != velocity
    #self.velocity is an instance variable
    #velocity is a parameter given upon object creation
    self.velocity = velocity
    self.startLongitude = startLongitude
    self.startLatitude = startLatitude
	#Composition, satellite has a camera
	self.camera = Camera(720)

  #Another (attribute) method
  def PrintData(self):
    print "Printed by Satellite"
    print "Class variable is {}.". format(self.manufacturer)
    print "Instance variables are {} {} {}".format(self.velocity,
    self.startLongitude, self.startLatitude)

  def ImpliedAction(self):
    print "Satellite implied"
	
  def OverridenAction(self):
    print "Satellite overriden"
	
  def Altered(self):
    print "Satellite altered"

#Each satellite has one
#Demonstrates composition
class Camera(object):
  
  def __init__(self, resolution):
    self.resolution = resolution

  def TakePhoto(self):
    print "Photo taken"
	
#Inheritance, it can imply, override or alter an action on the parent
#If a child class doesen't have a method you called, a parent method will be called
class SaturnOne(Satellite):
  
  def __init__(self, velocity, startLongitude, startLatitude):
    super(SaturnOne, self).__init__(velocity, startLongitude, startLatitude)
	
  def PrintData(self):
    print "Printed by SaturnOne"
    print "Class variable is {}.". format(self.manufacturer)
    print "Instance variables are {} {} {}".format(self.velocity,
    self.startLongitude, self.startLatitude)
	
  def OverridenAction(self):
    print "Saturn One overriden"
	
  def Altered(self):
    print "Saturn One before satellite altered"
    super(SaturnOne, self).Altered()
    print "Saturn One after satellite altered"
	

#Create an object from a class Satellite
satOne = Satellite(-120, 50000, 60000)
satTwo = Satellite(77, -99, -99)
#Access class and instance variable
print Satellite.manufacturer #-> NASA
print satOne.manufacturer #-> NASA
print satOne.velocity #-> -120
#Use an object's method
#Methods can be stored just like functions
satOne.PrintData()

#Add an instance variable to an object
satOne.anotherAtt = 5
print satOne.anotherAtt #-> 5

#Changing a class variable changes it for all objects
Satellite.manufacturer = "BLANK" # != satOne.manufacturer = "BLANK" !!!
print satOne.manufacturer #-> BLANK
print satTwo.manufacturer #-> BLANK

#Create a child class
USSat = SaturnOne(555, 87, 1235)
print USSat.manufacturer #-> BLANK
SaturnOne.manufacturer = "RUS"
print USSat.manufacturer #-> RUS
print satOne.manufacturer #-> BLANK