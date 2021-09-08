import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    private static int answer = 0;
    // 두 좌표의 놓인 퀸이 서로 공격할 수 있는 위치에 있으면 true
    private boolean invalid(int r1, int c1, int r2, int c2) {
        // 열이 같으면 탈락
        if (c1 == c2) return true;
        // 우상향, 좌상향 대각선 방향에 있으면 탈락
        if (r1 - c1 == r2 - c2) return true;
        if (r1 + c1 == r2 + c2) return true;
        return false;
    }

    private void nQueen(int n, int row, int[] col) {
        // 모든 row(0 ~ n-1)에 퀸을 놓는 것을 성공하면 카운트
        if (row == n)
            answer++;
        // row(0 ~ n-1)에 퀸을 놓기
        else {
            // i는 해당 row에서 선택한 col 인덱스
            for (int i = 0; i < n; i++) {
                boolean flag = true;
                // j는 i전에 놓았던 퀸의 row, col을 구하기 위함
                for (int j = 0; j < row; j++) {
                    // 전에 놓았던 퀸들과 현재 후보위치 퀸이 공격 불가능한 위치인지 확인
                    if (invalid(row, i, j, col[j])) {
                        flag = false;
                        break;
                    }
                }
                // 해당 row의 퀸과 전의 퀸들이 유효한 위치라면 다음 row로
                if (flag) {
                    col[row] = i;
                    nQueen(n, row + 1, col);
                    col[row] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Main main = new Main();
        int n = Integer.parseInt(br.readLine());
        br.close();
        // 첫번째 줄(0) 부터 시작, col[row]은 해당 행에서 어디 열에 퀸을 놓았는지 표시
        main.nQueen(n, 0, new int[n]);
        System.out.print(answer);
    }
}