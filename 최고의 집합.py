def solution(n, s):
    answer = []
    
    # 최고의 집합이 존재하지 않는 경우 = S가 n보다 작을 때
    if s < n:
        answer.append(-1)
        return answer
        
    # s를 n으로 나눈 나머지
    remainder = s % n
    # s를 n으로 나눈 몫
    quotient = s // n 

    # 몫 값을 n번 리스트에 추가 
    for i in range(n):
        answer.append(quotient)
    
    # 나머지 0이 아닌 경우 추가적 처리
    # 나머지 값 크기의 횟수만큼 맨 앞부터 원소에 1씩 더해줌
    if remainder != 0:
        answer[:remainder] = list(map(lambda x : x+1, answer[:remainder]))
        # 오름차순 정렬
        answer.sort()
            
    return answer