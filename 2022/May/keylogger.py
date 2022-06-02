n = int(input())

key_map = {
    "clank": "a",
    "bong": "b",
    "click": "c",
    "tap": "d",
    "poing": "e",
    "clonk": "f",
    "clack": "g",
    "ping": "h",
    "tip": "i",
    "cloing": "j",
    "tic": "k",
    "cling": "l",
    "bing": "m",
    "pong": "n",
    "clang": "o",
    "pang": "p",
    "clong": "q",
    "tac": "r",
    "boing": "s",
    "boink": "t",
    "cloink": "u",
    "rattle": "v",
    "clock": "w",
    "toc": "x",
    "clink": "y",
    "tuc": "z",
    "whack": " "
}

op_map = [
    "bump",
    "pop",
    "dink",
    "thumb"
]

current = ""
is_caps = False


for idx in range(n):
    op = input()

    if op in op_map:
        if op in ["bump", "dink", "thumb"]:
            is_caps = not is_caps
        else:
            current = current[:-1]
    else:
        current += key_map[op] if not is_caps else key_map[op].upper()

print(current)