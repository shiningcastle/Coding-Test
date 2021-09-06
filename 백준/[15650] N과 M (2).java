import java.io.*;
import java.util.StringTokenizer;

class Main {
    private StringBuilder sb = new StringBuilder();

    private void sequence(int n, int m, BufferedWriter bw, int idx, int before, boolean[] used) throws IOException {
        if (idx == m) {
            bw.write(sb.toString());
            bw.write('\n');
            return;
        }

        for (int i = before; i <= n; i++) {
            if (!used[i]) {
                sb.append(i).append(' ');
                used[i] = true;
                sequence(n, m, bw, idx + 1, i, used);
                sb.delete(sb.length() - 2, sb.length());
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
        main.sequence(n, m, bw, 0, 1, new boolean[n+1]);
        bw.flush();
        bw.close();
    }
}