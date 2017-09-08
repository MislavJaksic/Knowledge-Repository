//Special JS variable scoping
//var in a block statement -> doesn't have block scope
var x = 1
{ var x = 2 }
x //-> 2
//let in block statements -> variable local to block statement
let y = 1
{ let y = 2 }
y //-> 1
//var or let in a function -> variable local to the function

//Variable "hoisting" -> if the variable is declared later, the code will evaluate to undefined instead an error

//var b <- is that hoisting declares implicitly
b //-> undefined
var b = 5
b //-> 5

//Declare read only constant
//const will not be hoisted
const NUM_OF_CYCLES = 5

//undefined is an uninitialized value
let a
a //-> undefined
//undefined and operation => Nan
a + 2 //-> Nan

//Function declarations gets hoisted
foo() //-> 1
function foo(){console.log(1)}
//Function expressions don't get hoisted
bar() //-> ERROR
var bar = function(){ console.log(1) }

//Data types - primitive - Boolean, null, undefined, Number, String, Symbol
//           - Objects (equivalent to dictionaries or maps)

//Boolean
var bool = new Boolean(false);
if (bool) // -> true
if (bool == true) // -> false

//Strings
let stringNumber = "123.45"
parseInt(stringNumber) //-> 123
parseFloat(stringNumber) //-> 123.45
//String methods: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Guide/Text_formatting


