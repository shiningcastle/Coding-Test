n = int(input())
lis = []
for i in range(n):
    lis.append( [int(x) for x in input().strip().split()] )
    
for l in lis:
    man = l.pop(0)
    average = sum(l) / man
    # 평균 초과한 숫자만 추출한 리스트 생성
    good = list(filter(lambda x: x > average, l))
    # 모두 빵점인 경우 아랫줄에서 zerodivison 에러 발생하므로
    if len(good) == 0:
        print("0.000%")
    # 그냥 round함수를 쓰면 소숫점이 0인 경우 그 뒤로는 표현을 안한다.
    # 0이건 말건 3째자리까지 표기하기 위해 format함수 사용필요
    else:
        print("{0:0.3f}%".format(len(good) / man * 100))