## Python unit testing

Python programs can be tested using many different modules: unittest, nose, pytest, doctest, mock and others.
    - mock: create objects that imitate another object. For example, we don't have access to the Internet, but we still
want to test a function that needs it. Its simple: just create a mock object that will return data as if it was
downloaded from the Internet.
    - doctest: write tests in the docstring documentation of a method or a function.
    - pytest and nose: very similar in that they have features that make testing easier, automated and independent.
    - unittest: Python's "official" module that handles unit testing.

How to test using pytest:
1) Install using pip or Anaconda or any other tool
2) Choose a test layout: where you are going to put the tests?
  - are tests part of the source code or are they outside of it, in another folder (latter is reccommended)?
3) Populate folders with __init__.py files
4) Create test files that begin with "test_*"
5) Populate the tests with functions and classes
6) Run the tests with "pytest"

How to use Nose (package is no longer supported):
1) Create two folders, one with the tests and another with the functions you want to test
2) Import functions into the test
3) Assert that what you claim is true
4) Type "nosetests" when you are one folder above the tests folder to run all the discovered tests
5) Tests are discovered if they end with "__test" or begin with "test__"