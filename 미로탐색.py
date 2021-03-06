import sys
from collections import deque

n, m = map(int, sys.stdin.readline().split())
graph = []

for i in range(n):
    graph.append(list(map(int, sys.stdin.readline().strip())))

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

def bfs(x, y):

    queue = deque()
    queue.append((x,y))

    while queue:
        x, y = queue.popleft()

        for i in range(len(dx)):
            fx = x + dx[i]
            fy = y + dy[i]

            if fx <= -1 or fx >= n or fy <= -1 or fy >= m:
                continue

            if graph[fx][fy] == 0:
                continue
    
            if graph[fx][fy] == 1:
                graph[fx][fy] = graph[x][y] + 1
                queue.append((fx, fy))

    return graph[n-1][m-1]
    

print(bfs(0, 0))