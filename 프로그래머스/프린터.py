from collections import deque

def solution(priorities, location):
    lis = deque()
    count = 0
    # 우선순위 값이 인덱스보다 앞으로 오게해서 아래 max에서 우선순위 높은게 뽑히도록 함
    for i, v in enumerate(priorities):
        lis.append((v, i))
    
    first = max(lis)[0]
    while True:
        # 출력 최우선순위인 경우. 출력확정
        if lis[0][0] == first:
            count += 1
            # 출력확정된 것이 목표 타겟인 경우 여태까지 출력수 반환
            if lis[0][1] == location:
                return count
            # 출력된 것은 큐에서 삭제해주고 다시 최우선순위 값 구함
            lis.popleft()
            first = max(lis)[0]
        # 출력 최우선순위가 아닌 경우. 큐 앞에서 빼준 것을 뒤에 다시 넣어줌
        else:
            lis.append(lis.popleft())