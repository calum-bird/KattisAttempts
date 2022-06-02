n = int(input())

plaintext = input()
plain_vector = []
for ch in plaintext:
    val = ord(ch)
    if(val >= 48 and val <= 57):
        val = val-48+26
    elif(val >= 65 and val <= 90):
        val = val-65
    else:
        val = 36

    plain_vector.append(val)

encoded = input()
enc_vector = []
for ch in encoded:
    val = ord(ch)
    if(val >= 48 and val <= 57):
        val = val-48+26
    elif(val >= 65 and val <= 90):
        val = val-65
    else:
        val = 36

    enc_vector.append(val)

# Pain. Not happening tonight.

print(plain_vector)
print(enc_vector)