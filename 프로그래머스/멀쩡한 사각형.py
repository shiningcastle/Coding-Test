# 최대 공약수 구하기
def gcd(a, b):
    if b > a:
        a, b = b, a
    while b > 0:
        a, b = b, a % b
    return a

def solution(w,h):
    return (w * h) - (w + h - gcd(w,h)) 