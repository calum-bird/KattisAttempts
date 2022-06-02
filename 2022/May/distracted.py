nums = [int(x) for x in input().split(" ")]

n = nums[0]
l = nums[1]

people = {}
for _ in range(n):
    (name, status) = input().split(" ")
    people[name] = status

did_break = False
unknown = False
for _ in range(l):
    (person1, person2) = input().split(" -> ")
    if(people[person1] == "m" and people[person2] == "u"):
        print(1)
        did_break = True
        break
    elif(people[person2] == "?"):
        unknown = True
    else:
        unknown = False

if not did_break:
    if unknown:
        print("?")
    else:
        print(0)