import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    private List<int[]> blanks = new ArrayList<>();
    private List<int[]> viruses = new ArrayList<>();
    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int maximum = 0;
    private boolean[][] visited;

    private void bfs(int n, int m, int[][] matrix) {
        Queue<int[]> queue = new LinkedList<>();
        // 바이러스 위치에서만 시작해서 전파 탐색
        for (int[] virus : viruses) {
            queue.add(virus);
            visited[virus[0]][virus[1]] = true;
        }
        // bfs
        int virusCount = 0; // 전파된 바이러스 개수만 세기(초기 바이러스는 x)
        while (!queue.isEmpty()) {
            int[] virus = queue.poll();
            int x = virus[0], y = virus[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dirs[i][0], ny = y + dirs[i][1];
                // 범위를 넘어서거나, 이미 방문했거나, 빈공간이 아니면 종료
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny] || matrix[nx][ny] != 0)
                    continue;
                // 방문 처리하고 큐에 넣어 다음 전파 위치 찾기, 원본은 수정하지 않고 visited로 판별
                visited[nx][ny] = true;
                virusCount++;
                queue.add(new int[]{nx, ny});
            }
        }
        // 안전구역 = 모든 공백수 - 벽세운 수 - 전파된 바이러스 수
        int count = blanks.size() - (3 + virusCount);
        maximum = Math.max(maximum, count);
    }

    // 모든 벽 설치 가능한 지점별 모든 경우의 수, 설치 완료 후에 빈 공간 개수 세는 함수 호출
    private void findBlockCases(int idx, int selected, int length, int[][] matrix, int n, int m) {
        // 벽 3개 설치 경우별 완료후, 바이러스 전파시키고 결과로 최대값 갱신
        if (selected == 3) {
            visited = new boolean[n][m]; // 방문 여부 배열 매번 초기화, BFS에서 전염된 위치들 다시 false로
            bfs(n, m, matrix);
            return;
        }
        // 설치 가능한 최대 벽의 개수 초과 불가능
        if (idx >= length)
            return;
        int[] blank = blanks.get(idx);
        // 해당 위치의 빈칸에 벽설치하고 다음 순서의 벽으로
        matrix[blank[0]][blank[1]] = 1;
        findBlockCases(idx + 1, selected + 1, length, matrix, n, m);
        // 해당 위치의 빈칸에 벽설치 안하고 다음 순서의 벽으로
        matrix[blank[0]][blank[1]] = 0;
        findBlockCases(idx + 1, selected, length, matrix, n, m);
    }

    // 연구소의 모든 빈 공간, 바이러스의 좌표 찾기
    private void findBlankAndVirus(int n, int m, int[][] matrix) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0)
                    blanks.add(new int[]{i, j});
                else if (matrix[i][j] == 2)
                    viruses.add(new int[]{i, j});
            }
        }
    }

    // 정답 찾기
    private void findSafeAreas(int n, int m, int[][] matrix) {
        // 모든 빈공간, 바이러스 위치를 찾아서 보관
        findBlankAndVirus(n, m, matrix);
        // 빈공간에 벽 3개를 각각 놓거나, 안놓거나 모든 경우의 수
        findBlockCases(0, 0, blanks.size(), matrix, n, m);
        System.out.print(maximum); // 정답 출력
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++)
                matrix[i][j] = Integer.parseInt(st2.nextToken());
        }
        br.close();
        new Main().findSafeAreas(n, m, matrix);
    }
}