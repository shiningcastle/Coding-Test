def solution(N, A):
    answer = [0] * N
    maximum = 0
    activateMax = 0
    for i in range(len(A)):
        if A[i] != N+1:
            if answer[A[i]-1] < activateMax:
                answer[A[i]-1] = activateMax
            answer[A[i]-1] += 1
            if answer[A[i]-1] > maximum:
                maximum = answer[A[i]-1]
        else:
            activateMax = maximum

    for i in range(len(answer)):
        if answer[i] < activateMax:
            answer[i] = activateMax

    return answer