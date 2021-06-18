def solution(clothes):
    dic = dict()
    answer = 1
    for c in clothes:
        if c[1] in dic:
            dic[c[1]] += 1
        else:
            dic[c[1]] = 1
            
    for value in dic.values():
        answer *= (value + 1)
        
    return answer - 1