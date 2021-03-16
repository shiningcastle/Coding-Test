def solution(triangle):
    
    for i in range(1, len(triangle)):
        for j in range(len(triangle[i])):
            
            # 삼각형 왼쪽 변 부분
            if j == 0:
                triangle[i][j] += triangle[i-1][j]
            # 삼각형 오른쪽 변 부분
            elif j == len(triangle[i])-1:
                triangle[i][j] += triangle[i-1][j-1]
            # 삼각형 중간 부분
            # 윗줄 두 수 중 최대값 하나만 더해줌
            else:
                triangle[i][j] += max(triangle[i-1][j-1], triangle[i-1][j])
                
    # 마지막 행 최대값 = 총 최대값 케이스
    return max(triangle[-1])