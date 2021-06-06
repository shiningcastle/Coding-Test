def solution(A):
    # 정렬이 핵심!
    A.sort()
    for i in range(0, len(A), 2):
        # 길이 1 리스트 오는 경우
        if len(A) == 1:
            return A[0]
        # 맨 마지막 원소 앞까지 통과하면 마지막이 답
        if i == len(A) - 1:
            return A[i]
        # 중간에 앞, 뒤 짝이 다른경우 무조건 앞의 원소가 답
        # 정렬을 했기 때문이다.
        elif A[i] != A[i+1]:
            return A[i]