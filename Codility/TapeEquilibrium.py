def solution(A):
    minimum = 0
    pieceSum = 0
    totalSum = sum(A)
    for i in range(len(A)-1):
        pieceSum += A[i]
        absolute = abs(pieceSum - (totalSum - pieceSum))
        # 첫 절대값을 일단 최소값으로 지정
        if i == 0:
            minimum = absolute
        # 비교해서 최소값 갱신
        if absolute < minimum:
            minimum = absolute

    return minimum