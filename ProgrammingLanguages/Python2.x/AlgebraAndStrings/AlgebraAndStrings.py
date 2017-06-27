#Normal division
print 6/5 #-> 1
#Float division (at least one needs to be float)
print 6.0 / 5 #-> 1.2
#Precise division
print 1.0/3 - 0.33333333 #-> small number, not zero
#Data types exist in Pyhon, but they don't have to be explicitly declared
int(5)
long(5)
float(5)
complex(5, 5)

#Exponentiation
print 2 ** 10 #-> 1024
#Divide and truncate (floor division)
print 15 // 4
#Modulo
print 15 % 2 #-> 1
#Boolean operations
print False or True #-> True
print False and True #-> False
print not False #-> True
print None

#Assignment
#a points at 5
a = 5
#b points where a points (b points at 5)
b = a
#Assignment changes what you point at, not what is stored at that point
b = 6
print a #-> 5
print b #-> 6

#Strings
c = "String"
#String length
print len(c) #-> 6
#Won't change the string becuase they are immutable
c.replace("g","") #-> "Strin"
print c #-> "String"

#String is an array of characters
print c[1] #-> "t"
# Slicing arrays
# +---+---+---+---+---+---+
# | S | t | r | i | n | g |
# +---+---+---+---+---+---+
# 0   1   2   3   4   5   6
#-6  -5  -4  -3  -2  -1
#The numbers are between the letters
print c[2:4] #-> "ri"
print c[-2:] #-> "ng"

#Data conversion
d = 55
d = str(d)
d = int(d)
d = float(d)

