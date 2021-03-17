def solution(m, n, puddles):

    # 인덱스는 0부터 시작하지만 문제 좌표는 1,1 부터 시작하므로
    # 그리고 해당 칸의 최적 경로 수는 왼쪽 칸과 위쪽 칸의 수를 더한 수인데
    # 맨 왼쪽과 맨 위쪽 칸들은 더해줄 것이 없는 부분은 0으로 해주기 위해
    # 사이즈 1씩 더 크게 만들어 줌
    path = [ [0 for i in range(m+1)] for j in range(n+1)] 
    
    # 집이 있는 곳 최소 경로 1로 시작
    path[1][1] = 1

    for i in range(1, n+1):
        for j in range(1, m+1):

            # 집 위치는 계산 필요 없음
            if i == 1 and j == 1:
                continue
            # 해당 위치가 침수 지역일 경우 0으로 남겨둠
            # 여기 인접 칸은 0이 더해져서 경로 수에 추가 안됨
            if [j, i] in puddles:
                continue
            # 해당 칸까지의 최적 경로 수는
            # 해당 칸의 왼쪽 칸과 위쪽 칸의 최적 경로 수의 합    
            path[i][j] = path[i-1][j] + path[i][j-1]

    return path[n][m] % 1000000007