import string

def solution(S):
    letters, digits = string.ascii_letters, string.digits
    maxLength = 0
    lis = S.split()

    for l in lis:
        lcount, dcount = 0, 0
        for char in l:
            if char in letters:
                lcount += 1
            elif char in digits:
                dcount += 1
            else:
                flag = False
                break

        if flag and lcount % 2 == 0 and dcount % 2 != 0:
            if len(l) > maxLength:
                maxLength = len(l)

    if maxLength == 0:
        return -1
        
    return maxLength