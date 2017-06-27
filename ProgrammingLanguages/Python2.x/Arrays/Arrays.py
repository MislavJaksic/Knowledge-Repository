#Built in array functions: https://docs.python.org/2/tutorial/datastructures.html#more-on-lists

#Arrays(called lists in Python)
listOne = [0, 1, 2, 3, 4]
listOne = range(0, 5, 1)
#Assign a reference; doesen't copy the object
listTwo = listOne
#Add element after the last position
listTwo.append(5) #-> Changes both lists
print listOne #-> [0, 1, 2, 3, 4, 5]
print listTwo #-> [0, 1, 2, 3, 4, 5]
#Remove the element in the last position
print listOne.pop() #-> 5
#Access an element
print listTwo[2] #-> 2
# Slicing
# [| 0 | 1 | 2 | 3 | 4 |]
#  0   1   2   3   4   5
# -5  -4  -3  -2  -1
print listOne[2:4] #-> [2, 3]
print listTwo[-4:-3] #-> [1]

#A tuple is an immutable list; useful for passing data around the program
tuples = (1, 2, "Hello")
print tuples[2] #-> "Hello"
#tuples[2] = 3 #-> Error! Cannot be changed!
