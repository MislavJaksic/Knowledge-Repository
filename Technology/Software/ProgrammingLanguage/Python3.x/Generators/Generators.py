def firstn(n):
    i = 0
    sum = 0
    while(i <= n):
        yield sum
        i = i + 1
        sum = sum + i


for i in firstn(100):
    print(i)
