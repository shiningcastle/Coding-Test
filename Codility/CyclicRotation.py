def solution(A, K):
    length = len(A)
    restList = []
    # 빈 리스트 오는 경우 제외
    if length == 0:
        return []
        
    for i in range(K):
        spareList = []
        spareList.append(A[-1])
        restList = A[:length-1]
        A = spareList + restList
    
    return A