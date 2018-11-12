#include "DataTypes.h"

int main(void)
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
    std::string name{"John Doe"};
    int len = static_cast<int>(name.length());

    //aliasing data types
    using an_integer_t = int;
    an_integer_t number{5};

    //type inference
    auto d = 5.0; //infers double

    
    //pointers: addresses that hide a value at their address
    //& == read as "address of"
    //* == read as "access value at", dereference operator
    int x{5};
    int *int_pointer{&x}; //pointer, a data type
    int_pointer = &x; //same as above
    std::cout << int_pointer << std::endl; //address=0x6efe74
    std::cout << *int_pointer << std::endl; //value=5
    *int_pointer = 22;
    std::cout << x << std::endl; //value=22

    //null pointer points to nothing
    int *null_pointer{nullptr};
    std::cout << null_pointer << std::endl; //address=0

    //pointer arithmetic
    std::cout << int_pointer + 0 << std::endl; //address=0x6efe74
    std::cout << int_pointer + 1 << std::endl; //address=0x6efe78
    std::cout << int_pointer + 2 << std::endl; //address=0x6efe7c
    
    
    
    //references (aliases)
    //& == read as "reference to" (not to be confused with "address of")
    int &ref = x; //& means reference to 
    AcceptReference(ref);
    
    return 0;
}

void AcceptReference(int &ref)
{
    std::cout << ref << std::endl;
}
