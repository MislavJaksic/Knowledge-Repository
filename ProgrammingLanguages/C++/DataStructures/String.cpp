#include "String.h"



char& String::operator[](const unsigned int index) {
  return this->string[index];
}

const char& String::operator[](const unsigned int index) const {
  return this->string[index];
}

String& String::operator=(const char* s) {
  this->string = s;
  return *this;
}



unsigned int String::Length() {
  return this->string.length();
}



bool String::IsCharAt(const char character, const unsigned int index) {
  if (this->string[index] == character) {
    return true;
  }
  return false;
}

bool String::IsEmpty() {
  if (this->string.empty()) {
    return true;
  }
  return false;
}

bool String::IsNotEmpty() {
  if (this->IsEmpty()) {
    return false;
  }
  return true;
}



void String::Print() {
  std::cout << this->string << std::endl;
}



void String::Clear() {
  this->string.clear();
}
