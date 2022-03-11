// False values: false, undefined, null, 0, Nan, empty string

let a
if (a === undefined){
	console.log("Is undefined")
} else if (a !== undefined) {
	console.log("Will not be written")
}

let fruit = "Pear"
switch (fruit) {
  case "Oranges":
    console.log("Oranges!")
  case "Bananas":
  default:
    console.log("Neither oranges nor bananas")
}

let i = 0
do {
	console.log("do:" + i)
	i++
} while (i < 3)

let j = 0
while (j < 3){
  j++
  console.log("break while")
	break
	continue
}

for (let i = 0; i < 3; i++){  // define "let i" or the counter variable may leek
	console.log("for:" + i)
}

// Iterates over all the enumerable properties of an object
let array = [0,1]
array.prop = "property"
for (let propertyName in array){
	console.log("property:" + propertyName)  // -> 0 1 prop
}
// Iterates over property values
for (let value of array){
	console.log("value:" + value)  // -> 0 1
}
// Once forEach starts, it cannot be stopped with return, continue or break
array.forEach(function(element) {
  console.log("forEach:" + element);
});
