def solution(A):
    minimum = (A[0] + A[1]) / 2
    answer = 0
    # 두개씩 Slice
    for i in range(1, len(A)-1):
        twoAverage = (A[i] + A[i+1]) / 2
        if twoAverage < minimum:
            minimum = twoAverage
            answer = i
	# 세개씩 Slice
    for i in range(len(A)-2):
        threeAverage = (A[i] + A[i+1] + A[i+2]) / 3
        if threeAverage < minimum:
            minimum = threeAverage
            answer = i
    
    return answer