#Normal division
print 6/5 #-> 1
#Float division (at least one needs to be float)
print 6.0 / 5 #-> 1.2
#Precise division
print 1.0/3 - 0.33333333 #-> small number, not zero
#Exponentiation
print 2 ** 10 #-> 1024
#Modulo
print 15 % 2 #-> 1
#Boolean operations
print False or True #-> True
print False and True #-> False
print not False #-> True

#Referencing and pointing
#a points at 5
a = 5
#b points where a points
b = a
print b #-> 5
#Assignment changes what you point at, not what is stored at that point
b = 6
print a #-> 5
print b #-> 6
a = 5
b = a
a = 6
print b #-> 5

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

