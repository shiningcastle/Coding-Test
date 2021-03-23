import sys
inp = sys.stdin.readline

n = int(inp())
answer = 0

# 계속 5로 나눠지는지 체크하고 안되면 3씩 계속 빼줌 (n이 3이상이라 예외없이 가능)
while n >= 0:
    # n이 5로 나누어져도 여기로 빠지고, 0이 되어도 여기로 
    if n % 5 == 0:
        answer += (n // 5)
        print(answer)
        break
    n -= 3
    answer += 1
	
    # n이 0으로 안떨어지고 넘어가서 음수되면 루프 탈출해서 -1 출력
    if n < 0:
        print(-1)
        break