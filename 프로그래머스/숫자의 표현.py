def solution(n):
    # 자기 자신 경우의 수 미리 포함
    answer = 1
    # 절반 언저리 부터 시작
    k = n // 2 + 1
    flag = True
    
    while(flag):
        ssum = 0
        kk = k
        # 연속된 수의 합이 n보다 크면 중단하고 1작은수로 다시 누적합 시작
        while(ssum <= n):
            ssum += kk
            # 정답 발견하면 그만 계산하고 다음 케이스로 이동
            if ssum == n:
                answer += 1
                break
            # 끝에 1까지 찍으면 더이상 경우의 수 존재 안하므로 전체 종료
            if kk == 1:
                flag = False
                break
            kk -= 1
        k -= 1
    
    return answer