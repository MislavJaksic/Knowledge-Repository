var array = [0,1,2,3,4,5]

array.length //-> 6 (always return the highest index plus one)
array[0] //-> 0
array[-1] //-> undefined

array[2] = 2
array.push(6)
array.pop() //-> 6

array.slice() //-> [0,1,2,3,4,5]
array.slice(4, 1) //-> [4]

//Array methods: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Guide/Indexed_collections