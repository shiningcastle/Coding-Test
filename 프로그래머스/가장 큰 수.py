def solution(numbers):
    strList = list(map(str, numbers))
    strList.sort(key = lambda x : x * 3, reverse = True)
    # int로 한번 바꾸고 다시 str하는 이유는 "0000"을 "0"으로 변환해주기 위함
    return str(int("".join(strList)))