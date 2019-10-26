// Primitive parameters (numbers, strings, ...) are passed by value
// Objects (Arrays, Sets, Maps included) are passed by reference

// Default and "all other arguments" parameters
function square(number = 1, ...many_args) {
  return number * number;
}
// Function expressions
let cube = function(number) { return number * number * number }
cube(2)  // -> 8
// Annonymous function
function() {
  console.log("hi");
}

function returnOnlyOneValue() {
  return [1, 2, 3, 4]  // return multiple values
}

// Closure: the inner function remembers the outer's value, but the outer cannot see the inner's values
function outside(x) {
  function inside(y) {
    return x + y;
  }
  return inside;
}

let closureOne = outside(1);
let closureNineNine = outside(99);

closureOne(1);  // -> 2
closureNineNine(2);  // -> 101
