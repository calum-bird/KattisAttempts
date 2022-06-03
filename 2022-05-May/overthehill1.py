n = int(input())

matrix = []
for _ in range(n):
    nums = [int(x) for x in input().split(" ")]
    matrix.append(nums)

plaintext = input()
vector = []
for ch in plaintext:
    val = ord(ch)
    if(val >= 48 and val <= 57):
        val = val-48+26
    elif(val >= 65 and val <= 90):
        val = val-65
    else:
        val = 36

    vector.append(val)

text_matrix = []
vec_len = len(vector)
min_length = vec_len + (n - (vec_len % n)) if (vec_len % n != 0) else vec_len
diff = min_length - vec_len

# Append spaces as necessary
if(vec_len < min_length):
    for _ in range(diff):
        vector.append(36)

for idx in range(min_length):
    if(idx % n == 0):
        text_matrix.append(vector[idx: idx+n])

result_matrix = []
for idx in range(len(text_matrix)):
    vec = text_matrix[idx]

    result_vec = []
    for j in range(n):
        mult = matrix[j]
        result = 0
        for i in range(n):
            result += (vec[i] * mult[i])
        result_vec.append(result % 37)
    result_matrix.append(result_vec)

encoded = ""
for i in range(len(text_matrix)):
    for j in range(n):
        val = result_matrix[i][j]
        if(val == 36):
            encoded += " "
        elif(val >= 26 and val <= 35):
            val = val+48-26
            encoded += chr(val)
        elif(val >= 0 and val <= 26):
            val = val+65
            encoded += chr(val)

print(encoded)