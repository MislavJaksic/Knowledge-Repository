//Header guard start
#ifndef CONTROL_FLOW
#define CONTROL_FLOW

//Includes
#include <iostream>
#include <string>

//Declarations
int& PassAndReturnByReference(const int &x);
int* PassAndReturnByAddress(int *x);
void Print(int x=10); //default value
void Print(std::string x);

//Header guard end
#endif
