import string
# n진법 만들때 쓰는 문자열
tmp = string.digits + string.ascii_lowercase
# 진법 변환 함수, tmp 이용 문자열 반환
def convert(n, s):
    q, r = divmod(n, s)
    if q == 0:
        return tmp[r]
    else:
        return convert(q, s) + tmp[r]
    
def solution(n):
    # 3진법 변환한 문자열 반환
    threeNum = convert(n, 3)
    # 문자열 뒤집기
    reversedString = threeNum[::-1]
    # n진법 문자열을 10진법 정수로 변환
    answer = int(reversedString, 3)    
    
    return answer