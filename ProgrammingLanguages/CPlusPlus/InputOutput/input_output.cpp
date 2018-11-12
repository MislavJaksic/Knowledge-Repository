#include "InputOutput.h"

int main(void)
{
    //console input/output
    GetInt();
    GetString();

    return 0;
}

void GetInt(void)
{
    int input;
    std::cout << "Enter a whole number:" << std::endl;
    std::cin >> input; //extraction operation; from buffer to variable
    if (IsInputValid())
    {
        std::cout << "You entered: " << input << std::endl;
    }
}

void GetString(void)
{
    std::string input;
    std::cout << "Enter a string:" << std::endl;
    std::getline(std::cin, input);
    if (IsInputValid())
    {
        std::cout << "You entered: " << input << std::endl;
    }
}

bool IsInputValid(void)
{
    if (IsExtractionGood())
    {
        ClearInputBuffer();
        return true;
    }
    else
    {
        RestoreInputsToNormal();
        ClearInputBuffer();
        std::cout << "Invalid input." << std::endl;
        return false;
    }
}

bool IsExtractionGood(void)
{
    if (std::cin.fail()) //check if extraction failed
    {
        return false;
    }
    return true;
}

void RestoreInputsToNormal(void)
{
    std::cin.clear();
}

void ClearInputBuffer(void)
{
    std::cin.ignore(32767,'\n'); //flush \n after extraction
}

