import heapq

def solution(scoville, K):
    # 리스트를 heap으로 만들어준다
    heapq.heapify(scoville)
    count = 0
    for i in range(len(scoville)-1):
        # heap에서 가장 작은, 그 다음으로 작은 원소를 추출
        first = heapq.heappop(scoville)
        second = heapq.heappop(scoville)
        # 조건 체크
        if first >= K and second >= K:
            break
        # 섞어주고 힙에 넣어주고 카운팅. 자동으로 정렬된다.
        heapq.heappush(scoville, first + second * 2)
        count += 1
    # 힙에 원소가 없는 상태면 마지막 두 원소가 if break에 걸린 것 = 조건 만족
    # 길이가 0이면 에러 뜨는 것 방지, 마지막 원소가 k보다 작으면 조건 불만족 
    if len(scoville) != 0 and scoville[-1] < K:
        return -1
    
    return count