#include "FileReader.h"



std::string FileReader::ReadLine() {
  std::string line;
  std::getline(this->stream, line);

  return line;
}



bool FileReader::IsFlagsUnset() {
  if (this->stream.good()) {
    return true;
  }
  return false;
}

bool FileReader::IsEOF() {
  if (this->stream.eof()) {
    return true;
  }
  return false;
}

bool FileReader::IsFail() {
  if (this->stream.fail()) {
    return true;
  }
  return false;
}

bool FileReader::IsBad() {
  if (this->stream.bad()) {
    return true;
  }
  return false;
}

void FileReader::ResetFlags() {
  this->stream.clear();
}



void FileReader::Close() {
  this->stream.close();
}
