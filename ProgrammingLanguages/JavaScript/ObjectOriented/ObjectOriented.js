//Objects serve as templates/prototypes from which other objects are created

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

//Object hierarchy
//https://developer.mozilla.org/en-US/docs/Web/JavaScript/Guide/Details_of_the_Object_Model


//A demonstration of true inheritance

function ParentObject(parent_value){
  this.parent_value = parent_value;
};

ParentObject.prototype.ImpliedMethod = function() {
  alert("Parent implied " + this.parent_value);
};

ParentObject.prototype.OverridenMethod = function() {
  alert("Parent overriden " + this.parent_value);
};

ParentObject.prototype.AlteredMethod = function() {
  alert("Parent altered " + this.parent_value);
};

function ChildObject(parent_value, child_value){
  ParentObject.call(this, parent_value);
  this.child_value = child_value;
};

ChildObject.prototype = Object.create(ParentObject.prototype);
ChildObject.prototype.constructor = ChildObject;

ChildObject.prototype.OverridenMethod = function() {
  alert("Child overriden " + this.child_value);
};

ChildObject.prototype.AlteredMethod = function() {
  ParentObject.prototype.AlteredMethod.call(this)
  alert("Child altered " + this.child_value);
  ParentObject.prototype.AlteredMethod.call(this)
};

parent = new ParentObject(2);

child = new ChildObject(3, 5);

parent.ImpliedMethod(); //-> 2
parent.OverridenMethod(); //-> 2

child.ImpliedMethod(); //-> 3
child.OverridenMethod(); //-> 5
child.AlteredMethod(); //-> 3 5 3
