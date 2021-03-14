import sys

n = int(sys.stdin.readline().strip())
exlist = list(map(int, sys.stdin.readline().strip().split()))
mannum = int(sys.stdin.readline().strip())
manlist = []

for i in range(mannum):
    manlist.append(list(map(int, sys.stdin.readline().strip().split())))

for j in range(len(manlist)):
    # 남자 경우
    if manlist[j][0] == 1:
        for k in range(len(exlist)):
            if (k + 1) % manlist[j][1] == 0:
                if exlist[k] == 0:
                    exlist[k] = 1
                else:
                    exlist[k] = 0 

    # 여자 경우
    elif manlist[j][0] == 2:
        # 나는 인덱스 0부터 시작이라 1씩 작은 인덱스 값 사용함
        k = 0
        while (manlist[j][1] - k - 2 >= 0) and (manlist[j][1] + k < len(exlist)):
            if exlist[manlist[j][1] - k - 2] == exlist[manlist[j][1] + k]:
                if exlist[manlist[j][1] - k - 2] == 0:
                    exlist[manlist[j][1] - k - 2] = 1
                    exlist[manlist[j][1] + k] = 1
                else:
                    exlist[manlist[j][1] - k - 2] = 0
                    exlist[manlist[j][1] + k] = 0
                k += 1

            else:
                break

        if exlist[manlist[j][1] - 1] == 0:
            exlist[manlist[j][1] - 1] = 1
        else:
            exlist[manlist[j][1] - 1] = 0

for i in range(n):
    print(exlist[i], end = ' ')
    if (i % 19 == 0) and (i != 0):
        print()