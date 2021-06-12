def solution(A, B):
    stack = []
    count = 0
    for i in range(len(A)):
        # 상류로 가는 물고기인 경우
        if B[i] == 0:
            # 상대할 하류 물고기가 없는 경우
            if len(stack) == 0:
                count += 1
            else:
                # 상대할 하류 물고기가 있는 경우, 하나도 없을 때까지 반복
                while len(stack) != 0:
                    # 상류 물고기 패배시에 반복 중단
                    if stack[-1] > A[i]:
                        break
                    # 하류 물고기가 패배시에 없애주고 다음 하류 물고기 등장
                    else:
                        stack.pop()
                # 상류 물고기가 살아 남는 경우는 하류 물고기 전멸인 경우
                if len(stack) == 0:
                    count += 1
        # 하류로 가는 물고기인 경우
        else:
            stack.append(A[i])
    
    return len(stack) + count