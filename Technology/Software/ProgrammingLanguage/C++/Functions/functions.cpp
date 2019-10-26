#include "functions.h"

int main(void)
{
    //pass by value
    //pass primitives; no side effects

    //pass by reference
    //pass structures/classes; return "multiple" values (by modifying arguments)
    //can prevent modification by declaring pass by constant reference!

    //pass by address
    //pass pointers; prefer pass by reference over pass by address



    //return value

    //return reference
    //for returning structure/class
    int a = 1;
    int b = PassAndReturnByReference(a);
    std::cout << a << std::endl;
    std::cout << b << std::endl;

    //return address
    //for returning dynamic memory
    int c = 3;
    int *d;
    d = PassAndReturnByAddress(&c);
    std::cout << c << std::endl;
    std::cout << d << std::endl;
    std::cout << *d << std::endl;



    //function overloading
    Print(5);
    Print("Hello");



    //pointer to a function
    void (*print_pointer)(int) = &Print;
    print_pointer(6); //this is how you can pass a function to a function

    return 0;
}

int& PassAndReturnByReference(const int &x) //without const, the argument can be changed
{
    //x++; //-> const; cannot be changed
    std::cout << x << std::endl;
    static int y{2}; //without static, the value is destroyed after return
    //DO NOT DO THIS! Statics last for an exceptionally long time
    return y;
}

int* PassAndReturnByAddress(int *x)
{
    std::cout << x << std::endl;
    std::cout << *x << std::endl;
    *x = 4;
    return x;
}

void Print(int x) //has a default value; in header file
{
    std::cout << x << std::endl;
}

void Print(std::string x)
{
    std::cout << x << std::endl;
}
