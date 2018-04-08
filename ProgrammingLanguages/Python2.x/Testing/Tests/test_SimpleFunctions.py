from Testing.FunctionsWeTest import SimpleFunctions

import os
import pytest

def test_EchoParameter():
  assert SimpleFunctions.EchoParameter("Hello") == "Hello"
  
def test_Exception():
  with pytest.raises(SystemExit):
    SimpleFunctions.CreateSysException()
  
  
class TestClassForGroupingFunctions(object):
	
  def test_EchoParameter(self):
		assert SimpleFunctions.EchoParameter("Hi") == "Hi"
    
  def test_Exception(self):
    with pytest.raises(SystemExit):
      SimpleFunctions.CreateSysException()
      
      
def test_NeedTemporaryDirectory(tmpdir):
  text_file = tmpdir.mkdir("sub_dir").join("file.txt")
  text_file.write("hello world")
  text_file.write("world, hello")
  
  assert text_file.read() == "world, hello"
  assert len(tmpdir.listdir()) == 1
  
  
@pytest.fixture(scope="function")
def basic_array():
  #setup
  yield [x for x in range(5)]
  #teardown
  print "Finished!"
  
@pytest.fixture(scope="module")
def complex_array():
  yield [x for x in range(5)]
  print "Finished!"
  
def test_ManipulateArray(basic_array):
  assert len(basic_array) == 5
    
    
def test_SimpleFailure():
  assert 5 == 6
  
