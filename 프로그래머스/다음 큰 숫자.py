def solution(n):
    nstr = bin(n)[2:]
    nOneCount = nstr.count("1")
    candidate = n + 1
    
    while(True):
        # 조건2 체크
        cstr = bin(candidate)[2:]
        cOneCount = cstr.count("1")
        if cOneCount != nOneCount:
            candidate += 1
            continue
            
        return candidate