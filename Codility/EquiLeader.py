def solution(A):
    lDic = {}
    rDic = {}
    
    lDic[A[0]] = 1
    leader = 0 
    lmax = A[0]
    
    for n in A[1:]:
        if n in rDic:
            rDic[n] += 1
        else:
            rDic[n] = 1
    
    for i in range(1, len(A)):
        if lDic[lmax] > i/2 and lmax in rDic and rDic[lmax] > (len(A)-i)/2:
            leader += 1
        elif lDic[A[i-1]] > i/2 and A[i-1] in rDic and rDic[A[i-1]] > (len(A)-i)/2:
            leader += 1
            lmax = A[i-1]

        rDic[A[i]] -= 1
        
        if A[i] in lDic:
            lDic[A[i]] += 1
        else:
            lDic[A[i]] = 1
            
    return leader