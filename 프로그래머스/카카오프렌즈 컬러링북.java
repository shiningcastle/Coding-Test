import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int count = 0, maxArea = 0;
        // BFS
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] != 0 && !visited[i][j]) {
                    count++; // 땅 종류 세기
                    int same = 1;
                    queue.add(new int[] {i, j});
                    visited[i][j] = true;
                    while (!queue.isEmpty()) {
                        int[] point = queue.poll();
                        int x = point[0], y = point[1];
                        for (int[] dir : dirs) { // 상하좌우 좌표가 조건에 맞으면 큐에 넣기
                            int nx = x + dir[0], ny = y + dir[1];
                            if (nx >= 0 && nx < m && ny >= 0 && ny < n && picture[x][y] == picture[nx][ny] && !visited[nx][ny]) {
                                queue.offer(new int[] {nx, ny});
                                visited[nx][ny] = true; // 밖에서 방문체크하면 뽑기전에 인접한 앞원소에서 중복으로 들어갈 수 있다.
                                same++;
                            }
                        }
                    }
                    maxArea = Math.max(maxArea, same); // 지금의 땅수와 최대값 수와 비교해 갱신
                }
            }
        }
        return new int[] {count, maxArea};
    }
}