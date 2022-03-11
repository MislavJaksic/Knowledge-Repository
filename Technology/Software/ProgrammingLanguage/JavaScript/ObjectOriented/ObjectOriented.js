// Objects serve as templates/prototypes from which other objects are created

// Objects have properties associated with them
let car = new Object()
car["colour"] = "red"
car.year = "1999"

car.colour  // -> red
car["year"]  // -> 1999

for (let property in car) {
	console.log(property)  // -> colour, year
}

function writeProperties() {
	console.log(this.colour)
	console.log(this.taste)
}
// Constructor function
function Honey(colour, taste) {
	this.colour = colour
	this.taste = taste
	this.writeProperties = writeProperties  // add function as a method
}
let rareHoney = new Honey("purple", 3)
let commonHoney = new Honey("yellow", 5)
rareHoney.writeProperties()  // -> purple, 3

// Object hierarchy
// https:// developer.mozilla.org/en-US/docs/Web/JavaScript/Guide/Details_of_the_Object_Model


// A demonstration of true inheritance

function ParentObject(parentValue){
  this.parentValue = parentValue;
};

ParentObject.prototype.impliedMethod = function() {
  alert("Parent implied " + this.parentValue);
};

ParentObject.prototype.overridenMethod = function() {
  alert("Parent overriden " + this.parentValue);
};

ParentObject.prototype.alteredMethod = function() {
  alert("Parent altered " + this.parentValue);
};

function ChildObject(parentValue, childValue){
  ParentObject.call(this, parentValue);
  this.childValue = childValue;
};

ChildObject.prototype = Object.create(ParentObject.prototype);
ChildObject.prototype.constructor = ChildObject;

ChildObject.prototype.overridenMethod = function() {
  alert("Child overriden " + this.childValue);
};

ChildObject.prototype.alteredMethod = function() {
  ParentObject.prototype.alteredMethod.call(this)
  alert("Child altered " + this.childValue);
  ParentObject.prototype.alteredMethod.call(this)
};

parent = new ParentObject(2);

child = new ChildObject(3, 5);

parent.impliedMethod();  // -> 2
parent.overridenMethod();  // -> 2

child.impliedMethod();  // -> 3
child.overridenMethod();  // -> 5
child.alteredMethod();  // -> 3 5 3
