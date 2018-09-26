i = 0
if i != 0:
  x = False
else:
  print "Zero is treated as False."
  
i = -1
if i:
  print "Any other number is treated as True."
elif i == 5:
  pass
  
while False:
  print "Never executes"
  
list = [0, 1, 2, 3, 4, 5]
for number in list: #-> 1 2 3 4 5
  print number,
  
#range(<integer>) creates a list [0, ..., <integer - 1>]
for i in range(3): #-> 0 1 2
  print i,
else:
  print
  print "When a for loop exhaust the list, it will execute the else condition."
  
#continue skips to the next loop iteration
#break exits the innermost loop or if statement
