import math

(x1, y1, x2, y2) = (float(x) for x in input().split(" "))

res = (x2-x1) * (y2-y1)

print(abs(res))