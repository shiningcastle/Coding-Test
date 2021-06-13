def solution(A):
    maxProfit = 0
    minStock = A[0]
    # 길이 0인 케이스 처리
    if len(A) == 0:
        return 0
    
    for a in A[1:]:
        if a < minStock:
            minStock = a
        else:
            profit = a - minStock
            if maxProfit < profit:
                maxProfit = profit

    return maxProfit