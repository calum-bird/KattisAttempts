greeting = input()

e_count = 0
for char in greeting:
    if char == "e":
        e_count += 1

print("h" + "e"*e_count*2 + "y")