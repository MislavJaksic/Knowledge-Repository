//False values - false, undefined, null, 0 Nan, empty string

let a
if (a === undefined){
	console.log("Is undefined")
} else if {
	console.log("Will not be written")
}

let i = 0
while (i < 10){
    i++
	break
	continue
}

i = 0
do {
	console.log(i)
	i++
} while (i < 10)
	
for (let i = 0; i < 10; i++){ // define "let i" or the counter variable may "leek" into another function
	console.log(i)
}

//Iterates over all the enumerable properties of an object
let array = [0,1]
array.prop = "property"
for (let property_name in array){ 
	console.log(property_name) //-> 0 1 prop
}
//Iterates over property values
for (let value of array){ 
	console.log(value) //-> 0 1
}
//Once forEach starts it cannot stopped with return, continue or break 
array.forEach(function(element) {
  console.log(element);
});
