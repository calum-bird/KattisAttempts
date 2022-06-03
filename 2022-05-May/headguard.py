import sys

printed_string = ""
for line in sys.stdin:
    if(line is None or line == "" or line == "" or line == "\n"):
        break

    line_str = ""
    prev_ch = line[0]
    counter = 1
    for ch in line[1:]:
        if(ch == "\n"):
            continue

        if(ch != prev_ch):
            line_str += str(counter) + str(prev_ch)
            counter = 1
            prev_ch = ch
        else:
            counter += 1
    
    if(counter != 0):
        line_str += str(counter) + str(prev_ch)

    print(line_str)