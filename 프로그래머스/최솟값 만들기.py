def solution(A,B):
    answer = 0
    
    # 두 리스트를 오름차순으로 정렬해줌
    A.sort()
    B.sort()
    
    # 몇개의 경우를 손으로 계산해보니 가장 큰수가 가장 작은수와 곱해질 때 제일 결과값이 작아보였음
    # a는 처음 원소부터 b는 마지막 원소부터 차례대로 뽑아와 서로 곱해주고 
    # answer에 누적 합 해줌
    for i in range(0, len(A)):
        answer += A[i] * B[len(A)-i-1]

    return answer