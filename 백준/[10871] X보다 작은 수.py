jungsu = input().split()
sy = input().split()

N = int(jungsu[0])
X = int(jungsu[1])

answer = []

for i in range(N):
    if int(sy[i]) < X:
        answer.append(int(sy[i]))
        
for j in range(len(answer)):
    print(str(answer[j]), end = ' ')