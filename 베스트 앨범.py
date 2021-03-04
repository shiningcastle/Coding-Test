def solution(genres, plays):
    answer = []
    # {장르 : 총 플레이수} 딕셔너리
    sumdict = {}
    # {장르 : [(플레이 수 , 고유번호), (,).....]}
    casedict = {}
    
    for i in range(len(genres)):
        genre = genres[i]
        play = plays[i]
        
        # 각각 딕셔너리 형식으로 장르와 플레이 수 추가 
        # 둘 다 default값을 적어줘서 없으면 바로 생성되게 만들어 줌
        sumdict[genre] = sumdict.get(genre, 0) + play
        casedict[genre] = casedict.get(genre, []) + [(play, i)]
    
    # 총 플레이 수 많은 순(내림차순)으로 딕셔너리 원소 정렬
    sort_sumdict = sorted(sumdict.items(), key = lambda x : x[1], reverse = True)
	
    # 먼저 플레이 수 순(내림차순)으로 정렬하고 두번째로 고유번호 순(오름차순)으로 정렬
    # 플레이 수는 -를 붙이면 reverse true 안해도 내림차순으로 정렬 가능
    for (genre, plays) in sort_sumdict:
        casedict[genre] = sorted(casedict[genre], key = lambda x : (-x[0], x[1]))
        # 1,2 번째 케이스의 인덱스 숫자만 answer에 추가
        answer += [ idx for (play, idx) in casedict[genre][:2] ]  
    
    return answer