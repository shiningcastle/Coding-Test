def solution(skill, skill_trees):
    answer = 0

    # 스킬 트리들 전부 조회
    for trees in skill_trees:
        # 앞의 루프 선행 스킬의 인덱스 번호
        order = 0
        
        # 스킬 순서 속 선행 스킬 순서와 상관없는 매칭 개수 
        match_count = 0

        # 스킬 트리에서 스킬 순서와 맞는 스킬 모음 
        check = ""

        # 스킬 트리 순서 조회
        for i in range(len(skill)):
            # 스킬 순서에 있는 해당 스킬 존재 인덱스 번호
            exist = trees.find(skill[i])
            
            # 스킬 순서에 있는 스킬이 존재하는 경우
            if exist != -1:
                match_count += 1
                # 만약 첫번째 매칭 케이스가 0번째 인덱스면 order 상관없이 들어가게 <=
                # 스킬 순서와 맞는 알파벳 한 글자씩만 check에 넣어줌
                if order <= exist:
                    order = exist
                    check += trees[exist]

            # -1은 존재하지 않는 경우, 스킬 순서에 있는 스킬 찾는 목적이므로 스킵
            else:
                continue

        # 스킬 순서의 스킬이 한개라도 존재하는 경우만 체크    
        # 순서가 달라도 첫번째로 매칭된 스킬 트리 원소는 check에 무조건 들어감
        if check != "":
            # 선행 스킬 순서와 check를 비교해 똑같은 인덱스에 같은 스킬인 개수
            count = 0

            for i in range(len(check)):
                if check[i] == skill[i]:
                    count += 1
                    continue

                # 한개라도 순서와 값이 다르다면 카운트 중단 
                else:
                    break

            # 순서 상관없이 값 맞는 스킬 개수 = 순서와 값 모두 맞는 스킬 개수 -> 답
            if match_count == count:
                answer += 1

        # 스킬 순서에 있는 스킬이 한개도 존재하지 않는 케이스 -> 답
        else:
            answer += 1

    return answer