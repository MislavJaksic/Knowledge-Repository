#include <iostream>
#include <string>

void InputOutput(void)
{
    //console input/output
    std::cout << "Enter a whole number:" << std::endl;

    int x;
    std::cin >> x;
    std::cin.ignore(32767, '\n'); // flush newline \n
    
    std::cout << "You entered: " << x << std::endl;
    
    std::cout << "Enter a string:" << std::endl;

    std:string line;
    std::getline(std::cin, line);
}
