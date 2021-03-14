def solution(n, words):
    # 탈락자 없이 words 다 돌면 [0, 0] 반환하도록 초기화
    answer = [0, 0]
    # set 이용해서 중복을 제거 하고 다시 리스트로 변환
    uni_words = list(set(words))
    # {단어 : 0(횟수)} 형태의 딕셔너리
    check = {uni_words[i] : 0 for i in range(len(uni_words))}
    # 차례
    turn = 1

    # 첫 단어는 반복문에서 예외이므로 여기서 처리
    # 전 순서 단어의 끝말 (첫 단어의 끝말로 시작)
    last_word = words[0][-1]
    # 첫 단어 check에 등록하고 한번 카운트
    check[words[0]] = 1

    for i in range(1, len(words)):
        # 차례 카운트
        if i % n == 0:
            turn += 1 
        # 끝말잇기 실패 or 같은 단어가 이미 한 번 나왔을 경우 종료
        if words[i][0] != last_word or check[words[i]] == 1:
            # 그 사람의 번호 = 해당 인덱스 사람수로 나눈 나머지 값 + 1
            answer[0] = (i % n) + 1
            answer[1] = turn
            break
        # 끝말잇기 성공시 check 딕셔너리에 성공 단어 등록 및 횟수 갱신
        else:
            last_word = words[i][-1]
            check[words[i]] += 1

    return answer

def solution(n, words):
    for p in range(1, len(words)):
        if words[p][0] != words[p-1][-1] or words[p] in words[:p]:
            return [(p%n)+1, (p//n)+1]
    else:
        return [0,0]