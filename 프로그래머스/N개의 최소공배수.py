def gcd(a, b):
    while b > 0:
        a, b = b, a % b
    return a

def solution(arr):
    # a가 b보다 크게 넣어줘야 하므로 먼저 정렬해주기
    arr.sort()
    arr.reverse()
    answer = arr[0]
    
    for i in range(1, len(arr)):
        answer = (answer * arr[i]) // gcd(answer, arr[i])
    
    return answer