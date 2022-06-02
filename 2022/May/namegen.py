from random import randint

n = int(input())

consonants = [
    "b",
    "c",
    "d",
    "f",
    "g",
    "h",
    "j",
    "k",
    "l",
    "m",
    "n",
    "p",
    "q",
    "r",
    "s",
    "t",
    "v",
    "w",
    "x",
    "y",
    "z"
]

vowels = [
    "a",
    "e",
    "i",
    "o",
    "u"
]


for _ in range(n):
    name = ""
    for idx in range(20):
        if idx % 2 == 0:
            name += consonants[randint(0, len(consonants) - 1)]
        else:
            name += vowels[randint(0, len(vowels) - 1)]

    print(name)