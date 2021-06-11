def solution(A):
    A.sort()

    case1 = A[0] * A[1] * A[-1]
    case2 = A[-3] * A[-2] * A[-1]

    return max(case1, case2)