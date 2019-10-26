//Header guard start
#ifndef STRING_WRAPPER
#define STRING_WRAPPER

//Includes
#include <iostream>
#include <string>

//Declarations
class String {
private:
  std::string string;

public:
  String() :
    string() {
  }
  //for "String string{"hello"}" init
  String(const char* s) :
    string{s} {
  }

  ~String() {
    this->Clear();
  }

  char& operator[](const unsigned int index);
  const char& operator[](const unsigned int index) const;
  String& operator= (const char* s); //for "string = "hello""

  unsigned int Length();

  bool IsCharAt(const char character, const unsigned int index);
  bool IsEmpty();
  bool IsNotEmpty();

  void Print();

  void Clear();
};

//Header guard end
#endif

