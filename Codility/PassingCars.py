def solution(A):
    # 총 몇쌍
    ssum = 0
    # 0인 차의 숫자
    same = 1
    # 만약 0 값인 차 한대도 없으면 답은 0
    if A.count(0) == 0:
        return 0
    # 가장 최근에 나온 0값 차의 위치부터 시작
    else:
        standard = A.index(0)

    for i in range(standard + 1, len(A)):
        # 합이 1억이상이면 반복 중단하고 -1 리턴
        if ssum > 1000000000:
            return -1
        # (0, 1) 쌍인 경우 카운트, +1에 0인 차의 대수만큼 곱해서 더해준다
        if A[standard] != A[i]:
            ssum += (1 * same)
        # 0값인 차 발견하면 곱하는 수 + 1
        else:
            same += 1
    
    return ssum