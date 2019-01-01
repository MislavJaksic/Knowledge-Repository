#include "main.h"



int main(void) {
  Parent dad{"parent"}; //instantiation, instance/object
  dad.Print();
  Child daughter;
  daughter.Print();

  ChainCalc calc{1};
  //ChainCalc::code = 1234;
  calc.Add(2).Multiply(10);
  calc.Print();

  return 0;
}
