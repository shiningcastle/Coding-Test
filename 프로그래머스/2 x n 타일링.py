def solution(n):
    
    # 피보나치 수열 계산 시간 줄이기 DP
    d = [0 for i in range(n+1)]
    # 피보나치 수 1, 2일 때
    d[1], d[2] = 1, 2 

    # 피보나치 수 n에 도달할 때까지 모두 다 계산
    for i in range(3, n+1):
        d[i] = (d[i-1] + d[i-2]) % 1000000007
    
    return d[n]


# 정확도는 다 맞았지만 시간 복잡도를 초과 판정 받은 풀이
import math

def solution(n):
    # 직사각형 세워서 다 채우는 경우 1가지 카운트 
    answer = 1
    # n을 2로 나눈 몫, 나머지
    quo, rem = divmod(n, 2)
    
    # 2로 나눈 몫 1부터 quo까지 경우의 수 계산해서 더해줌
    for i in range(1, quo+1):
        res = n - (2*i)
        answer += math.factorial(i+res) // ( math.factorial(i) * math.factorial(res) ) % 1000000007
    
    return answer