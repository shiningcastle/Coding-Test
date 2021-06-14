import math

def solution(N):
    count = 0
    # 제곱 수의 정수 범위까지만 탐색
    for n in range(1, int(math.sqrt(N))+1):
        # 약수인 경우
        if N % n == 0:
            # 자기 자신이 약수 짝인 경우 +1만 카운트
            if n ** 2 == N:
                count += 1
            else:
                count += 2

    return count