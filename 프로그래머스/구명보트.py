from collections import deque

def solution(people, limit):
    answer = 0
    # 효율성 검사 때문에 deque 사용
    # deque는 sort 불가능이라 people을 sort한후 deque에 넣어줌
    people.sort()
    queue = deque(people)

    # 모든 사람이 구조될 때까지 반복
    while queue:
        # 만약 가장 큰 몸무계의 사람이 limit의 절반 이하라면
        # 그후론 쭉 두명씩 탈 수 있음
        if queue[-1] <= limit // 2:
            # 남은 사람들이 짝수
            if len(queue) % 2 == 0:
                answer += len(queue) // 2
                break
            # 남은 사람들이 홀수
            else:
                answer += len(queue) // 2 + 1
                break
        # 가장 몸무계가 큰 사람과 가장 작은 사람의 합이 limit 이하일 때
        # 두 사람 다 리스트에서 제외 (남은게 한명일 때 자기 자신과 더해지므로 예외처리)
        if queue[-1] + queue[0] <= limit and len(queue) != 1:
            queue.pop()
            queue.popleft()
            answer += 1
        # 둘 다 못타면 가장 무거운 사람 혼자 구조
        else:
            queue.pop()
            answer += 1

    return answer