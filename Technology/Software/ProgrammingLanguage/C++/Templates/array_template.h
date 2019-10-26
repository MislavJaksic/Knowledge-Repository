#ifndef ARRAY
#define ARRAY

//Includes
#include <assert.h>

//function definition and declaration both must be in the header file
//valid example, but effc++ throws an error due to a pointer
template <class T, int number> //template type parameter and template non-type parameter
class Array {
private:
  int m_length;
  T *m_data;
  int integer = number;

public:
  Array() {
    m_length = 0;
    m_data = nullptr;
  }

  Array(int length) {
    m_data = new T[length];
    m_length = length;
  }

  ~Array() {
    delete[] m_data;
  }

  void Erase() {
    delete[] m_data;
    m_data = nullptr;
    m_length = 0;
  }


  T& operator[](int index) {
    assert(index >= 0 && index < m_length);
    return m_data[index];
  }

  int getLength() {
    return m_length;
  }
};

#endif
