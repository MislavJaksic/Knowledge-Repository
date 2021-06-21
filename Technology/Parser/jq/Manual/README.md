## [jq 1.6 Manual](https://stedolan.github.io/jq/manual/v1.6/)

ToDo

### Invoking jq

ToDo

### Basic Filters

Identity `.`:
* takes its input and produces it unchanged as output

`jq '.'`

Object Identifier-Index `.foo.bar`:
* produces the value at the key `.foo.bar`, or `null` if there's none present
* if key starts with digits or special characters, you must surround it like `.["foo"].["bar"]`

`jq '.foo.bar'`  
`jq '.["foo"].["bar"]'`

Optional Object Identifier-Index `.foo?`:
* like previous commands but does not output an error

`jq '.foo.bar?'`  
`jq '.["foo"]?.["bar"]?'`

Array Index `.[2]`:
* takes an element in an zero indexed array

`jq '.[2]'`  
`jq '.[-2]'`

Array/String Slice `.[10:15]`:
* slices the array, just like Python slicing

ToDo...

### Types and Values

ToDo
...

### Conditionals and Comparisons
