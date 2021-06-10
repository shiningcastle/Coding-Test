def solution(A, B, K):
    leftEqual = False

    if A % K == 0:
        leftEqual = True

    if leftEqual:
        return B//K - A//K + 1
    else:
        return B//K - A//K