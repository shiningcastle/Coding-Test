def solution(dirs):
    # 시작점
    point = [0, 0]

    # 방향별 좌표 변화
    u = [1, 0]
    d = [-1, 0]
    r = [0, 1]
    l = [0, -1]

    # 거쳐간 길 체크 용도 리스트
    check = []
    # 새롭게 거쳐간 길 횟수
    count = 0

    for char in dirs:
        if char == "U":
            # 현재 지점에서 위로 이동했을 때 좌표 값
            after = [x+y for x,y in zip(point, u)]
            # 좌표 평면을 벗어난 경우 이동하지 않고 스킵
            if after[0] > 5:
                continue

            # 체크 리스트에 [x1, y1 (지금 좌표), x2, y2 (이동 후 좌표)] 형태로 넣기
            # 반대 순서로도 같은 길이므로 만들어서 넣어주기
            bef_aft = point + after
            bef_aft2 = after + point
            # 중복 길이든 아니든 일단 현재 좌표는 명령대로 이동
            point = after

            # 지금 길이 지나왔던 길이 아닌 경우에만
            if bef_aft not in check and bef_aft2 not in check:
                # 처음 지나가는 새 길을 체크 리스트에 등록
                check.append(bef_aft)
                check.append(bef_aft2)
                # 새로운 길 지나가므로 카운트 
                count += 1

        elif char == "D":
            # 현재 지점에서 아래로 이동했을 때 좌표 값
            after = [x+y for x,y in zip(point, d)]
            if after[0] < -5:
                continue
            
            bef_aft = point + after
            bef_aft2 = after + point
            point = after

            if bef_aft not in check and bef_aft2 not in check:
                check.append(bef_aft)
                check.append(bef_aft2)
                count += 1

        elif char == "R":
            # 현재 지점에서 오른쪽으로 이동했을 때 좌표 값
            after = [x+y for x,y in zip(point, r)]
            if after[1] > 5:
                continue
            
            bef_aft = point + after
            bef_aft2 = after + point
            point = after

            if bef_aft not in check and bef_aft2 not in check:
                check.append(bef_aft)
                check.append(bef_aft2)
                count += 1

        elif char == "L":
            # 현재 지점에서 왼쪽으로 이동했을 때 좌표 값
            after = [x+y for x,y in zip(point, l)]
            if after[1] < -5:
                continue
            
            bef_aft = point + after
            bef_aft2 = after + point
            point = after

            if bef_aft not in check and bef_aft2 not in check:
                check.append(bef_aft)
                check.append(bef_aft2)
                count += 1

    return count

## 같은 아이디어를 줄인 코드
def solution(dirs):
    # 세트를 사용해서 중복인 경로는 들어가지 않게 함
    s = set()
    d = {'U': (0,1), 'D': (0, -1), 'R': (1, 0), 'L': (-1, 0)}
    x, y = 0, 0
    
    for i in dirs:
        nx, ny = x + d[i][0], y + d[i][1]
        
        if -5 <= nx <= 5 and -5 <= ny <= 5:
            s.add((x,y,nx,ny))
            s.add((nx,ny,x,y))
            x, y = nx, ny

    # 같은 경우 두가지 케이스 (전, 후) (후, 전)를 넣어주므로 나누기 2한 값
    return len(s)//2
