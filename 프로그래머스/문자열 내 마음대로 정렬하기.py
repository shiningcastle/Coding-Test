def solution(strings, n):
    standard = []
    answer = []
    # n번째 글자와 해당 글자의 소속 문자열을 연관짓기위해 튜플로 묶어줌
    for s in strings:
        tup = (s, s[n])
        standard.append(tup)
    # 핵심 부분, 두번째 원소 기준으로 정렬하고 다음으로 첫번째 원소 기준으로 정렬한다.
    # 내림차순 원하면 '-'를 붙여주면 된다.
    standard.sort(key = lambda x: (x[1], x[0]))
    # 정렬 완료 후에 뒤의 기준 글자 버리고 앞의 문자열만 추출해서 정답 생성
    for i in range(len(standard)):
        answer.append(standard[i][0])
        
    return answer