def solution(n):
    lis = list(str(n))
    lis.sort()
    lis.reverse()
    return int(''.join(lis))