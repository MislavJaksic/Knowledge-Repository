#include "functions.h"

int main(void)
{
    //pass by value
    //pass primitives; no side effects

    //pass by reference
    //pass structures/classes; return "multiple" values (by modifying arguments)
    //can prevent modification by declaring pass by constant reference!

    //pass by address
    //pass pointers; prefer pass by reference over pass by value



    //return value

    //return reference
    //return structure/class
    int z = PassAndReturnByReference(12);

    //return address
    //return dynamic memory

    return 0;
}

int& PassAndReturnByReference(const int &x) //without const, the argument can be changed
{
    std::cout << x << std::endl;
    if (true)
    {
        static int y{8}; //without static, the value is destroyed
        return y;
    }
    return x;
}