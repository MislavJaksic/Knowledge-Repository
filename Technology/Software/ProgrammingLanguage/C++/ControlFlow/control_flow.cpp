#include "control_flow.h"

enum Colours
{
    COLOUR_BLACK,
    COLOUR_RED
};

int main(void)
{
    if (1) { //non zero is boolean True
      ; //null statement, "do nothing"
    } else if (2){
      ;
    } else {
      ;
    }

    Colours colour{COLOUR_BLACK}; //must be a number
    switch (colour) {
      case COLOUR_BLACK:
          break;
      default:
          break;
    }

    int counter{0};
    while (counter < 3) {
      counter++;
    }
    do {
      counter--;
    } while (counter > 0);

    for (int i = 0; i < 3; i++) {
      ;
    }
    //references and for-each loops
    std::vector<int> fibonacci{0,1,1,2};
    for (auto &number : fibonacci)
        std::cout << number << ' ';
      
    return 0;
}