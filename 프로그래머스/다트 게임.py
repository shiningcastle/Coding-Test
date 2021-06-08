def solution(dartResult):
    lis = ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9"]
    answer = 0
    # 문자열에서 현재 위치
    idx = 0
    # 바로 직전 점수
    beforeScore = 0
    # 이번 점수가 두자리 수인지 판별
    twoCheck = 0
    # 두자리 수인지 체크해서 인덱스에 반영
    while idx < len(dartResult):
        if dartResult[idx+1] in lis:
            twoCheck = 1
        else:
            twoCheck = 0
        
        score = int(dartResult[idx : idx + 1 + twoCheck])
        bonus = dartResult[idx + 1 + twoCheck]
        # 옵션 존재하는 경우
        if (idx + 2 + twoCheck) != len(dartResult) and (dartResult[idx + 2 + twoCheck] == "*" or dartResult[idx + 2 + twoCheck] == "#"):
            option = dartResult[idx + 2 + twoCheck]
            # 인덱스 옮겨줌
            idx += 3 + twoCheck
            # 스타상인 경우
            if option == "*":
                if bonus == "S":
                    answer += (score * 2)
                    answer += beforeScore
                    beforeScore = (score * 2)
                elif bonus == "D":
                    answer += ((score ** 2) * 2)
                    answer += beforeScore
                    beforeScore = ((score ** 2) * 2)
                else:
                    answer += ((score ** 3) * 2)
                    answer += beforeScore
                    beforeScore = ((score ** 3) * 2)
            # 아차상인 경우
            else:
                if bonus == "S":
                    answer -= score 
                    beforeScore = -score
                elif bonus == "D":
                    answer -= (score ** 2)
                    beforeScore = -(score ** 2)
                else:
                    answer -= (score ** 3)
                    beforeScore = -(score ** 3)
        # 옵션 없는 경우              
        else:
            # 인덱스 옮겨줌
            idx += 2 + twoCheck
            if bonus == "S":
                answer += score
                beforeScore = score
            elif bonus == "D":
                answer += (score ** 2)
                beforeScore = (score ** 2)
            else:
                answer += (score ** 3)
                beforeScore = (score ** 3)
    return answer