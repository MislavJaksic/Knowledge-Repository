//Primitive parameters (numbers, strings, ...) are passed by value
//Objects (Arrays, Sets, Maps included) are passed by reference

//Default and "all other arguments" parameters
function square(number = 1, ...restArgs) { 
  return number * number;
}
//Function expressions
let cube = function(number) { return number * number * number }
cube(2) //-> 8
//Annonymous function
function() {
  console.log("hi");
}

function ReturnOnlyOneValue() {
  return [1, 2, 3, 4] // return multiple values
}

//A function within a function:
//Closure: the inner function remembers the outer's value, but
//the outer cannot see the inner's ones values
function outside(x) {
  function inside(y) {
    return x + y;
  }
  return inside;
}

let closureOne = outside(1);
let closureNineNine = outside(99);

closureOne(1); //-> 2
closureNineNine(2); //-> 101