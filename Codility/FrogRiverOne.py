def solution(X, A):
    # A의 위치 값들의 중복을 제거하기 위한 set 선언
    check = set()
    for i in range(len(A)):
        check.add(A[i])
        # 도중에 check의 길이가 X와 같아지면 모든 나뭇잎이 채워졌으므로 i=시간초 반환
        if len(check) == X:
            return i
    # for문을 다 돌았는데도 함수가 안끝났으면 못가는 케이스이므로 -1 반환        
    return -1