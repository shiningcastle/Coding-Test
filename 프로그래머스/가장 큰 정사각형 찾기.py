def solution(board):
    rowLength = len(board)
    colLength = len(board[0])
    dp = [[0] * colLength for _ in range(rowLength)]
    # dp 이차원 배열의 첫행과 첫열을 board와 똑같게 바꿔줌
    dp[0] = board[0]
    for i in range(1, rowLength):
        dp[i][0] = board[i][0]
    # board에서 해당 위치가 1이면 dp 행렬에서 왼쪽, 위쪽, 대각선 위쪽의 원소들의 최소값 + 1이
    # 만들 수 있는 정사각형 개수
    for i in range(1, rowLength):
        for j in range(1, colLength):
            if board[i][j] == 1:
                dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1
    # 만들 수 있는 최대 크기의 정사각형 길이 찾기    
    maxLength = 0
    for i in range(rowLength):
        maxLength = max(maxLength, max(dp[i]))
        
    return maxLength ** 2