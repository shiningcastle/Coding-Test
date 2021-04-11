def solution(brown, yellow):
    
    # 정답 가로세로가 [x,y] 일때, yellow의 값은 가로 세로가 2씩 빠진 값인 (x-2)(y-2)임
    # x * y = brown + yellow 와 y를 지우고 x에 대해 연립방정식을 정리해 근의 공식으로 만들어 코드로 그대로 씀 
    x = ( (4 + brown) + ( (4 + brown) ** 2 - 16 * (brown + yellow) ) ** 0.5) / 4
    y = (brown + yellow) / x
    
    # x y 값이 실수 형태로 소수점 달고 나오므로 int형 변환
    answer = [int(max(x,y)), int(min(x,y))]
    return answer