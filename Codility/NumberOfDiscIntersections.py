def solution(A):
    lis = []
    
    for i, a in enumerate(A):
        # -1은 왼쪽 원의 끝, +1은 오른쪽 원의 끝
        lis.append((i-a, -1))
        lis.append((i+a, 1))
    # 가장 왼쪽 기준(음수)에서 시작    
    lis.sort()
    # 교집합 수
    intersect = 0
    # 아직 열려있는 원(카운트 중인)의 수
    opened = 0
    
    for i in range(len(lis)):
        # 원의 오른쪽 끝 좌표만나면 열린 원의 개수 차감
        if lis[i][1] == 1:
            opened -= 1
        # 열린 원의 수만 큼 중첩해서 교집합 수 카운트
        # 원의 왼쪽 끝 좌표만나면 열린 원의 개수 증가
        if lis[i][1] == -1:
            intersect += opened
            opened += 1
    # 천만개 초과시에 -1 반환처리
    if intersect > 10000000:
        return -1
    
    return intersect