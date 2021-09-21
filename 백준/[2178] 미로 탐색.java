import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    private int findMinDistance(int n, int m, int[][] maze) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        // 첫 시작점 큐에 넣고, 방문처리
        queue.add(new int[] {0, 0});
        visited[0][0] = true;
        // BFS
        while(!queue.isEmpty()) {
            int[] point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = point[0] + dirs[i][0], ny = point[1] + dirs[i][1];
                // 범위를 넘거나, 이미 방문했거나, 갈수 없는 길이면 스킵
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny] || maze[nx][ny] == 0)
                    continue;
                // 시작점부터 이전 지점까지의 거리 + 1은 향할 지점의 최단거리, 해당 지점에 적고 방문처리 후 큐에 넣기
                maze[nx][ny] = maze[point[0]][point[1]] + 1;
                visited[nx][ny] = true;
                queue.add(new int[] {nx, ny});
            }
        }
        // BFS라 먼저 도착하면 그게 최단 거리이므로 최소값인지 여러 정답 값을 비교할 필요가 없다
        // 첫 정답값 이후 정답을 만족하는 값들은 최소값이 아니다. visited true로 적용안됨)
        return maze[n-1][m-1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        int[][] maze = new int[n][m];
        for (int i = 0; i < n; i++) {
            String nums = br.readLine();
            for (int j = 0; j < m; j++)
                maze[i][j] = nums.charAt(j) - '0';
        }
        br.close();
        System.out.print(new Main().findMinDistance(n, m, maze));
    }
}