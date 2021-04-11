def solution(s):
    count = 0
    
    for c in s:
        if c == "p" or c == "P":
            count += 1
        elif c == "y" or c == "Y":
            count -= 1
    
    if count == 0:
        return True
    else:
        return False