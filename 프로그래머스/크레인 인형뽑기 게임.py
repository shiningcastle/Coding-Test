def solution(board, moves):
    resultList = []
    answer = 0
    
    for k in range(len(moves)):
        for i in range(len(board)):
            # 인형이 있는 경우
            if not board[i][moves[k]-1] == 0:
                # 바구니에 한개도 없는 경우, 조회시 에러 발생 방지
                if len(resultList) == 0:
                    resultList.append(board[i][moves[k]-1])
                    # 꼭 인형을 뽑고난 후에 0으로 바꿔줘야 한다
                    board[i][moves[k]-1] = 0
                    break
                # 바구니의 인형이 있는 경우 비교
                else:
                    # 바구니의 마지막 인형과 뽑은 인형이 같은 경우
                    if resultList[-1] == board[i][moves[k]-1]:
                        del resultList[-1]
                        board[i][moves[k]-1] = 0
                        answer += 2
                        break
                    # 바구니의 마지막 인형과 뽑은 인형이 다른 경우
                    else:                       
                        resultList.append(board[i][moves[k]-1])
                        board[i][moves[k]-1] = 0
                        break
    return answer