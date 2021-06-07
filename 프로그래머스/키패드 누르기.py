def solution(numbers, hand):
    answer = ''
    leftSpot = "*"
    rightSpot = "#"
    # 키패드 숫자를 좌표로 표현
    position = {1 : (0,0), 2 : (0,1), 3 : (0,2), 4 : (1,0), 5 : (1,1), 6 : (1,2),
               7 : (2,0), 8 : (2,1), 9 : (2,2), "*" : (3,0), 0 : (3,1), "#" : (3,2)}
        
    for n in numbers:
        if n == 1 or n == 4 or n == 7:
            answer += "L"
            leftSpot = n
        elif n == 3 or n == 6 or n == 9:
            answer += "R"
            rightSpot = n
        else:
            # 가로 좌표, 세로 좌표 차이 각각 구해서 더하면 총거리 차이
            l = abs(position[leftSpot][0] - position[n][0]) + abs(position[leftSpot][1] - position[n][1])
            r = abs(position[rightSpot][0] - position[n][0]) + abs(position[rightSpot][1] - position[n][1])
            
            if l < r:
                answer += "L"
                leftSpot = n
            elif l > r:
                answer += "R"
                rightSpot = n
            else:
                if hand == "left":
                    answer += "L"
                    leftSpot = n
                else:
                    answer += "R"
                    rightSpot = n
            
    return answer