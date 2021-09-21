import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    private void escape(int n, int m, char[][] forest) {
        // 방향 배열, 해당 지점에 물이 몇초에 오는지 값을 넣은 2차원 배열, 방문 배열
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int[][] waterArr = new int[n][m];
        boolean[][] waterVisit = new boolean[n][m];
        // 물의 시작점 위치, 고슴도치 시작위치 구하기
        List<int[]> waters = new ArrayList<>();
        int[] start = new int[2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                waterArr[i][j] = -1; // 물 배열 기본 원소 -1로
                if (forest[i][j] == '*') {
                    waters.add(new int[]{i, j}); // 시작점의 좌표를 리스트에 기록
                    waterArr[i][j] = 0; // 물 시작점은 0초만에 물에 잠김
                } else if (forest[i][j] == 'S') {
                    start[0] = i;
                    start[1] = j;
                } else if (forest[i][j] == 'D') {
                    waterArr[i][j] = 2500;
                }
            }
        }
        // 물의 시작 지점들을 큐에 넣고 BFS를 실행
        Queue<int[]> flood = new LinkedList<>();
        for (int[] water : waters)
            flood.offer(water);
        // 시간, BFS
        int waterTime = 0;
        // 해당 지점에 물이 몇초에 오는지 값을 넣은 2차원 배열 만들기
        while (!flood.isEmpty()) {
            waterTime++;
            int size = flood.size();
            for (int i = 0; i < size; i++) {
                int[] area = flood.poll();
                int x = area[0], y = area[1];
                for (int j = 0; j < 4; j++) {
                    int nx = x + dirs[j][0], ny = y + dirs[j][1];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m || waterVisit[nx][ny] || forest[nx][ny] != '.')
                        continue;
                    waterArr[nx][ny] = waterTime;
                    waterVisit[nx][ny] = true;
                    flood.offer(new int[]{nx, ny});
                }
            }
        }
        boolean[][] goVisit = new boolean[n][m];
        // 고슴도치의 위치 넣기
        flood.offer(new int[]{start[0], start[1]});
        waterArr[start[0]][start[1]] = 0; // 시작점 아래 if문 통과위해 고슴도치 시작점 0 초기화
        int goTime = -1;
        while (!flood.isEmpty()) {
            goTime++;
            int size = flood.size();
            for (int i = 0; i < size; i++) {
                int[] here = flood.poll();
                int x = here[0], y = here[1];
                // 고슴도치 동굴 발견시 정답 출력
                if (forest[x][y] == 'D') {
                    System.out.print(goTime);
                    return;
                }
                for (int j = 0; j < 4; j++) {
                    int nx = x + dirs[j][0], ny = y + dirs[j][1];
                    // 범위를 벗어나거나, 이미 방문한 지역이면 스킵
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m || goVisit[nx][ny])
                        continue;
                    // 갈 수 없는 곳이거나, 이미 침수된 지역일 경우 스킵
                    if (waterArr[nx][ny] != -1 && waterArr[nx][ny] <= goTime + 1)
                        continue;
                    if (forest[nx][ny] != '.' && forest[nx][ny] != 'D')
                        continue;
                    goVisit[nx][ny] = true;
                    flood.offer(new int[]{nx, ny});
                }
            }
        }
        System.out.print("KAKTUS");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        char[][] forest = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++)
                forest[i][j] = s.charAt(j);
        }
        br.close();
        new Main().escape(n, m, forest);
    }
}