#Vector in mathematics notation
#Lists in Python syntax

#S = {x² : x in {0 ... 9}}
S = [x**2 for x in range(10)]
print S # -> [0, 1, 4, 9, 16, 25, 36, 49, 64, 81]

#M = {x | x in S and x even}
M = [x for x in S if x % 2 == 0]
print M # -> [0, 4, 16, 36, 64]