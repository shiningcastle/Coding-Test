## DFS 풀이
def dfs(n, cur, computers, visited):
    # 방문 여부 리스트에 방문 처리
    if visited[cur] == False:
        visited[cur] = True

    for con in range(n):
        if cur != con and computers[cur][con] == 1:
            # 재귀함수로 미 방문 요소 존재시 방문
            if visited[con] == False:
                dfs(n, con, computers, visited)

def solution(n, computers):
    answer = 0
    # 방문 여부 리스트
    visited = [False for i in range(n)]
    # cur = 현재 컴퓨터
    for cur in range(n):
        if visited[cur] == False:
            # dfs 한 사이클 = 1개의 네트워크
            dfs(n, cur, computers, visited)
            answer += 1
    return answer


## BFS 풀이
from collections import deque

def bfs(n, cur, computers, visited):
    # 맨 처음 시작 컴퓨터 방문 처리
    visited[cur] = True
    # 큐에 시작점 넣어주기
    queue = deque([cur])

    # 큐의 원소가 모두 사라질 때까지 반복
    while queue:
        # 큐 안에서 루프 돌릴 때 방문 처리 
        cur = queue.popleft()
        visited[cur] = True
        
        for con in range(n):
            if cur != con and computers[cur][con] == 1:
            # 미 방문 요소 존재시 큐에 추가해 방문
                if visited[con] == False:
                    queue.append(con)

def solution(n, computers):
    answer = 0
    # 방문 여부 리스트
    visited = [False for i in range(n)]
    # cur = 현재 컴퓨터
    for cur in range(n):
        if visited[cur] == False:
            # bfs 한 사이클 = 1개의 네트워크
            bfs(n, cur, computers, visited)
            answer += 1
    return answer