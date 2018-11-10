#include <iostream>
#include <string>

void ControlFlow(void)
{
    if (1) { //non zero is boolean True
      ; //null statement
    } else if (2){
      ;
    } else {
      ;
    }
    
    std::string colour{"red"};
    switch (colour) {
      case "black":
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
}
