def solution(s):
    count = 0
    
    for _ in s:
        if count < 0:
            return False
        
        if _ == "(":
            count += 1
        else:
            count -= 1
    
    if (count == 0):
        return True
    else:
        return False