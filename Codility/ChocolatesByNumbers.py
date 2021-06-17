def solution(N, M):
    # 최대 공약수 구하기
    a, b = N, M
    while b > 0:
        a, b = b, a % b
	# a는 최대 공약수
    return N // a