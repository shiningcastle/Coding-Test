import heapq

def solution(jobs):
    answer = 0
    start, now, i = -1, 0, 0  # 시작 시간, 현재 시간, 처리한 수
    heap = [] # 현시점에서 처리 가능한 작업들 넣어줄 힙 작업대기 리스트
    jobs.sort() # 요청 시간 빠른순으로 정렬
    idx = 0 # 힙에 어디 작업까지 포함 됐는지 저장
    
    # 전체 케이스를 다 처리할 떄까지 반복
    while i < len(jobs):
        # 작업 리스트에서 현재 처리 가능한 작업을 작업 소요 시간 순으로 정렬한 힙에 넣어줌
        # 어디 인덱스까지 처리했는지 저장해주어 매번 첫 인덱스 부터 확인작업 안하게 함
        for j in range(idx, len(jobs)):
            if start < jobs[j][0] <= now:
                heapq.heappush(heap, [jobs[j][1], jobs[j][0]])
                idx = j
            # 요청 시점 순으로 정렬 했으므로 한 번 조건 불만족하면 뒤는 자동 불만족이라 확인 중단
            else:
                idx = j
                break
        # 처리 가능한 작업 있을 때
        if len(heap) > 0:
            cur_work = heapq.heappop(heap)
            start = now
            now += cur_work[0]
            # 작업 완료한 현재 시간에서 요청 시점을 뺀 시간이 완료 소요 시간
            answer += (now - cur_work[1])
            i += 1 # 처리한 작업 수 카운트
        # 처리 가능한 작업 없을 때 현재 시간을 더 뒤로 보내 다음 가능 요청 있나 확인
        else:
            now += 1
                    
    return int(answer / len(jobs))