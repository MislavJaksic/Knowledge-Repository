#Python's hash table
# {key1:value1, key2:value2, ...}
dict = {'1' : 'One'}
dict['2'] = 'Two'
#Get a value if you have a key
print dict['1'] #-> "One"
#Avoid an error if there is no such key
print dict.get('3') #-> None
#Dict contents
print dict.keys() #-> ['1', '2']
print dict.values() #-> ['One, 'Two']
print dict.items() #-> [('1', 'One'), ('2', 'Two')]

