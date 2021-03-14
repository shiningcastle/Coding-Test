import math

def solution(n,a,b):
    # n이 2의 몇승인지 2 ** num = n
    num = 0
    # 만날 때까지 총 경기 수
    count = 0
    # num = 최다 경기 수 
    while True:
        num += 1
        if math.pow(2, num) == n:
            break
    # (1, 2), (3, 4).... 같은 경기 뛰는 숫자 쌍의 법칙은 -(-X // 2) 했을때 같은 수
    for i in range(num):
        a = - (-a // 2)
        b = - (-b // 2)
        count += 1

        if a == b:
            break

    return count