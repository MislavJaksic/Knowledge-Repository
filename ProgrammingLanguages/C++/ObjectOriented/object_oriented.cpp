#include "main.h"

//ChainCalc defined in the header file

ChainCalc::ChainCalc(int value): value(value) {
}

ChainCalc& ChainCalc::Add(int value) {
  this->value += value;
  return *this;
}
ChainCalc& ChainCalc::Multiply(int value) {
  this->value *= value;
  return *this;
}

void ChainCalc::Print() const { //make all function that don't change the object state const
  std::cout << "value: " << this->value << std::endl;
}

int ChainCalc::GetCode() { //declared as static, tied to a class
  return ChainCalc::code;
}

int ChainCalc::GetValue() const {
  return value;
}

ChainCalc operator+(const ChainCalc &calc_A, const ChainCalc &calc_B) { //operator overloading
  return ChainCalc(calc_A.GetValue() + calc_B.GetValue());
}



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









int main(void) {
  Parent dad{"parent"}; //instantiation, instance/object
  dad.Print();
  Child daughter;
  daughter.Print();

  ChainCalc calc{1};
  calc.Add(2).Multiply(10);
  calc.Print();

  return 0;
}
