s = input()

for (idx, char) in enumerate(s):
    if char == "a":
        print(s[idx:])
        break