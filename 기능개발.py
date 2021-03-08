def solution(progresses, speeds):
    answer = []
    # 작업 리스트의 원소가 모두 사라질 때까지 반복
    while progresses:
        for i in range(len(progresses)):
            progresses[i] += speeds[i]

        if progresses[0] >= 100:
            # 100% 이상인 작업의 인덱스 번호 넣어줄 리스트
            result = []
            for j in range(len(progresses)):
                if progresses[j] >= 100:
                    result.append(j)
                # 바로 다음 순서에서 100 못넘으면 반복문 탈출해서
                # 그보다 뒤에서 100% 넘었어도 list에 추가 X
                else:
                    break
            # 완료된 작업 인덱스 리스트를 뒤에서 부터 꺼내서 
            # 작업, 스피드 리스트에서 해당 위치 원소 삭제해서 인덱스 번호 순서가 밀리는 것 방지
            for r in result[::-1]:
                del progresses[r]
                del speeds[r]
            # 정답 리스트에는 개수를 주기위해 result 길이로 append
            answer.append(len(result))

    return answer