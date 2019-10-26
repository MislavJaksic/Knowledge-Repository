#include "object_oriented.h"



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
