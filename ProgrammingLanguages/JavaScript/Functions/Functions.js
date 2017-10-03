//Primitive parameters (numbers, strings, ...) are passed by value
//Objects, Arrays and similar objects are passed by reference

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

//Pssible to nest a function within a function
//Cosure is an expression that can have free variables together with an environment that binds those variables
//If he expression is a function, the inner function can use the outer function's variables, while the outer functio ncannot use the inner function's variables
function outside(x) {
  function inside(y) {
    return x + y;
  }
  return inside;
}

let closureOne = outside(1)
let closureTwo = outside(99) //???




