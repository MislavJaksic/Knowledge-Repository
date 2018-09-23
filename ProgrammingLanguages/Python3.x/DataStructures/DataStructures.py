#Built in array functions: https://docs.python.org/2/tutorial/datastructures.html#more-on-lists

#Arrays(lists behave like arrays in Python)
listOne = [0, 1, 2, 3, 4] #or listOne = range(0, 5, 1)
#Assign a reference; doesn't copy the object!
listTwo = listOne
#Add element after the last position
listTwo.append(5) #-> Changes both lists
print(listOne) #-> [0, 1, 2, 3, 4, 5]
print(listTwo) #-> [0, 1, 2, 3, 4, 5]
#Remove the element in the last position
print(listOne.pop()) #-> 5
#Change element
listOne[0] = 99 #-> [99, 1, 2, 3, 4]
print(listOne[0]) #-> 99
#Access an element
print(listTwo[2]) #-> 2
# Slicing (same as strings)
# [| 0 | 1 | 2 | 3 | 4 |]
#  0   1   2   3   4   5
# -5  -4  -3  -2  -1
print(listOne[2:4]) #-> [2, 3]
print(listTwo[-4:-3]) #-> [1]
#List comprehension
M = [x for x in range(0,29) if x % 2 == 0 if x % 3 == 0]
print(M) # -> [6.12,18,24]



#A tuple is an immutable Python list; useful for passing data around the program
tuples = (1, 2, "Hello")
print(tuples[2]) #-> "Hello"
#tuples[2] = 3 #-> Error! Cannot be changed!



#Python's hash table (dictionary)

# {key1:value1, key2:value2, ...}
dict = {'1' : 'One'}
dict['2'] = 'Two'

#Get a value if you have a key
print(dict['1']) #-> "One"
#Avoid an error if there is no such key
print(dict.get('3')) #-> None

#Dict contents
print(list(dict.keys())) #-> ['1', '2']
print(list(dict.values())) #-> ['One, 'Two']
print(list(dict.items())) #-> [('1', 'One'), ('2', 'Two')]



set = set([1,1,5,6,7,8,8])
print(set)
