from collections import deque

def solution(bridge_length, weight, truck_weights):
    answer = 0
    # 다리 위에 존재하는 트럭의 무게와 거리 정보
    on_bridge = [deque([]), deque([])] # 무게, 거리
    # truck_weights를 deque로 바꿔서 사용
    before_bridge = deque(truck_weights)

    # 대기트럭이 존재하지 않고 다리 위에도 트럭이 없을 때까지 반복
    while len(before_bridge) != 0 or len(on_bridge[0]) != 0:

        # 경과시간 1초씩 증가
        answer += 1

        # 맨 처음에 on_bridge[1][0]가 없어서 answer != 1해서 에러 안뜨게
        # 다리 위의 트럭들 중 맨 앞의 트럭의 거리가 다리 길이와 같으면 맨 앞 트럭은 지난 트럭
        # 동시에 여러 트럭이 다리를 지날 일은 없어서 맨 앞에 트럭만 검사
        if answer != 1 and on_bridge[1][0] == bridge_length:
            on_bridge[0].popleft()
            on_bridge[1].popleft()

        # 무게가 여유있어 다리에 트럭을 추가하는 경우
        # 대기 트럭이 존재하고 다리 위 트럭들 무게 합 + 대기 트럭 무게 합이 
        # 다리 무게 제한보다 작을 때만 추가
        if len(before_bridge) != 0 and sum(on_bridge[0]) + before_bridge[0] <= weight:
            # 무게, 거리 = 0 입력
            on_bridge[0].append(before_bridge.popleft())
            on_bridge[1].append(0)

        # 매 턴마다 모든 트럭 거리 1씩 증가
        # 트럭들 거리 정보 리스트에 모든 원소 1씩 더해서 다시 저장
        on_bridge[1] = deque(map(lambda x: x+1, on_bridge[1]))

    return answer