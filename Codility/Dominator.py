from collections import Counter 

def solution(A):
    counter = Counter(A)
    
    if len(A) == 0:
        return -1
        
    dominator = counter.most_common(1)[0][0]

    if A.count(dominator) > len(A) / 2:
        return A.index(dominator)
    else:
        return -1