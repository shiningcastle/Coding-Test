def solution(n):
    
    fibo = [0] * (n + 1)
    fibo[1], fibo[2] = 1, 2
    
    for i in range(3, n + 1):
        fibo[i] = (fibo[i-1] + fibo[i-2]) % 1234567
    
    return fibo[n]