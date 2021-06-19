def solution(A, B):
    n = len(A)
    lis = []
    # 길이가 0, 1인 경우는 아래 코드에서 처리 못함
    if n == 0:
        return 0
    elif n == 1:
        return 1
    # 시작, 끝 위치를 튜플로 묶어서 리스트에 넣어줌
    for a, b in zip(A, B):
        lis.append((a, b))
    # 먼저 끝점 기준 그 다음으로 시작점 기준으로 정렬
    lis.sort(key = lambda x : (x[1], x[0]))
    # 처음 스타트 줄
    end = lis[0][1]
    count = 1
	# 끝 점이 다음 줄의 시작 점보다 작으면 조건 만족
    for i in range(1, n):
        if end < lis[i][0]:
            end = lis[i][1]
            count += 1
    
    return count