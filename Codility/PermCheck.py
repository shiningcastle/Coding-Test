def solution(A):
    length = len(A)
    # A 길이 만큼의 체크 리스트를 선언하고 등장한 수 체크
    checkList = [False for i in range(length)]
    
    for i in range(length):
        # 1~N까지라 리스트 길이보다 큰 값이오면 어차피 수열 범위 밖이라 제외 
        if A[i] <= length:
            checkList[A[i]-1] = True
    # 중간에 False 값이 하나라도 남아있으면 수열 성립 안함
    if checkList.count(False) != 0:
        return 0
    else:
        return 1