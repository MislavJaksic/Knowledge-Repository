//Special JavaScript variable scoping:

//var in a block statement -> doesn't have block scope
var x = 1
{ var x = 2 }
x //-> 2
//let in block statements -> variable local to block statement
let y = 1
{ let y = 2 }
y //-> 1
//var or let in a function -> variable local to the function

//Variable "hoisting" -> if the variable is used before it is declared,
//                       the code will evaluate to "undefined"
b //-> undefined
var b = 5
b //-> 5

//Read only variables are constants; will not be hoisted
const NUM_OF_CYCLES = 5

let a
a //-> undefined; uninitialized value
a + 2 //-> Nan; undefined and operation; watch out for it!

//Function declarations are hoisted
foo() //-> 1
function foo(){console.log(1)}
//Function expressions aren't hoisted
bar() //-> ERROR
var bar = function(){ console.log(1) }

//Data types - primitive - Boolean, null, undefined, Number, String, Symbol
//           - Objects (Arrays, Sets and Maps are also Objects)

//Boolean
var bool = new Boolean(false);
//The value is not undefined of null, its a boolean object
if (bool){ // -> true
  console.log(1); // -> 1
}

if (bool === true){ // -> false
  console.log(0);
} 

//Strings
let stringNumber = "123.45"
parseInt(stringNumber) //-> 123
parseFloat(stringNumber) //-> 123.45
//String methods: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Guide/Text_formatting


