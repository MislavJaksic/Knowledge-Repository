## Insertion sort

Insertion sort is very simple algorithm to implement and to discuss. Its speed is O(n*n).
Imagine that an array is made up of two part, an unsorted right part and sorted left part. At the beginning
the sorted part doesn't exist. The algorithm begins sorting by taking the leftmost element in the unsorted
part swaps elements in the sorted part with the element until it finds a place for it. The algorithm ends 
when it tries to grab an element outside the bounds of a data structure.
|*3|1|2|4|6|5|
  ^ the sorted part is empty. Compares 3 with numbers in the sorted part.
|3*1|2|4|6|5|
 ^ each element in the unsorted part will be compared with every element in the sorted part beginning with
   the rightmost element in the sorted part and continuing to the left. The unsorted element is swapped with the
   next element on the left in the sorted part until the unsorted element becomes greater the next sorted
   element on the left.
|3*1|2|4|6|5|
   ^ compare one with all the elements in the sorted part.
|3*1|2|4|6|5|
   ^ one is less then three, swap one and three.
|1|3*2|4|6|5|
^ reached the end of array, stop swapping.
|1|3*2|4|6|5|
     ^ compare two with all the elements in the sorted part.
|1|2|3*4|6|5|
   ^ two is less then three, swap two and three.
|1|2|3*4|6|5|
 ^ two is greater then one, stop swapping.
|1|2|3*4|6|5|
       ^ ...