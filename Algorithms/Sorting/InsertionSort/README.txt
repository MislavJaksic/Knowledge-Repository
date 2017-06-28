Insertion sort
==============

Insertion sort is very simple algorithm to implement and to discuss. Its speed is O(n*n).
Before sorting it is imagined that an array is made up of two part, an unsorted right part and sorted left part. The sorted part doesn't exist and the algorithm begins sorting from the leftmost element in the unsorted part and ends when it reaches the end of the data structure.
||3|1|2|4|6|5|
  ^ the sorted part is empty and 3 will become its first element.
|3||1|2|4|6|5|
 ^
Each element in the unsorted part will be compared with every element in the sorted part beginning with the rightmost element in the sorted part and going to the left. The unsorted element is swapped with the next element on the left in the sorted part until the unsorted element becomes greater the next sorted element on the left.
|3||1|2|4|6|5|
    ^ compare one with all the elements in the sorted part.
|3||1|2|4|6|5|
    ^ one is less then three, swap one and three.
|1||3|2|4|6|5|
^ reached the end of array, stop swapping.
|1|3||2|4|6|5|
      ^ compare two with all the elements in the sorted part.
|1|2||3|4|6|5|
   ^ two is less then three, swap two and three.
|1|2||3|4|6|5|
 ^ two is greater then one, stop swapping.
|1|2|3||4|6|5|
        ^ ...