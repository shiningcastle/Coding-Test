def solution(N, stages):
    result = {}
    # 분모
    denominator = len(stages)
    for stage in range(1, N+1):
        if denominator != 0:
            count = stages.count(stage)
            # 딕셔너리로 저장
            result[stage] = count / denominator
            # 전 스테이지 도달 한 사람수를 뺀 분모 생성
            denominator -= count
        else:
            result[stage] = 0
            # 딕셔너리의 값(실패율)기준 내림차순 정렬
    return sorted(result, key=lambda x : -result[x])