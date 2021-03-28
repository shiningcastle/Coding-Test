time = input().split()
H = int(time[0])
M = int(time[1])

if (M - 45) >= 0:
    M = M - 45

else:
    M = (60 - 45) + M
    H = H - 1
    if H == -1:
        H = 23

print(H, M)