def solution(n):
    count = 0
    # 범위를 n+1 까지 해주어야 함 (0번째 인덱스 무시하고 1번째부터 숫자 1이라고 가정)
    lis = [False for i in range(n+1)]
    # 리스트 생성을 n까지 하면 for문 range(1, n)이 되어 에라토스테네스 체(배수 삭제) 사용 어려움
    # 소수는 2부터 n까지(인덱스는 +1 해야 맞음) 세기
    for i in range(2, n+1):
        # false일 경우에만 소수 카운트
        if lis[i] == False:
            count += 1
        # 에라토스테네스의 체로 해당 턴 숫자의 배수들(인덱스)은 true로 바꿔 다음 루프에서 카운트 안되고 지나가게 함
        # i씩 더해줌 = i의 배수 
        for j in range(i*2, n+1, i):
            lis[j] = True
    return count



