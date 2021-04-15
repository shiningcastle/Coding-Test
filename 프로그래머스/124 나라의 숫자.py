def solution(n):
    soo = "124"
        
    if n <= 3:
        return soo[(n-1) % 3] 
    
    else:
        quo, rem = divmod((n-1), 3)
        return solution(quo) + soo[rem]