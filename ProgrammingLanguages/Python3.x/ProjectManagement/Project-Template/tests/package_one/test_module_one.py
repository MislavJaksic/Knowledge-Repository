import os
import sys
import pytest

from tests import context
from big_package.package_one import module_one



class TestClassForModuleOne(object):
  def test_Add(self):
    print(sys.path)
    assert module_one.Add(1, 5) == 6
    
  def test_RaiseException(self):
    with pytest.raises(SystemExit):
      module_one.RaiseException()
      
      
      
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
  print("Finished!")
  
@pytest.fixture(scope="module")
def complex_array():
  yield [x for x in range(5)]
  print("Finished!")
  
def test_ManipulateArray(basic_array):
  assert len(basic_array) == 5
    
    
    
def test_SimpleTestFailure():
  print("Should fail as a demo!")
  assert 5 == 6
