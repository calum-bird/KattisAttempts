# I like this problem! A well-disguised binary search!

import math

r = int(input())
max_bottles = r*85
min_bottles = 0

guess = r
print(guess)

day = 2
while True:
    response = input()

    if(response == "less"):
        max_bottles = guess
    elif(response == "more"):
        min_bottles = guess
    else:
        break
    
    guess = math.ceil((max_bottles + min_bottles)/2)
    print(guess*day)
    day += 1