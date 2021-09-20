import java.io.*;
import java.util.*;

class Main {
    private List<Integer> answer = new ArrayList<>();
    private int count = 0;

    private void dfs(int x, int y, int n, String[][] matrix, boolean[][] visited) {
        // 범위를 넘거나, 이미 체크한 아파트, 아파트가 아니면 스킵
        if (x < 0 || x >= n || y < 0 || y >= n || visited[x][y] || matrix[x][y].equals("0"))
            return;
        // 아파트 개수 카운트, 방문 체크하고 상하좌우로 연결된 아파트 찾기
        count++;
        visited[x][y] = true;
        dfs(x-1, y, n, matrix, visited);
        dfs(x+1, y, n, matrix, visited);
        dfs(x, y-1, n, matrix, visited);
        dfs(x, y+1, n, matrix, visited);
    }

    private void findComplex(int n, String[][] matrix) throws IOException {
        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 이미 앞에서 단지에 포함된 아파트거나 아파트가 아니면 다음으로
                if (visited[i][j] || matrix[i][j].equals("0"))
                    continue;
                dfs(i, j, n, matrix, visited); // 단지 수 조회
                if (count > 0) // 단지를 찾으면 개수 정답 리스트에 넣기
                    answer.add(count);
                count = 0; // 단지수 초기화
            }
        }
        // 정답 문자열 만들고 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Collections.sort(answer); // 오름차순 정렬
        bw.write(String.valueOf(answer.size()));
        for (int num : answer) {
            bw.write("\n");
            bw.write(String.valueOf(num));
        }
        bw.flush();
        bw.close();
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[][] matrix = new String[n][n];
        for (int i = 0; i < n; i++)
            matrix[i] = br.readLine().split("");
        br.close();
        new Main().findComplex(n, matrix);
    }
}