Python unit testing
===================

Python programs can be tested using many different modules: unittest, nose, pytest, doctest and mock.
mock - creates false objects that can imitate objects that we are testing. Useful when we don't want to use the internet, but we have to test a function that grabs data from the internet
doctest - allows you to perform tiny tests in the docstring documentation of a method or function
pytest and nose - very similar in that they have features that make testing easier, automated and independent
unittest - Python's module that handles unit testing

How to use pytest (recommended):
1) Create a folder named "Tests" and populate it with subfolders that mimic the structure that is being tested
2) Create .py files named "test_*" and populate them with classes that begin with "Test*"
3) Create methods that begin with "test_*" and use assert command to test if the function works correctly
4) Position the command window in the folder above the folder "Tests" and write "pytest"
Use pytest --help for more information.

How to use Nose:
1) Create two folders, one with the tests and another with the functions you want to test
2) Import functions into the test
3) Assert that what you claim is true
4) Type "nosetests" when you are one folder above the tests folder to run all the discovered tests
5) Tests are discovered if they end with "__test" or begin with "test__"