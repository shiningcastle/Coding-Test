def solution(A):
    # 중복을 제거하기위해 set 사용
    checkSet = set()

    for i in range(len(A)):
        # 0, 음수는 정답과 관련 없으므로 제외
        if A[i] >= 1:
            checkSet.add(A[i])
    # set를 list로 변환해 sort 함수로 정렬        
    answer = list(checkSet)
    answer.sort()
    
    for i in range(len(answer)):
        # i+1은 1부터 1씩 증가하므로 중간에 없으면 그때 i+1이 존재하지 않는 제일 작은 양의 정수
        if answer[i] != i+1:
            return i+1
    # 위의 반복문을 다 돌아도 없으면 중간에 빠진 양의 정수가 없는 것이므로 다음 큰 수가 답    
    return len(answer) + 1