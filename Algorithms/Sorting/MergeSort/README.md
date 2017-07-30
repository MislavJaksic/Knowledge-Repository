## Merge sort

Merge sort is a recursive sort which divides the data structure until it cannot be divided any further,
that is, until each element is by itself and then merges two elements together swapping elements before merging
if they are in the incorrect order resulting in a merged concatenation that is always ordered. Its speed is
always O(nlogn). Sorting begins by dividing an array into two part, left and right. The division is executed
by modifying the low and high barriers which hold a number corresponding with the position in the array.