import java.io.*;
import java.util.StringTokenizer;

class Main {
    private StringBuilder sb = new StringBuilder();
    private void sequence(int n, int m, int idx, BufferedWriter bw, boolean[] used) throws IOException {
        // 완성된 문자열 + 줄바꿈 BufferedWriter에 넣기
        if (idx == m) {
            bw.write(sb.toString());
            bw.write('\n');
            return;
        }
        // 해당 인덱스 위치에 1~n 까지의 숫자를 넣음 다음 차례수는 재귀로 넣고 끝부분 다시 지우기
        for (int i = 1; i <= n; i++) {
            if (!used[i]) {
                sb.append(i).append(' ');
                used[i] = true;
                sequence(n, m, idx+1, bw, used);
                sb.delete(sb.length()-2, sb.length());
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        Main main = new Main();
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        main.sequence(n, m, 0, bw, new boolean[n+1]);
        bw.flush();
        bw.close();
    }
}