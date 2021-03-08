def solution(progresses, speeds):
    answer = []
    while progresses:
        for i in range(len(progresses)):
            progresses[i] += speeds[i]

        if progresses[0] >= 100:

            result = []
            for j in range(len(progresses)):
                if progresses[j] >= 100:
                    result.append(j)
                else:
                    break
            for r in result[::-1]:
                del progresses[r]
                del speeds[r]
            answer.append(len(result))

    return answer
print(solution([93, 30, 55],[1, 30, 5]))