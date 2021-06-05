from itertools import combinations
# 소수 판별 함수
def primeNumber(n):
    if n == 0 or n == 1:
        return False
    
    for i in range(2, (n // 2) + 1):
        if n % i == 0:
            return False
        
    return True
    
def solution(nums):
    # 3개 숫자 조합 모든 경우의 수 튜플 리스트로
    case = list(combinations(nums, 3))
    result = 0
    for t in case:
        if primeNumber(sum(t)):
            result += 1
    
    return result