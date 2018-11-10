#include <iostream>
#include <string>

void DataTypes(void)
{
    //definition
    //basic, primitive or built-in types
    bool boolean;
    char character;
    int integer;
    float single_precision;
    double double_precision;

    //uniform initialisation
    int init_int{44};
    
    //compiler and runtime compiler
    const double gravity{9.8};
    constexpr double age = 5 + 9;
    
    //explicit casting
    int small_number = static_cast<int>(gravity);
    
    //strings
    std:string name{"John Doe"};
    int length = name.length();
    
    //aliasing data types
    using an_integer_t = int;
    an_integer_t number{5};
    
    //type inference
    auto d = 5.0; //infers double
}
