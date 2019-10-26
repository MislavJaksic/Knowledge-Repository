#ifndef CHAR_VECTOR_WRAPPER
#define CHAR_VECTOR_WRAPPER

//Includes
#include <iostream>
#include <vector>

//Declarations
class CharVector {
private:
  std::vector<char> resizeable_array;

public:
  CharVector() :
    resizeable_array{} {
  }

  CharVector(std::initializer_list<char> il) :
    resizeable_array{il} {
  }

  char& operator[](const unsigned int index);
  const char& operator[](const unsigned int index) const;
  friend bool operator< (const CharVector &vector_A, const CharVector &vector_B);

  void Append(const char &character);
  void Append(const std::string &string);

  unsigned int Length() const;

  void Print();

  void Shrink();
  void Clear();
};

#endif // VECTOR_WRAPPER_TEMPLATE

