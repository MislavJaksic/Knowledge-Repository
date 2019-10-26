#include "CharVector.h"



char& CharVector::operator[](const unsigned int index) {
  return this->resizeable_array[index];
}

const char& CharVector::operator[](const unsigned int index) const {
  return this->resizeable_array[index];
}

bool operator< (const CharVector &vector_A, const CharVector &vector_B) {
  unsigned int length_A = vector_A.Length();
  unsigned int length_B = vector_B.Length();

  if (length_A < length_B) {
    return true;
  } else if (length_A > length_B) {
    return false;
  }

  for (unsigned int i = 0; i < length_A; i++) {
    if (vector_A[i] < vector_B[i]) {
      return true;
    } else if (vector_A[i] > vector_B[i]) {
      return false;
    }
  }
  return false;
}



void CharVector::Append(const char &character) {
  this->resizeable_array.push_back(character);
}

void CharVector::Append(const std::string &string) {
  for (unsigned int i = 0; i < string.size(); i++) {
    this->Append(string[i]);
  }
}



unsigned int CharVector::Length() const {
  return this->resizeable_array.size();
}



void CharVector::Print() {
  std::cout << "[";
  for (auto& element : this->resizeable_array) {
    std::cout << element;
    std::cout << ",";
  }
  std::cout << "]";
  std::cout << std::endl;
}



void CharVector::Shrink() {
  this->resizeable_array.shrink_to_fit();
}

void CharVector::Clear() {
  this->resizeable_array.clear();
}
