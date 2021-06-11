def solution(A):
    lis = []
    for i, a in enumerate(A):
        lis.append((i, a))

    lis.sort(key = lambda x : x[1])

    for i in range(len(lis)-2):
        if lis[i][1] + lis[i+1][1] > lis[i+2][1]:
            return 1
        
    return 0