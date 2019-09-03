import os
import sys
import argparse

import context
from big_package.package_one import module_one
from big_package.package_two import module_two

# Run from ".../Project-Template" with "python ./src/big_package/runner.py"

# Main will be run if you run this script directly
def Main(args):
  x = 2
  y = 7
  
  print(module_one.Add(x, y)) #-> 9 
  print(module_one.Multiply(x, y)) #-> 14

# Entry point for the runnable script (defined in setup.py)
def Run():
  sys.exit(Main(sys.argv[1:]))

if __name__ == '__main__':
  Run()