#include "main.h"

//resolves to actual parameters: function template instance
template <typename A, typename B> //template type parameters
void CreatePair(const A &key, const B &value) { //template function
  std::make_pair(key, value);
}

int main(void) {
  char key = 'K';
  int value = 1;
  CreatePair(key, value);

  /*
  Array<int> intArray(12);
	Array<double> doubleArray(12);
	*/

	//TODO https://www.learncpp.com/cpp-tutorial/13-5-function-template-specialization/ and beyond

  return 0;
}
