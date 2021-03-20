import sys

# 노드의 개수, 간선의 개수
n, m = map(int, sys.stdin.readline().split())
# 무한을 의미하는 값으로 10억을 설정
inf = int(1e9)

graph = []
# 최단 거리 테이블을 모두 무한으로 초기화
dist = [inf for i in range(n+1)]

for i in range(m):
    # a번 노드에서 b번 노드로 가는 비용이 c
    a, b, c = map(int, sys.stdin.readline().split())
    graph.append( (a, b, c) )

def bf(start):
    
    # 시작 노드 거리 초기화
    dist[start] = 0

    # 전체 n - 1번을 반복
    for i in range(n):
        # 매 반복마다 모든 간선을 확인
        for j in range(m):
            a = graph[j][0]
            b = graph[j][1]
            cost = graph[j][2]
            # 현재 간선을 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
            if dist[a] != inf and dist[b] > dist[a] + cost:
                dist[b] = dist[a] + cost
                # n번째에서도 값이 갱신된다면 음수 무한 순환이 존재
                if i == n-1:
                    return True
    
    return False

if bf(1):
    print(-1)
else:
    for dis in dist[2:]:
        if dis == inf:
            print(-1)
        else:
            print(dis)