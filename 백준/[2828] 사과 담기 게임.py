import sys
inp = sys.stdin.readline

n, m = map(int, inp().split())
j = int(inp())

lis = []
answer = 0
# 바구니 시작과 끝 위치
start = 1
end = m

# 사과 떨어지는 위치들 리스트에 넣어줌
for i in range(j):
    lis.append(int(inp()))

for i in range(len(lis)):
    # 사과 떨어지는 위치가 바구니 범위 안에 있으면 움직이지 않음
    if lis[i] >= start and lis[i] <= end:
        continue
    # 사과 떨어지는 위치가 바구니 왼쪽보다 앞일 때
    if lis[i] < start:
        answer += start-lis[i]
        end -= start-lis[i]
        start = lis[i]
    # 사과 떨어지는 위치가 바구니 오른쪽보다 뒤일 때
    else:
        answer += lis[i]-end
        start += lis[i]-end
        end = lis[i]

print(answer)