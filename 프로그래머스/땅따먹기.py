def solution(land):
	
    # 한 단계 전에 것들을 사용하므로 1부터 
    for i in range(1,len(land)):
        for j in range(4):
            # 해당 위치 값은 전 행에서 그 열 값을 뺀 나머지 값들 중의 최대값을 더해줌
            # 어떤 인덱스였는지는 기록 안함, j가 이미 정보 보유
            land[i][j] += max(land[i-1][:j] + land[i-1][j+1:])
    # 마지막 행이 값들의 총합 리스트
    return max(land[-1])