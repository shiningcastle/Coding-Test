def solution(A):
    length = len(A)
    leftSum = [0 for i in range(length)]
    rightSum = [0 for i in range(length)]
    maximum = 0

    for i in range(1, length-1):
        leftSum[i] = max(0, leftSum[i-1] + A[i])
    
    for i in range(length-2, 0, -1):
        rightSum[i] = max(0, rightSum[i+1] + A[i])

    for i in range(1, length-1):
        maximum = max(maximum, leftSum[i-1] + rightSum[i+1])
    
    return maximum