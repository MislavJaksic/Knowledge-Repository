//Objects (equivalent to dictionaries or maps)
let object = {name: "MJ", code: 123}
object['name'] //-> MJ
object.code //-> 123

//Maps (better then Objects because Maps can have any value as a key, iterates in insertion orderd, ...)
let map = new Map()

map.set(5, "five")
map.set(4, "four")
map.size //-> 2
map.get(2) //-> undefined
map.has(5); // true
map.delete(4);

