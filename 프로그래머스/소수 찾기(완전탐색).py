from itertools import permutations
# n이 소수면 True
def check(n):
    if n < 2:
        return False
    # 2로 나누어지는 약수까지만 체크하면 됨    
    for i in range(2, n//2 + 1):
        if n % i == 0:
            return False
    return True
        
def solution(numbers):
    # 중복 수를 제거하기 위한 set
    numSet = set()
    for i in range(1, len(numbers)+1):
        # 1자리, 2자리 .... 자리 수 케이스
        caseList = list(permutations(numbers, i))
        for j in range(len(caseList)):
            candidate = int("".join(caseList[j]))
            # 소수면 set에 넣어줌
            if check(candidate):
                numSet.add(candidate)
                
    return len(numSet)