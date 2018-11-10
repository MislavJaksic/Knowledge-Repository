#include <iostream>

struct Employee
{
    //members
    short id;
    int age;
    double wage;
};

void DataStructures(void)
{
    Employee joe; 
    joe.id = 14;
    joe.age = 32;
    joe.wage = 24.15;
    Employee frank{2,28}; //id = 2,age = 28,wage = 0.0(default)
}
