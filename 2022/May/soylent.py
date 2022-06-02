import math

n = int(input())

for _ in range(n):
    cals = int(input())
    bottles = math.ceil(cals/400)
    print(bottles)