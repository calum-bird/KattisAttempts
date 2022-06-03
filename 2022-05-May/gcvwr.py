(g, t, n) = [int(x) for x in input().split(" ")]

items = [int(x) for x in input().split(" ")]

leftover = (g-t)*0.9

for i in range(n):
    leftover -= items[i]

print(int(leftover))