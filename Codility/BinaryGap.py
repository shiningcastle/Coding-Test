def solution(N):
    binaryNum = bin(N)[2:]
    oneList = []
    maxNum = 0
    for i in range(len(binaryNum)):
        if binaryNum[i] == "1":
            oneList.append(i)

    for i in range(1, len(oneList)):
        gap = oneList[i] - oneList[i-1] - 1
        if gap > maxNum:
            maxNum = gap
            
    return maxNum 