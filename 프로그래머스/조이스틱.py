def solution(name):
    # 미리 각 문자별 위아래 움직이는 횟수 구해놓음
    change = [min(ord(n) - ord('A'), ord('Z') - ord(n) + 1) for n in name]
    idx = 0
    answer = 0
    
    while True:
        answer += change[idx]
        # 체크한 문자별 움직이는 횟수 값은 A의 값 0으로 변경
        change[idx] = 0
        # A만 있는 경우에 정답 반환
        if sum(change) == 0:
            return answer
        # A를 덜만나는 쪽 방향으로 계속 나아감    
        left, right = 1, 1
        while change[idx - left] == 0:
            left += 1
        while change[idx + right] == 0:
            right += 1
        # 커서값 정답에 더해주고, 현재 인덱스도 위치 갱신    
        answer += left if left < right else right
        idx += -left if left < right else right