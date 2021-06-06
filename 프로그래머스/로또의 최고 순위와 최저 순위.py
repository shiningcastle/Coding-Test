# 숫자 일치 갯수 넣으면 로또등수를 반환
def grade(n):
    if n != 0:
        return 7 - n
    else:
        return 6

def solution(lottos, win_nums):
    zeroNum = lottos.count(0)
    count = 0
    # 찍은 번호 중에 알아볼 수 없는 번호 제외
    for _ in range(zeroNum):
        idx = lottos.index(0)
        del lottos[idx]
    # 0 제외하고 나머지 번호들 맞은 개수 체크
    for i in range(len(lottos)):
        if win_nums.count(lottos[i]) == 1:
            count += 1
    # [최고로 맞을 번호 개수, 최저로 맞을 번호 개수]
    result = [grade(count + zeroNum), grade(count)]    
    
    return result