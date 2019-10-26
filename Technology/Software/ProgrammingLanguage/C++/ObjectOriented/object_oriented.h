//Header guard start
#ifndef OBJECT_ORIENTED
#define OBJECT_ORIENTED

//Includes
#include <iostream>
#include <string>

//Declarations

//Classes
class ChainCalc {
private:
  static int code;
  int value;

public:
  ChainCalc(int value = 0); //default value in declaration

  ChainCalc& Add(int value);
  ChainCalc& Multiply(int value);

  void Print() const;
  static int GetCode();
  int GetValue() const;
};

ChainCalc operator+(const ChainCalc &calc_A, const ChainCalc &calc_B);



//anonymous objects and "friend" classes exist

//composition, aggregation, association, dependency
//part of,     has a,       uses a,      needs a

//container classes

//std::initializer_list

//TODO inheritance

//classes are constructed from the base to the most specific class
//classes are deconstructed in the reverse order of construction

//specific classes cannot access private members of base classes!
//protected means specific classes can access members

//public, private, protected inheritance
//
class Parent {
private: //access specifier
  std::string parent_id;

public:
  Parent(std::string parent_id = "parent_default") : //can delegate or initialize, not both
    parent_id(parent_id) {
    std::cout << "ID " << parent_id << " constructed" << std::endl;
  }

  ~Parent() { //destructor
    std::cout << "ID " << parent_id << " destroyed" << std::endl;
  }

  void Print() { //member function
    //you should use this->_member sparingly
    std::cout << "ID: " << this->parent_id << std::endl;
  }
};

class Child : public Parent { //public inheritance
private:
  std::string child_id;

public:
  Child(std::string child_id = "child_default", std::string parent_id = "parent_from_child_default") : //can delegate or initialize, not both
    Parent(parent_id), //construct the most base class first!
    child_id(child_id) {
    std::cout << "ID " << child_id << " constructed" << std::endl;
  }

  ~Child() { //destructor
    std::cout << "ID " << child_id << " destroyed" << std::endl;
  }

  void Print() { //member function
    //you should use this->_member sparingly
    std::cout << "ID: " << this->child_id << std::endl;
  }
};

//Header guard end
#endif
