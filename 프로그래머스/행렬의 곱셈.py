def solution(arr1, arr2):
    answer = []
    # 첫번째 행렬의 행의 개수만큼 반복
    for i in range(len(arr1)):
        lis = []
        # 두번째 행렬의 열의 개수만큼 반복
        for j in range(len(arr2[0])):
            ssum = 0
            # 각 행렬의 곱할 원소들은 첫번째 행렬의 열의 인덱스 = 두번째 행렬의 행의 인덱스
            for k in range(len(arr1[i])):
                ssum += arr1[i][k] * arr2[k][j]
            lis.append(ssum)
        answer.append(lis)
            
    return answer