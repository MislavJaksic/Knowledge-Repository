class Mom(object):
  class_field = "MOM CLASS VALUE"
  
  def __init__(self, mom_param, *args):
    print("MOM INIT")
    super(Mom, self).__init__(*args)
    self.instance_field = mom_param
    
  def MomFunction(self):
    print("MOM FUNCTION")
    
  def ParentFunction(self):
    print("MOM SHARED FUNCTION")
    
class Dad(object):
  class_field = "DAD CLASS VALUE"
  
  def __init__(self, dad_param, *args):
    print("DAD INIT")
    super(Dad, self).__init__(*args)
    self.instance_field = dad_param
    
  def DadFunction(self):
    print("DAD FUNCTION")
    
  def ParentFunction(self):
    print("DAD SHARED FUNCTION")
  
class Child(Mom, Dad):
  class_field = "CHILD CLASS VALUE"
  
  def __init__(self, child_param, mom_param, dad_param):
    print("CHILD INIT")
    super(Child, self).__init__(mom_param, dad_param)
    self.instance_field = child_param
    
  def ChildFunction(self):
    print("CHILD FUNCTION")
    
  def _PrivateFunction(self):
    pass

print(Mom.class_field)
print(Dad.class_field)
print(Child.class_field)

mom_object = Mom("Alice")
dad_object = Dad("Bob")
child_object = Child("Charlie", "Alice", "Bob") #-> CHILD INIT, MOM INIT, DAD INIT

child_object.ParentFunction() #-> MOM SHARED FUNCTION

stored_function = mom_object.MomFunction
stored_function() #-> MOM FUNCTION

mom_object.extra_object_field = "EXTRA"
print(mom_object.extra_object_field)
del mom_object.extra_object_field

#Multiple inheritence works as follows: the classes are searched depth first, from left to right
#This is done when using super(), when invoking a function or anything similar
