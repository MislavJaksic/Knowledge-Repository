//JavaScript as a prototype-based language has only objects that serve as templates from which other objects are created

//Objects have properties associated with them
var car = new Object()

car["colour"] = "red"
car.year = "1999"

car.colour //-> red
car["year"] //-> 1999

for (let property in car) {
	console.log(property) //-> colour, year
}

function writeProperties() {
	console.log(this.colour)
	console.log(this.taste)
}
//Constructor function
function Honey(colour, taste) {
	this.colour = colour
	this.taste = taste
	this.writeProperties = writeProperties //add function as a method
}
let rareHoney = new Honey("purple", 3)
let commonHoney = new Honey("yellow", 5)
rareHoney.writeProperties() //-> purple, 3

//Objects can have objects within them (composition)

//Object hierarchy
//https://developer.mozilla.org/en-US/docs/Web/JavaScript/Guide/Details_of_the_Object_Model









