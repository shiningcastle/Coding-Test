def solution(A):
    # 이미 카운트된 숫자인지 체크할 딕셔너리. 리스트보다 조회가 빨라서 사용했다.
    dic = {key : 0 for key, value in dict.fromkeys(A).items()}
    count = 0
    for i in range(len(A)):
        # 이미 앞에서 나온 수는 카운트 안하고 다음으로 넘어감
        if dic.get(A[i]) != 0:
            continue
        # 새로 나온 숫자와 그 반대 부호 수는 딕셔너리에서 value를 1로 해주고 개수 카운트    
        else:
            dic[A[i]], dic[-A[i]] = 1, 1
            count += 1

    return count