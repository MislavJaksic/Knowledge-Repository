//Header guard start
#ifndef OBJECT_ORIENTED
#define OBJECT_ORIENTED

//Includes
#include <iostream>
#include <string>

//Declarations

//Classes
class ChainCalc
{
private:
    static int code;
    int value;

public:
    ChainCalc(int value=0); //default value in declaration

    ChainCalc& Add(int value);
    ChainCalc& Multiply(int value);

    void Print() const;
    static int GetCode();
    int GetValue() const;
};

int ChainCalc::code = 1234;
ChainCalc operator+(const ChainCalc &calc_A, const ChainCalc &calc_B);

//Header guard end
#endif
