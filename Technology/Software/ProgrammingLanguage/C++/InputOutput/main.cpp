#include "main.h"



int main(void) {
  FileReader reader{"example.fasta"};
  while (reader.IsFlagsUnset()) {
    std::cout << reader.ReadLine() << std::endl;
  }
  
  return 0;
}
