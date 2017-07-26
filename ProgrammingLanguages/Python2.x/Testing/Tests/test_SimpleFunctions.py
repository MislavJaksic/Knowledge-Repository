from Testing.FunctionsWeTest import SimpleFunctions

def test_EchoSomething():
  assert SimpleFunctions.EchoSomething("Hello") == "Hello"
  
def test_SimpleFailure():
  assert 5 == 6
  
def TestSimpleFunction(object):
	def test_EchoSomething(self):
		assert SimpleFunctions.EchoSomething("Hi") == "Hi"