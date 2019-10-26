// Array methods: https:// developer.mozilla.org/en-US/docs/Web/JavaScript/Guide/Indexed_collections
var array = [0,1,2,3,4,5]

array.length  // -> 6
array[0]  // -> 0
array[-1]  // -> undefined

array[2] = 2
array.push(6)
array.pop()  // -> 6

array.slice()  // -> [0,1,2,3,4,5]; returns a copy of an Array

array.splice(4, 2)  // -> [4, 5]
array  // -> [0,1,2,3]

// Maps
let map = new Map()
map.set(5, "five")  // -> (key, value)
map.set(4, "four")

map.size  // -> 2

map.get(2)  // -> undefined
map.has(5); //  true
map.delete(4);

map.forEach(function (value, key, map_itself) {
  console.log(value)  // -> "five"
});

// "Pure" Objects
let object = {name: "MJ",
              code: 123}
console.log(object['name'])  // -> MJ
console.log(object.code)  // -> 123
