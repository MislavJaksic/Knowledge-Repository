#ifndef FILE_READER
#define FILE_READER

//Includes
#include <iostream>
#include <fstream>

//Declarations
class FileReader {
private:
  std::ifstream stream;

public:
  FileReader(const std::string &file_name) :
    stream{file_name} {
    if (this->IsFail() || this->IsBad()) {
      std::cerr << "R/W or logical error while opening '" << file_name << "'." << std::endl;
    }
  }

  ~FileReader() {
    this->Close();
  }



  std::string ReadLine();

  bool IsFlagsUnset();
  bool IsEOF();
  bool IsFail();
  bool IsBad();
  void ResetFlags();

  void Close();
};

#endif // INPUT_FILE_STREAM_WRAPPER

