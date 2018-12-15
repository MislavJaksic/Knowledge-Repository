import pytest

from tests import context
from big_package.package_two import module_two



class TestClassForModuleTwo(object):
  def test_AddTwoNumbers(self):
    assert module_two.AddTwoNumbers(1, 5) == 6
    
  def test_MultiplyTwoNumbers(self):
    module_two.MultiplyTwoNumbers(2, 4) == 8
