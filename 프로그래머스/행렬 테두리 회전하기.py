def solution(rows, columns, queries):
    matrix = [[0 for _ in range(columns)] for _ in range(rows)]
    answer = []
    # 행렬에 1씩 증가하는 수 채워넣음
    for i in range(rows):
        for j in range(columns):
            matrix[i][j] = i * columns + j + 1
            
    for x1, y1, x2, y2 in queries:
        # 시작점은 첫번째 for문에서 값이 사라지므로 보관
        start = matrix[x1-1][y1-1]
        # 시작점은 옮기는 수들의 min 연산에 포함되지 않으므로 포함위해 초기화
        minimum = start
        # 왼쪽 변
        for i in range(x1, x2):
            number = matrix[i][y1-1]
            matrix[i-1][y1-1] = number
            minimum = min(minimum, number)
        # 아래쪽 변
        for j in range(y1, y2):
            number = matrix[x2-1][j]
            matrix[x2-1][j-1] = number
            minimum = min(minimum, number)
        # 오른쪽 변    
        for i in range(x2, x1, -1):
            number = matrix[i-2][y2-1]
            matrix[i-1][y2-1] = number
            minimum = min(minimum, number)
        # 위쪽 변
        for j in range(y2, y1, -1):
            number = matrix[x1-1][j-2]
            matrix[x1-1][j-1] = number
            minimum = min(minimum, number)
        # 시작점은 아직 옮기지 못했으므로 여기서 반영     
        matrix[x1-1][y1] = start
        answer.append(minimum)
    
    return answer