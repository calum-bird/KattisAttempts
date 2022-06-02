n = int(input())

diff = 100 - n%100

if(n < 149):
    print(99)
else:
    if(diff == 0):
        print(n-1)
    elif(diff > 51):
        print(n - (n%100) - 1)
    else:
        print(n + diff - 1)