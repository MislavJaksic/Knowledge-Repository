from nose.tools import *
from Testing.FunctionsWeTest import SimpleFunctions

def test_EchoSomething():
  eq_(SimpleFunctions.EchoSomething("Hello"), "Hello")
  
def test_SimpleFailure():
  eq_(5, 6)
  
def test_Division():
  eq_(1.0/3, 0.33333333)