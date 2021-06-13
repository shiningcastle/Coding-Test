def solution(A):
    current = 0
    maximum = -1000000

    for a in A:
        # 누적합 계산
        nextSum = current + a
        # 최대 값보다 크면 최대값 갱신
        if nextSum > maximum:
            maximum = nextSum
        # 중간에 음수로 떨어지면 뒤에가 양수든 음수든 누적합 안하고 안더해주고 새로 시작(0으로)
        if nextSum > 0:
            current = nextSum
        else:
            current = 0

    return maximum