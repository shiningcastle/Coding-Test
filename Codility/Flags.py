import math

def solution(A):
    # 배열이 3보다 작은 경우는 peak를 구할 수 없으므로 0 return
    if len(A) < 3:
        return 0
	
	# peak인 index를 담는 list
    peak = []
    for i in range(1, len(A)-1):
        if A[i] > A[i-1] and A[i] > A[i+1]:
            peak.append(i)
	
    # peak가 2개 이하인 경우는 바로 return
    if len(peak) < 3 :
        return len(peak)
	
    # 제일 처음 peak와 끝 peak 사이에 최대한 깃발을 꽂을 수 있는 갯수
    maxflag = int(math.sqrt(peak[-1]-peak[0]))+1
    
    # 제일처음 peak에서부터 조건을 비교하면서, count로 체크한 후 flag 수(f)를 return
    for f in range(maxflag, 2, -1):
        count = 1
        p = peak[0]
        for i, pe in enumerate(peak):
            if f <= pe-p:
                count += 1
                p = pe
            
        if count >= f:
            break

    return f