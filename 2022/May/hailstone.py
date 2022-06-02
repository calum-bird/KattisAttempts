n = int(input())
seq = [n]

cont = True
while(cont):
    if(n == 1):
        cont = False

    if(n % 2 == 0):
        n = n/2
    else:
        n = (n*3) + 1
    
    seq.append(n)

print(len(seq) - 1)