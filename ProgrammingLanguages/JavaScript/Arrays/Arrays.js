var array = [0,1,2,3,4,5]

array.length //-> 6
array[0] //-> 0
array[-1] //-> undefined

array[2] = 2
array.push(6)
array.pop() //-> 6

array.slice() //-> [0,1,2,3,4,5]; returns a copy of an Array

array.splice(4, 2) //-> [4, 5]
array //-> [0,1,2,3]

//Array methods: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Guide/Indexed_collections