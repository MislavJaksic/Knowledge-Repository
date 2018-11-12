#include "DataStructures.h"

namespace ColourNames
{
enum Colours
{
    COLOUR_BLACK,
    COLOUR_RED,
    COLOUR_PINK
    MAX_COLOURS
};
}

struct Employee
{
    //members
    short id;
    int age;
    double wage;
};

int main(void)
{
    //enums
    ColourNames::Colours colour{COLOUR_RED};
    std::cout << colour << std::endl; // 1

    
    
    //structs
    Employee joe;
    joe.id = 14;
    joe.age = 32;
    joe.wage = 24.15;
    std::cout << joe.wage << std::endl; // 24.15

    Employee frank{2,28,0.0}; //id = 2,age = 28,wage = 0.0
    std::cout << frank.wage << std::endl; // 0
    
    
    
    //built-in arrays
    std::array<double, 5> built_in_array{9.0,7.2};
    AcceptBuiltInArrays(built_in_array);

    //built-in vector
    std::vector<int> built_in_vector{3,5,7};
    built_in_vector.size();
    built_in_vector.resize(10);
    
    
    
    //manual arrays
    int scores[ColourNames::MAX_COLOURS]; //3 integer fixed array
    scores[0] = 55555;
    int len = sizeof(scores) / sizeof(scores[0]); //len=3

    //arrays are also pointers
    int *array_pointer{&scores[0]};
    std::cout << *array_pointer << std::endl; //value=55555
    PrintArray(scores, len);
    
    std::sort(scores, scores+len); //parameters is array range (using pointer arithmetic)
    
    
    
    //dynamic memory
    int *dynamic_int = new int{5}; //allocate and assign value
    delete dynamic_int; //deallocate
    dynamic_int = nullptr;

    int *dynamic_array = new int[3](); //allocate and assign default values
    dynamic_array[0] = 3;
    delete[] dynamic_array; //deallocate

    return 0;
}

void PrintArray(int *array, int len) //same as parameters "(int *array[])"
{
    for (int i = 0; i < len; i++)
    {
        std::cout << "Element: " << i << std::endl;
        std::cout << array[i] << std::endl;
        std::cout << *(array + i) << std::endl; //same as above
    }
}



void AcceptBuiltInArrays(std::array<double, 5> &array)
{
    for (auto &number : array)
        std::cout << number << ' ';
}