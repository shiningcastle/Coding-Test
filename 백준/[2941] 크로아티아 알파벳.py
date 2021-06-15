alphabet = input()
croatia = ["c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="]
count = 0
idx = 0

while idx < len(alphabet):
    if idx == len(alphabet) - 1:
        count += 1
        break
    if alphabet[idx:idx+3] == "dz=":
        idx += 3
    elif alphabet[idx:idx+2] in croatia:
        idx += 2
    else:
        idx += 1
    count += 1

print(count)